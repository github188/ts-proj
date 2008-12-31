package tower.filebase.bo.catalogDef;

import java.io.File;
import java.util.Vector;

import org.apache.log4j.Logger;

import tower.common.auto.BoAddAuto;
import tower.common.util.DateFunc;
import tower.filebase.bo.perm.CheckParam;
import tower.filebase.db.DbTCatalog;
import tower.filebase.en.EnTCatalog;
import tower.filebase.util.PathByCatalog;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoCatalogSubmit implements RootBo {

	/**
	 * <strong>输入：目录的基本信息</strong><br>
	 * <br>
	 * <strong>业务逻辑：添加目录并且在服务器端添加一个目录</strong><br>
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
		EnTCatalog enTCatalogOld = null;
		String catalogId;
		String userId;
		String dateTime;
		String cataPraId;
		String cataName;
		String cataDesc;
		Vector catalogs;

		String operaStatue;
		String message="";
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/

		catalogId = requestXml.getInputValue("CATALOG_ID");
		cataPraId = requestXml.getInputValue("PARENT_ID");
		cataDesc = requestXml.getInputValue("CATALOG_REMARK");
		cataName = requestXml.getInputValue("CATALOG_NAME");
		userId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		dateTime = DateFunc.GenNowTime();

		operaStatue = requestXml.getInputValue("OPERATION_STATUE");
		//System.out.println("operaStatue"+operaStatue);
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/

		transaction.createDefaultConnection(null, false);
		dbTCatalog = new DbTCatalog(transaction, null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		enTCatalog = new EnTCatalog();

		StringBuffer sqlWhere = new StringBuffer();
		sqlWhere.append("CATALOG_NAME = '");
		sqlWhere.append(cataName  );
		sqlWhere.append("'");
		sqlWhere.append(" and PARENT_ID = '");
		sqlWhere.append(cataPraId);
		sqlWhere.append("'");
		if(catalogId != null && catalogId.length() > 0){
			enTCatalogOld = dbTCatalog.findByKey(catalogId);
			sqlWhere.append(" and CATALOG_ID != '");
			sqlWhere.append(enTCatalogOld.getCatalogId());
			sqlWhere.append("'");
		}
		catalogs = dbTCatalog.findAllWhere(sqlWhere.toString());
		if(operaStatue != null){
			if (catalogs == null || catalogs.size() == 0) {
				if (catalogId != null && catalogId.length() > 0) {
					//组装修改数据
					enTCatalog.setCatalogName(cataName);
					enTCatalog.setCatalogRemark(cataDesc);
					enTCatalog.setCatalogId(enTCatalogOld.getCatalogId());
					enTCatalog.setDeleteFlag(enTCatalogOld.getDeleteFlag());
					enTCatalog.setCreateDatetime(enTCatalogOld.getCreateDatetime());
					enTCatalog.setCreator(enTCatalogOld.getCreator());
					enTCatalog.setParentId(enTCatalogOld.getParentId());
					/*
					 * 在服务器端修改目录
					 */
						Boolean modeFlag = CheckParam.checkContent(transaction, catalogId, userId, operaStatue);
						if(modeFlag){
							String winPath = applicationXml
									.getInputValue("UPLOAD_CATALOG");
							String filePart = PathByCatalog.pathByCatalogId(enTCatalog
									.getParentId(), transaction);
							StringBuffer filePathNew = new StringBuffer();
							filePathNew.append(winPath);
							filePathNew.append(filePart);
							filePathNew.append("/");
							filePathNew.append(enTCatalog.getCatalogName());
							//System.out.println("filePathNew"+filePathNew);
							File myFilePathNew = new File(filePathNew.toString());
							if (enTCatalogOld != null) {
								StringBuffer filePathOld = new StringBuffer();
								filePathOld.append(winPath);
								filePart = PathByCatalog.pathByCatalogId(enTCatalogOld
										.getCatalogId(), transaction);
								//System.out.println("old"+enTCatalogOld.getCatalogName());
								filePathOld.append(filePart);
								//System.out.println("filePart"+filePathOld.toString());
								File myFilePathOld = new File(filePathOld.toString());
								dbTCatalog.updateByKey(catalogId, enTCatalog);
								if (myFilePathOld.exists()) {
									//myFilePathOld.delete();
									//myFilePathNew.mkdirs();
									myFilePathOld.renameTo(myFilePathNew);
									//System.out.println("rename");
								} else {
									myFilePathNew.mkdirs();
									//System.out.println("mkdir");
								}
								message= "修改目录成功";
							}
						}else{
							message = "没有权限修改目录";
						}
					} else {
						//组装添加对象
						catalogId = BoAddAuto.GetBuildMode(transaction, "CATALOG_ID");
						enTCatalog.setCatalogId(catalogId);
						enTCatalog.setParentId(cataPraId);
						enTCatalog.setDeleteFlag("1");
						enTCatalog.setCreateDatetime(dateTime);
						enTCatalog.setCreator(userId);
						enTCatalog.setCatalogName(cataName);
						enTCatalog.setCatalogRemark(cataDesc);
						Boolean addFlag = CheckParam.checkContent(transaction, cataPraId, userId, operaStatue);
						if(addFlag){
							// 获得目录的路径
							String filePart = PathByCatalog.pathByCatalogId(enTCatalog
									.getParentId(), transaction);
							// 获得系统路径
							StringBuffer filePath = new StringBuffer();
							String winPath = applicationXml
									.getInputValue("UPLOAD_CATALOG");
							filePath.append(winPath);
							filePath.append(filePart + "/");
							filePath.append(enTCatalog.getCatalogName());
							//System.out.println(filePath.toString());
							// 获得创建文件或者目录路径
							File myFilePathNew = new File(filePath.toString());
							dbTCatalog.insert(enTCatalog);
							if (!myFilePathNew.exists()) {
								myFilePathNew.mkdirs();
							}
							message = "创建目录成功";
							/*
							 * 在服务器端添加目录
							 */
						}else{
							message = "没有权限添加目录";
						}
					}
				} else {
					//System.out.println("添加同名");
					// 抛出异常不能添加成同名目录，其他人已经添加
					//throw new ErrorException("CATALOG001", null);
					message = "不能添加同名目录";
				}
			}else{
				message = "权限码读取失败";
			}
			if(requestXml.getRowCount("CATALOG_MESSAGE") == 0){
				requestXml.addInputRow("CATALOG_MESSAGE");
			}
			requestXml.setInputValue("CATALOG_MESSAGE", 1, message);
			//System.out.println("消息"+message);
		}
}
