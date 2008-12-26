package tower.filebase.bo.sys.org;


import java.util.Vector;

import org.apache.log4j.Logger;

import tower.filebase.db.DbSysOrg;
import tower.filebase.en.EnSysOrg;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoSelectOrg implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		// TODO Auto-generated method stub
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//机构db、en
		DbSysOrg dbOrg;
		EnSysOrg enOrg;
		
		Vector enOrgs;
		

		/***********************************************************************
		 * 获取参数
		 **********************************************************************/
		

		/***********************************************************************
		 * 创建数据库连接，初始化DB，EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbOrg = new DbSysOrg(transaction,null);
		enOrg = new EnSysOrg();
		
		/***********************************************************************
		 * 业务处理
		 **********************************************************************/
		
		enOrgs = dbOrg.findAll();
		for(int i=0; i<enOrgs.size(); i++){
			enOrg =(EnSysOrg) enOrgs.get(i);
			int row = requestXml.addRow("SYS_TREEITEM_ORG");
			requestXml.setItemValue("SYS_TREEITEM_ORG", row, "TREE_ORG_ID", 
					enOrg.getOrgId());
			requestXml.setItemValue("SYS_TREEITEM_ORG", row, "TREE_ORG_NAME", 
					enOrg.getOrgName());
			requestXml.setItemValue("SYS_TREEITEM_ORG", row, "TREE_PARENT_ID", 
					enOrg.getParentId());
		}
	
	}
}
