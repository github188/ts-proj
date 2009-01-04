package tower.filebase.bo.fileDef;

import java.io.File;
import java.util.Vector;

import org.apache.log4j.Logger;

import tower.filebase.bo.perm.CheckParam;
import tower.filebase.db.DbTFile;
import tower.filebase.en.EnTFile;
import tower.filebase.util.PathByCatalog;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoFileDownLoad implements RootBo{

	/**
	 * <strong>输入：</strong><br>
	 * <br>1、文件代号：FILE_ID、文件所属目录编号：CATALOG_ID
	 * <strong>业务逻辑：</strong><br>
	 * <br>1、根据文件的所属目录ID(CATALOG_ID)获取该文件的权限，判断是否有下载权限：如果有则下载文件，如果没有这抛出异常  . 
	 * <br>2、根据文件代号（FILE_ID）从文件表中获取文件信息.
	 * <strong>输出：</strong><br>
	 * <br>文件信息
	 * <br>
	 */
	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		
		//文件db en
		DbTFile dbTFile;
		EnTFile enTFile;
		
		//文件代号
		String[] fileIds;
		String[] catalogIds;
		
		//其他
		File file;
		
		String filePath;
		String rootPath;
		String path;
		
		Vector vEnTFiles;
		
		String catalogId;
		String userId;
		String fileOperateState;
		
		StringBuffer sql = new StringBuffer();
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		
		fileIds = requestXml.getInputValues("FILE_ID");
		catalogIds = requestXml.getInputValues("CATALOG_ID");
		catalogId = requestXml.getInputValue("CATALOG_ID");
		userId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		fileOperateState = requestXml.getInputValue("FILE_OPERATE_STATUE");
		
		rootPath =applicationXml.getInputValue("UPLOAD_CATALOG");
		
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		
		transaction.createDefaultConnection(null, false);
		dbTFile = new DbTFile(transaction,null);
		
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		
		//根据所属目录代号判断是否有下载权限
		if(catalogIds == null && catalogIds.length ==0){
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
		
		StringBuffer strBuf = new StringBuffer();
		strBuf.append("(");
		for(int i=0;i<fileIds.length;i++){
			if(i==0){
				strBuf.append(fileIds[i]);
			}else{
				strBuf.append(",");
				strBuf.append(fileIds[i]);
			}
		}
		strBuf.append(")");
		
		sql.append(" FILE_ID IN ");
		sql.append(strBuf.toString());
		vEnTFiles = dbTFile.findAllWhere(sql.toString());
		
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
		
		dbTFile.setAllToXml(requestXml, vEnTFiles);
		path =rootPath+"/"+ PathByCatalog.pathByCatalogId(catalogId,transaction);
		if (requestXml.getInputRowCount("PATH") <= 0) {
			requestXml.addInputRow("PATH");
			requestXml.setInputValue("PATH", 1,path);
		}
	}
}
