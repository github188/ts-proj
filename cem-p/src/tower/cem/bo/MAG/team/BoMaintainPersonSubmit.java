package tower.cem.bo.MAG.team;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbMaintainTeamUserMap;
import tower.cem.en.EnMaintainTeamUserMap;
import tower.cem.util.IdCreatorDefine;
import tower.common.util.SysIdCreator;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 功能描述：为维护团队增加维护人员
 * 1、根据维护团队编号从维护团队与人员对照表（MAINTAIN_TEAM_USER_MAP）中删除所有对应维护人员信息。
 * 2、根据提交的维护团队编号（TEAM_ID）和人员编号(USER_ID)向维护团队与人员对照表（MAINTAIN_TEAM_USER_MAP）中增加记录。
 * @author flj
 *
 */
public class BoMaintainPersonSubmit implements RootBo{
	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//维护团队与人员对照DB EN 
		DbMaintainTeamUserMap dbMaintainTeamUserMap;
		EnMaintainTeamUserMap enMaintainTeamUserMap;
		
		
		//页面参数
		String teamId;    //维护团队编号
		String mapId;
		String[] userIds;  //维护人员编号
		
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		teamId = requestXml.getInputValue("TEAM_ID");
		userIds = requestXml.getInputValues("USER_ID");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, true);
		dbMaintainTeamUserMap = new DbMaintainTeamUserMap(transaction, null);
		enMaintainTeamUserMap = new EnMaintainTeamUserMap();
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		//根据维护团队编号从维护团队与人员对照表（MAINTAIN_TEAM_USER_MAP）中删除所有对应维护人员信息。
		dbMaintainTeamUserMap.deleteWhere("TEAM_ID ='"
			+ teamId + "'");
		
		//向维护团队与人员对照表（MAINTAIN_TEAM_USER_MAP）中增加记录
		enMaintainTeamUserMap.setTeamId(teamId);
		for( int i = 0;i < userIds.length;i++){
			mapId = SysIdCreator.GenNextId(transaction, null,
					IdCreatorDefine.ID_TYPE_TEAM_USER_MAP_ID,
					IdCreatorDefine.ID_LEN_TEAM_USER_MAP_ID);
			enMaintainTeamUserMap.setMapId(mapId);
			enMaintainTeamUserMap.setUserId(userIds[i]);
			dbMaintainTeamUserMap.insert(enMaintainTeamUserMap);
		}
		
		

	}

	
}
