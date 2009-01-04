package tower.filebase.bo.fileDef;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import tower.common.auto.BoAddAuto;
import tower.common.util.DateFunc;
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

public class BoFileCopySubmit implements RootBo {

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
		// TODO Auto-generated method stub

		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		// 目录db en
		DbTCatalog dbTCatalog;
		EnTCatalog enTCatalog;
		DbTFileVersion dbTFileVersion;
		EnTFileVersion enTFileVersion;
		DbTFile dbTFile;
		EnTFile enTFile;
		String[] catalogNewIds;
		String[] fileIds;
		String userId;
		String dateTime;

		String path;
		StringBuffer filePath;
		File fileFrom;
		File fileTo;
		File file;
		
		String fileOperateState;
		
		StringBuffer sqlWhere = new StringBuffer();
		Vector files;
		String filePart;

		InputStream inputStream = null;
		OutputStream outputStream = null;

		/***********************************************************************
		 * 获取输入
		 **********************************************************************/

		catalogNewIds = requestXml.getInputValues("COPY_TO_CATALOG_ID");
		fileIds = requestXml.getInputValues("FILE_COPY_ID");
		userId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		dateTime = DateFunc.GenNowTime();
		
		fileOperateState = requestXml.getInputValue("FILE_OPERATE_STATUE");
		filePart = applicationXml.getInputValue("UPLOAD_CATALOG");
		
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/

		transaction.createDefaultConnection(null, false);
		dbTCatalog = new DbTCatalog(transaction, null);
		dbTFile = new DbTFile(transaction, null);
		dbTFileVersion = new DbTFileVersion(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		//检查所有的文件
		if(fileOperateState != null && fileOperateState.length() > 0){
			if (fileIds != null && fileIds.length > 0) {
				enTFile = dbTFile.findByKey(fileIds[0]);
				if(enTFile != null){
					enTCatalog = dbTCatalog.findByKey(enTFile.getCatalogId());
					if(enTCatalog != null){
						if(catalogNewIds != null && catalogNewIds.length > 0 ){
							for(int i = 0 ; i < fileIds.length ; i ++){
								enTFile = dbTFile.findByKey(fileIds[i]);
								if(enTFile != null){
									path = PathByCatalog.pathByCatalogId(enTFile.getCatalogId(),
											transaction);
									filePath = new StringBuffer();
									filePath.append(filePart);
									filePath.append(path);
									filePath.append("/");
									filePath.append(enTFile.getFileId());
									filePath.append("_");
									filePath.append(enTFile.getNewVersionNo());
									filePath.append("_");
									filePath.append(enTFile.getFileName() );
									fileFrom = new File(filePath.toString());
									//System.out.println(filePath.toString());
									if(fileFrom.exists()){
										for (int j = 0; j < catalogNewIds.length; j++) {
											enTCatalog = dbTCatalog.findByKey(catalogNewIds[j]);
											if(enTCatalog != null){
												boolean moveFlag = CheckParam.checkFile(transaction, catalogNewIds[j], userId, fileOperateState);
												if(moveFlag){
													sqlWhere = new StringBuffer();
													sqlWhere.append("FILE_NAME = '"+enTFile.getFileName() + "'");
													sqlWhere.append(" and CATALOG_ID = '");
													sqlWhere.append(catalogNewIds[j]+"'");
													files = dbTFile.findAllWhere(sqlWhere.toString());
													if(files != null && files.size() > 0){
														//copy到的目录下已经有此文件
														String[] mes = {enTFile.getFileName(),enTCatalog.getCatalogName()};
														throw new ErrorException("FileCC0005",mes);
													}
												}else{
													String[] mes = {enTCatalog.getCatalogName()};
													throw new ErrorException("FileCC0009",mes);
												}
											}else{
												//copy到的目录不存在
												throw new ErrorException("FileCC0002",null);
											}
										}
									}else{
										//落地文件不存在
										String[] mes = {enTFile.getFileName()};
										throw new ErrorException("FileCC008",mes);
									}
								}else{
									//copy的文件不存在
									throw new ErrorException("FileCC001",null);
								}
							}
						}else{
							//没有选择目录
							throw new ErrorException("FileCC007",null);
						}
					}else{
						//要拷贝的文件所在的目录不存在
						throw new ErrorException("FileCC0003",null);
					}
				}else{
					//拷贝的文件不存在
					throw new ErrorException("FileCC001",null);
				}
			}
		}else{
			throw new ErrorException("FileP0000",null);
		}
		//执行逻辑
		if (fileIds != null && fileIds.length > 0) {
			for(int i = 0 ; i < fileIds.length ; i++){
				enTFile = dbTFile.findByKey(fileIds[i]);
				if (enTFile != null) {
					path = PathByCatalog.pathByCatalogId(enTFile.getCatalogId(),
							transaction);
					filePath = new StringBuffer();
					filePath.append(filePart);
					filePath.append(path);
					filePath.append("/");
					filePath.append(enTFile.getFileId());
					filePath.append("_");
					filePath.append(enTFile.getNewVersionNo());
					filePath.append("_");
					filePath.append(enTFile.getFileName() );
					fileFrom = new File(filePath.toString());
					if(fileFrom.exists()){
						for (int j = 0; j < catalogNewIds.length; j++) {
							if (catalogNewIds[j] != null && catalogNewIds[j].length() > 0) {
								enTCatalog = dbTCatalog.findByKey(catalogNewIds[j]);
								//复制文件路径
								path = PathByCatalog.pathByCatalogId(catalogNewIds[j],
										transaction);
								filePath = new StringBuffer();
								filePath.append(filePart);
								//filePath.append("/");
								filePath.append(path);
								
								enTFile.setCatalogId(catalogNewIds[j]);
								// 从新生成主键Id
								//BoAddAuto boAddAuto = new BoAddAuto();
								String newFileId = BoAddAuto.GetBuildMode(transaction, "FILE_ID");
								enTFile.setFileId(newFileId);
								enTFile.setNewVersionNo("1");
								enTFile.setCreateDatetime(dateTime);
								enTFile.setCreator(userId);
								enTFile.setFlag("1");
								enTFile.setFileState("0");
								enTFile.setCurrEditPerson("");
								enTFile.setEditDatetime("");
								enTFile.setDeleteDatetime("");
								enTFile.setDeletePerson("");
								filePath.append("/"+enTFile.getFileId());
								filePath.append("_1_");
								filePath.append(enTFile.getFileName()+".");
								filePath.append(enTFile.getFileExtName());
								enTFile.setFilePath(filePath.toString());
								dbTFile.insert(enTFile);
								//添加版本
								enTFileVersion = new EnTFileVersion();
								enTFileVersion.setFileId(enTFile.getFileId());
								enTFileVersion.setVersionNo(1);
								enTFileVersion.setUpdateDatetime(dateTime);
								enTFileVersion.setUpdatePerson(userId);
								enTFileVersion.setUpdateRemark("");
								dbTFileVersion.insert(enTFileVersion);
								
								file = new File(filePath.toString());
								if (!file.exists()) {
									file.mkdirs();
								}
								filePath.append("/");
								filePath.append(enTFile.getFileId());
								filePath.append("_");
								filePath.append(enTFile.getNewVersionNo());
								filePath.append("_");
								filePath.append(enTFile.getFileName() );
								//System.out.println("copy到的"+filePath.toString());
								//filePath.append("."+ enTFile.getFileExtName());
								fileTo = new File(filePath.toString());
								if (!fileTo.exists()) {
									try {
										fileTo.createNewFile();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
								try {
									inputStream = new FileInputStream(fileFrom);
									outputStream = new FileOutputStream(
											fileTo);
									if (inputStream != null) {
										try {
											IOUtils.copy(inputStream, outputStream);
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}finally{
									try {
										inputStream.close();
										outputStream.close();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
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
