package tower.cem.bo.MAG.team;

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
 * 功能描述：
 * 根据提交的维护团队编号和维护人员编号从维护团队与人员对照表（MAINTAIN_TEAM_USER_MAP）删除对应记录
 * @author flj
 *
 */
public class BoMaintainPersonDelete implements RootBo{

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
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		//根据提交的维护团队编号和维护人员编号从维护团队与人员对照表（MAINTAIN_TEAM_USER_MAP）删除对应记录
		dbMaintainTeamUserMap.deleteWhere("TEAM_ID ='"
			+ teamId + "' and USER_ID = '"+userId +"'");
		
	}
}
