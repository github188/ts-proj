package tower.filebase.bo.fileDef;

import java.io.File;
import java.util.Vector;

import org.apache.log4j.Logger;

import tower.common.util.DateFunc;
import tower.filebase.bo.perm.CheckParam;
import tower.filebase.db.DbTFile;
import tower.filebase.db.DbTFileVersion;
import tower.filebase.en.EnTFile;
import tower.filebase.en.EnTFileVersion;
import tower.filebase.util.PathByCatalog;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoFileDestory implements RootBo {

	/**
	 * <strong>输入：文件Id</strong><br>
	 * <br>
	 * <strong>业务逻辑：刪除文件信息并且删除历史版本</strong><br>
	 * <br>
	 * <strong>输出：</strong><br>
	 * 无<br>
	 * <br>
	 */
	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		// TODO Auto-generated method stub

		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		// 目录db en
		DbTFile dbTFile;
		EnTFile enTFile;
		DbTFileVersion dbTFileVersion;
		EnTFileVersion enTFileVersion = null;
		Vector fileVersions;
		String[] fileIds;
		String userId;
		String date;

		String filePart;
		String path;
		StringBuffer filePath;
		File file;
		String fileOperateState;

		/***********************************************************************
		 * 获取输入
		 **********************************************************************/

		fileIds = requestXml.getInputValues("FILE_ID");
		userId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		date = DateFunc.GenNowTime();
		fileOperateState = requestXml.getInputValue("FILE_OPERATE_STATUE");

		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/

		transaction.createDefaultConnection(null, false);
		dbTFile = new DbTFile(transaction, null);
		dbTFileVersion = new DbTFileVersion(transaction, null);
		//System.out.println("fileOperateState"+fileOperateState);
		

		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/

		if (fileIds != null && fileIds.length > 0) {
			for (int i = 0; i < fileIds.length; i++) {
				enTFile = dbTFile.findByKey(fileIds[i]);
				if (enTFile != null) {
					if(fileOperateState != null && fileOperateState.length() > 0){
						boolean flage = CheckParam.checkFile(transaction, enTFile
								.getCatalogId(), userId, fileOperateState);
						if (!flage) {
							//没有销毁权限
							throw new ErrorException("FileD0014", null);
						}
					}else{
						//没有权限操作码
						throw new ErrorException("FileP0000", null);
					}
				} else {
					//要销毁的文件不存在
					throw new ErrorException("FileD0012", null);
				}
			}
		}else{
			//没有选择要销毁的文件
			throw new ErrorException("FileD0011", null);
		}
		if (fileIds != null && fileIds.length > 0) {
			filePart = applicationXml.getInputValue("UPLOAD_CATALOG");
			for (int i = 0; i < fileIds.length; i++) {
				String fileId = fileIds[i];
				// 查找出要删除的文件
				enTFile = dbTFile.findByKey(fileId);
				if (enTFile != null) {
					// 删除数据库记录
					dbTFile.deleteByKey(fileId);
					path = PathByCatalog.pathByCatalogId(
							enTFile.getCatalogId(), transaction);
					// 查找出要删除的版本
					StringBuffer sql = new StringBuffer();
					sql.append("FILE_ID = '");
					sql.append(fileId);
					sql.append("'");
					fileVersions = dbTFileVersion.findAllWhere(sql.toString());
					// 删除版本记录
					dbTFileVersion.deleteWhere(sql.toString());
					// 删除文件
					if (fileVersions != null && fileVersions.size() > 0) {
						// System.out.println("版本 记录" + fileVersions.size());
						for (int j = 0; j < fileVersions.size(); j++) {
							enTFileVersion = (EnTFileVersion) fileVersions
									.get(j);
							filePath = new StringBuffer();
							filePath.append(filePart);
							filePath.append(path);
							filePath.append("/");
							filePath.append(fileId);
							filePath.append("_");
							filePath.append(enTFileVersion.getVersionNo());
							filePath.append("_");
							filePath.append(enTFile.getFileName());
							// System.out.println("删除" + filePath.toString());
							file = new File(filePath.toString());
							if (file.exists()) {
								file.delete();
							}
						}
					}
				}
			}
		}
			/*
			 * enTFile = dbTFile.findByKey(fileId); if (enTFile != null) { /*
			 * 判断权限是否能够删除 Boolean destoryFlag =
			 * class(enTFile.getCatalogId,userId,8,transaction); if(
			 * destoryFlag){ 删除数据 }
			 */
			// 
			/*
			 * if (true) { dbTFile.deleteByKey(fileId); /* 在服务器端删除文件
			 */
			/*
			 * filePart = applicationXml.getInputValue("UPLOAD_CATALOG"); path =
			 * PathByCatalog.pathByCatalogId( enTFile.getCatalogId(),
			 * transaction); /* filePath = new StringBuffer();
			 * filePath.append(filePart); //filePath.append("/");
			 * filePath.append(path); filePath.append("/");
			 * filePath.append(enTFile.getFileName());
			 * //filePath.append("."+enTFile.getFileExtName()); file = new
			 * File(filePath.toString()); if(file.exists()){ file.delete(); }
			 */
			// 删除历史版本
			/*
			 * StringBuffer sql = new StringBuffer(); sql.append("FILE_ID = '");
			 * sql.append(fileId); sql.append("'"); fileVersions =
			 * dbTFileVersion.findAllWhere(sql.toString());
			 * dbTFileVersion.deleteWhere(sql.toString()); if (fileVersions !=
			 * null && fileVersions.size() > 0) { System.out.println("版本 记录" +
			 * fileVersions.size()); for (int i = 0; i < fileVersions.size();
			 * i++) { enTFileVersion = (EnTFileVersion) fileVersions .get(i);
			 * filePath = new StringBuffer(); filePath.append(filePart);
			 * filePath.append(path); filePath.append("/");
			 * filePath.append(fileId);
			 * filePath.append(enTFileVersion.getVersionNo());
			 * filePath.append(enTFile.getFileName()); System.out.println("删除" +
			 * filePath.toString()); file = new File(filePath.toString()); if
			 * (file.exists()) { file.delete(); } } } } }
			 */
			/*
			 * else { throw new ErrorException("File0006", null); }
			 */
		/*
		 * else { throw new ErrorException("File0004", null); }
		 */
	}
}
