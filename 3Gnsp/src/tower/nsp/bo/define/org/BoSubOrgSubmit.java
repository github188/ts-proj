package tower.nsp.bo.define.org;

import org.apache.log4j.Logger;

import tower.common.util.SysIdCreator;
import tower.nsp.common.util.IdCreatorDefine;
import tower.nsp.db.DbSysOrg;
import tower.nsp.en.EnSysOrg;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoSubOrgSubmit implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		// 输入参数
		String orgId;
		String orgName;
		String parentId;
		String orgDesc;
		String linkMan;
		String linkTele;
		String linkEmail;
		String frePoint;
		String perCode;
		String orgType;
		@SuppressWarnings("unused")
		String stationFlag;
		String buyInFlag;
		String orgCode;
		
		String flag;

		// db,en
		DbSysOrg dbOrg;
		EnSysOrg enOrg;

		/***********************************************************************
		 * 获取参数
		 **********************************************************************/
		orgId = requestXml.getInputValue("QORG_ID");
		orgName = requestXml.getInputValue("ORG_NAME");
		parentId = requestXml.getInputValue("PARENT_ID");
		orgDesc = requestXml.getInputValue("ORG_DESC");
		frePoint = requestXml.getInputValue("FRE_POINT");
		perCode = requestXml.getInputValue("PER_CODE");
		orgType = requestXml.getInputValue("ORG_TYPE");
		linkMan = requestXml.getInputValue("LINK_MAN");
		linkTele = requestXml.getInputValue("LINK_TELE");
		linkEmail = requestXml.getInputValue("LINK_EMAIL");
		stationFlag = (String) requestXml.getInputObject("STATION_FLAG");
		buyInFlag = requestXml.getInputValue("BUY_IN_FLAG");
		orgCode = requestXml.getInputValue("ORG_CODE");
		
		flag= requestXml.getInputValue("FLAG");

		/***********************************************************************
		 * 创建数据库连接，初始化DB，EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbOrg = new DbSysOrg(transaction, null);
		enOrg = new EnSysOrg();

		/***********************************************************************
		 * 业务处理
		 **********************************************************************/
		//检查是否有重复的基站
		if(orgId == null || orgId.length()==0){
			
		}
		// 设置EN除ID外的字段
		enOrg.setOrgName(orgName);
		enOrg.setParentId(parentId);
		enOrg.setOrgDesc(orgDesc);
		enOrg.setFrePoint(frePoint);
		enOrg.setOrgType(orgType);
		enOrg.setPerCode(perCode);
		enOrg.setLinkMan(linkMan);
		enOrg.setLinkTele(linkTele);
		enOrg.setLinkEmail(linkEmail);
		enOrg.setStationFlag("Y");
		enOrg.setBuyInFlag(buyInFlag);
		enOrg.setOrgCode(orgCode);
		
		sessionXml.addRow("SYS_ORG");
		sessionXml.setItemValue("SYS_ORG", 1, "PARENT_ORG_ID", parentId);
		

		// 根据ID判断添加还是修改
		if (orgId.length() == 0 || orgId == null) {
			
			//验证
			int count1 = dbOrg.countWhere(" ORG_NAME='"+orgName+"' and STATION_FLAG='Y'");
			if(count1 > 0){
				throw new ErrorException("AM0106",null);
			}
//			int count2 = dbOrg.countWhere(" ORG_CODE='"+orgCode+"' and STATION_FLAG='Y'");
//			if(count2 > 0){
//				throw new ErrorException("AM0107",null);
//			}
			
			// ID长度为零表示添加
			enOrg.setStationFlag(flag);
			// 生成ID
			orgId = SysIdCreator.GenNextId(transaction, null,
					IdCreatorDefine.ID_TYPE_ORG_ID,
					IdCreatorDefine.ID_LEN_ORG_ID);
	
			// 设置ID
			enOrg.setOrgId(orgId);

			// 添加至数据库
			dbOrg.insert(enOrg);
		} else {
			
			//验证
			int count1 = dbOrg.countWhere(" ORG_NAME='"+orgName+"' and STATION_FLAG='Y' and ORG_ID !='"+orgId+"'");
			if(count1 > 0){
				throw new ErrorException("AM0106",null);
			}
			int count2 = dbOrg.countWhere(" ORG_CODE='"+orgCode+"' and STATION_FLAG='Y' and ORG_ID !='"+orgId+"'");
			if(count2 > 0){
				throw new ErrorException("AM0107",null);
			}
			// 按ID更新数据库
			dbOrg.updateByKey(orgId, enOrg);
		}
	}

}
