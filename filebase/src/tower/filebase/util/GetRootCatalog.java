package tower.filebase.util;

import java.util.Vector;

import tower.filebase.db.DbTCatalog;
import tower.filebase.en.EnTCatalog;
import tower.tmvc.ErrorException;
import tower.tmvc.Transaction;

public class GetRootCatalog {

	public static String getRootId ( Transaction transaction) throws ErrorException{
	/***********************************************************************
	 * 声明变量
	 **********************************************************************/
	//目录db en
	DbTCatalog dbTCatalog;
	EnTCatalog enTCatalog;
	
	//其他
	String sql = "PARENT_ID  IS NULL";
	Vector vEnTCatalog;
	String catalogId="";
	/***********************************************************************
	 * 创建数据库连接、实例化DB、EN
	 **********************************************************************/
	transaction.createDefaultConnection(null, false);
	dbTCatalog = new DbTCatalog(transaction, null);
	/***********************************************************************
	 * 执行业务逻辑、输出
	 **********************************************************************/
		vEnTCatalog = dbTCatalog.findAllWhere(sql);
		if( vEnTCatalog!= null && vEnTCatalog.size() > 0){
			enTCatalog = (EnTCatalog) vEnTCatalog.get(0);
			catalogId = enTCatalog.getCatalogId();
			
		}
		return catalogId;
	}
}
