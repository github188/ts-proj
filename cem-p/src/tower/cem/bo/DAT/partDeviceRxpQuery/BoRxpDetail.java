package tower.cem.bo.DAT.partDeviceRxpQuery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbDeviceCollectLog;
import tower.cem.db.DbDeviceInfo;
import tower.cem.db.DbDevicePortRxp;
import tower.cem.db.DbDevicePortType;
import tower.cem.db.DbDeviceType;
import tower.cem.en.EnDeviceCollectLog;
import tower.cem.en.EnDeviceInfo;
import tower.cem.en.EnDevicePortRxp;
import tower.cem.en.EnDevicePortType;
import tower.cem.en.EnDeviceType;
import tower.tmvc.ErrorException;
import tower.tmvc.QueryResult;
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
	
	//设备配置db en
	DbDeviceInfo dbDeviceInfo;
	EnDeviceInfo enDeviceInfo;
	
	
	//设备端口类型db en
	DbDevicePortType dbDevicePortType;
	EnDevicePortType enDevicePortType;
	
	//采集日志 db en 
	DbDeviceCollectLog dbDeviceCollectLog;
	EnDeviceCollectLog enDeviceCollectLog;
	
	// 设备类型db en
	DbDeviceType dbDeviceType;
	EnDeviceType enDeviceType;
	
	//发送编号
	String sendId;
	
	//其他
	StringBuffer sql = new StringBuffer();
	
	Vector vector;
	Vector vLog;
	Vector vEnDevicePortType;
	
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
	dbDeviceInfo = new DbDeviceInfo(transaction, null);
	dbDevicePortType = new DbDevicePortType(transaction,null);
	dbDeviceCollectLog = new DbDeviceCollectLog(transaction,null);
	dbDeviceType = new DbDeviceType(transaction, null);
	enDevicePortRxp = new EnDevicePortRxp();
	dbDevicePortRxp.setOrderBy(" ORDER BY DEVICE_NAME ASC ");
	enDevicePortType = new EnDevicePortType();
	/*****************************************************************************************************
	 * 执行业务逻辑、输出
	 ****************************************************************************************************/
	//获取光功率数据
	vector = dbDevicePortRxp.findAllWhere(" SEND_ID='"+sendId+"'");
	vLog = dbDeviceCollectLog.findAllWhere(" SEND_ID='"+sendId+"'");
	enDeviceCollectLog =(EnDeviceCollectLog) vLog.get(0);
	//获取设备Ip
	for(int i=0;i<vector.size();i++){
		enDevicePortRxp = (EnDevicePortRxp)vector.get(i);
		int row  = dbDevicePortRxp.setToXml(requestXml, enDevicePortRxp);
		enDeviceInfo = dbDeviceInfo.findByKey(enDevicePortRxp.getDeviceId());
		enDeviceType = dbDeviceType.findByKey(enDeviceInfo.getTypeId());
		
		vEnDevicePortType = dbDevicePortType.findAllWhere(" TYPE_NAME_EN='"+enDevicePortRxp.getPortType()+"'");
		if(vEnDevicePortType != null && vEnDevicePortType.size() != 0){
			enDevicePortType = (EnDevicePortType)vEnDevicePortType.get(0);
			requestXml.setItemValue("DEVICE_PORT_RXP", row, "PORT_TYPE_NAME",enDevicePortType.getTypeNameCn());
			requestXml.setItemValue("DEVICE_PORT_RXP", row, "STANDARD_RX_MAX",enDevicePortType.getStandardRxMax());
			requestXml.setItemValue("DEVICE_PORT_RXP", row, "STANDARD_RX_MIN",enDevicePortType.getStandardRxMin());
			requestXml.setItemValue("DEVICE_PORT_RXP", row, "NETWORK_RX_MIN",enDevicePortType.getNetworkRxMin());
			requestXml.setItemValue("DEVICE_PORT_RXP", row, "NETWORK_RX_MAX",enDevicePortType.getNetworkRxMax());
			double rxp =enDevicePortRxp.getRxp();
			double rxMax = enDevicePortType.getStandardRxMax();
			double rxMin = enDevicePortType.getStandardRxMin();
			
			if(rxp >= rxMin && rxp <= rxMax){
				requestXml.setItemValue("DEVICE_PORT_RXP", row, "IS_NORMAL","是");
			}else{
				requestXml.setItemValue("DEVICE_PORT_RXP", row, "IS_NORMAL","否");
			}
		}else{
			requestXml.setItemValue("DEVICE_PORT_RXP", row, "PORT_TYPE_NAME","");
			requestXml.setItemValue("DEVICE_PORT_RXP", row, "STANDARD_RX_MAX","");
			requestXml.setItemValue("DEVICE_PORT_RXP", row, "STANDARD_RX_MIN","");
			requestXml.setItemValue("DEVICE_PORT_RXP", row, "NETWORK_RX_MIN","");
			requestXml.setItemValue("DEVICE_PORT_RXP", row, "NETWORK_RX_MAX","");
			requestXml.setItemValue("DEVICE_PORT_RXP", row, "IS_NORMAL","");
		}
	
		requestXml.setItemValue("DEVICE_PORT_RXP", row, "DEVICE_IP",enDeviceInfo.getDeviceIp());
		requestXml.setItemValue("DEVICE_PORT_RXP", row, "COLLECT_END",enDeviceCollectLog.getCollectEnd());
		requestXml.setItemValue("DEVICE_PORT_RXP", row, "DEVICE_TYPE_NAME",enDeviceType.getTypeNameCn());
		
		
	}
	
	}
	
}
