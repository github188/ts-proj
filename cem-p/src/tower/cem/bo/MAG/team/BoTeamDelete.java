package tower.cem.bo.MAG.team;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbMaintainTeam;
import tower.cem.db.DbMaintainTeamDeviceMap;
import tower.cem.db.DbMaintainTeamUserMap;
import tower.cem.en.EnMaintainTeam;
import tower.cem.en.EnMaintainTeamDeviceMap;
import tower.cem.en.EnMaintainTeamUserMap;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
/**
 * 功能描述：根据维护团队编号从维护团队定义表中删除团队信息
 * 1、但当维护团队中已经定义了成员或设备时，提示不能删除
 * @author flj
 *
 */
public class BoTeamDelete implements RootBo{

	public void doBusiness(Transaction transaction, XMLWrap requestXml, 
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//维护团队db en
		DbMaintainTeam dbMaintainTeam;
		EnMaintainTeam enMaintainTeam;
		
		//维护团队与维护团队与人员对照db en
		DbMaintainTeamUserMap dbMaintainTeamUserMap;
		EnMaintainTeamUserMap enMaintainTeamUserMap;
		
		//维护团队与设备对照db en
		DbMaintainTeamDeviceMap dbMaintainTeamDeviceMap;
		EnMaintainTeamDeviceMap enMaintainTeamDeviceMap;
		
		//页面参数
		String teamId;        //维护团队编号
		
		//其他
		Vector vector;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		teamId = requestXml.getInputValue("TEAM_ID");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		 dbMaintainTeam = new DbMaintainTeam(transaction,null);
		 dbMaintainTeamUserMap = new DbMaintainTeamUserMap(transaction,null);
		 dbMaintainTeamDeviceMap = new DbMaintainTeamDeviceMap(transaction,null);
		 enMaintainTeam = new EnMaintainTeam();
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 //但当维护团队中已经定义了成员或设备时，提示不能删除：
		 //MT002:维护团队:{0}中已经定义了成员,不能删除该维护团队信息。
		 
		 vector = dbMaintainTeamUserMap.findAllWhere(" TEAM_ID ='"
					+ teamId + "'");
		 
		 //获取维护团队名称
		 enMaintainTeam  = dbMaintainTeam.findByKey(teamId);
		 if (vector.size() > 0) {
				throw new ErrorException("MT002", new Object[] { enMaintainTeam.getTeamName() });
			}
		 vector = dbMaintainTeamDeviceMap.findAllWhere(" TEAM_ID ='"
					+ teamId + "'");
		 
		 //MT003:维护团队:{0}中已经定义了设备,不能删除该维护团队信息。
		 vector = dbMaintainTeamDeviceMap.findAllWhere(" TEAM_ID ='"
					+ teamId + "'");
		 if (vector.size() > 0) {
				throw new ErrorException("MT003", new Object[] { enMaintainTeam.getTeamName() });
			}
		 
		   dbMaintainTeam.deleteByKey(teamId);
	}
}
