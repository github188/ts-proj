package tower.filebase.bo.sys.org;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.filebase.db.DbSysOrg;
import tower.filebase.en.EnSysOrg;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoOrgDetail implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		// TODO Auto-generated method stub
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		// 输入参数
		String orgId;

		// db,en
		DbSysOrg dbOrg;
		EnSysOrg enOrg;
		EnSysOrg enParentOrg;

		Vector enOrgs;
		// xml行号
		int row;

		/***********************************************************************
		 * 获取参数
		 **********************************************************************/
		orgId = requestXml.getInputValue("ORG_ID");

		/***********************************************************************
		 * 创建数据库连接，初始化DB，EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbOrg = new DbSysOrg(transaction, null);
		enOrgs = new Vector();
		/***********************************************************************
		 * 业务处理
		 **********************************************************************/
		// 根据orgId查找部门
		if (orgId != null && orgId.length() > 0) {
			enOrg = dbOrg.findByKey(orgId);
			if (enOrg != null) {
				row = dbOrg.setToXml(requestXml, enOrg);

				// 查找上级部门名称
				if (enOrg.getParentId() != null
						&& enOrg.getParentId().length() > 0) {
					enParentOrg = dbOrg.findByKey(enOrg.getParentId());
					if (enParentOrg != null) {
						requestXml.setItemValue("SYS_ORG", row, "PARENT_NAME", enParentOrg.getOrgName());
					}
				}
			}

			// 根据orgId查找子部门信息
			enOrgs = dbOrg.findAllWhere("PARENT_ID ='" + orgId + "'");
			if (enOrgs != null) {

				for (int i = 0; i < enOrgs.size(); i++) {
					row = requestXml.addRow("SYS_CHLID_ORG");
					enOrg = (EnSysOrg) enOrgs.get(i);
					requestXml.setItemValue("SYS_CHLID_ORG", row, "CORG_ID",
							enOrg.getOrgId());
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
					}
			}
		 } else { //orgId为空时
			enOrgs = dbOrg.findAllWhere(" PARENT_ID is null ");
//			enOrgs = dbOrg.findAll();
			if (enOrgs != null) {
//				if(requestXml.getRowCount("SYS_ORG")>0){
//				}else{
//					requestXml.addRow("SYS_ORG");
//				}
//				requestXml.setItemValue("SYS_ORG", 1, "ORG_NAME", "根");
				for (int i = 0; i < enOrgs.size(); i++) {
					row = requestXml.addRow("SYS_CHLID_ORG");
					enOrg = (EnSysOrg) enOrgs.get(i);
					requestXml.setItemValue("SYS_CHLID_ORG", row, "CORG_ID",
							enOrg.getOrgId());
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
				}

			}

		}
	}
}
