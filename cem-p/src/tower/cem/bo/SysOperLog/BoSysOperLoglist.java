package tower.cem.bo.SysOperLog;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbSystemOperationLog;
import tower.cem.en.EnSystemOperationLog;
import tower.common.util.DateFunc;
import tower.common.util.Page;
import tower.common.util.PubFunc;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoSysOperLoglist implements RootBo{

	
	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml,
			XMLWrap applicationXml, Logger logger) throws ErrorException {
		/*****************************************************************************************************
		 * 声明变量
		 ****************************************************************************************************/
		// 系统操作日志db en
		DbSystemOperationLog dbSystemOperationLog;
		EnSystemOperationLog enSystemOperationLog;

		// 其他
		Vector logs;
		StringBuffer sqlWhere;
		/*****************************************************************************************************
		 * 获取输入
		 ****************************************************************************************************/
		String quserId = requestXml.getInputValue("USER_ID");
		String operDateUp = requestXml.getInputValue("OPERATION_TIME_BEGIN");
		String operDateDown = requestXml.getInputValue("OPERATION_TIME_END");
		String operFunc = requestXml.getInputValue("OPER_FUNC");
		/*****************************************************************************************************
		 * 创建数据库连接、实例化DB、EN
		 ****************************************************************************************************/
		transaction.createDefaultConnection(null, true);
		dbSystemOperationLog = new DbSystemOperationLog(transaction, null);
		enSystemOperationLog = new EnSystemOperationLog();
		/*****************************************************************************************************
		 * 执行业务逻辑、输出
		 ****************************************************************************************************/
		// 根据查询条件组装查询语句
		sqlWhere = new StringBuffer();
		if (quserId != null && quserId.length() != 0) {
			if (sqlWhere == null || sqlWhere.length() == 0) {
				sqlWhere.append(" USER_ID  LIKE'%" + quserId + "%'");
			} else {
				sqlWhere.append(" AND USER_ID LIKE '%" + quserId + "%'");
			}
		}
		if (operDateUp != null && operDateUp.length() != 0) {
			if (sqlWhere == null || sqlWhere.length() == 0) {
				sqlWhere.append(" OPERATION_TIME  >='" + DateFunc.ParseDateTime(operDateUp) + "000000'");
			} else {
				sqlWhere.append(" AND OPERATION_TIME  >='" +DateFunc.ParseDateTime( operDateUp )+ "000000'");
			}
		}
		if (operDateDown != null && operDateDown.length() != 0) {
			if (sqlWhere == null || sqlWhere.length() == 0) {
				sqlWhere.append(" OPERATION_TIME  <='" + DateFunc.ParseDateTime(operDateDown )+ "999999'");
			} else {
				sqlWhere.append(" AND OPERATION_TIME  <='" +DateFunc.ParseDateTime( operDateDown )+ "999999'");
			}
		}
		if (operFunc != null && operFunc.length() != 0) {
			if (sqlWhere == null || sqlWhere.length() == 0) {
				sqlWhere.append(" OPERATION_FUN_ID  = '" + operFunc + "'");
			} else {
				sqlWhere.append(" AND OPERATION_FUN_ID  = '" + operFunc + "'");
			}
		}
		// 查询表，将符合条件的保存到requestXml中返回。
		if (sqlWhere != null && sqlWhere.length() != 0) {
			Page.SetPageInfo(transaction, null, requestXml, dbSystemOperationLog, PubFunc.LEN_PAGE_COUNT,
					"SYSTEM_OPERATION_LOG", sqlWhere.toString());
			logs = dbSystemOperationLog.findAllWhere(sqlWhere.toString());

		} else {
			Page.SetPageInfo(transaction, null, requestXml, dbSystemOperationLog, PubFunc.LEN_PAGE_COUNT,
					"SYSTEM_OPERATION_LOG", null);
			logs = dbSystemOperationLog.findAll();
		}
		dbSystemOperationLog.setAllToXml(requestXml, logs);
}
}
