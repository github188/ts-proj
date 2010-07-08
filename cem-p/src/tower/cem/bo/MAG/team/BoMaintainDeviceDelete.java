package tower.cem.bo.MAG.team;

import org.apache.log4j.Logger;

import tower.cem.db.DbMaintainTeamDeviceMap;
import tower.cem.db.DbMaintainTeamUserMap;
import tower.cem.en.EnMaintainTeamDeviceMap;
import tower.cem.en.EnMaintainTeamUserMap;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 功能描述：
 * 根据提交的维护团队编号和维护设备编号从维护团队与设备对照表（MAINTAIN_TEAM_DEVICE_MAP）删除对应记录
 * @author flj
 *
 */
public class BoMaintainDeviceDelete implements RootBo{

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//维护团队与设备对照DB EN 
		DbMaintainTeamDeviceMap dbMaintainTeamDeviceMap;
		EnMaintainTeamDeviceMap enMaintainTeamDeviceMap;
		
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
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		//根据提交的维护团队编号和维护人员编号从维护团队与人员对照表（MAINTAIN_TEAM_USER_MAP）删除对应记录
		dbMaintainTeamDeviceMap.deleteWhere("TEAM_ID ='"
			+ teamId + "' and DEVICE_ID = '"+deviceId +"'");
		
	}
}
