package tower.filebase.bo.fileDef;

import java.io.File;
import java.util.Vector;

import org.apache.log4j.Logger;

import tower.common.util.DateFunc;
import tower.filebase.bo.perm.CheckParam;
import tower.filebase.db.DbTFile;
import tower.filebase.en.EnTFile;
import tower.filebase.util.PathByCatalog;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoFileEditDownLoad implements RootBo{

	/**
	 * <strong>输入：</strong><br>
	 * <br>
	 * <strong>业务逻辑：</strong><br>
	 * <br>1、根据文件的所属目录ID(CATALOG_ID)获取该文件的权限，判断是否有下载权限：如果有则下载文件，如果没有这抛出异常  . 
	 * <br>2、根据系统参数判断是否是“互斥编辑”：（1）如果是互斥编辑则判断当前文件状态是否是“编辑中”，如果当前文件是编辑状态
	 * 		  则抛出异常，如果文件是正常状态，则根据文件代号（FILE_ID）、文件名(FILE_NAME)、版本号（VERSION_NO）、文件
	 * 		 存储路径(PATH)从服务器上获取文件. 并在文件表中记录当前编辑人(CURR_EDIT_PERSON)和编辑时间(EDIT_DATETIEM),
	 * 		  更新文件状态(FILE_STATE)为"编辑中". （2）如果系统参数不是互斥编辑，则直接根据文件代号（FILE_ID）、文件名
	 * 		(FILE_NAME)、版本号（VERSION_NO）、文件存储路径(PATH)从服务器上获取文件 
	 * <strong>输出：</strong><br>
	 * 无<br>
	 * <br>
	 */
	public void doBusiness(Transaction transaction, XMLWrap requestXml, 
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) 
			throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		
		//文件db en
		DbTFile dbTFile;
		EnTFile enTFile;
		
		//文件代号
		String[] fileIds;
		String[] catalogIds;
		String catalogId;
		
		//文件编辑信息
		String currEditPerson;
		String editDateTime;
		
		
		//是否互斥编辑：1是；0否
		String opMutes;
		
		//其他
		Vector<EnTFile> vEnTFiles;
		
		String userId;
		String fileOperateState;
		String filePath;
		String path;
		String rootPath;
		
		File file;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		
		fileIds = requestXml.getInputValues("FILE_ID");
		catalogIds = requestXml.getInputValues("CATALOG_ID");
		catalogId = requestXml.getInputValue("CATALOG_ID");
		currEditPerson = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		editDateTime = DateFunc.GenNowTime();
		
		opMutes = sessionXml.getInputValue("OP_MUTES");
		
		userId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		fileOperateState = requestXml.getInputValue("FILE_OPERATE_STATUE");
		rootPath =applicationXml.getInputValue("UPLOAD_CATALOG");
		
		/************************************************************
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbTFile = new DbTFile(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		
		
		//根据所属目录代号判断是否有下载权限
		if(catalogId != null && catalogId.length() !=0){
			if(!CheckParam.checkFile(transaction, catalogId, userId, fileOperateState)){
				throw new ErrorException("F0002",null);
			}
		}else{
			for(int i=0;i<catalogIds.length;i++){
				if(!CheckParam.checkFile(transaction, catalogIds[i], userId, fileOperateState)){
					throw new ErrorException("F0002",null);
				}
			}
		}
		
		//根据系统参数判断是否互斥：如果互斥，如果选中的文件状态处于编辑状态则抛出异常.
		vEnTFiles = new Vector<EnTFile>();
		if(opMutes.equals("1")){
			for(int i=0;i<fileIds.length;i++){
				enTFile = dbTFile.findByKey(fileIds[i]);
				if(enTFile != null){
					if(enTFile.getFileState().equals("1")){
						//F0101:该文件处于编辑状态！
						throw new ErrorException("F0101",new Object[]{enTFile.getFileName()} );
					}else{
						vEnTFiles.add(enTFile);
						enTFile.setCurrEditPerson(currEditPerson);
						enTFile.setEditDatetime(editDateTime);
						enTFile.setFileState("1");
						dbTFile.updateByKey(enTFile.getFileId(), enTFile);
					}
				}
			}
		}else{
			for(int i=0;i<fileIds.length;i++){
				enTFile = dbTFile.findByKey(fileIds[i]);
				vEnTFiles.add(enTFile);
			}
		}
		
		//判断要下载的文件是否存在，如果不存在着抛出异常：F00010：要下载的文件不存在；否则保存文件完整路径。
		for(int i=0;i<vEnTFiles.size();i++){
			enTFile = (EnTFile)vEnTFiles.get(i);
			String localFileName = enTFile.getFileId()+"_"+enTFile.getNewVersionNo()+"_"+enTFile.getFileName();
			filePath =rootPath+"/"+ PathByCatalog.pathByCatalogId(catalogId,transaction)+"/"+localFileName;
			file = new File(filePath);
			if(!file.exists()){
				throw new ErrorException("F00010",new Object[]{enTFile.getFileName()});
			}else{
				int row = requestXml.addInputRow("FULL_PATH");
				requestXml.setInputValue("FULL_PATH", row,filePath);
			}
		}
		
		//根据该路径下载文件
		path =rootPath+"/"+ PathByCatalog.pathByCatalogId(catalogId,transaction);
		if (requestXml.getInputRowCount("PATH") <= 0) {
			requestXml.addInputRow("PATH");
			requestXml.setInputValue("PATH", 1,path);
		}
		//为下载文件准备数据
		dbTFile.setAllToXml(requestXml, vEnTFiles);
	}


}
