package tower.cem.bo.MAG.team;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbMaintainTeam;
import tower.cem.db.DbMaintainTeamUserMap;
import tower.cem.en.EnMaintainTeam;
import tower.cem.en.EnMaintainTeamUserMap;
import tower.common.util.Page;
import tower.common.util.PubFunc;
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
 * 功能描述：
 * 1、根据维护团队编号（TEAM_ID）从维护团队与人员对照表（MAINTAIN_TEAM_USER_MAP）获取维护人员编号
 * 2、根据维护人员编号（USER_ID）从人员信息表（SYS_USER）中获取维护人员详细信息。
 * @author flj
 *
 */
public class BoMaintainPersonList  implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//维护团队db en
		DbMaintainTeam dbMaintainTeam;
		EnMaintainTeam enMaintainTeam;
		
		//维护团队与人员对照DB EN 
		DbMaintainTeamUserMap dbMaintainTeamUserMap;
		EnMaintainTeamUserMap enMaintainTeamUserMap;
		
		//人员DB EN 
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
		String userName;  //维护人员名称
		String userOrgId; //人员所属机构
		
		Vector vector;
		StringBuffer sqlWhere;
		StringBuffer userIds;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		teamId = requestXml.getInputValue("TEAM_ID");
		userName = requestXml.getInputValue("QUSER_NAME");
		userOrgId = requestXml.getInputValue("QUSER_ORG_ID");
		
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, true);
		dbMaintainTeamUserMap = new DbMaintainTeamUserMap(transaction, null);
		dbSysUser = new DbSysUser(transaction, null);
		dbSysOrg = new DbSysOrg(transaction, null);
		dbSysStat = new DbSysStat(transaction, null);
		dbMaintainTeam = new DbMaintainTeam(transaction,null);
		enMaintainTeamUserMap = new EnMaintainTeamUserMap();
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		//根据维护团队编号从维护团队与人员对照表中获取维护人员编号
		vector = dbMaintainTeamUserMap.findAllWhere(" TEAM_ID ='"
				+ teamId + "'");
		if(vector != null && vector.size() > 0){
			
			userIds = new StringBuffer();
			userIds.append("(");
			for(int i = 0 ;i<vector.size();i++){
				enMaintainTeamUserMap = (EnMaintainTeamUserMap)vector.get(i);
				if(i == 0){
					userIds.append(enMaintainTeamUserMap.getUserId());
				}else{
					userIds.append(",");
					userIds.append(enMaintainTeamUserMap.getUserId());
				}
				
			}
			userIds.append(")");
			// 根据提交的参数，构造查询where子句，提供模糊查询。
			sqlWhere = new StringBuffer();
			sqlWhere.append(" USER_ID IN "+userIds.toString());
			if (userName != null && userName.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" USER_NAME LIKE '%" + userName + "%'");
				} else {
					sqlWhere.append(" AND USER_NAME LIKE '%" + userName + "%'");
				}
			}
			if (userOrgId != null && userOrgId.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" USER_ORG_ID LIKE '%" + userOrgId + "%'");
				} else {
					sqlWhere.append(" AND USER_ORG_ID LIKE '%" + userOrgId + "%'");
				}
			}
			// 3、查询表，将符合条件的保存到requestXml中返回。
			if (sqlWhere != null && sqlWhere.length() != 0) {
				Page.SetPageInfo(transaction, null, requestXml, dbSysUser,
						PubFunc.LEN_PAGE_COUNT, "SYS_USER",sqlWhere.toString());
				vector = dbSysUser.findAllWhere(sqlWhere.toString());

			} else {
				Page.SetPageInfo(transaction, null, requestXml, dbSysUser,
						PubFunc.LEN_PAGE_COUNT, "SYS_USER", null);
				vector = dbSysUser.findAll();

			}
			if (vector != null) {
				for (int i = 0; i < vector.size(); i++) {
					enSysUser = (EnSysUser) vector.get(i);
					int row = dbSysUser.setToXml(requestXml, enSysUser);
					enSysOrg = dbSysOrg.findByKey(enSysUser.getUserOrgId());
					if (enSysOrg != null) {
						requestXml.setItemValue("SYS_USER", row, "USER_ORG_NAME",
								enSysOrg.getOrgName());
					} else {
						requestXml.setItemValue("SYS_USER", row, "USER_ORG_NAME",
								"");
					}
					enSysStat = dbSysStat.findByKey(enSysUser.getUserStatId());
					if (enSysStat != null) {
						requestXml.setItemValue("SYS_USER", row, "USER_STAT_NAME",
								enSysStat.getStatName());
					} else {
						requestXml.setItemValue("SYS_USER", row, "USER_STAT_NAME",
								"");
					}
				}
			}
			
		}
		//获取团队信息
		enMaintainTeam =  dbMaintainTeam.findByKey(teamId);
		dbMaintainTeam.setToXml(requestXml, enMaintainTeam);

	}

}
