package tower.cem.bo.SysOperLog;


import org.apache.log4j.Logger;

import tower.cem.db.DbSystemOperationLog;
import tower.cem.en.EnSystemOperationLog;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoSysOperLogDetail implements RootBo{

	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml,
			XMLWrap applicationXml, Logger logger) throws ErrorException {
		/*****************************************************************************************************
		 * 声明变量
		 ****************************************************************************************************/
		// 系统操作日志db en
		DbSystemOperationLog dbSystemOperationLog;
		EnSystemOperationLog enSystemOperationLog;

		/*****************************************************************************************************
		 * 获取输入
		 ****************************************************************************************************/
		String logId = requestXml.getInputValue("LOG_ID");
		/*****************************************************************************************************
		 * 创建数据库连接、实例化DB、EN
		 ****************************************************************************************************/
		transaction.createDefaultConnection(null, true);
		dbSystemOperationLog = new DbSystemOperationLog(transaction, null);
		enSystemOperationLog = new EnSystemOperationLog();
		/*****************************************************************************************************
		 * 执行业务逻辑、输出
		 ****************************************************************************************************/
		enSystemOperationLog = dbSystemOperationLog.findByKey(logId);
		dbSystemOperationLog.setToXml(requestXml, enSystemOperationLog);
}
}
