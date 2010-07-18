package tower.cem.bo.MAI.commLog;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbDeviceCommandExecLog;
import tower.cem.db.DbDeviceInfo;
import tower.cem.db.DbLocationInfo;
import tower.cem.en.EnDeviceCommandExecLog;
import tower.cem.en.EnDeviceInfo;
import tower.cem.en.EnLocationInfo;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 功能描述：根据维护指令执行日志编号从维护指令执行日志表中获取维护指令详细信息。
 * @author flj
 *
 */
public class BoCommLogDetail implements RootBo{
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
	EnLocationInfo enLocationInfo ;
	
	//日志编号
	String logId;
	/*****************************************************************************************************
	 * 获取输入
	 ****************************************************************************************************/
	logId = requestXml.getInputValue("LOG_ID");
	/*****************************************************************************************************
	 * 创建数据库连接、实例化DB、EN
	 ****************************************************************************************************/
	transaction.createDefaultConnection(null, true);
	dbLocationInfo = new DbLocationInfo(transaction, null);
	dbDeviceInfo = new DbDeviceInfo(transaction, null);
	dbDeviceCommandExecLog = new DbDeviceCommandExecLog(transaction, null);
	enLocationInfo = new EnLocationInfo();
	enDeviceInfo = new EnDeviceInfo();
	/*****************************************************************************************************
	 * 执行业务逻辑、输出
	 ****************************************************************************************************/
	enDeviceCommandExecLog = dbDeviceCommandExecLog.findByKey(logId);
	int row = dbDeviceCommandExecLog.setToXml(requestXml, enDeviceCommandExecLog);
	if(enDeviceCommandExecLog != null){
		enDeviceInfo = dbDeviceInfo.findByKey(enDeviceCommandExecLog.getDeviceId());
	}
	if(enDeviceInfo != null){
		enLocationInfo = dbLocationInfo.findByKey(enDeviceInfo.getLocationId());
	}
	
	requestXml.setItemValue("DEVICE_COMMAND_EXEC_LOG", row, "DEVICE_NAME_CN", enDeviceInfo.getDeviceNameCn());
	requestXml.setItemValue("DEVICE_COMMAND_EXEC_LOG", row, "DEVICE_NAME_EN", enDeviceInfo.getDeviceNameEn());
	requestXml.setItemValue("DEVICE_COMMAND_EXEC_LOG", row, "DEVICE_LOCATION_NAME", enLocationInfo.getLocationNameCn());
	requestXml.setItemValue("DEVICE_COMMAND_EXEC_LOG", row, "DEVICE_IP", enDeviceInfo.getDeviceIp());
	requestXml.setItemValue("DEVICE_COMMAND_EXEC_LOG", row, "DEVICE_STATUS", enDeviceInfo.getDeviceStatus());
}
}
