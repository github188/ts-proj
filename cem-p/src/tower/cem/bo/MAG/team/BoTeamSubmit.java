package tower.cem.bo.MAG.team;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbLocationInfo;
import tower.cem.db.DbMaintainTeam;
import tower.cem.db.DbMaintainTeamDeviceMap;
import tower.cem.db.DbMaintainTeamUserMap;
import tower.cem.en.EnLocationInfo;
import tower.cem.en.EnMaintainTeam;
import tower.cem.en.EnMaintainTeamDeviceMap;
import tower.cem.en.EnMaintainTeamUserMap;
import tower.cem.util.IdCreatorDefine;
import tower.common.util.SysIdCreator;
import tower.common.util.SysIdCreatorDefine;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
/**
 * 功能描述：
 * 1、添加维护团队：向维护团队定义表中添加一条记录。
 * @author flj
 *
 */
public class BoTeamSubmit implements RootBo{

	
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
		String teamName;     //物维护团队名称
		String remark;       //备注
		String[] maintainPersonId; //维护人员编号
		String[] maintainDeviceId;//维护设备编号
		
		//其他
		Vector vector;
		StringBuffer sql1;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		teamId = requestXml.getInputValue("TEAM_ID");
		teamName = requestXml.getInputValue("TEAM_NAME");
		remark = requestXml.getInputValue("REMARK");
		maintainPersonId = requestXml.getInputValues("MANTAIN_PERSON_ID");
		maintainDeviceId = requestXml.getInputValues("MANTAIN_DEVICE_ID");
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
		 //判断添加的维护团队名称在系统中是否，如果已存在，则抛出异常。
		 sql1 = new StringBuffer(" TEAM_NAME ='"
					+ teamName + "'");
		 
			enMaintainTeam.setTeamName(teamName);
			enMaintainTeam.setRemark(remark);
	          //判断是添加还是编辑：
				if(teamId == null || teamId.length() == 0){
					teamId = SysIdCreator.GenNextId(transaction, null,
							IdCreatorDefine.ID_TYPE_TEAM_ID,
							IdCreatorDefine.ID_LEN_TEAM_ID);
					  vector = dbMaintainTeam.findAllWhere(sql1.toString());

						if (vector.size() > 0) {
								throw new ErrorException("MT001", new Object[] { teamName });// 维护团队名称：{0}在系统中已存在,请重新输入。
						}
					enMaintainTeam.setTeamId(teamId);
					dbMaintainTeam.insert(enMaintainTeam);
				}else{
					//更新维护团队信息
					sql1.append(" AND TEAM_ID != '" + teamId + "'");
					 vector = dbMaintainTeam.findAllWhere(sql1.toString());

						if (vector.size() > 0) {
								throw new ErrorException("MT001", new Object[] { teamName });// 维护团队名称：{0}在系统中已存在,请重新输入。
						}
					dbMaintainTeam.updateByKey(teamId, enMaintainTeam);
				}
	}
}
