package tower.cem.bo.DAT.allDevicesRxpQuery;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbCommandsSendHis;
import tower.cem.db.DbDeviceInfo;
import tower.cem.db.DbDeviceType;
import tower.cem.en.EnCommandsSendHis;
import tower.cem.en.EnDeviceInfo;
import tower.cem.en.EnDeviceType;
import tower.common.util.DateFunc;
import tower.common.util.Page;
import tower.common.util.PubFunc;
import tower.tmvc.ErrorException;
import tower.tmvc.QueryResult;
import tower.tmvc.QueryResultRow;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoAllDevicesRxpQueryList implements RootBo {

    public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml,
	    XMLWrap applicationXml, Logger logger) throws ErrorException {

	// 查询条件
	String execEndBegin; // 维护结束时间
	String execEndEnd; // 维护结束时间

	// 设备类型db en
	DbDeviceType dbDeviceType;
	EnDeviceType enDeviceType;

	// 其他
	StringBuffer sqlWhere = new StringBuffer();
	StringBuffer sql = new StringBuffer();
	QueryResult rs = null;
	Vector vector;
	/***********************************************************************
         * 获取输入
         **********************************************************************/
	execEndBegin = requestXml.getInputValue("EXEC_END_TIME_BEGIN");
	execEndEnd = requestXml.getInputValue("EXEC_END_TIME_END");
	/***********************************************************************
         * 创建数据库连接、实例化DB、EN
         **********************************************************************/
	transaction.createDefaultConnection(null, true);
	dbDeviceType = new DbDeviceType(transaction, null);
	enDeviceType = new EnDeviceType();
	/***********************************************************************
         * 执行业务逻辑、输出
         **********************************************************************/
	vector = dbDeviceType.findAll();
	sql
		.append(" select a.SEND_ID,a.TASK_DEFINE_TIME, a.TASK_PLAN_TIME,a.STATUS,a.EXEC_BEGIN_TIME,a.EXEC_END_TIME,f.USER_NAME, a.DEVICE_TYPE_ID"
			+ " from COMMANDS_SEND_HIS a ,SYS_USER f where"
			+ "  a.USER_ID  = f.USER_ID "
			+ " and a.COMMANDS_TYPE = 'C' " + " and a.DEVICE_ID is  null ");

	if (execEndBegin != null && execEndBegin.length() != 0) {
	    if (sqlWhere == null || sqlWhere.length() == 0) {
		sqlWhere.append(" a.EXEC_END_TIME  >='" + DateFunc.ParseDateTime(execEndBegin) + "000000'");
	    } else {
		sqlWhere.append(" AND a.EXEC_END_TIME  >='" + DateFunc.ParseDateTime(execEndBegin)
			+ "000000'");
	    }
	}
	if (execEndEnd != null && execEndEnd.length() != 0) {
	    if (sqlWhere == null || sqlWhere.length() == 0) {
		sqlWhere.append(" a.EXEC_END_TIME  <='" + DateFunc.ParseDateTime(execEndEnd) + "999999'");
	    } else {
		sqlWhere.append(" AND a.EXEC_END_TIME  <='" + DateFunc.ParseDateTime(execEndEnd) + "999999'");
	    }
	}

	if (sqlWhere != null && sqlWhere.length() != 0) {
	    sql.append(" and ");
	    sql.append(sqlWhere.toString());
	    sql.append(" order by a.EXEC_END_TIME ");
	}

	int page = Page.SetPageInfo(transaction, null, requestXml, PubFunc.LEN_PAGE_COUNT, sql.toString());
	rs = transaction.doQuery(null, sql.toString(), page, PubFunc.LEN_PAGE_COUNT);
	for (int i = 0; i < rs.size(); i++) {
	    QueryResultRow rsRow = rs.get(i);
	    if (rsRow != null) {
		int row = requestXml.addRow("COMMANDS_SEND_HIS");
		String deviceTypeId = rsRow.getString("DEVICE_TYPE_ID");
		if (!(deviceTypeId == null || deviceTypeId.trim().length() == 0)) {
		    enDeviceType = dbDeviceType.findByKey(deviceTypeId);
		    if (enDeviceType != null) {
			requestXml.setItemValue("COMMANDS_SEND_HIS", row, "TYPE_NAME_CN", enDeviceType
				.getTypeNameCn());
			requestXml.setItemValue("COMMANDS_SEND_HIS", row, "DEVICE_TYPE_ID", enDeviceType
					.getTypeId());
		    }
		}else{
			requestXml.setItemValue("COMMANDS_SEND_HIS", row, "TYPE_NAME_CN", "全网设备");
		}

		requestXml.setItemValue("COMMANDS_SEND_HIS", row, "SEND_ID", rsRow.getString("SEND_ID"));
		requestXml.setItemValue("COMMANDS_SEND_HIS", row, "USER_NAME", rsRow.getString("USER_NAME"));
		requestXml.setItemValue("COMMANDS_SEND_HIS", row, "TASK_DEFINE_TIME", DateFunc
			.FormatDateTime(rsRow.getString("TASK_DEFINE_TIME")));
		requestXml.setItemValue("COMMANDS_SEND_HIS", row, "TASK_PLAN_TIME", DateFunc
			.FormatDateTime(rsRow.getString("TASK_PLAN_TIME")));
		requestXml.setItemValue("COMMANDS_SEND_HIS", row, "STATUS", rsRow.getString("STATUS"));
		requestXml.setItemValue("COMMANDS_SEND_HIS", row, "EXEC_BEGIN_TIME", DateFunc
			.FormatDateTime(rsRow.getString("EXEC_BEGIN_TIME")));
		requestXml.setItemValue("COMMANDS_SEND_HIS", row, "EXEC_END_TIME", DateFunc
			.FormatDateTime(rsRow.getString("EXEC_END_TIME")));
	    }
	}
    }
}
