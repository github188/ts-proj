package tower.filebase.bo.sys.catalog;

import java.io.File;
import java.util.Vector;

import org.apache.log4j.Logger;

import tower.common.auto.BoAddAuto;
import tower.common.util.DateFunc;
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
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		catalogId = requestXml.getInputValue("CATALOG_ID");
		cataPraId = requestXml.getInputValue("PARENT_ID");
		cataDesc = requestXml.getInputValue("CATALOG_REMARK");
		cataName = requestXml.getInputValue("CATALOG_NAME");
		userId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		dateTime = DateFunc.GenNowTime();
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbTCatalog = new DbTCatalog(transaction, null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		enTCatalog = new EnTCatalog();
		// 查看父目录下是否存在同名的目录
		StringBuffer sqlWhere = new StringBuffer();
		sqlWhere.append("CATALOG_NAME = '");
		sqlWhere.append(cataName);
		sqlWhere.append("'");
		sqlWhere.append(" and PARENT_ID = '");
		sqlWhere.append(cataPraId);
		sqlWhere.append("'");
		if (catalogId != null && catalogId.length() > 0) {
			enTCatalogOld = dbTCatalog.findByKey(catalogId);
			sqlWhere.append(" and CATALOG_ID != '");
			sqlWhere.append(enTCatalogOld.getCatalogId());
			sqlWhere.append("'");
		}
		catalogs = dbTCatalog.findAllWhere(sqlWhere.toString());
		if (catalogs == null || catalogs.size() == 0) {
			if (catalogId != null && catalogId.length() > 0) {
				// 组装修改数据
				enTCatalog.setCatalogName(cataName);
				enTCatalog.setCatalogRemark(cataDesc);
				enTCatalog.setCatalogId(enTCatalogOld.getCatalogId());
				enTCatalog.setDeleteFlag(enTCatalogOld.getDeleteFlag());
				enTCatalog.setCreateDatetime(enTCatalogOld.getCreateDatetime());
				enTCatalog.setCreator(enTCatalogOld.getCreator());
				enTCatalog.setParentId(enTCatalogOld.getParentId());
				// 获得根目录的绝对路径
				String winPath = applicationXml.getInputValue("UPLOAD_CATALOG");
				// 获取目录的相对路径
				String filePart = PathByCatalog.pathByCatalogId(enTCatalog
						.getParentId(), transaction);
				StringBuffer filePathNew = new StringBuffer();
				filePathNew.append(winPath);
				filePathNew.append(filePart);
				filePathNew.append("/");
				filePathNew.append(enTCatalog.getCatalogName());
				File myFilePathNew = new File(filePathNew.toString());
				if (enTCatalogOld != null) {
					StringBuffer filePathOld = new StringBuffer();
					filePathOld.append(winPath);
					filePart = PathByCatalog.pathByCatalogId(enTCatalogOld
							.getCatalogId(), transaction);
					filePathOld.append(filePart);
					File myFilePathOld = new File(filePathOld.toString());
					dbTCatalog.updateByKey(catalogId, enTCatalog);
					// 判断旧目录是否存在，如果存在把旧目录从新命名，如果旧目录不存在则重新创建
					if (myFilePathOld.exists()) {
						myFilePathOld.renameTo(myFilePathNew);
					} else {
						myFilePathNew.mkdirs();
					}
				}
			} else {
				// 组装添加对象
				catalogId = BoAddAuto.GetBuildMode(transaction, "CATALOG_ID");
				enTCatalog.setCatalogId(catalogId);
				enTCatalog.setParentId(cataPraId);
				enTCatalog.setDeleteFlag("1");
				enTCatalog.setCreateDatetime(dateTime);
				enTCatalog.setCreator(userId);
				enTCatalog.setCatalogName(cataName);
				enTCatalog.setCatalogRemark(cataDesc);
				// 获得目录的路径
				String filePart = PathByCatalog.pathByCatalogId(enTCatalog
						.getParentId(), transaction);
				// 获得系统路径
				StringBuffer filePath = new StringBuffer();
				String winPath = applicationXml.getInputValue("UPLOAD_CATALOG");
				filePath.append(winPath);
				filePath.append(filePart + "/");
				filePath.append(enTCatalog.getCatalogName());
				// 获得创建文件或者目录路径
				File myFilePathNew = new File(filePath.toString());
				dbTCatalog.insert(enTCatalog);
				if (!myFilePathNew.exists()) {
					myFilePathNew.mkdirs();
				}
			}
		}
	}
}