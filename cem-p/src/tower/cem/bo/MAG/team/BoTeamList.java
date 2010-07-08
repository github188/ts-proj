package tower.cem.bo.MAG.team;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbLocationInfo;
import tower.cem.db.DbMaintainTeam;
import tower.common.util.Page;
import tower.common.util.PubFunc;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
/**
 * 功能描述：从维护团队定义表中获取全部维护团队信息。
 * @author flj
 *
 */
public class BoTeamList implements RootBo{

	public void doBusiness(Transaction transaction, XMLWrap requestXml, 
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//维护团队db en
		DbMaintainTeam dbMaintainTeam;
		
		String teamName;
		//其他
		Vector teams;
		StringBuffer sqlWhere;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		teamName = requestXml.getInputValue("QTEAM_NAME");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		 dbMaintainTeam = new DbMaintainTeam(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 sqlWhere = new StringBuffer();
			if (teamName != null && teamName.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" TEAM_NAME  LIKE'%" + teamName + "%'");
				} else {
					sqlWhere.append(" AND TEAM_NAME LIKE '%" + teamName + "%'");
				}
			}
			if (sqlWhere != null && sqlWhere.length() != 0) {
				Page.SetPageInfo(transaction, null, requestXml, dbMaintainTeam,
						PubFunc.LEN_PAGE_COUNT, "MAINTAIN_TEAM", sqlWhere.toString());
				teams = dbMaintainTeam.findAllWhere(sqlWhere.toString());

			} else {
				Page.SetPageInfo(transaction, null, requestXml, dbMaintainTeam,
						PubFunc.LEN_PAGE_COUNT, "MAINTAIN_TEAM", null);
				teams = dbMaintainTeam.findAll();
		   }
		 dbMaintainTeam.setAllToXml(requestXml, teams);
	}
}
