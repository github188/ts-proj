package tower.cem.bo.MAG.device;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbDeviceInfo;
import tower.cem.db.DbFrontHostInfo;
import tower.cem.db.DbLocationInfo;
import tower.cem.db.DbMaintainTeamDeviceMap;
import tower.cem.en.EnDeviceInfo;
import tower.cem.en.EnFrontHostInfo;
import tower.cem.en.EnLocationInfo;
import tower.cem.en.EnMaintainTeamDeviceMap;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
/**
 * 功能描述：根据设备编号从设备信息定义表中删除设备信息。
 * @author flj
 *
 */
public class BoDeviceDelete implements RootBo{

	public void doBusiness(Transaction transaction, XMLWrap requestXml, 
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//设备配置db en 
		DbDeviceInfo dbDeviceInfo;
		EnDeviceInfo enDeviceInfo;
		
		//物理位置db en
		DbLocationInfo dbLocationInfo;
		EnLocationInfo enLocationInfo;
		
		//维护团队与设备对照关系db en
		DbMaintainTeamDeviceMap dbMaintainTeamDeviceMap;
		EnMaintainTeamDeviceMap enMaintainTeamDeviceMap;
		
		//堡垒主机编号
		String deviceId; 
		Vector vector;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		deviceId = requestXml.getInputValue("DEVICE_ID");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		 dbDeviceInfo = new DbDeviceInfo(transaction,null);
		 dbMaintainTeamDeviceMap = new DbMaintainTeamDeviceMap(transaction,null);
		 dbLocationInfo = new DbLocationInfo(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 //当要删除的设备信息已经在维护团队与设备对照关系中时，提示不能删除
		 //DI004:设备{0}已经在维护团队与设备对照关系中，该设备不能删除。
		 vector =  dbMaintainTeamDeviceMap.findAllWhere(" DEVICE_ID ='"
					+ deviceId + "'");
		 //获取设备名称
		 enDeviceInfo  = dbDeviceInfo.findByKey(deviceId);
		 if (vector.size() > 0) {
				throw new ErrorException("DI004", new Object[] { enDeviceInfo.getDeviceNameCn() });
		  }
		 
		 //根据设备编号（deviceId）删除设备信息
		 dbDeviceInfo.deleteByKey(deviceId);
	}
}
