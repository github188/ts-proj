package tower.cem.bo.MAI.tempLog;

import java.util.Date;

import org.apache.log4j.Logger;

import tower.cem.db.DbCommandsSendHis;
import tower.cem.db.DbDeviceMaintainLog;
import tower.cem.en.EnCommandsSendHis;
import tower.cem.en.EnDeviceMaintainLog;
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
		
		//维护指令模板发送日志 db en
		DbDeviceMaintainLog dbDeviceMaintainLog;
		EnDeviceMaintainLog enDeviceMaintainLog;
		
		//查询条件
		String deviceNameEn;   //设备名称-英文
		String deviceNameCn;   //设备名称-中文
		String locationId;     //物理位置
		String deviceIp;       //网络地址
		String execBeginBegin; //维护开始时间
		String execBeginEnd;   //维护开始时间
		String execEndBegin;   //维护结束时间
		String execEndEnd;     //维护结束时间
		String tempId;         //模板编号
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
		deviceNameEn = requestXml.getInputValue("QDEVICE_NAME_EN");
		deviceNameCn = requestXml.getInputValue("QDEVICE_NAME_CN");
		locationId = requestXml.getInputValue("QLOCATION_ID");
		deviceIp = requestXml.getInputValue("QDEVICE_IP");
		execBeginBegin = requestXml.getInputValue("QEXEC_BEGIN_BEGIN");
		execBeginEnd = requestXml.getInputValue("QEXEC_BEGIN_END");
		execEndBegin = requestXml.getInputValue("QEXEC_END_BEGIN");
		execEndEnd = requestXml.getInputValue("QEXEC_END_END");
		tempId = requestXml.getInputValue("QTEMP_ID");
		typeId = requestXml.getInputValue("QTYPE_ID");
		userId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		 dbCommandsSendHis = new DbCommandsSendHis(transaction,null);
		 enCommandsSendHis = new EnCommandsSendHis();
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 sql.append("select a.SEND_ID,b.DEVICE_NAME_EN,b.DEVICE_NAME_CN,e.TYPE_NAME_CN,b.DEVICE_IP,a.TASK_DEFINE_TIME," +
		 		"c.TEMP_NAME,d.STATUS,d.MAINTAIN_END " +
		 		"from COMMANDS_SEND_HIS a " +
		 		"left join DEVICE_INFO b on a.DEVICE_ID = b.DEVICE_ID" +
		 		"left join MAINTAIN_COMMANDS_TEMPLATE c on a.TEMPLATE_ID = c.TEMP_ID" +
		 		"left join DEVICE_MAINTAIN_LOG d on a.SEND_ID = d.SEND_ID" +
		 		"left join DEVICE_TYPE e on a.TYPE_ID = e.TYPE_ID" +
		 		"left join LOCATION_INFO f on a.TYPE_ID = e.TYPE_ID" +
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
			if (tempId != null && tempId.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" a.TEMPLATE_ID  ='" + tempId + "'");
				} else {
					sqlWhere.append(" AND a.TEMPLATE_ID  ='" + tempId + "'");
				}
			}
			if (typeId != null && typeId.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" a.DEVICE_TYPE_ID  ='" + typeId + "'");
				} else {
					sqlWhere.append(" AND a.DEVICE_TYPE_ID  ='" + typeId + "'");
				}
			}
				
			if (execBeginBegin != null && execBeginBegin.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" a.MAINTAIN_BEGIN  >='" + execBeginBegin + "'");
				} else {
					sqlWhere.append(" AND a.MAINTAIN_BEGIN  >='" + execBeginBegin + "'");
				}
			}
			if (execBeginEnd != null && execBeginEnd.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" a.MAINTAIN_BEGIN  <='" + execBeginEnd + "'");
				} else {
					sqlWhere.append(" AND a.MAINTAIN_BEGIN  <='" + execBeginEnd + "'");
				}
			}
			if (execEndBegin != null && execEndBegin.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" a.MAINTAIN_END  >='" + execEndBegin + "'");
				} else {
					sqlWhere.append(" AND a.MAINTAIN_END  >='" + execEndBegin + "'");
				}
			}
			if (execEndEnd != null && execEndEnd.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" a.MAINTAIN_END  >='" + execEndEnd + "'");
				} else {
					sqlWhere.append(" AND a.MAINTAIN_END  >='" + execEndEnd + "'");
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
					requestXml.setItemValue("DEVICE_MAINTAIN_LOG", row, "DEVICE_NAME_EN", rsRow.getString("DEVICE_NAME_EN"));
					requestXml.setItemValue("DEVICE_MAINTAIN_LOG", row, "DEVICE_NAME_CN", rsRow.getString("DEVICE_NAME_CN"));
					requestXml.setItemValue("DEVICE_MAINTAIN_LOG", row, "TYPE_NAME", rsRow.getString("TYPE_NAME"));
					requestXml.setItemValue("DEVICE_MAINTAIN_LOG", row, "DEVICE_IP", rsRow.getString("DEVICE_IP"));
					requestXml.setItemValue("DEVICE_MAINTAIN_LOG", row, "TASK_DEFINE_TIME", rsRow.getString("TASK_DEFINE_TIME"));
					requestXml.setItemValue("DEVICE_MAINTAIN_LOG", row, "TEMPLATE_NAME", rsRow.getString("TEMPLATE_NAME"));
					requestXml.setItemValue("DEVICE_MAINTAIN_LOG", row, "STATUS", rsRow.getString("STATUS"));
					requestXml.setItemValue("DEVICE_MAINTAIN_LOG", row, "EXEC_BEGIN_TIME", rsRow.getString("EXEC_BEGIN_TIME"));
					requestXml.setItemValue("DEVICE_MAINTAIN_LOG", row, "EXEC_END_TIME", rsRow.getString("EXEC_END_TIME"));
				}
			}
			
	}

}
