package tower.cem.bo.MAG.device;

import org.apache.log4j.Logger;

import tower.cem.db.DbDeviceInfo;
import tower.cem.db.DbFrontHostInfo;
import tower.cem.db.DbLocationInfo;
import tower.cem.en.EnDeviceInfo;
import tower.cem.en.EnFrontHostInfo;
import tower.cem.en.EnLocationInfo;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
/**
 * 功能描述：根据设备编号从设备信息定义表中获取的设备的详细信息。
 * @author flj
 *
 */
public class BoDeviceDetail implements RootBo{
	public void doBusiness(Transaction transaction, XMLWrap requestXml, 
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//设备配置db en 
		DbDeviceInfo dbDeviceInfo;
		EnDeviceInfo enDeviceInfo;
		
		//堡垒主机db en 
		DbFrontHostInfo dbFrontHostInfo;
		EnFrontHostInfo enFrontHostInfo;
		
		//物理位置db en
		DbLocationInfo dbLocationInfo;
		EnLocationInfo enLocationInfo;
		
		//堡垒主机编号
		String deviceId; 
		
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		deviceId = requestXml.getInputValue("DEVICE_ID");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		 dbDeviceInfo = new DbDeviceInfo(transaction,null);
		 dbFrontHostInfo = new DbFrontHostInfo(transaction,null);
		 dbLocationInfo = new DbLocationInfo(transaction,null);
		 enDeviceInfo = new EnDeviceInfo();
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 //根据堡垒主机编号（hostId）
		 enDeviceInfo = dbDeviceInfo.findByKey(deviceId);
		 dbDeviceInfo.setToXml(requestXml, enDeviceInfo);
	}
}
