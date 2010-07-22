package tower.cem.bo.INS.partDevicesLog;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbDeviceInspectPickLog;
import tower.cem.en.EnDeviceInspectPickLog;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoPickLogDetail implements RootBo{

	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml,
			XMLWrap applicationXml, Logger logger) throws ErrorException {

	/*****************************************************************************************************
	 * 声明变量
	 ****************************************************************************************************/
	//设备巡检分拣日志 db en
	DbDeviceInspectPickLog dbDeviceInspectPickLog;
	EnDeviceInspectPickLog enDeviceInspectPickLog;
	
	//日志编号
	String sendId;
	
	//其他
	Vector vector;
	/*****************************************************************************************************
	 * 获取输入
	 ****************************************************************************************************/
	sendId = requestXml.getInputValue("SEND_ID");
	/*****************************************************************************************************
	 * 创建数据库连接、实例化DB、EN
	 ****************************************************************************************************/
	transaction.createDefaultConnection(null, true);
	dbDeviceInspectPickLog = new DbDeviceInspectPickLog(transaction, null);
	enDeviceInspectPickLog = new EnDeviceInspectPickLog();
	/*****************************************************************************************************
	 * 执行业务逻辑、输出
	 ****************************************************************************************************/
	vector = dbDeviceInspectPickLog.findAllWhere(" send_id='"+sendId+"'");
	enDeviceInspectPickLog = (EnDeviceInspectPickLog)vector.get(0);
	dbDeviceInspectPickLog.setToXml(requestXml, enDeviceInspectPickLog);
}
}
