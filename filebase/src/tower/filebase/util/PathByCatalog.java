package tower.filebase.util;

import tower.filebase.db.DbTCatalog;
import tower.filebase.en.EnTCatalog;
import tower.tmvc.ErrorException;
import tower.tmvc.Transaction;
/**
 * 
 * @author Administrator
 * 
 * 根据文件所在目录的Id获得根目录的路径
 *
 */
public class PathByCatalog {
	
	public static String pathByCatalogId(String catalogId, Transaction transaction) throws ErrorException{
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		DbTCatalog dbTCatalog;
		EnTCatalog enTCatalog;
		StringBuffer path = new StringBuffer();
		String pathPart ;
		
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/

		transaction.createDefaultConnection(null, false);
		dbTCatalog = new DbTCatalog(transaction, null);
		
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		if(catalogId != null && catalogId.length() > 0){
			enTCatalog = dbTCatalog.findByKey(catalogId);
			if(enTCatalog != null){
				path.append(enTCatalog.getCatalogName());
				//path.insert(0, "/");
				pathPart = enTCatalog.getParentId();
				while(pathPart != "000000"){
					
					enTCatalog = dbTCatalog.findByKey(pathPart);
					if(enTCatalog != null){
						path.insert(0 , "/");
						path.insert(0, enTCatalog.getCatalogName());
						pathPart = enTCatalog.getParentId();
					}else{
						pathPart = "000000";
					}
				}
				//path.append("/");
			}
		}
		return path.toString();
	}

}
