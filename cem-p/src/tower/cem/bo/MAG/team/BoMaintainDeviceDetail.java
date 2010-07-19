package tower.cem.bo.MAG.team;

import org.apache.log4j.Logger;

import tower.cem.db.DbDeviceInfo;
import tower.cem.db.DbDeviceType;
import tower.cem.db.DbFrontHostInfo;
import tower.cem.db.DbLocationInfo;
import tower.cem.db.DbMaintainTeam;
import tower.cem.db.DbMaintainTeamDeviceMap;
import tower.cem.db.DbMaintainTeamUserMap;
import tower.cem.en.EnDeviceInfo;
import tower.cem.en.EnDeviceType;
import tower.cem.en.EnFrontHostInfo;
import tower.cem.en.EnLocationInfo;
import tower.cem.en.EnMaintainTeam;
import tower.cem.en.EnMaintainTeamDeviceMap;
import tower.cem.en.EnMaintainTeamUserMap;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
import tower.tmvc.sys.db.DbSysOrg;
import tower.tmvc.sys.db.DbSysStat;
import tower.tmvc.sys.db.DbSysUser;
import tower.tmvc.sys.en.EnSysOrg;
import tower.tmvc.sys.en.EnSysStat;
import tower.tmvc.sys.en.EnSysUser;
/**
 * 功能描述：根据维护设备编号获取维护设备详细信息。
 * @author flj
 *
 */
public class BoMaintainDeviceDetail implements RootBo{

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//维护团队与设备对照DB EN 
		DbMaintainTeamDeviceMap dbMaintainTeamDeviceMap;
		EnMaintainTeamDeviceMap enMaintainTeamDeviceMap;
		
		//设备配置db en 
		DbDeviceInfo dbDeviceInfo;
		EnDeviceInfo enDeviceInfo;
		
		//维护团队db en
		DbMaintainTeam dbMaintainTeam;
		EnMaintainTeam enMaintainTeam;
		
		//设备类型db en
		DbDeviceType dbDeviceType;
		EnDeviceType enDeviceType;
		
		 //堡垒主机db en
		DbFrontHostInfo dbFrontHostInfo;
		EnFrontHostInfo enFrontHostInfo;

		// 物理位置db en
		DbLocationInfo dbLocationInfo;
		EnLocationInfo enLocationInfo;
		
		
		//页面参数
		String teamId;    //维护团队编号
		String deviceId;  //维护设备编号
		
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		teamId = requestXml.getInputValue("TEAM_ID");
		deviceId = requestXml.getInputValue("DEVICE_ID");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, true);
		dbMaintainTeamDeviceMap = new DbMaintainTeamDeviceMap(transaction, null);
		enMaintainTeamDeviceMap = new EnMaintainTeamDeviceMap();
		dbMaintainTeam = new DbMaintainTeam(transaction,null);
		dbDeviceInfo = new DbDeviceInfo(transaction,null);
		dbDeviceType = new DbDeviceType(transaction,null);
		enDeviceType = new EnDeviceType();
		dbFrontHostInfo = new DbFrontHostInfo(transaction, null);
		dbLocationInfo = new DbLocationInfo(transaction, null);
		dbDeviceType = new DbDeviceType(transaction, null);
		enDeviceType = new EnDeviceType();
		enDeviceInfo = new EnDeviceInfo();
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
//		 根据堡垒主机编号（hostId）
		enDeviceInfo = dbDeviceInfo.findByKey(deviceId);
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
				requestXml.setItemValue("DEVICE_INFO", irow, "FRONT_HOST_NAME", enFrontHostInfo.getHostIp());
			}
		}
		if (!(enDeviceInfo.getTypeId() == null || enDeviceInfo.getTypeId().length() == 0)) {
			enDeviceType = dbDeviceType.findByKey(enDeviceInfo.getTypeId());
			if (!(enDeviceType == null)) {
				requestXml.setItemValue("DEVICE_INFO", irow, "TYPE_NAME", enDeviceType.getTypeNameCn());
			}
		}
		
		//获取团队信息
		enMaintainTeam =  dbMaintainTeam.findByKey(teamId);
		dbMaintainTeam.setToXml(requestXml, enMaintainTeam);
	}
}
