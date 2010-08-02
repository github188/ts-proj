package tower.cem.bo.DAT.partDeviceRxpQuery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbDeviceInfo;
import tower.cem.db.DbDeviceInspectLog;
import tower.cem.db.DbDevicePortRxp;
import tower.cem.en.EnDeviceInfo;
import tower.cem.en.EnDeviceInspectLog;
import tower.cem.en.EnDevicePortRxp;
import tower.common.util.Page;
import tower.common.util.PubFunc;
import tower.tmvc.ErrorException;
import tower.tmvc.QueryResult;
import tower.tmvc.QueryResultRow;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoRxpDetail implements RootBo{

	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml,
			XMLWrap applicationXml, Logger logger) throws ErrorException {

	/*****************************************************************************************************
	 * 声明变量
	 ****************************************************************************************************/
	//设备光功率数据 db en
	DbDevicePortRxp dbDevicePortRxp;
	EnDevicePortRxp enDevicePortRxp;
	
	//发送编号
	String sendId;
	
	//其他
	StringBuffer sql = new StringBuffer();
	
	QueryResult rs = null;
	
	/*****************************************************************************************************
	 * 获取输入
	 ****************************************************************************************************/
	sendId = requestXml.getInputValue("SEND_ID");
	/*****************************************************************************************************
	 * 创建数据库连接、实例化DB、EN
	 ****************************************************************************************************/
	transaction.createDefaultConnection(null, true);
	dbDevicePortRxp = new DbDevicePortRxp(transaction, null);
	enDevicePortRxp = new EnDevicePortRxp();
	/*****************************************************************************************************
	 * 执行业务逻辑、输出
	 ****************************************************************************************************/
	sql.append("select c.TYPE_NAME_CN,a.DEVICE_NAME,a.SEND_ID,b.DEVICE_IP,a.RXP,a.PORT_SN,d.STATUS,f.TYPE_NAME_CN,g.COLLECT_END ," +
			   "f.STANDARD_RX_MAX,f.STANDARD_RX_MIN ,f.NETWORK_RX_MIN" +
			   " from DEVICE_PORT_RXP a,DEVICE_INFO b, DEVICE_TYPE c,DEVICE_PORT_INFO d,DEVICE_PORT_TYPE f, DEVICE_COLLECT_LOG g" +
			   " where a.DEVICE_ID = b.DEVICE_ID " +
			   " and a.PORT_ID = d.PORT_ID " +
			   " and  d.TYPE_ID = f.TYPE_ID " +
			   " and a.SEND_ID = g.SEND_ID" +
			   " and  b.TYPE_ID = c.TYPE_ID" +
			   " and a.SEND_ID = ");
	sql.append(transaction.formatString(sendId));
	rs = transaction.doQuery(null, sql.toString());
	for(int i =0; i<rs.size();i++){
		QueryResultRow rsRow =  rs.get(i);
		int row  = requestXml.addInputRow("DEVICE_PORT_RXP");
		requestXml.setItemValue("DEVICE_PORT_RXP", row, "SEND_ID",rsRow.getString("SEND_ID"));
		requestXml.setItemValue("DEVICE_PORT_RXP", row, "TYPE_NAME",rsRow.getString("TYPE_NAME_CN"));
		requestXml.setItemValue("DEVICE_PORT_RXP", row, "DEVICE_NAME",rsRow.getString("DEVICE_NAME"));
		requestXml.setItemValue("DEVICE_PORT_RXP", row, "DEVICE_IP",rsRow.getString("DEVICE_IP"));
		requestXml.setItemValue("DEVICE_PORT_RXP", row, "PORT_SN",rsRow.getString("PORT_SN"));
		requestXml.setItemValue("DEVICE_PORT_RXP", row, "TYPE_NAME_CN",rsRow.getString("TYPE_NAME_CN"));
		requestXml.setItemValue("DEVICE_PORT_RXP", row, "RXP",rsRow.getDouble("RXP").toString());
		requestXml.setItemValue("DEVICE_PORT_RXP", row, "STANDARD_RX_MAX",rsRow.getDouble("STANDARD_RX_MAX").toString());
		requestXml.setItemValue("DEVICE_PORT_RXP", row, "STANDARD_RX_MIN",rsRow.getDouble("STANDARD_RX_MIN").toString());
		requestXml.setItemValue("DEVICE_PORT_RXP", row, "NETWORK_RX_MIN",rsRow.getDouble("NETWORK_RX_MIN").toString());
		requestXml.setItemValue("DEVICE_PORT_RXP", row, "COLLECT_END",rsRow.getDouble("COLLECT_END").toString());
		requestXml.setItemValue("DEVICE_PORT_RXP", row, "COLLECT_END",rsRow.getString("STATUS"));
		
		double rxp = rsRow.getDouble("RXP");
		double rxMax = rsRow.getDouble("STANDARD_RX_MAX");
		double rxMin = rsRow.getDouble("NETWORK_RX_MIN");
		
		if(rxp >= rxMin && rxp <= rxMax){
			requestXml.setItemValue("DEVICE_PORT_RXP", row, "IS_NORMAL","是");
		}else{
			requestXml.setItemValue("DEVICE_PORT_RXP", row, "IS_NORMAL","否");
		}
		
	}
	
	
	}
}
