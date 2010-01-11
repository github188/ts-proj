package tower.nsp.bo.define.org;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.common.util.Page;
import tower.common.util.PubFunc;
import tower.nsp.db.DbSysOrg;
import tower.tmvc.ErrorException;
import tower.tmvc.QueryResult;
import tower.tmvc.QueryResultRow;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoOrgPartList implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		// TODO Auto-generated method stub

		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		
		@SuppressWarnings("unused")
		DbSysOrg dbSysOrg;
		@SuppressWarnings("unused")
		Vector orgs;
		
		QueryResult rsAmount;
		QueryResultRow rowAmount;
		
		String org;
		String parOrg;
		String stationFlag;
		
		StringBuffer sqlP = new StringBuffer();
		
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		
		org = requestXml.getInputValue("SELECT_ORG");
		parOrg = requestXml.getInputValue("SELECT_PARENT_ORG");
		stationFlag = requestXml.getInputValue("SELECT_STATION");
		
		//System.out.println("org"+org+"stationFlag" + stationFlag);
		
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		
		transaction.createDefaultConnection(null, false);
		dbSysOrg = new DbSysOrg(transaction,null);
		
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
			sqlP.append("select s.* , p.org_name parentName from (");
			sqlP.append("select * from sys_org where 1=1 ");
			if(parOrg != null && parOrg.length() > 0){
				sqlP.append(" and parent_id in(select org_id from sys_org where org_name like'%");
				sqlP.append(parOrg);
				sqlP.append("%')");
			}
			sqlP.append(" and STATION_FLAG = ");
			sqlP.append(Transaction.formatString(stationFlag));
			if(org != null && org.length() > 0){
				sqlP.append(" and org_name like '%");
				sqlP.append(org);
				sqlP.append("%'");
			}
			sqlP.append(") s left join sys_org p on s.parent_id = p.org_id where s.parent_id != ''");
			//System.out.println(sqlP.toString());
			/*select ss.*,p.org_name from (SELECT s.* FROM nsp.sys_org s where parent_id in
					(select org_id from nsp.sys_org where org_name like '%青%'))
					 ss , nsp.sys_org p where ss.parent_id = p.org_id;
					 */
			 int page = Page.SetPageInfo(transaction, null, requestXml,
						PubFunc.LEN_PAGE_COUNT, sqlP.toString());
			rsAmount = transaction.doQuery(null, sqlP.toString(),page,PubFunc.LEN_PAGE_COUNT);
			if(rsAmount != null && rsAmount.size() > 0){
				for(int i = 0 ; i < rsAmount.size() ; i++){
					rowAmount = rsAmount.get(i);
					int row = requestXml.addRow("SYS_ORG");
					requestXml.setItemValue("SYS_ORG", row, "SYS_PARENT_NAME", rowAmount.getString("parentName"));
					requestXml.setItemValue("SYS_ORG", row, "ORG_NAME", rowAmount.getString("ORG_NAME"));
					requestXml.setItemValue("SYS_ORG", row, "ORG_CODE", rowAmount.getString("ORG_CODE"));
					requestXml.setItemValue("SYS_ORG", row, "LINK_MAN", rowAmount.getString("LINK_MAN"));
					requestXml.setItemValue("SYS_ORG", row, "LINK_TELE", rowAmount.getString("LINK_TELE"));
					requestXml.setItemValue("SYS_ORG", row, "ORG_ID", rowAmount.getString("ORG_ID"));
					requestXml.setItemValue("SYS_ORG", row, "PARENT_ID", rowAmount.getString("PARENT_ID"));
					requestXml.setItemValue("SYS_ORG", row, "STATION_FLAG", rowAmount.getString("STATION_FLAG"));
					requestXml.setItemValue("SYS_ORG", row, "PER_CODE", rowAmount.getString("PER_CODE"));
					requestXml.setItemValue("SYS_ORG", row, "FRE_POINT", rowAmount.getString("FRE_POINT"));
					requestXml.setItemValue("SYS_ORG", row, "ORG_TYPE", rowAmount.getString("ORG_TYPE"));
				}
			}
		
	}

}
