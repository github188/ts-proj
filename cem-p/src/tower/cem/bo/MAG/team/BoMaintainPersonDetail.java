package tower.cem.bo.MAG.team;

import org.apache.log4j.Logger;

import tower.cem.db.DbMaintainTeam;
import tower.cem.db.DbMaintainTeamUserMap;
import tower.cem.en.EnMaintainTeam;
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
 * 功能描述：根据维护人员编号获取维护人员详细信息。
 * @author flj
 *
 */
public class BoMaintainPersonDetail implements RootBo{

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//维护团队与人员对照DB EN 
		DbMaintainTeamUserMap dbMaintainTeamUserMap;
		EnMaintainTeamUserMap enMaintainTeamUserMap;
		
		//维护团队db en
		DbMaintainTeam dbMaintainTeam;
		EnMaintainTeam enMaintainTeam;
		
		//用户DB EN 
		DbSysUser dbSysUser;
		EnSysUser enSysUser;
		
		//机构DB EN 
		DbSysOrg dbSysOrg;
		EnSysOrg enSysOrg;
		
		//岗位DB EN
		DbSysStat dbSysStat;
		EnSysStat enSysStat;
		
		//页面参数
		String teamId;    //维护团队编号
		String userId;  //维护人员编号
		
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		teamId = requestXml.getInputValue("TEAM_ID");
		userId = requestXml.getInputValue("USER_ID");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, true);
		dbMaintainTeamUserMap = new DbMaintainTeamUserMap(transaction, null);
		enMaintainTeamUserMap = new EnMaintainTeamUserMap();
		dbSysUser = new DbSysUser(transaction, null);
		dbSysOrg = new DbSysOrg(transaction, null);
		dbSysStat = new DbSysStat(transaction, null);
		dbMaintainTeam = new DbMaintainTeam(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		// 取得所有的用户信息
		enSysUser = dbSysUser.findByKey(userId);
		if (enSysUser != null) {
			int row = dbSysUser.setToXml(requestXml, enSysUser);

			enSysOrg = dbSysOrg.findByKey(enSysUser.getUserOrgId());
			if (enSysOrg != null) {
				requestXml.setItemValue("SYS_USER", row, "USER_ORG_NAME",
						enSysOrg.getOrgName());
			} else {
				requestXml.setItemValue("SYS_USER", row, "USER_ORG_NAME", "");
			}
			enSysStat = dbSysStat.findByKey(enSysUser.getUserStatId());
			if (enSysStat != null) {
				requestXml.setItemValue("SYS_USER", row, "USER_STAT_NAME",
						enSysStat.getStatName());
			} else {
				requestXml.setItemValue("SYS_USER", row, "USER_STAT_NAME", "");
			}
		}
		
		//获取团队信息
		enMaintainTeam =  dbMaintainTeam.findByKey(teamId);
		dbMaintainTeam.setToXml(requestXml, enMaintainTeam);
	}
}
