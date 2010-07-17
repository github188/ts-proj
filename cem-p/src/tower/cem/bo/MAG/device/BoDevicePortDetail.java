package tower.cem.bo.MAG.device;

import org.apache.log4j.Logger;

import tower.cem.db.DbDevicePortInfo;
import tower.cem.db.DbDevicePortType;
import tower.cem.en.EnDevicePortInfo;
import tower.cem.en.EnDevicePortType;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoDevicePortDetail  implements RootBo{

	public void doBusiness(Transaction transaction, XMLWrap requestXml, 
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//设备配置db en 
		DbDevicePortInfo dbDevicePortInfo;
		EnDevicePortInfo enDevicePortInfo;
		
		//设备端口类型db en
		DbDevicePortType dbDevicePortType;
		EnDevicePortType enDevicePortType;
		
		//堡垒主机编号
		String portId; 
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		portId = requestXml.getInputValue("PORT_ID");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		 dbDevicePortInfo = new DbDevicePortInfo(transaction,null);
		 dbDevicePortType = new DbDevicePortType(transaction,null);
		 enDevicePortType = new EnDevicePortType();
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 //根据设备端口编号（deviceId）获取设备端口信息
		 enDevicePortInfo = dbDevicePortInfo.findByKey(portId);
		 if(enDevicePortInfo != null){
			 enDevicePortType = dbDevicePortType.findByKey(enDevicePortInfo.getTypeId());
		 }
		if(enDevicePortType != null){
			int row = dbDevicePortInfo.setToXml(requestXml, enDevicePortInfo);
			 requestXml.addRow("DEVICE_PORT_INFO");
			 requestXml.setItemValue("DEVICE_PORT_INFO", row, "TYPE_NAME", enDevicePortType.getTypeNameCn());
		}
		 
		 }
}
