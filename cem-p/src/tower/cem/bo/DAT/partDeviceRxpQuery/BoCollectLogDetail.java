package tower.cem.bo.DAT.partDeviceRxpQuery;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbDeviceCollectLog;
import tower.cem.db.DbDeviceInfo;
import tower.cem.db.DbDeviceInspectLog;
import tower.cem.en.EnDeviceCollectLog;
import tower.cem.en.EnDeviceInfo;
import tower.cem.en.EnDeviceInspectLog;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoCollectLogDetail implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml,
			XMLWrap applicationXml, Logger logger) throws ErrorException {

		/*****************************************************************************************************
		 * 声明变量
		 ****************************************************************************************************/
		// 设备数据采集日志 db en
		DbDeviceCollectLog dbDeviceCollectLog;
		EnDeviceCollectLog enDeviceCollectLog;

		// 设备配置db en
		DbDeviceInfo dbDeviceInfo;
		EnDeviceInfo enDeviceInfo;

		// 发送编号
		String sendId;
		String deviceId;

		// 其他
		Vector vector;
		StringBuffer sqlwhere = new StringBuffer();
		/*****************************************************************************************************
		 * 获取输入
		 ****************************************************************************************************/
		sendId = requestXml.getInputValue("SEND_ID");
		deviceId = requestXml.getInputValue("DEVICE_ID");
		/*****************************************************************************************************
		 * 创建数据库连接、实例化DB、EN
		 ****************************************************************************************************/
		transaction.createDefaultConnection(null, true);
		dbDeviceCollectLog = new DbDeviceCollectLog(transaction, null);
		enDeviceCollectLog = new EnDeviceCollectLog();
		dbDeviceInfo = new DbDeviceInfo(transaction, null);
		enDeviceInfo = new EnDeviceInfo();
		/*****************************************************************************************************
		 * 执行业务逻辑、输出
		 ****************************************************************************************************/
		sqlwhere.append(" send_id='" + sendId + "'");
		if (!(deviceId == null || deviceId.trim().length() == 0))
			sqlwhere.append(" and device_id='" + deviceId + "'");
		vector = dbDeviceCollectLog.findAllWhere(sqlwhere.toString());
		if (vector != null && vector.size() != 0) {
			enDeviceCollectLog = (EnDeviceCollectLog) vector.get(0);
		}
		int row = 0;
		if (enDeviceCollectLog != null) {
			row = dbDeviceCollectLog.setToXml(requestXml, enDeviceCollectLog);
			enDeviceInfo = dbDeviceInfo.findByKey(enDeviceCollectLog.getDeviceId());
		}
		if (enDeviceInfo != null) {
			requestXml.setItemValue("DEVICE_COLLECT_LOG", row, "DEVICE_NAME_CN", enDeviceInfo
					.getDeviceNameCn());
			requestXml.setItemValue("DEVICE_COLLECT_LOG", row, "DEVICE_NAME_EN", enDeviceInfo
					.getDeviceNameEn());
			requestXml.setItemValue("DEVICE_COLLECT_LOG", row, "DEVICE_IP", enDeviceInfo.getDeviceIp());
		}
	}
}
