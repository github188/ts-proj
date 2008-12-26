package tower.filebase.bo.sys.org;

import java.util.Vector;

import org.apache.log4j.Logger;


import tower.filebase.db.DbSysOrg;
import tower.filebase.en.EnSysOrg;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoOrgList implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		// TODO Auto-generated method stub
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		// db,en
		DbSysOrg dbOrg;
		EnSysOrg enOrg;

		Vector vOrg;
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
		vOrg = new Vector();
		enOrgs = new Vector();
		enOrg = new EnSysOrg();

		/***********************************************************************
		 * 业务处理:
		 **********************************************************************/
		//查询根节点
		vOrg=dbOrg.findAllWhere(" PARENT_ID is null ");
		if(vOrg!=null&&vOrg.size()>0){
			enOrg=(EnSysOrg) vOrg.get(0);
			if(enOrg!=null){
				int iRow=requestXml.addRow("ROOT_ORG");
				requestXml.setItemValue("ROOT_ORG", iRow, "ROOT_ORG_ID", enOrg.getOrgId());
				requestXml.setItemValue("ROOT_ORG", iRow, "ROOT_ORG_NAME", enOrg.getOrgName());
				requestXml.setItemValue("ROOT_ORG", iRow,"ORG_DESC",enOrg.getOrgDesc());
				requestXml.setItemValue("ROOT_ORG", iRow,"LINK_MAN",enOrg.getLinkMan() );
				requestXml.setItemValue("ROOT_ORG", iRow,"LINK_TELE",enOrg.getLinkTele() );
				requestXml.setItemValue("ROOT_ORG", iRow,"LINK_EMAIL",enOrg.getLinkEmail() );
				if(parentId==null||parentId.length()<=0){
					parentId=enOrg.getOrgId();
				}
			}
			
		}
		enOrg=new EnSysOrg();
		// 查找所有部门
		
		// 根据parentId查找子级信息
		if(parentId!=null&&parentId.length()>0){
			enOrgs = dbOrg.findAllWhere("PARENT_ID='" + parentId + "'");
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

				// 根据parentId查找父级信息
			enOrgs = dbOrg.findAllWhere("ORG_ID='" + parentId + "'");
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
				requestXml.setItemValue("SYS_ORG", row, "PARENT_ID", enOrg
						.getParentId());
			}
		}
	
	}


}
