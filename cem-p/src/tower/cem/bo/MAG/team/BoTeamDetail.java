package tower.cem.bo.MAG.team;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbMaintainTeam;
import tower.cem.db.DbMaintainTeamDeviceMap;
import tower.cem.db.DbMaintainTeamUserMap;
import tower.cem.en.EnMaintainTeam;
import tower.cem.en.EnMaintainTeamDeviceMap;
import tower.cem.en.EnMaintainTeamUserMap;
import tower.cem.util.IdCreatorDefine;
import tower.common.util.SysIdCreator;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
/**
 * 功能描述：根据维护团队编号从维护团队定义表中获取详细信息。
 * @author flj
 *
 */
public class BoTeamDetail implements RootBo{

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
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 enMaintainTeam =  dbMaintainTeam.findByKey(teamId);
		 dbMaintainTeam.setToXml(requestXml, enMaintainTeam);
	}
}
