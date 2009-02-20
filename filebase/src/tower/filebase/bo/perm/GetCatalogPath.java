package tower.filebase.bo.perm;

import tower.filebase.db.DbSysParam;
import tower.filebase.en.EnSysParam;
import tower.tmvc.ErrorException;
import tower.tmvc.Transaction;

public class GetCatalogPath {

	public String getCatalogPath(Transaction transaction) throws ErrorException{
		
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		DbSysParam dbSysParam;
		EnSysParam enSysParam;
		String pathPart ;
		
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/

		transaction.createDefaultConnection(null, false);
		dbSysParam = new DbSysParam(transaction, null);
		
		
		
		enSysParam = dbSysParam.findByKey("");
		
		pathPart = enSysParam.getParamValue();
		
		return pathPart;
	}
}
