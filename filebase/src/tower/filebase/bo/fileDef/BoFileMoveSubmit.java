package tower.filebase.bo.fileDef;

import java.io.File;
import java.util.Vector;

import org.apache.log4j.Logger;

import tower.filebase.bo.perm.CheckParam;
import tower.filebase.db.DbTCatalog;
import tower.filebase.db.DbTFile;
import tower.filebase.db.DbTFileVersion;
import tower.filebase.en.EnTCatalog;
import tower.filebase.en.EnTFile;
import tower.filebase.en.EnTFileVersion;
import tower.filebase.util.PathByCatalog;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoFileMoveSubmit implements RootBo {

	/**
	 * <strong>输入：目录Id</strong><br>
	 * <br>
	 * <strong>业务逻辑：从原始目录删除并且从目标目录添加</strong><br>
	 * <br>
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
		// 目录db en
		DbTCatalog dbTCatalog;
		EnTCatalog enTCatalogFrom;
		EnTCatalog enTCatalogTo;
		DbTFileVersion dbTFileVersion;
		EnTFileVersion enTFileVersion = null;
		Vector fileVersions;
		Vector files;
		DbTFile dbTFile;
		EnTFile enTFile;
		String catalogOldId;
		String catalogNewId;
		String[] fileIds;
		String userId;
		StringBuffer filePath = new StringBuffer();
		String path;
		File fileFrom;
		File fileTo;
		File file;
		
		String fileOperateState;
		
		StringBuffer sqlWhere = new StringBuffer();

		/***********************************************************************
		 * 获取输入
		 **********************************************************************/

		catalogOldId = requestXml.getInputValue("MOVE_FROM_CATALOG_ID");
		catalogNewId = requestXml.getInputValue("MOVE_TO_CATALOG_ID");
		fileIds = requestXml.getInputValues("FILE_MOVE_ID");
		userId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		fileOperateState = requestXml.getInputValue("FILE_OPERATE_STATUE");

		//System.out.println("CATALOG_ID" + requestXml.getInputValue("CATALOG_ID"));
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/

		transaction.createDefaultConnection(null, false);
		dbTCatalog = new DbTCatalog(transaction, null);
		dbTFile = new DbTFile(transaction, null);
		dbTFileVersion = new DbTFileVersion(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 * 
		 **********************************************************************/
		//获得系统路径
		String winPath = applicationXml.getInputValue("UPLOAD_CATALOG");
		//检查所有的文件
		if (fileIds != null && fileIds.length > 0) {
			if(catalogNewId != null && catalogNewId.length() > 0 ){
				enTCatalogTo = dbTCatalog.findByKey(catalogNewId);
				enTFile = dbTFile.findByKey(fileIds[0]);
				if(enTFile != null){
					enTCatalogFrom = dbTCatalog.findByKey(enTFile.getCatalogId());
					if(enTCatalogFrom != null){
						if(enTCatalogTo != null){
							if( fileOperateState != null && fileOperateState.length() > 0){
								//判断对此目录是存在添加权限
								boolean moveFlag = CheckParam.checkFile(transaction, catalogNewId, userId, fileOperateState);
								if(moveFlag){
									for(int i = 0 ; i < fileIds.length ; i++){
										enTFile = dbTFile.findByKey(fileIds[i]);
										if(enTFile != null){
											sqlWhere = new StringBuffer();
											sqlWhere.append("FILE_NAME = '"+enTFile.getFileName() + "'");
											sqlWhere.append(" and CATALOG_ID = '");
											sqlWhere.append(catalogNewId+"'");
											files = dbTFile.findAllWhere(sqlWhere.toString());
											if(files != null && files.size() > 0){
												//文件在目录中已经存在不能移动
												String[] mes = {enTFile.getFileName(),enTCatalogTo.getCatalogName()};
												throw new ErrorException("FileMC008",mes);
											}else{
												fileVersions = dbTFileVersion.findAllWhere("FILE_ID = '" + fileIds[i] + "'");
												for(int j = 0 ; j < fileVersions.size() ; j ++){
													path = PathByCatalog.pathByCatalogId(enTCatalogFrom.getCatalogId(),transaction);
													enTFileVersion = (EnTFileVersion) fileVersions.get(j);
													filePath = new StringBuffer();
													filePath.append(winPath);
													filePath.append(path);
													filePath.append("/");
													filePath.append(enTFile.getFileId());
													filePath.append("_");
													filePath.append(enTFileVersion.getVersionNo());
													filePath.append("_");
													filePath.append(enTFile.getFileName());
													fileFrom = new File(filePath.toString());
													if(!fileFrom.exists()){
														//实际的落地文件不存在
														Long version = enTFileVersion.getVersionNo();
														String[] mes = {enTFile.getFileName(),version.toString()};
														throw new ErrorException("FileMC009",mes);
													}
												}
											}
										}else{
											//没有找到要移动的文件
											//String[] mes = {enTFile.getFileName()}; 
											throw new ErrorException("FileMC002",null);
										}
									}
								}else{
									//对移动到的目录没有移动权限
									String[] mes = {enTCatalogTo.getCatalogName()};
									throw new ErrorException("FileMC007",mes);
								}
							}else{
								//没有权限操作码
								throw new ErrorException("FileP0000",null);
							}
						}else{
							//要移动的目标目录不存在
							throw new ErrorException("FileMC006",null);
						}
					}else{
						//要移动的文件所在的目录不存在 
						throw new ErrorException("FileMC003",null);
					}
				}else{
					//没有找到要移动的文件
					throw new ErrorException("FileMC002",null);
				}
			}else{
				//没有选择要移动的目录
				throw new ErrorException("FileMC005",null);
			}
		}
		//执行逻辑操作
		if (fileIds != null && fileIds.length > 0) {
			for(int i = 0 ; i < fileIds.length ; i++){
				enTFile = dbTFile.findByKey(fileIds[i]);
				if (enTFile != null) {
					fileVersions = dbTFileVersion.findAllWhere("FILE_ID = '" + fileIds[i] + "'");
					if(catalogNewId != null && catalogNewId.length() > 0 ){
						enTCatalogTo = dbTCatalog.findByKey(catalogNewId);
						enTCatalogFrom = dbTCatalog.findByKey(enTFile.getCatalogId());
						if(enTCatalogFrom != null && enTCatalogTo != null){
							path = PathByCatalog.pathByCatalogId(enTCatalogTo.getCatalogId(),transaction);
							filePath = new StringBuffer();
							filePath.append(winPath);
							filePath.append(path);
							filePath.append("/");
							filePath.append(enTFile.getFileId()+"_");
							filePath.append(enTFile.getNewVersionNo()+"_");
							filePath.append(enTFile.getFileName()+"."+enTFile.getFileExtName());
							enTFile.setFilePath(filePath.toString());
							enTFile.setCatalogId(catalogNewId);
							dbTFile.updateByKey(fileIds[i], enTFile);
							if(fileVersions != null && fileVersions.size() > 0){
								//文件在服务器端的移动
								path = PathByCatalog.pathByCatalogId(enTCatalogFrom.getCatalogId(),transaction);
								for(int j = 0 ; j < fileVersions.size() ; j ++){
									enTFileVersion = (EnTFileVersion) fileVersions.get(j);
									filePath = new StringBuffer();
									filePath.append(winPath);
									filePath.append(path);
									filePath.append("/");
									filePath.append(enTFile.getFileId());
									filePath.append("_");
									filePath.append(enTFileVersion.getVersionNo());
									filePath.append("_");
									filePath.append(enTFile.getFileName());
									fileFrom = new File(filePath.toString());
									path = PathByCatalog.pathByCatalogId(enTCatalogTo.getCatalogId(),transaction);
									filePath = new StringBuffer();
									filePath.append(winPath);
									filePath.append(path);
									if(j == 0){
										file = new File(filePath.toString());
										if(!file.exists() ){
											file.mkdir();
										}
									}
									filePath.append("/");
									filePath.append(enTFile.getFileId());
									filePath.append("_");
									filePath.append(enTFileVersion.getVersionNo());
									filePath.append("_");
									filePath.append(enTFile.getFileName());
									fileTo = new File(filePath.toString());
									if(fileFrom.exists()){
										fileFrom.renameTo(fileTo);
									}
								}
							}
						}
					}
				}
			}
		}
	}
}