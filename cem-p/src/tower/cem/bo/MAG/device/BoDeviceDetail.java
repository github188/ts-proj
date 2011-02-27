package tower.cem.bo.MAG.device;

import java.util.Vector;

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

/**
 * 功能描述：根据设备编号从设备信息定义表中获取的设备的详细信息。
 * 
 * @author flj
 * 
 */
public class BoDeviceDetail implements RootBo {
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
		Vector deviceTypes;

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
		if(enDeviceInfo != null ){
		int irow = dbDeviceInfo.setToXml(requestXml, enDeviceInfo);

		if (!(enDeviceInfo.getLocationId() == null || enDeviceInfo.getLocationId().trim().length() == 0)) {
			enLocationInfo = dbLocationInfo.findByKey(enDeviceInfo.getLocationId());
			if (!(enLocationInfo == null)) {
				requestXml.setItemValue("DEVICE_INFO", irow, "LOCATION_NAME", enLocationInfo
						.getLocationNameCn());
			}
		}

		if (!(enDeviceInfo.getFrontHostId() == null || enDeviceInfo.getFrontHostId().trim().length() == 0)) {
			enFrontHostInfo = dbFrontHostInfo.findByKey(enDeviceInfo.getFrontHostId());
			if (!(enFrontHostInfo == null)) {
				requestXml.setItemValue("DEVICE_INFO", irow, "FRONT_HOST_NAME", enFrontHostInfo.getHostNameCn());			
			}
		}
		if (!(enDeviceInfo.getTypeId() == null || enDeviceInfo.getTypeId().length() == 0)) {
			enDeviceType = dbDeviceType.findByKey(enDeviceInfo.getTypeId());
			if (!(enDeviceType == null)) {
				requestXml.setItemValue("DEVICE_INFO", irow, "TYPE_NAME", enDeviceType.getTypeNameCn());
			}
		}
		}
		//获取设备类型
		deviceTypes  = dbDeviceType.findAll();
		dbDeviceType.setAllToXml(requestXml, deviceTypes);
	}
}
