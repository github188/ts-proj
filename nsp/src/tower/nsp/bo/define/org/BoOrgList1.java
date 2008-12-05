package tower.nsp.bo.define.org;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.nsp.db.DbSysOrg;
import tower.nsp.en.EnSysOrg;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoOrgList1 implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		// db,en
		DbSysOrg dbOrg;
		EnSysOrg enOrg;

		// vector
		Vector enOrgs;

		// xml行号
		int row;

		/***********************************************************************
		 * 获取参数
		 **********************************************************************/
		String parentId = requestXml.getInputValue("PARENT_ID");

		/***********************************************************************
		 * 创建数据库连接，初始化DB，EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbOrg = new DbSysOrg(transaction, null);

		/***********************************************************************
		 * 业务处理
		 **********************************************************************/
		// 查找所有部门
		if (parentId == null || parentId.length() == 0) {
			// 查找顶级下的子级级信息
			enOrgs = dbOrg.findAllWhere(" STATION_FLAG='N' AND PARENT_ID='' ");

			for (int i = 0; i < enOrgs.size(); i++) {
				row = requestXml.addRow("SYS_CHLID_ORG");
				enOrg = (EnSysOrg) enOrgs.get(i);
				requestXml.setItemValue("SYS_CHLID_ORG", row, "CORG_ID", enOrg
						.getOrgId());
				requestXml.setItemValue("SYS_CHLID_ORG", row, "CORG_NAME",
						enOrg.getOrgName());
				requestXml.setItemValue("SYS_CHLID_ORG", row, "CORG_DESC",
						enOrg.getOrgDesc());
				requestXml.setItemValue("SYS_CHLID_ORG", row, "CLINK_MAN",
						enOrg.getLinkMan());
				requestXml.setItemValue("SYS_CHLID_ORG", row, "CLINK_TELE",
						enOrg.getLinkTele());
				requestXml.setItemValue("SYS_CHLID_ORG", row, "CLINK_EMAIL",
						enOrg.getLinkEmail());
				requestXml.setItemValue("SYS_CHLID_ORG", row, "CSTATION_FLAG", 
						enOrg.getStationFlag());
				requestXml.setItemValue("SYS_CHLID_ORG", row, "CBUY_IN_FLAG",
						enOrg.getBuyInFlag());
				requestXml.setItemValue("SYS_CHLID_ORG", row, "CORG_CODE", 
						enOrg.getOrgCode());
			}

		} else {
			// 根据parentId查找子级信息
			enOrgs = dbOrg.findAllWhere("PARENT_ID='" + parentId + "'"+" and "+"STATION_FLAG='N'");
			for (int i = 0; i < enOrgs.size(); i++) {
				row = requestXml.addRow("SYS_CHLID_ORG");
				enOrg = (EnSysOrg) enOrgs.get(i);
				requestXml.setItemValue("SYS_CHLID_ORG", row, "CORG_ID", enOrg
						.getOrgId());
				requestXml.setItemValue("SYS_CHLID_ORG", row, "CORG_NAME",
						enOrg.getOrgName());
				requestXml.setItemValue("SYS_CHLID_ORG", row, "CORG_DESC",
						enOrg.getOrgDesc());
				requestXml.setItemValue("SYS_CHLID_ORG", row, "CLINK_MAN",
						enOrg.getLinkMan());
				requestXml.setItemValue("SYS_CHLID_ORG", row, "CLINK_TELE",
						enOrg.getLinkTele());
				requestXml.setItemValue("SYS_CHLID_ORG", row, "CLINK_EMAIL",
						enOrg.getLinkEmail());
				requestXml.setItemValue("SYS_CHLID_ORG", row, "CSTATION_FLAG", 
						enOrg.getStationFlag());
				requestXml.setItemValue("SYS_CHLID_ORG", row, "CBUY_IN_FLAG",
						enOrg.getBuyInFlag());
				requestXml.setItemValue("SYS_CHLID_ORG", row, "CORG_CODE", 
						enOrg.getOrgCode());
			}

			// 根据parentId查找父级信息
			enOrgs = dbOrg.findAllWhere("ORG_ID='" + parentId + "'" +" and "+"STATION_FLAG='N'");
			row = requestXml.addRow("SYS_ORG");
			for (int i = 0; i < enOrgs.size(); i++) {
				enOrg = (EnSysOrg) enOrgs.get(i);
				requestXml.setItemValue("SYS_ORG", row, "ORG_ID", enOrg
						.getOrgId());
				requestXml.setItemValue("SYS_ORG", row, "ORG_NAME", enOrg
						.getOrgName());
				requestXml.setItemValue("SYS_ORG", row, "ORG_DESC", enOrg
						.getOrgDesc());
				requestXml.setItemValue("SYS_ORG", row, "LINK_MAN", enOrg
						.getLinkMan());
				requestXml.setItemValue("SYS_ORG", row, "LINK_TELE", enOrg
						.getLinkTele());
				requestXml.setItemValue("SYS_ORG", row, "LINK_EMAIL", enOrg
						.getLinkEmail());
				requestXml.setItemValue("SYS_ORG", row, "STATION_FLAG", 
						enOrg.getStationFlag());
				requestXml.setItemValue("SYS_ORG", row, "BUY_IN_FLAG",
						enOrg.getBuyInFlag());
				requestXml.setItemValue("SYS_ORG", row, "PARENT_ID", enOrg
						.getParentId());
				requestXml.setItemValue("SYS_ORG", row, "ORG_CODE", 
						enOrg.getOrgCode());
			}
		}

		/*
		 * for (int i = 0; i < enOrgs.size(); i++) { enOrg =
		 * (EnSysOrg)enOrgs.get(i); row = dbOrg.setToXml(requestXml, enOrg);
		 * //查找上级部门名称 if (enOrg.getParentId() != null &&
		 * enOrg.getParentId().length() > 0) { enParentOrg =
		 * dbOrg.findByKey(enOrg.getParentId()); if (enParentOrg != null) {
		 * requestXml.setItemValue("SYS_ORG", row, "PARENT_NAME",
		 * enParentOrg.getOrgName()); } } }
		 */
	}

}
