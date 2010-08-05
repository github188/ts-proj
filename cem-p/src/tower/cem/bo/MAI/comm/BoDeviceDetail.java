package tower.cem.bo.MAI.comm;

import org.apache.log4j.Logger;

import tower.cem.db.DbDeviceInfo;
import tower.cem.db.DbDeviceType;
import tower.cem.db.DbFrontHostInfo;
import tower.cem.db.DbLocationInfo;
import tower.cem.en.EnDeviceInfo;
import tower.cem.en.EnDeviceType;
import tower.cem.en.EnFrontHostInfo;
import tower.cem.en.EnLocationInfo;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoDeviceDetail implements RootBo{

	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml,
			XMLWrap applicationXml, Logger logger) throws ErrorException {
		/*****************************************************************************************************
		 * 声明变量
		 ****************************************************************************************************/
		// 设备配置db en
		DbDeviceInfo dbDeviceInfo;
		EnDeviceInfo enDeviceInfo;

		// 堡垒主机db en
		DbFrontHostInfo dbFrontHostInfo;
		EnFrontHostInfo enFrontHostInfo;

		// 物理位置db en
		DbLocationInfo dbLocationInfo;
		EnLocationInfo enLocationInfo;
		
	  	// 设备类型db en
	  	DbDeviceType dbDeviceType;
	  	EnDeviceType enDeviceType;

		// 堡垒主机编号
		String deviceId;

		/*****************************************************************************************************
		 * 获取输入
		 ****************************************************************************************************/
		deviceId = requestXml.getInputValue("DEVICE_ID");
		/*****************************************************************************************************
		 * 创建数据库连接、实例化DB、EN
		 ****************************************************************************************************/
		transaction.createDefaultConnection(null, true);
		dbDeviceInfo = new DbDeviceInfo(transaction, null);
		dbFrontHostInfo = new DbFrontHostInfo(transaction, null);
		dbLocationInfo = new DbLocationInfo(transaction, null);
		dbDeviceType = new DbDeviceType(transaction, null);
		enDeviceType = new EnDeviceType();
		enDeviceInfo = new EnDeviceInfo();
		/*****************************************************************************************************
		 * 执行业务逻辑、输出
		 ****************************************************************************************************/
		// 根据堡垒主机编号（hostId）
		enDeviceInfo = dbDeviceInfo.findByKey(deviceId);
		int row = dbDeviceInfo.setToXml(requestXml, enDeviceInfo);

		if (!(enDeviceInfo.getLocationId() == null || enDeviceInfo.getLocationId().trim().length() == 0)) {
			enLocationInfo = dbLocationInfo.findByKey(enDeviceInfo.getLocationId());
			if (!(enLocationInfo == null)) {
				requestXml.setItemValue("DEVICE_INFO", row, "LOCATION_NAME", enLocationInfo
						.getLocationNameCn());
			}
		}

		if (!(enDeviceInfo.getFrontHostId() == null || enDeviceInfo.getFrontHostId().trim().length() == 0)) {
			enFrontHostInfo = dbFrontHostInfo.findByKey(enDeviceInfo.getFrontHostId());
			if (!(enFrontHostInfo == null)) {
				requestXml.setItemValue("DEVICE_INFO",row,"HOST_ID",enFrontHostInfo.getHostId());
				requestXml.setItemValue("DEVICE_INFO",row,"HOST_NAME_EN",enFrontHostInfo.getHostNameEn());
				requestXml.setItemValue("DEVICE_INFO",row,"HOST_ABB_NAME_EN",enFrontHostInfo.getHostAbbNameEn());
				requestXml.setItemValue("DEVICE_INFO",row,"HOST_NAME_CN",enFrontHostInfo.getHostNameCn());
				requestXml.setItemValue("DEVICE_INFO",row,"LOCATION_ID",enFrontHostInfo.getLocationId());
				requestXml.setItemValue("DEVICE_INFO",row,"HOST_STATUS",enFrontHostInfo.getHostStatus());
				requestXml.setItemValue("DEVICE_INFO",row,"HOST_IP",enFrontHostInfo.getHostIp());
				requestXml.setItemValue("DEVICE_INFO",row,"HOST_PORT",enFrontHostInfo.getHostPort());
				requestXml.setItemValue("DEVICE_INFO",row,"HOST_USER",enFrontHostInfo.getHostUser());
				requestXml.setItemValue("DEVICE_INFO",row,"HOST_PASSWORD",enFrontHostInfo.getHostPassword());
				requestXml.setItemValue("DEVICE_INFO",row,"HOST_PROMPT",enFrontHostInfo.getHostPrompt());
				requestXml.setItemValue("DEVICE_INFO",row,"REMARK",enFrontHostInfo.getRemark());
				requestXml.setItemValue("DEVICE_INFO",row,"HOST_USER_PROMPT",enFrontHostInfo.getUserPrompt());
				requestXml.setItemValue("DEVICE_INFO",row,"HOST_PASSWORD_PROMPT",enFrontHostInfo.getPasswordPrompt());
			}
		}
		if (!(enDeviceInfo.getTypeId() == null || enDeviceInfo.getTypeId().length() == 0)) {
			enDeviceType = dbDeviceType.findByKey(enDeviceInfo.getTypeId());
			if (!(enDeviceType == null)) {
				requestXml.setItemValue("DEVICE_INFO", row, "TYPE_NAME", enDeviceType.getTypeNameCn());
			}
		}
	}
}
