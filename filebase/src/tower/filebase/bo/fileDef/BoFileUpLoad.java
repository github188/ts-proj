package tower.filebase.bo.fileDef;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

import org.apache.log4j.Logger;

import tower.common.auto.BoAddAuto;
import tower.common.util.DateFunc;
import tower.filebase.bo.perm.CheckParam;
import tower.filebase.db.DbTFile;
import tower.filebase.db.DbTFileVersion;
import tower.filebase.en.EnTFile;
import tower.filebase.en.EnTFileVersion;
import tower.filebase.util.GetRootCatalog;
import tower.filebase.util.PathByCatalog;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
import tower.tmvc.util.UploadFile;

/**
 * 
 * @author fanlj
 *
 */
public class BoFileUpLoad implements RootBo{

	/**
	 * <strong>输入：</strong><br>
	 * <br>1、文件名：FILE_NAME、文件扩展名：FILE_EXT_NAME
	 * <br>2、文件关键字：KEY_WORD、文件说明：FILE_REMARK
	 * <strong>业务逻辑：</strong><br>
	 * <br>1、根据目录代号(CATALOG_ID)和当前操作用户检查是否有权限执行该操作，如果没有权限则抛出异常
	 * <br>2、根据文件代号（FILE_ID）判断是“编辑上传”还是“新建”：如果文件代号为空则为"新建"; 否则为"编辑上传"。
	 * <br>3、若是“编辑上传” ：首先判断编辑后上传的文件名和原文件的文件名是否一致，如果不一致抛出异常；其次判断当前文件是否处于编辑状态
	 * <br>  根据文件代号（FILE_ID）号更新文件表（IT_FILE）最新版本号+1;然后往文件版本表
	 * 		 中插入该文件的一个新版本记录。修改文件表（IT_FILE）中的当前编辑人(CURR_EDIT_PERSON)为空和状态
	 * 		(FILE_STATE)为正常。                                                
	 * <br>4、若是“新建”：首先判断新上传的文件名在该目录下释放存在，如果已存在则抛出异常；如果不存在则往文件表（IT_FILE）
	 * 		中插入一条新纪录，文件存储路径为“系统路径+文件相对路径+文件名（文件代号_+文件名_+版本号）”；根据系统参数判断
	 * 		是否保存历史版本，如果是则往文件版本表（IT_FILE_VERSON）中插入该文件的一个新版本记录。                                  
	 * <strong>输出：</strong><br>
	 * 无<br>
	 * <br>
	 */
	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//文件db en
		DbTFile dbTFile;
		EnTFile enTFile;
		
		//文件版本db en
		DbTFileVersion dbTFileVersion;
		EnTFileVersion enTFileVersion;
		
		//文件信息
		String fileId;
		String fileSize;
		String keyWord;
		String fileRemark;
		String catalogId;
		String creator;
		String createDateTime;
		String newVersionNo;
		
		//上传文件
		UploadFile uploadFile;
		
		//文件更新信息
		String updatePerson;
		String updateDateTime;
		String updateRemark;
		
		//是否保存历史历史版本:0：保存；1：不保存
		String opSave;
		
		//是否互斥编辑：0是；1否
		String opMutes;
		
		//其他
		Vector vEnTFile;
		String rootPath;
		String path;
		String localFileName;
		String userId;
		String fileOperateState;
		File file ;
		StringBuffer sql ;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		//文件信息
		fileId = requestXml.getInputValue("FILE_ID");
		keyWord = requestXml.getInputValue("KEY_WORK");
		fileRemark = requestXml.getInputValue("FILE_REMARK");
		catalogId = requestXml.getInputValue("CATALOG_ID");
		newVersionNo = requestXml.getInputValue("NEW_VERSION_NO");
		creator = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		createDateTime = DateFunc.GenNowTime();
		
		//文件更新信息
		updatePerson = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		updateDateTime = DateFunc.GenNowTime();
		updateRemark = requestXml.getInputValue("FILE_REMARK");
		
		//是否保存历史版本
		opSave = sessionXml.getInputValue("OP_SAVE");
		
		//是否互斥编辑
		opMutes = sessionXml.getInputValue("OP_MUTES");
		
		//其他
		rootPath =applicationXml.getInputValue("UPLOAD_CATALOG");
		userId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		fileOperateState = requestXml.getInputValue("FILE_OPERATE_STATUE");
		
		
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		
		transaction.createDefaultConnection(null, false);
		dbTFile = new DbTFile(transaction,null);
		dbTFileVersion = new  DbTFileVersion(transaction,null);
		
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		
		//如果当前的目录代号为空，则默认在根目录下添加
		if(catalogId == null || catalogId.length() == 0){
			catalogId=GetRootCatalog.getRootId(transaction);
		}
			
		//判断当前用户是否有执行该功能的权限
		/*
		 * 应该检查文件的验证权限码是否获取到
		 * if(fileOperateState != null && fileOperateState.length > 0){
		 * }
		 */
		if(!CheckParam.checkFile(transaction, catalogId, userId, fileOperateState)){
			//F0002:您的权限不足，请向管理员申请此权限
			throw new ErrorException("F0002",null);
		}
		
		//获取上传的文件
		uploadFile = (UploadFile)requestXml.getInputObject("UPLOAD_FILE");
		
		enTFile = new EnTFile();
		//根据文件代号：FILE_ID判断是"新建"还是"编辑上传"
		if(fileId == null || fileId.length() ==0){
			newVersionNo="1";
			if(uploadFile != null){
					//检查上传的文件名在该目录下是否存在同名文件
					sql = new StringBuffer();
					sql.append("  FILE_NAME=");
					sql.append(Transaction.formatString(uploadFile.getFileName()));
					sql.append(" AND CATALOG_ID=");
					sql.append(Transaction.formatString(catalogId));
					sql.append(" AND FLAG=1");
					vEnTFile = dbTFile.findAllWhere(sql.toString());
					if(vEnTFile.size() > 0){
						//F0004：该目录下已存在同名文件！
						throw new ErrorException("F0004",null);
					}
					//检查上传的文件名在回收站是否存在同名文件
					sql = new StringBuffer();
					sql.append("  FILE_NAME=");
					sql.append(Transaction.formatString(uploadFile.getFileName()));
					sql.append(" AND CATALOG_ID=");
					sql.append(Transaction.formatString(catalogId));
					sql.append(" AND FLAG=0");
					vEnTFile = dbTFile.findAllWhere(sql.toString());
					if(vEnTFile.size() > 0){
						//F0004：该目录下已存在同名文件！
						throw new ErrorException("F0008",null);
					}
				
				//增加文件记录
				fileId = BoAddAuto.GetBuildMode(transaction, "FILE_ID");
				enTFile.setFileId(fileId);
				enTFile.setCreateDatetime(createDateTime);
				enTFile.setCreator(creator);
				enTFile.setNewVersionNo(newVersionNo);
				enTFile.setKeyWord(keyWord);
				enTFile.setCatalogId(catalogId);
				enTFile.setFileState("0");
				enTFile.setFileRemark(fileRemark);
				enTFile.setFlag("1");
				//存储到服务器上后的文件名：文件代号_+版本号_+上传文件名
				localFileName = fileId+"_"+newVersionNo+"_"+uploadFile.getFileName();
				path =rootPath+"/"+ PathByCatalog.pathByCatalogId(catalogId,transaction)+"/"+localFileName;
				enTFile.setFilePath(path);
				enTFile.setFileName(uploadFile.getFileName());
				enTFile.setFileExtName(uploadFile.getExtention());
				if(uploadFile.getSize()/1024 <= 0){
					fileSize = String.valueOf(1);
				}else{
					fileSize = String.valueOf(uploadFile.getSize()/1024);
				}
				enTFile.setFileSize(fileSize +"KB");
				dbTFile.insert(enTFile);
				
				//增加新版本
				enTFileVersion = new EnTFileVersion();
				enTFileVersion.setFileId(fileId);
				enTFileVersion.setVersionNo(Integer.parseInt(newVersionNo));
				enTFileVersion.setUpdateDatetime(updateDateTime);
				enTFileVersion.setUpdateRemark(updateRemark);
				enTFileVersion.setUpdatePerson(updatePerson);
				dbTFileVersion.insert(enTFileVersion);
			}else{
				//F0009:上传的文件不能为空！
				throw new ErrorException("F0009",null);
			}
		}else{
			// 判断编辑后上传的文件名和原文件名是否一致，如果不一致抛出异常
			enTFile = dbTFile.findByKey(fileId);
			if(enTFile != null){
				if(!enTFile.getFileName().equals(uploadFile.getFileName())){
					//F0003:编辑后的文件名和原文件名不一致！
					throw new ErrorException("F0003",null);
				}
				
				//如果系统参数是互斥编辑，如果当前文件是正常状态则抛出异常：F0006：必须下载编辑后才能编辑上传;
				//如果当前文件处于编辑状态而当前操作者非当前编辑人则抛出异常：F0007：当前文件已被锁定。
				if(opMutes.equals("1")){
					if(enTFile.getFileState().equals("0")){
						//F0006:必须下载编辑后才能编辑上传
						throw new ErrorException("F0006",null);
					}else if(enTFile.getFileState().equals("1")){
						if(!enTFile.getCurrEditPerson().equals(userId)){
							//F0007:当前文件已被锁定!
							throw new ErrorException("F0007",new Object[]{enTFile.getFileName()});
						}
					}
				}
			}
			
			
			
			//如果系统参数设置保留历史版本，则版本号加一并增加一条版本记录
			if(opSave.equals("1")){
				newVersionNo = String.valueOf(Integer.parseInt(newVersionNo)+1);
				enTFileVersion = new EnTFileVersion();
				enTFileVersion.setFileId(fileId);
				enTFileVersion.setVersionNo(Integer.parseInt(newVersionNo));
				enTFileVersion.setUpdateDatetime(updateDateTime);
				enTFileVersion.setUpdateRemark(updateRemark);
				enTFileVersion.setUpdatePerson(updatePerson);
				dbTFileVersion.insert(enTFileVersion);
			}else{
				newVersionNo="1";
			}
			
			//更新文件信息
			enTFile.setNewVersionNo(newVersionNo);
			enTFile.setKeyWord(keyWord);
			enTFile.setCatalogId(catalogId);
			enTFile.setFileRemark(fileRemark);
			enTFile.setFlag("1");
			if(uploadFile != null){
				//存储到服务器上后的文件名：文件代号+版本号+上传文件名
				localFileName = fileId+"_"+newVersionNo+"_"+uploadFile.getFileName();
				path =rootPath+"/"+ PathByCatalog.pathByCatalogId(catalogId,transaction)+"/"+localFileName;
				enTFile.setFilePath(path);
				enTFile.setFileName(uploadFile.getFileName());
				enTFile.setFileExtName(uploadFile.getExtention());
				if(uploadFile.getSize()/1024 <= 0){
					fileSize = String.valueOf(1);
				}else{
					fileSize = String.valueOf(uploadFile.getSize()/1024);
				}
				enTFile.setFileSize(fileSize +"KB");
			}else{
				//F0009:上传的文件不能为空！
				throw new ErrorException("F0009",null);
			}
				enTFile.setFileState("0");
				enTFile.setCurrEditPerson("");
				dbTFile.updateByKey(fileId, enTFile);
			
		}
		
		if(uploadFile != null){
			//存储到服务器上后的文件名：文件代号+版本号+上传文件名
			localFileName = fileId+"_"+newVersionNo+"_"+uploadFile.getFileName();
			path =rootPath+"/"+ PathByCatalog.pathByCatalogId(catalogId,transaction);
			file = new File(path);
			
			//如果目录不存在，创建目录。
			if(!file.exists()){
				file.mkdirs();
			}
			path =rootPath+"/"+ PathByCatalog.pathByCatalogId(catalogId,transaction)+"/"+localFileName;
			//保存文件
			file = new File(path);
			if(!file.exists()){
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			uploadFile.writeTo(file);
		}else{
			//F0009:上传的文件不能为空！
			throw new ErrorException("F0009",null);
		}
		
	}

	
}
