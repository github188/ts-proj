package tower.cem.bo.MAI.comm;

import org.apache.log4j.Logger;

import tower.cem.db.DbDeviceCommandExecLog;
import tower.cem.en.EnDeviceCommandExecLog;
import tower.cem.util.IdCreatorDefine;
import tower.common.util.DateFunc;
import tower.common.util.SysIdCreator;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoCommsSubmit implements RootBo {

    public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml,
	    XMLWrap applicationXml, Logger logger) throws ErrorException {

	/***********************************************************************
         * 声明变量
         **********************************************************************/
	// 维护指令执行日志db en
	DbDeviceCommandExecLog dbDeviceCommandExecLog;
	EnDeviceCommandExecLog enDeviceCommandExecLog;

	String comms; // 维护指令
	String userId; // 维护人员
	String deviceId;// 维护设备
	String execBegin;// 维护开始时间
	String execEnd; // 维护结束时间
	String logId; // 维护日志编号

	/***********************************************************************
         * 获取输入
         **********************************************************************/
	comms = requestXml.getInputValue("COMMANDS").trim();
	deviceId = requestXml.getInputValue("DEVICE_ID");
	execBegin = requestXml.getInputValue("EXEC_BEGIN");
	execEnd = DateFunc.GenNowTime();
	userId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
	/***********************************************************************
         * 创建数据库连接、实例化DB、EN
         **********************************************************************/
	transaction.createDefaultConnection(null, true);
	dbDeviceCommandExecLog = new DbDeviceCommandExecLog(transaction, null);
	enDeviceCommandExecLog = new EnDeviceCommandExecLog();
	/***********************************************************************
         * 执行业务逻辑、输出
         **********************************************************************/
	if (!(comms == null || comms.length() == 0)) {
	    logId = SysIdCreator.GenNextId(transaction, null, IdCreatorDefine.ID_TYPE_DEVICE_COMMAND_LOG_ID,
		    IdCreatorDefine.ID_LEN_DEVICE_COMMAND_LOG_ID);
	    enDeviceCommandExecLog.setLogId(logId);
	    enDeviceCommandExecLog.setUserId(userId);
	    enDeviceCommandExecLog.setCommandCont(comms);
	    enDeviceCommandExecLog.setDeviceId(deviceId);
	    enDeviceCommandExecLog.setExecBegin(DateFunc.ParseDateTime(execBegin));
	    enDeviceCommandExecLog.setExecEnd(execEnd);
	    dbDeviceCommandExecLog.insert(enDeviceCommandExecLog);
	}
    }
}
