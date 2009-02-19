package tower.filebase.bo.sys.catalog;

import org.apache.log4j.Logger;

import tower.filebase.db.DbTCatalog;
import tower.filebase.en.EnTCatalog;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoCatalogDetail implements RootBo {

	/**
	 * <strong>输入：目录Id</strong><br>
	 * <br>
	 * <strong>业务逻辑：查找目录的基本信息</strong><br>
	 * <br>
	 * <strong>输出：</strong><br>
	 * 目录的基本信息<br>
	 * <br>
	 */
	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//目录db en
		DbTCatalog dbTCatalog;
		EnTCatalog enTCatalog;
		String catalogId ;
		
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/

		catalogId = requestXml.getInputValue("CATALOG_ID");
		
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		
		transaction.createDefaultConnection(null, false);
		dbTCatalog = new DbTCatalog(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		enTCatalog = dbTCatalog.findByKey(catalogId);
		if(enTCatalog != null){
			dbTCatalog.setToXml(requestXml, enTCatalog);
		}
	}

}
