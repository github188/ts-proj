package tower.cem.bo.INS.partDevicesLog;

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

public class BoDeviceInspectLogList  implements RootBo{

	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//查询条件
		String deviceNameEn;   //设备名称-英文
		String deviceNameCn;   //设备名称-中文
		String deviceIp;       //网络地址
		String execEndBegin;   //维护结束时间
		String execEndEnd;     //维护结束时间
		String typeId;         //设备类型
		String userId;        
		//其他
		StringBuffer sqlWhere = new StringBuffer();
		StringBuffer sql = new StringBuffer();
		
		QueryResult rs = null;
		QueryResult rs1 = null;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		deviceNameEn = requestXml.getInputValue("DEVICE_NAME_EN");
		deviceNameCn = requestXml.getInputValue("DEVICE_NAME_CN");
		deviceIp = requestXml.getInputValue("DEVICE_IP");
		execEndBegin = requestXml.getInputValue("INSPECT_END_BEGIN");
		execEndEnd = requestXml.getInputValue("INSPECT_ENDC_END");
		typeId = requestXml.getInputValue("TYPE_ID");
		userId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 sql.append(" select a.SEND_ID,b.DEVICE_NAME_EN,b.DEVICE_NAME_CN,e.TYPE_NAME_CN,b.DEVICE_IP,a.TASK_DEFINE_TIME, a.STATUS,a.EXEC_END_TIME" +
		 		    " from COMMANDS_SEND_HIS a ,DEVICE_INFO b ,DEVICE_TYPE e" +
		 		    " where  a.DEVICE_ID = b.DEVICE_ID " +
		 		    " and a.DEVICE_TYPE_ID = e.TYPE_ID " +
		 		    " and a.COMMANDS_TYPE = 'I' " +
		 		    " and a.DEVICE_ID is not null " +
		 		    " and a.DEVICE_ID IN  (select distinct device_id  " +
				        "from maintain_team t, maintain_team_device_map d, maintain_team_user_map u " +
				        "where t.team_id = d.team_id and t.team_id = u.team_id and u.user_id = ");
		 sql.append(Transaction.formatString(userId));
		 sql.append(")");
		 
		 //根据查询条件组装查询语句
		 
		 sqlWhere = new StringBuffer();
			if (deviceNameEn != null && deviceNameEn.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" b.DEVICE_NAME_EN  LIKE'%" + deviceNameEn + "%'");
				} else {
					sqlWhere.append(" AND b.DEVICE_NAME_EN LIKE '%" + deviceNameEn + "%'");
				}
			}
			if (deviceNameCn != null && deviceNameCn.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" b.DEVICE_NAME_CN  LIKE'%" + deviceNameCn + "%'");
				} else {
					sqlWhere.append(" AND b.DEVICE_NAME_CN LIKE '%" + deviceNameCn + "%'");
				}
			}
			if (deviceIp != null && deviceIp.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" b.DEVICE_IP  ='" + deviceIp + "'");
				} else {
					sqlWhere.append(" AND b.DEVICE_IP  ='" + deviceIp + "'");
				}
			}
			if (typeId != null && typeId.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" a.DEVICE_TYPE_ID  ='" + typeId + "'");
				} else {
					sqlWhere.append(" AND a.DEVICE_TYPE_ID  ='" + typeId + "'");
				}
			}
				
			if (execEndBegin != null && execEndBegin.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" a.EXEC_END_TIME  >='" + DateFunc.ParseDateTime(execEndBegin) + "000000'");
				} else {
					sqlWhere.append(" AND a.EXEC_END_TIME  >='" +DateFunc.ParseDateTime( execEndBegin )+ "000000'");
				}
			}
			if (execEndEnd != null && execEndEnd.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" a.EXEC_END_TIME  <='" + DateFunc.ParseDateTime(execEndEnd )+ "999999'");
				} else {
					sqlWhere.append(" AND a.EXEC_END_TIME  <='" +DateFunc.ParseDateTime( execEndEnd )+ "999999'");
				}
			}
			if (sqlWhere != null && sqlWhere.length() != 0) {
				sql.append(" and ");
				sql.append(sqlWhere.toString());
			}

			int page = Page.SetPageInfo(transaction, null, requestXml,
					PubFunc.LEN_PAGE_COUNT, sql.toString());
			rs = transaction.doQuery(null, sql.toString(), page,
					PubFunc.LEN_PAGE_COUNT);
			for(int i=0; i<rs.size(); i++){
				QueryResultRow rsRow = rs.get(i);
				if(rsRow != null){
					int row = requestXml.addRow("DEVICE_INSPECT_LOG");
					requestXml.setItemValue("DEVICE_INSPECT_LOG", row, "SEND_ID", rsRow.getString("SEND_ID"));
					requestXml.setItemValue("DEVICE_INSPECT_LOG", row, "DEVICE_NAME_EN", rsRow.getString("DEVICE_NAME_EN"));
					requestXml.setItemValue("DEVICE_INSPECT_LOG", row, "DEVICE_NAME_CN", rsRow.getString("DEVICE_NAME_CN"));
					requestXml.setItemValue("DEVICE_INSPECT_LOG", row, "TYPE_NAME_CN", rsRow.getString("TYPE_NAME_CN"));
					requestXml.setItemValue("DEVICE_INSPECT_LOG", row, "DEVICE_IP", rsRow.getString("DEVICE_IP"));
					requestXml.setItemValue("DEVICE_INSPECT_LOG", row, "TASK_DEFINE_TIME", DateFunc.FormatDateTime(rsRow.getString("TASK_DEFINE_TIME")));
					requestXml.setItemValue("DEVICE_INSPECT_LOG", row, "STATUS", rsRow.getString("STATUS"));
					requestXml.setItemValue("DEVICE_INSPECT_LOG", row, "EXEC_END_TIME", DateFunc.FormatDateTime(rsRow.getString("EXEC_END_TIME")));
				}
			}
			
	}
}
