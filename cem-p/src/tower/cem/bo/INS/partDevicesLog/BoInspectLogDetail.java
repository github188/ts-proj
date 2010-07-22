package tower.cem.bo.INS.partDevicesLog;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbDeviceCommandExecLog;
import tower.cem.db.DbDeviceInfo;
import tower.cem.db.DbDeviceInspectLog;
import tower.cem.en.EnDeviceInfo;
import tower.cem.en.EnDeviceInspectLog;
import tower.cem.en.EnLocationInfo;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoInspectLogDetail  implements RootBo{

	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml,
			XMLWrap applicationXml, Logger logger) throws ErrorException {

	/*****************************************************************************************************
	 * 声明变量
	 ****************************************************************************************************/
	//设备巡检日志 db en
	DbDeviceInspectLog dbDeviceInspectLog;
	EnDeviceInspectLog enDeviceInspectLog;
	
	// 设备配置db en
	DbDeviceInfo dbDeviceInfo;
	EnDeviceInfo enDeviceInfo;
	
	
	//发送编号
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
	dbDeviceInspectLog = new DbDeviceInspectLog(transaction, null);
	enDeviceInspectLog = new EnDeviceInspectLog();
	dbDeviceInfo = new DbDeviceInfo(transaction, null);
	enDeviceInfo = new EnDeviceInfo();
	/*****************************************************************************************************
	 * 执行业务逻辑、输出
	 ****************************************************************************************************/
	vector = dbDeviceInspectLog.findAllWhere(" send_id='"+sendId+"'");
	enDeviceInspectLog = (EnDeviceInspectLog)vector.get(0);
	
	int row = dbDeviceInspectLog.setToXml(requestXml, enDeviceInspectLog);
	if(enDeviceInspectLog != null){
		enDeviceInfo = dbDeviceInfo.findByKey(enDeviceInspectLog.getDeviceId());
	}
	requestXml.setItemValue("DEVICE_INSPECT_LOG", row, "DEVICE_NAME_CN", enDeviceInfo.getDeviceNameCn());
	requestXml.setItemValue("DEVICE_INSPECT_LOG", row, "DEVICE_NAME_EN", enDeviceInfo.getDeviceNameEn());
	requestXml.setItemValue("DEVICE_INSPECT_LOG", row, "DEVICE_IP", enDeviceInfo.getDeviceIp());
	
}
}