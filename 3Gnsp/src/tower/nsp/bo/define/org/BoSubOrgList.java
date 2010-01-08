package tower.nsp.bo.define.org;


import java.util.Vector;

import org.apache.log4j.Logger;

import tower.common.util.Page;
import tower.common.util.PubFunc;
import tower.nsp.db.DbSysOrg;
import tower.nsp.en.EnSysOrg;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoSubOrgList implements RootBo {

	@SuppressWarnings("static-access")
	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//db,en
		DbSysOrg dbSysOrg;
		EnSysOrg enSysOrg;
		
		//参数声明
		Vector vEnSysOrg;
		String orgId;
		StringBuffer sqlWhere;
		String orgName;
		String orgCode;
		String linkMan;
		String linkTele;
		String linkEmail;
		String buyInFlag;
		
		/***********************************************************************
		 * 获取参数
		 **********************************************************************/
		orgId = requestXml.getInputValue("ORG_ID");
		if(orgId == null || orgId.length() ==0){
			orgId = sessionXml.getItemValue("SYS_ORG", 1, "PARENT_ORG_ID");
		}
		if(orgId == null || orgId.length() ==0){
			throw new ErrorException("AM0104",null);
		}
		orgName = requestXml.getInputValue("QORG_NAME");
		orgCode = requestXml.getInputValue("QORG_CODE");
		linkMan = requestXml.getInputValue("QLINK_MAN");	
		linkTele =requestXml.getInputValue("QLINK_TELE");
		linkEmail =requestXml.getInputValue("QLINK_EMAIL");
		buyInFlag = requestXml.getInputValue("QBUY_IN_FLAG");
		
		/***********************************************************************
		 * 创建数据库连接，初始化DB，EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbSysOrg = new DbSysOrg(transaction,null);
		sqlWhere = new StringBuffer();
		/***********************************************************************
		 * 业务处理
		 **********************************************************************/
          //进行查询
		 if(orgName != null && orgName.length() !=0){
			 if(sqlWhere.toString().length()>0){
				 sqlWhere.append(" AND ");
			 }
			 sqlWhere.append("  ORG_NAME LIKE '%");
			 sqlWhere.append(orgName);
			 sqlWhere.append("%'");
		 }
		 if(orgCode != null && orgCode.length() !=0){
			 if(sqlWhere.toString().length()>0){
				 sqlWhere.append(" AND ");
			 }
			 sqlWhere.append("  ORG_CODE=");
			 sqlWhere.append(transaction.formatString(orgCode));
		 }
		 if(linkMan != null && linkMan.length() !=0){
			 if(sqlWhere.toString().length()>0){
				 sqlWhere.append(" AND ");
			 }
			 sqlWhere.append("  LINK_MAN LIKE '%");
			 sqlWhere.append(linkMan);
			 sqlWhere.append("%'");
		 }
		 if(linkTele != null && linkTele.length() !=0){
			 if(sqlWhere.toString().length()>0){
				 sqlWhere.append(" AND ");
			 }
			 sqlWhere.append("  LINK_TELE=");
			 sqlWhere.append(transaction.formatString(linkTele));
		 }
		 if(linkEmail != null && linkEmail.length() !=0){
			 if(sqlWhere.toString().length()>0){
				 sqlWhere.append(" AND ");
			 }
			 sqlWhere.append("  LINK_EMAIL=");
			 sqlWhere.append(transaction.formatString(linkEmail));
		 }
		 if(buyInFlag != null && buyInFlag.length() !=0){
			 if(sqlWhere.toString().length()>0){
				 sqlWhere.append(" AND ");
			 }
			 sqlWhere.append("  BUY_IN_FLAG=");
			 sqlWhere.append(transaction.formatString(buyInFlag));
		 }
		if(sqlWhere.toString().length()>0){
			sqlWhere.append(" AND ");
		}
		sqlWhere.append("  PARENT_ID=");
		sqlWhere.append(transaction.formatString(orgId));
		sqlWhere.append(" AND STATION_FLAG='Y'");
		 
			 //根据查询条件从“机构(SYS_ORG)”表中获取满足条件的数据，并按照调度日期降序排序：
		 if(sqlWhere.toString().length()>0){
			 Page.SetPageInfo(transaction, null, requestXml,dbSysOrg,
						PubFunc.LEN_PAGE_COUNT,"SYS_ORG", sqlWhere.toString());
			 vEnSysOrg = dbSysOrg.findAllWhere(sqlWhere.toString());
		 }else{
			 Page.SetPageInfo(transaction, null, requestXml,dbSysOrg,
						PubFunc.LEN_PAGE_COUNT,"SYS_ORG", null);
			 vEnSysOrg = dbSysOrg.findAllWhere(" PARENT_ID='" + orgId + "'"
						+ " and " + "STATION_FLAG='Y'");
		 }
		
			if(vEnSysOrg.size() >0){
				enSysOrg = dbSysOrg.findByKey(orgId);
				requestXml.addRow("SYS_ORG");
				requestXml.setItemValue("SYS_ORG", 1, "PARENT_ORG_NAME",enSysOrg.getOrgName());
				dbSysOrg.setAllToXml(requestXml, vEnSysOrg);
			}
			if(requestXml.getRowCount("SYS_ORG") == 0){
				requestXml.addRow("SYS_ORG");
			}
			requestXml.setItemValue("SYS_ORG", 1, "CORG_ID", orgId);
	}		
}
