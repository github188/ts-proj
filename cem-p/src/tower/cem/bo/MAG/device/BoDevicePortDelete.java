package tower.cem.bo.MAG.device;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbDeviceInfo;
import tower.cem.db.DbDevicePortInfo;
import tower.cem.db.DbLocationInfo;
import tower.cem.db.DbMaintainTeamDeviceMap;
import tower.cem.en.EnDeviceInfo;
import tower.cem.en.EnDevicePortInfo;
import tower.cem.en.EnLocationInfo;
import tower.cem.en.EnMaintainTeamDeviceMap;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoDevicePortDelete implements RootBo{

	public void doBusiness(Transaction transaction, XMLWrap requestXml, 
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//设备配置端口db en 
		DbDevicePortInfo dbDevicePortInfo;
		EnDevicePortInfo enDevicePortInfo;
		
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
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 //根据设备端口编号（deviceId）删除设备端口信息
		 dbDevicePortInfo.deleteByKey(portId);
	}
}
