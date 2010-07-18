package tower.cem.bo.MAI.commLog;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbDeviceCommandExecLog;
import tower.cem.db.DbDeviceInfo;
import tower.cem.db.DbFrontHostInfo;
import tower.cem.db.DbLocationInfo;
import tower.cem.en.EnDeviceCommandExecLog;
import tower.cem.en.EnDeviceInfo;
import tower.cem.en.EnFrontHostInfo;
import tower.cem.en.EnLocationInfo;
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
 * 根据页面提交的查询条件从设备信息定义表（DEVICE_INFO）、维护指令执行日志（DEVICE_COMMAND_EXEC_LOG）
 * 获取满足条件的维护指令执行日志信息
 * @author flj
 *
 */
public class BoCommLogList implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml,
			XMLWrap applicationXml, Logger logger) throws ErrorException {
		/*****************************************************************************************************
		 * 声明变量
		 ****************************************************************************************************/
		// 设备配置db en
		DbDeviceInfo dbDeviceInfo;
		EnDeviceInfo enDeviceInfo;
		
		//维护指令执行日志 db en
		DbDeviceCommandExecLog dbDeviceCommandExecLog;
		EnDeviceCommandExecLog enDeviceCommandExecLog;

		// 物理位置db en
		DbLocationInfo dbLocationInfo;
		EnLocationInfo enLocationInfo;
		
		// 查询条件：
		String deviceNameEn;// 设备名称-英文
		String deviceNameCn;// 设备名称-中文
		String locationId; // 物理位置编号
		String deviceStatus;// 设备状态
		String deviceIp; // 网络地址
		String devicePort; // 网络端口
		String beginExecBegin; //维护开始日期
		String endExecBegin;
		String beginExecEnd;//维护结束日期
		String endExecEnd;  
		
		// 其他
		Vector devices;
		StringBuffer sqlWhere;
		
		QueryResult rs = null;
		QueryResult rs1 = null;
		/*****************************************************************************************************
		 * 获取输入
		 ****************************************************************************************************/
		deviceNameEn = requestXml.getInputValue("DEVICE_NAME_EN");
		deviceNameCn = requestXml.getInputValue("DEVICE_NAME_CN");
		locationId = requestXml.getInputValue("LOCATION_ID");
		deviceStatus = requestXml.getInputValue("DEVICE_STATUS");
		deviceIp = requestXml.getInputValue("DEVICE_IP");
		devicePort = requestXml.getInputValue("DEVICE_PORT");
		beginExecBegin = requestXml.getInputValue("BENGIN_EXEC_BEGIN");
		endExecBegin = requestXml.getInputValue("END_EXEC_BEGIN");
		beginExecEnd = requestXml.getInputValue("BENGIN_EXEC_END");
		endExecEnd = requestXml.getInputValue("END_EXEC_END");
		/*****************************************************************************************************
		 * 创建数据库连接、实例化DB、EN
		 ****************************************************************************************************/
		transaction.createDefaultConnection(null, true);
		dbLocationInfo = new DbLocationInfo(transaction, null);
		dbDeviceInfo = new DbDeviceInfo(transaction, null);
		dbDeviceCommandExecLog = new DbDeviceCommandExecLog(transaction, null);
		/*****************************************************************************************************
		 * 执行业务逻辑、输出
		 ****************************************************************************************************/
		// 根据查询条件组装查询语句
		sqlWhere = new StringBuffer();
		
		sqlWhere.append("select a. LOG_ID,a.DEVICE_ID,a.EXEC_BEGIN,a.EXEC_END,b.DEVICE_NAME_EN,b.DEVICE_NAME_CN," +
				"c.LOCATION_NAME_CN,b.DEVICE_IP,b.DEVICE_STATUS"
				+ " from  DEVICE_COMMAND_EXEC_LOG a " +
			   "inner join DEVICE_INFO  b on a.DEVICE_ID =b.DEVICE_ID " +
			   "left join LOCATION_INFO c on b.LOCATION_ID = c.LOCATION_ID"
			   + " where 1=1 ");
		
		if (deviceNameEn != null && deviceNameEn.length() != 0) {
			if (sqlWhere == null || sqlWhere.length() == 0) {
				sqlWhere.append(" b.DEVICE_NAME_EN  LIKE'%" + deviceNameEn + "%'");
			} else {
				sqlWhere.append(" AND b.DEVICE_NAME_EN LIKE '%" + deviceNameEn + "%'");
			}
		}
		if (deviceNameCn != null && deviceNameCn.length() != 0) {
			if (sqlWhere == null || sqlWhere.length() == 0) {
				sqlWhere.append(" b.DEVICE_NAME_CN LIKE '%" + deviceNameCn + "%'");
			} else {
				sqlWhere.append(" AND b.DEVICE_NAME_CN LIKE '%" + deviceNameCn + "%'");
			}
		}
		if (locationId != null && locationId.length() != 0) {
			if (sqlWhere == null || sqlWhere.length() == 0) {
				sqlWhere.append(" b.LOCATION_ID  = '" + locationId + "'");
			} else {
				sqlWhere.append(" AND b.LOCATION_ID  = '" + locationId + "'");
			}
		}
		if (deviceStatus != null && deviceStatus.length() != 0) {
			if (sqlWhere == null || sqlWhere.length() == 0) {
				sqlWhere.append(" b.DEVICE_STATUS = '" + deviceStatus + "'");
			} else {
				sqlWhere.append(" AND b.DEVICE_STATUS = '" + deviceStatus + "'");
			}
		}
		if (deviceIp != null && deviceIp.length() != 0) {
			if (sqlWhere == null || sqlWhere.length() == 0) {
				sqlWhere.append(" b.DEVICE_IP LIKE '%" + deviceIp + "%'");
			} else {
				sqlWhere.append(" AND b.DEVICE_IP LIKE '%" + deviceIp + "%'");
			}
		}
		if (devicePort != null && devicePort.length() != 0) {
			if (sqlWhere == null || sqlWhere.length() == 0) {
				sqlWhere.append(" b.DEVICE_PORT LIKE '%" + devicePort + "%'");
			} else {
				sqlWhere.append(" AND b.DEVICE_PORT LIKE '%" + devicePort + "%'");
			}
		}
		
		if (beginExecBegin != null && beginExecBegin.length() != 0) {
			if (sqlWhere == null || sqlWhere.length() == 0) {
				sqlWhere.append(" a.EXEC_BEGIN >='" + DateFunc.ParseDateTime(beginExecBegin) + "'");
			} else {
				sqlWhere.append(" AND a.EXEC_BEGIN >='" + DateFunc.ParseDateTime(beginExecBegin) + "'");
			}
		}
		
		if (endExecBegin != null && endExecBegin.length() != 0) {
			if (sqlWhere == null || sqlWhere.length() == 0) {
				sqlWhere.append(" a.EXEC_BEGIN <='" + DateFunc.ParseDateTime(endExecBegin) + "'");
			} else {
				sqlWhere.append(" AND a.EXEC_BEGIN <='" + DateFunc.ParseDateTime(endExecBegin) + "'");
			}
		}
		
		if (beginExecEnd != null && beginExecEnd.length() != 0) {
			if (sqlWhere == null || sqlWhere.length() == 0) {
				sqlWhere.append(" a.EXEC_END >= '" + DateFunc.ParseDateTime(beginExecEnd) + "'");
			} else {
				sqlWhere.append(" AND a.EXEC_END >= '" + DateFunc.ParseDateTime(beginExecEnd )+ "'");
			}
		}
		if (endExecEnd != null && endExecEnd.length() != 0) {
			if (sqlWhere == null || sqlWhere.length() == 0) {
				sqlWhere.append(" a.EXEC_END LIKE <= '" + DateFunc.ParseDateTime(endExecEnd) + "'");
			} else {
				sqlWhere.append(" AND a.EXEC_END <= '" + DateFunc.ParseDateTime(endExecEnd )+ "'");
			}
		}
		sqlWhere.append(" order by a.DEVICE_ID , a.EXEC_BEGIN  DESC");
		 
		// 查询表，将符合条件的保存到requestXml中返回。
		int page = Page.SetPageInfo(transaction, null, requestXml,
				PubFunc.LEN_PAGE_COUNT, sqlWhere.toString());
		
		rs = transaction.doQuery(null, sqlWhere.toString(), page,
				PubFunc.LEN_PAGE_COUNT);
		
		for(int i=0; i<rs.size(); i++){
			QueryResultRow rsRow = rs.get(i);
			if(rsRow != null){
				int row = requestXml.addRow("DEVICE_COMMAND_EXEC_LOG");
				requestXml.setItemValue("DEVICE_COMMAND_EXEC_LOG", row, "LOG_ID", rsRow.getString("LOG_ID"));
				requestXml.setItemValue("DEVICE_COMMAND_EXEC_LOG", row, "DEVICE_ID", rsRow.getString("DEVICE_ID"));
				requestXml.setItemValue("DEVICE_COMMAND_EXEC_LOG", row, "DEVICE_NAME_EN", rsRow.getString("DEVICE_NAME_EN"));
				requestXml.setItemValue("DEVICE_COMMAND_EXEC_LOG", row, "DEVICE_NAME_CN", rsRow.getString("DEVICE_NAME_CN"));
				requestXml.setItemValue("DEVICE_COMMAND_EXEC_LOG", row, "LOCATION_NAME", rsRow.getString("LOCATION_NAME_CN"));
				requestXml.setItemValue("DEVICE_COMMAND_EXEC_LOG", row, "DEVICE_IP", rsRow.getString("DEVICE_IP"));
				requestXml.setItemValue("DEVICE_COMMAND_EXEC_LOG", row, "DEVICE_STATUS", rsRow.getString("DEVICE_STATUS"));
				requestXml.setItemValue("DEVICE_COMMAND_EXEC_LOG", row, "EXEC_BEGIN", rsRow.getString("EXEC_BEGIN"));
				requestXml.setItemValue("DEVICE_COMMAND_EXEC_LOG", row, "EXEC_END", rsRow.getString("EXEC_END"));
				
			}
		}
		
	}
}
