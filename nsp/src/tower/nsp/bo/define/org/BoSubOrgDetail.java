package tower.nsp.bo.define.org;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.nsp.db.DbSysOrg;
import tower.nsp.en.EnSysOrg;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoSubOrgDetail implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		// 输入参数
		String orgId;

		// db,en
		DbSysOrg dbOrg;
		EnSysOrg enOrg;
		EnSysOrg enParentOrg;

		@SuppressWarnings("unused")
		Vector enOrgs = new Vector();
		// xml行号
		int row;

		/***********************************************************************
		 * 获取参数
		 **********************************************************************/
		orgId = requestXml.getInputValue("QORG_ID");

		/***********************************************************************
		 * 创建数据库连接，初始化DB，EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbOrg = new DbSysOrg(transaction, null);
		/***********************************************************************
		 * 业务处理
		 **********************************************************************/
		// 根据orgId查找部门
		if (orgId.length() > 0) {
			enOrg = dbOrg.findByKey(orgId);
			if (enOrg != null) {
				row = dbOrg.setToXml(requestXml, enOrg);

				// 查找上级部门名称
				if (enOrg.getParentId() != null
						&& enOrg.getParentId().length() > 0) {
					enParentOrg = dbOrg.findByKey(enOrg.getParentId());
					if (enParentOrg != null) {
						requestXml.setItemValue("SYS_ORG", row, "PARENT_NAME",
								enParentOrg.getOrgName());
//						int row1 = sessionXml.addRow("SYS_ORG");
//						int cou = sessionXml.setItemValue("SYS_ORG", row1, "PARENT_ORG_ID", enOrg.getParentId());
					}
				}
			}
			
//			存parentId 
//			int row1 = sessionXml.addRow("SYS_ORG");
//			sessionXml.setItemValue("SYS_ORG", row1, "CORG_ID", orgId);
		}

	}

}
