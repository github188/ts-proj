package tower.cem.bo.MAG.team;

import org.apache.log4j.Logger;

import tower.cem.db.DbMaintainTeamDeviceMap;
import tower.cem.en.EnMaintainTeamDeviceMap;
import tower.cem.util.IdCreatorDefine;
import tower.common.util.SysIdCreator;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 功能描述：为维护团队增加维护设备 1、根据维护团队编号从维护团队与设备对照表（MAINTAIN_TEAM_DEVICE_MAP）中删除所有对应维护设备信息。
 * 2、根据提交的维护团队编号（TEAM_ID）和设备编号(DEVICE_ID)向维护团队与设备对照表（MAINTAIN_TEAM_DEVICE_MAP）中增加记录。
 * 
 * @author flj
 * 
 */
public class BoMaintainDeviceSubmit implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml,
			XMLWrap applicationXml, Logger logger) throws ErrorException {
		/*****************************************************************************************************
		 * 声明变量
		 ****************************************************************************************************/
		// 维护团队与设备对照DB EN
		DbMaintainTeamDeviceMap dbMaintainTeamDeviceMap;
		EnMaintainTeamDeviceMap enMaintainTeamDeviceMap;

		// 页面参数
		String teamId; // 维护团队编号
		String mapId;
		String[] deviceIds; // 维护人员编号

		/*****************************************************************************************************
		 * 获取输入
		 ****************************************************************************************************/
		teamId = requestXml.getInputValue("TEAM_ID");
		deviceIds = requestXml.getInputValues("DEVICE_ID");
		/*****************************************************************************************************
		 * 创建数据库连接、实例化DB、EN
		 ****************************************************************************************************/
		transaction.createDefaultConnection(null, true);
		dbMaintainTeamDeviceMap = new DbMaintainTeamDeviceMap(transaction, null);
		enMaintainTeamDeviceMap = new EnMaintainTeamDeviceMap();
		/*****************************************************************************************************
		 * 执行业务逻辑、输出
		 ****************************************************************************************************/

		// 向维护团队与设备对照表（MAINTAIN_TEAM_DEVICE_MAP）中增加记录。
		enMaintainTeamDeviceMap.setTeamId(teamId);
		for (int i = 0; i < deviceIds.length; i++) {
			int iCount = dbMaintainTeamDeviceMap.countWhere("TEAM_ID ='" + teamId + "' and DEVICE_ID ='"
					+ deviceIds[i] + "'");
			if (iCount < 1) {
				mapId = SysIdCreator.GenNextId(transaction, null, IdCreatorDefine.ID_TYPE_TEAM_DEVICE_MAP_ID,
						IdCreatorDefine.ID_LEN_TEAM_DEVICE_MAP_ID);
				enMaintainTeamDeviceMap.setMapId(mapId);
				enMaintainTeamDeviceMap.setDeviceId(deviceIds[i]);
				dbMaintainTeamDeviceMap.insert(enMaintainTeamDeviceMap);
			}
		}
	}
}