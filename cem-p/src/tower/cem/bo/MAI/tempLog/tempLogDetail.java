package tower.cem.bo.MAI.tempLog;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbCommandsSendHis;
import tower.cem.db.DbDeviceInfo;
import tower.cem.db.DbDeviceMaintainLog;
import tower.cem.en.EnCommandsSendHis;
import tower.cem.en.EnDeviceInfo;
import tower.cem.en.EnDeviceInspectLog;
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
import tower.tmvc.sys.db.DbSysUser;
import tower.tmvc.sys.en.EnSysUser;

public class tempLogDetail implements RootBo{

	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//维护指令模板发送日志 db en
		DbDeviceMaintainLog dbDeviceMaintainLog;
		EnDeviceMaintainLog enDeviceMaintainLog;
		
		//维护人员 db en
		DbSysUser dbSysUser;
		EnSysUser enSysUser;
		
		// 设备配置db en
		DbDeviceInfo dbDeviceInfo;
		EnDeviceInfo enDeviceInfo;
		
		//日志编号
		String sendId;
		Vector vector;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		sendId = requestXml.getInputValue("SEND_ID");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		 dbDeviceMaintainLog = new DbDeviceMaintainLog(transaction,null);
		 dbSysUser = new DbSysUser(transaction, null);
		 enDeviceMaintainLog = new EnDeviceMaintainLog();
		 dbDeviceInfo = new DbDeviceInfo(transaction, null);
		 enDeviceInfo = new EnDeviceInfo();
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 vector = dbDeviceMaintainLog.findAllWhere(" SEND_ID='"+sendId+"'");
			if(vector != null && vector.size() != 0){
				enDeviceMaintainLog = (EnDeviceMaintainLog)vector.get(0);
			}
		 for(int i=0;i<vector.size();i++){
			 enDeviceMaintainLog = (EnDeviceMaintainLog)vector.get(i);
			 if(enDeviceMaintainLog != null){
				 if(enDeviceMaintainLog.getUserId() != null && enDeviceMaintainLog.getUserId().length()>0 ){
					 enSysUser = dbSysUser.findByKey(enDeviceMaintainLog.getUserId());
					 int row  =  dbDeviceMaintainLog.setToXml(requestXml, enDeviceMaintainLog);
					 requestXml.setItemValue("requestXml", row, "USER_NAME", enSysUser.getUserName());
				 }
			 }
			 
		 }
		 dbDeviceMaintainLog.setAllToXml(requestXml, vector);
			
			int row=0;
			if(enDeviceMaintainLog != null){
				row = dbDeviceMaintainLog.setToXml(requestXml, enDeviceMaintainLog);
				enDeviceInfo = dbDeviceInfo.findByKey(enDeviceMaintainLog.getDeviceId());
			}
			if(enDeviceInfo != null){
				requestXml.setItemValue("DEVICE_MAINTAIN_LOG", row, "DEVICE_NAME_CN", enDeviceInfo.getDeviceNameCn());
				requestXml.setItemValue("DEVICE_MAINTAIN_LOG", row, "DEVICE_NAME_EN", enDeviceInfo.getDeviceNameEn());
				requestXml.setItemValue("DEVICE_MAINTAIN_LOG", row, "DEVICE_IP", enDeviceInfo.getDeviceIp());
			}
			
	}
}
