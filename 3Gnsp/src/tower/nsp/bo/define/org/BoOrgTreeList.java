package tower.nsp.bo.define.org;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.nsp.db.DbSysOrg;
import tower.nsp.en.EnSysOrg;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoOrgTreeList implements RootBo {

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
		
		//can shu
		String flag;

		/***********************************************************************
		 * 获取参数
		 **********************************************************************/
		 flag = requestXml.getInputValue("FLAG");
		 
		/***********************************************************************
		 * 创建数据库连接，初始化DB，EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbOrg = new DbSysOrg(transaction, null);
		enOrg = new EnSysOrg();
		enOrgs = new Vector();

		/***********************************************************************
		 * 5************** * 业务处理
		 **********************************************************************/
		// 查找所有机构信息（除了基站）
		enOrgs = dbOrg.findAllWhere(" STATION_FLAG='N'" );
		for (int i = 0; i < enOrgs.size(); i++) {

			enOrg = (EnSysOrg) enOrgs.get(i);
			int row = requestXml.addRow("SYS_TREEITEM_ORG");
			requestXml.setItemValue("SYS_TREEITEM_ORG", row, "TREE_ORG_ID",
					enOrg.getOrgId());
			requestXml.setItemValue("SYS_TREEITEM_ORG", row, "TREE_ORG_NAME",
					enOrg.getOrgName());
			requestXml.setItemValue("SYS_TREEITEM_ORG", row, "TREE_PARENT_ID",
					enOrg.getParentId());
		}
		if(requestXml.getRowCount("SYS_ORG_STATION") == 0){
			requestXml.addRow("SYS_ORG_STATION");
		}
		requestXml.setItemValue("SYS_ORG_STATION", 1, "ADD_FLAG", flag);
	}
}
