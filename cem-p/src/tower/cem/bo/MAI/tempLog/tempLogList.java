package tower.cem.bo.MAI.tempLog;

import java.util.Date;

import org.apache.log4j.Logger;

import tower.cem.db.DbCommandsSendHis;
import tower.cem.en.EnCommandsSendHis;
import tower.common.util.DateFunc;
import tower.common.util.Page;
import tower.common.util.PubFunc;
import tower.tmvc.ErrorException;
import tower.tmvc.QueryResult;
import tower.tmvc.QueryResultRow;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 功能描述：
 * 1、获取页面提交的查询条件
 * 2、组装查询语句
 * 3、从指令发送任务历史表（COMMANDS_SEND_HIS）中获取满足条件的信息
 * @author flj
 *
 */
public class tempLogList implements RootBo{

	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//指令发送任务历史表 db en
		DbCommandsSendHis dbCommandsSendHis;
		EnCommandsSendHis enCommandsSendHis;
		
		String userId;       //维护人员编号
		String deviceNameEn; //设备名称-英文
		String deviceNameCn; //设备名称-中文
		String locationId;   //物理位置编号
		String deviceIp;    //网络地址
		String execBegin_start;   //
		String execEnd_end;     //
		String tempId;     //指令模板编号
		
		//其他
		StringBuffer sqlWhere = new StringBuffer();
		StringBuffer sql = new StringBuffer();
		
		QueryResult rs = null;
		QueryResult rs1 = null;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		userId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		deviceNameEn = requestXml.getInputValue("QDEVICE_NAME_EN");
		deviceNameCn = requestXml.getInputValue("QDEVICE_NAME_CN");
		locationId = requestXml.getInputValue("QLOCATION_ID");
		deviceIp = requestXml.getInputValue("QDEVICE_IP");
		execBegin_start = DateFunc.ParseDateTime(requestXml.getInputValue("QEXEC_BEGIN"));
		execEnd_end = DateFunc.ParseDateTime(requestXml.getInputValue("QEXEC_END"));
		tempId = requestXml.getInputValue("QTEMP_ID");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		 dbCommandsSendHis = new DbCommandsSendHis(transaction,null);
		 enCommandsSendHis = new EnCommandsSendHis();
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 sql.append("select a.SEND_ID,a.DEVICE_ID,a.TASK_DEFINE_TIME,a.TASK_PLAN_TIME,a.EXEC_BEGIN_TIME,a.EXEC_END_TIME,b.DEVICE_NAME_EN,b.DEVICE_IP,c.TEMP_NAME,d.USER_NAME，e.LOG_CONT" +
		 		"from COMMANDS_SEND_HIS a " +
		 		"left join SYS_USER d on a.USER_ID = d.USER_ID" +
		 		"left join DEVICE_INFO b on a.DEVICE_ID = b.DEVICE_ID" +
		 		"left join MAINTAIN_COMMANDS_TEMPLATE c on a.TEMPLATE_ID = c.TEMP_ID" +
		 		"left join DEVICE_MAINTAIN_LOG e on e.SEND_ID = d.SEND_ID" +
		 		"where a.USER_ID=");
		 sql.append(Transaction.formatString(userId));
		 sql.append(" AND a.COMMANDS_TYPE =");
		 sql.append(Transaction.formatString("T"));
		 //根据查询条件组装查询语句
		 sqlWhere = new StringBuffer();
			if (deviceNameEn != null && deviceNameEn.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" b.DEVICE_NAME_EN  LIKE'%" + deviceNameEn + "%'");
				} else {
					sqlWhere.append(" AND b.DEVICE_NAME_EN LIKE '%" + deviceNameEn + "%'");
				}
			}
			if (locationId != null && locationId.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" b.DEVICE_NAME_EN  ='" + locationId + "'");
				} else {
					sqlWhere.append(" AND b.DEVICE_NAME_EN  ='" + locationId + "'");
				}
			}
			if (tempId != null && tempId.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" a.TEMPLATE_ID  ='" + tempId + "'");
				} else {
					sqlWhere.append(" AND a.TEMPLATE_ID  ='" + tempId + "'");
				}
			}
			if (deviceIp != null && deviceIp.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" b.DEVICE_IP  ='" + deviceIp + "'");
				} else {
					sqlWhere.append(" AND b.DEVICE_IP  ='" + deviceIp + "'");
				}
			}
			if (execBegin_start != null && execBegin_start.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" a.EXEC_BEGIN  >='" + execBegin_start + "'");
				} else {
					sqlWhere.append(" AND a.EXEC_BEGIN  >='" + execBegin_start + "'");
				}
			}
			if (execBegin_start != null && execBegin_start.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" a.EXEC_BEGIN  <='" + execBegin_start + "'");
				} else {
					sqlWhere.append(" AND a.EXEC_BEGIN  <='" + execBegin_start + "'");
				}
			}
			if (execEnd_end != null && execEnd_end.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" a.EXEC_END  >='" + execEnd_end + "'");
				} else {
					sqlWhere.append(" AND a.EXEC_END  >='" + execEnd_end + "'");
				}
			}
			if (execEnd_end != null && execEnd_end.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" a.EXEC_END  <='" + execEnd_end + "'");
				} else {
					sqlWhere.append(" AND a.EXEC_END  <='" + execEnd_end + "'");
				}
			}
			
			int page = Page.SetPageInfo(transaction, null, requestXml,
					PubFunc.LEN_PAGE_COUNT, sql.toString());
			rs = transaction.doQuery(null, sql.toString(), page,
					PubFunc.LEN_PAGE_COUNT);
			for(int i=0; i<rs.size(); i++){
				QueryResultRow rsRow = rs.get(i);
				if(rsRow != null){
					int row = requestXml.addRow("DEVICE_MAINTAIN_LOG");
					requestXml.setItemValue("DEVICE_MAINTAIN_LOG", row, "SEND_ID", rsRow.getString("SEND_ID"));
					requestXml.setItemValue("DEVICE_MAINTAIN_LOG", row, "DEVICE_ID", rsRow.getString("DEVICE_ID"));
					requestXml.setItemValue("DEVICE_MAINTAIN_LOG", row, "USER_NAME", rsRow.getString("USER_NAME"));
					requestXml.setItemValue("DEVICE_MAINTAIN_LOG", row, "DEVICE_NAME_EN", rsRow.getString("DEVICE_NAME_EN"));
					requestXml.setItemValue("DEVICE_MAINTAIN_LOG", row, "DEVICE_IP", rsRow.getString("DEVICE_IP"));
					requestXml.setItemValue("DEVICE_MAINTAIN_LOG", row, "TASK_DEFINE_TIME", rsRow.getString("TASK_DEFINE_TIME"));
					requestXml.setItemValue("DEVICE_MAINTAIN_LOG", row, "TASK_PLAN_TIME", rsRow.getString("TASK_PLAN_TIME"));
					requestXml.setItemValue("DEVICE_MAINTAIN_LOG", row, "TEMPLATE_NAME", rsRow.getString("TEMPLATE_NAME"));
					requestXml.setItemValue("DEVICE_MAINTAIN_LOG", row, "STATUS", rsRow.getString("STATUS"));
					requestXml.setItemValue("DEVICE_MAINTAIN_LOG", row, "EXEC_BEGIN_TIME", rsRow.getString("EXEC_BEGIN_TIME"));
					requestXml.setItemValue("DEVICE_MAINTAIN_LOG", row, "EXEC_END_TIME", rsRow.getString("EXEC_END_TIME"));
				}
			}
			
	}

}
