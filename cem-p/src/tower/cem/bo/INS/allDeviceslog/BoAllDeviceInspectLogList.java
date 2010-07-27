package tower.cem.bo.INS.allDeviceslog;


import org.apache.log4j.Logger;

import tower.common.util.DateFunc;
import tower.common.util.Page;
import tower.common.util.PubFunc;
import tower.tmvc.ErrorException;
import tower.tmvc.QueryResult;
import tower.tmvc.QueryResultRow;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoAllDeviceInspectLogList implements RootBo {
	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		
		
		//查询条件
		String execEndBegin;   //维护结束时间
		String execEndEnd;     //维护结束时间
		
		//其他
		StringBuffer sqlWhere = new StringBuffer();
		StringBuffer sql = new StringBuffer();
		QueryResult rs = null;
		
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		execEndBegin = requestXml.getInputValue("INSPECT_END_BEGIN");
		execEndEnd = requestXml.getInputValue("INSPECT_END_END");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 sql.append(" select a.SEND_ID,e.TYPE_NAME_CN,a.TASK_DEFINE_TIME, a.TASK_PLAN_TIME,a.STATUS,a.EXEC_BEGIN_TIME,a.EXEC_END_TIME,f.USER_NAME" +
		 		    " from COMMANDS_SEND_HIS a ,DEVICE_TYPE e , SYS_USER f" +
		 		    " where a.DEVICE_TYPE_ID = e.TYPE_ID " +
		 		    " and a.USER_ID  = f.USER_ID " +
		 		    " and a.COMMANDS_TYPE = 'I' " +
		 		    " and a.DEVICE_ID is  null " );
		 
			if (execEndBegin != null && execEndBegin.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" a.EXEC_END_TIME  >='" + DateFunc.ParseDateTime(execEndBegin) + "'");
				} else {
					sqlWhere.append(" AND a.EXEC_END_TIME  >='" + DateFunc.ParseDateTime(execEndBegin) + "'");
				}
			}
			if (execEndEnd != null && execEndEnd.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" a.EXEC_END_TIME  <='" + DateFunc.ParseDateTime(execEndEnd)+ "'");
				} else {
					sqlWhere.append(" AND a.EXEC_END_TIME  <='" + DateFunc.ParseDateTime(execEndEnd )+ "'");
				}
			}
			
			if (sqlWhere != null && sqlWhere.length() != 0) {
				sql.append(" and ");
				sql.append(sqlWhere.toString());
			}
			
			System.out.println(sql.toString());
		 int page = Page.SetPageInfo(transaction, null, requestXml,
					PubFunc.LEN_PAGE_COUNT, sql.toString());
			rs = transaction.doQuery(null, sql.toString(), page,
					PubFunc.LEN_PAGE_COUNT);
			for(int i=0; i<rs.size(); i++){
				QueryResultRow rsRow = rs.get(i);
				if(rsRow != null){
					int row = requestXml.addRow("COMMANDS_SEND_HIS");
					requestXml.setItemValue("COMMANDS_SEND_HIS", row, "SEND_ID", rsRow.getString("SEND_ID"));
					requestXml.setItemValue("COMMANDS_SEND_HIS", row, "USER_NAME", rsRow.getString("USER_NAME"));
					requestXml.setItemValue("COMMANDS_SEND_HIS", row, "TYPE_NAME_CN", rsRow.getString("TYPE_NAME_CN"));
					requestXml.setItemValue("COMMANDS_SEND_HIS", row, "TASK_DEFINE_TIME", DateFunc.FormatDateTime(rsRow.getString("TASK_DEFINE_TIME")));
					requestXml.setItemValue("COMMANDS_SEND_HIS", row, "TASK_PLAN_TIME", DateFunc.FormatDateTime(rsRow.getString("TASK_PLAN_TIME")));
					requestXml.setItemValue("COMMANDS_SEND_HIS", row, "STATUS", rsRow.getString("STATUS"));
					requestXml.setItemValue("COMMANDS_SEND_HIS", row, "EXEC_BEGIN_TIME", DateFunc.FormatDateTime(rsRow.getString("EXEC_BEGIN_TIME")));
					requestXml.setItemValue("COMMANDS_SEND_HIS", row, "EXEC_END_TIME", DateFunc.FormatDateTime(rsRow.getString("EXEC_END_TIME")));
				}
			}
	}

}
