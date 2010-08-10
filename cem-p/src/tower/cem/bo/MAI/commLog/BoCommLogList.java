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
 * 功能描述： 根据页面提交的查询条件从设备信息定义表（DEVICE_INFO）、维护指令执行日志（DEVICE_COMMAND_EXEC_LOG）
 * 获取满足条件的维护指令执行日志信息
 * 
 * @author flj
 * 
 */
public class BoCommLogList implements RootBo {

    public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml,
	    XMLWrap applicationXml, Logger logger) throws ErrorException {
	/***********************************************************************
         * 声明变量
         **********************************************************************/

	// 查询条件：
	String deviceNameEn;// 设备名称-英文
	String deviceNameCn;// 设备名称-中文
	String locationId; // 物理位置编号
	String deviceStatus;// 设备状态
	String deviceIp; // 网络地址
	String devicePort; // 网络端口
	String beginExecEnd;// 维护结束日期
	String endExecEnd;
	String userId;

	// 其他
	StringBuffer sqlWhere;
	QueryResult rs = null;
	/***********************************************************************
         * 获取输入
         **********************************************************************/
	deviceNameEn = requestXml.getInputValue("DEVICE_NAME_EN");
	deviceNameCn = requestXml.getInputValue("DEVICE_NAME_CN");
	locationId = requestXml.getInputValue("LOCATION_ID");
	deviceStatus = requestXml.getInputValue("DEVICE_STATUS");
	deviceIp = requestXml.getInputValue("DEVICE_IP");
	devicePort = requestXml.getInputValue("DEVICE_PORT");
	beginExecEnd = requestXml.getInputValue("BENGIN_EXEC_END");
	endExecEnd = requestXml.getInputValue("END_EXEC_END");
	userId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
	/***********************************************************************
         * 创建数据库连接、实例化DB、EN
         **********************************************************************/
	/***********************************************************************
         * 执行业务逻辑、输出
         **********************************************************************/
	// 根据查询条件组装查询语句
	sqlWhere = new StringBuffer();

	sqlWhere
		.append("select a. LOG_ID,a.DEVICE_ID,a.EXEC_BEGIN,a.EXEC_END,b.DEVICE_NAME_EN,b.DEVICE_NAME_CN, "
			+ "c.LOCATION_NAME_CN,b.DEVICE_IP,b.DEVICE_STATUS, d.USER_NAME "
			+ "from DEVICE_COMMAND_EXEC_LOG a,DEVICE_INFO  b,LOCATION_INFO c,SYS_USER d  "
			+ "where a.DEVICE_ID =b.DEVICE_ID "
			+ "and b.LOCATION_ID = c.LOCATION_ID "
			+ "and a.USER_ID = d.USER_ID "
			+ "and a.DEVICE_ID IN  (select distinct device_id  "
			+ "from maintain_team t, maintain_team_device_map d, maintain_team_user_map u "
			+ "where t.team_id = d.team_id and t.team_id = u.team_id and u.user_id = ");

	sqlWhere.append(transaction.formatString(userId));
	sqlWhere.append(")");

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

	if (beginExecEnd != null && beginExecEnd.length() != 0) {
	    if (sqlWhere == null || sqlWhere.length() == 0) {
		sqlWhere.append(" a.EXEC_END >= '" + DateFunc.ParseDateTime(beginExecEnd) + "000000'");
	    } else {
		sqlWhere.append(" AND a.EXEC_END >= '" + DateFunc.ParseDateTime(beginExecEnd) + "000000'");
	    }
	}
	if (endExecEnd != null && endExecEnd.length() != 0) {
	    if (sqlWhere == null || sqlWhere.length() == 0) {
		sqlWhere.append(" a.EXEC_END LIKE <= '" + DateFunc.ParseDateTime(endExecEnd) + "999999'");
	    } else {
		sqlWhere.append(" AND a.EXEC_END <= '" + DateFunc.ParseDateTime(endExecEnd) + "999999'");
	    }
	}
	sqlWhere.append(" order by a.EXEC_END  DESC");

	// 查询表，将符合条件的保存到requestXml中返回。
	int page = Page.SetPageInfo(transaction, null, requestXml, PubFunc.LEN_PAGE_COUNT, sqlWhere
		.toString());

	rs = transaction.doQuery(null, sqlWhere.toString(), page, PubFunc.LEN_PAGE_COUNT);

	for (int i = 0; i < rs.size(); i++) {
	    QueryResultRow rsRow = rs.get(i);
	    if (rsRow != null) {
		int row = requestXml.addRow("DEVICE_COMMAND_EXEC_LOG");
		requestXml.setItemValue("DEVICE_COMMAND_EXEC_LOG", row, "LOG_ID", rsRow.getString("LOG_ID"));
		requestXml.setItemValue("DEVICE_COMMAND_EXEC_LOG", row, "DEVICE_ID", rsRow
			.getString("DEVICE_ID"));
		requestXml.setItemValue("DEVICE_COMMAND_EXEC_LOG", row, "DEVICE_NAME_EN", rsRow
			.getString("DEVICE_NAME_EN"));
		requestXml.setItemValue("DEVICE_COMMAND_EXEC_LOG", row, "DEVICE_NAME_CN", rsRow
			.getString("DEVICE_NAME_CN"));
		requestXml.setItemValue("DEVICE_COMMAND_EXEC_LOG", row, "LOCATION_NAME", rsRow
			.getString("LOCATION_NAME_CN"));
		requestXml.setItemValue("DEVICE_COMMAND_EXEC_LOG", row, "DEVICE_IP", rsRow
			.getString("DEVICE_IP"));
		requestXml.setItemValue("DEVICE_COMMAND_EXEC_LOG", row, "DEVICE_STATUS", rsRow
			.getString("DEVICE_STATUS"));
		requestXml.setItemValue("DEVICE_COMMAND_EXEC_LOG", row, "EXEC_BEGIN", DateFunc
			.FormatDateTime(rsRow.getString("EXEC_BEGIN")));
		requestXml.setItemValue("DEVICE_COMMAND_EXEC_LOG", row, "EXEC_END", DateFunc
			.FormatDateTime(rsRow.getString("EXEC_END")));
		requestXml.setItemValue("DEVICE_COMMAND_EXEC_LOG", row, "USER_NAME",  rsRow.getString("USER_NAME"));

	    }
	}

    }
}
