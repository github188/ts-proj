package tower.nsp.bo.define.org;


import org.apache.log4j.Logger;


import tower.nsp.db.DbResourcePrepareList;
import tower.nsp.db.DbSysOrg;
import tower.nsp.db.DbSysUser;
import tower.nsp.en.EnResourcePrepareList;
import tower.nsp.en.EnSysOrg;
import tower.tmvc.ErrorException;
import tower.tmvc.QueryResult;
import tower.tmvc.QueryResultRow;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
//import tower.tmvc.sys.db.DbSysOrg;
//import tower.tmvc.sys.db.DbSysUser;

public class BoSubOrgDelete implements RootBo {

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

		DbResourcePrepareList dbResourcePrepareList;
		EnResourcePrepareList enResourcePrepareList;
		
		DbSysUser dbUser;

		// 下属用户数，下属部门数，调出工单数，调入工单数
		int userCount;
		int subOrgCount;
		int outSheetCount;
		int inSheetCount;
		
		
		QueryResult qs;
		StringBuffer sql;

		/***********************************************************************
		 * 获取参数
		 **********************************************************************/
		orgId = requestXml.getInputValue("QORG_ID");

		/***********************************************************************
		 * 创建数据库连接，初始化DB，EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbOrg = new DbSysOrg(transaction, null);
		dbUser = new DbSysUser(transaction, null);
		dbResourcePrepareList = new DbResourcePrepareList(transaction, null);
		sql = new StringBuffer();
		/***********************************************************************
		 * 业务处理
		 **********************************************************************/
		if(orgId != null && orgId.length() != 0){
			enOrg = dbOrg.findByKey(orgId);
			if(enOrg != null){
				sessionXml.addRow("SYS_ORG");
				sessionXml.setItemValue("SYS_ORG", 1, "PARENT_ORG_ID", enOrg.getParentId());
			}
		}
		//根据orgId查找库存数
		sql.append("select sum(stock_amount) as 'AMOUNT' from resource_org_amount where org_id=");
		sql.append(Transaction.formatString(orgId));
		qs = transaction.doQuery(null, sql.toString());
		QueryResultRow resultRow = qs.get(0);
		String result = resultRow.getString("AMOUNT");
		if(result == null || result.length() ==0){
			result = "0";
		}
		int count = Integer.parseInt(result);
		if(count > 0){
			throw new ErrorException("AM0105",null);
		}
		
		// 根据orgId查找下属用户数
		userCount = dbUser.countWhere(" USER_ORG_ID ='"+ orgId +"'");
		if (userCount > 0) {
			// 此部门下包含用户，不能删除。
			throw new ErrorException("SORG01", null);
		}
		
		// 根据orgId查找下属部门数
		subOrgCount = dbOrg.countWhere(" PARENT_ID ='"+ orgId+ "'");
		if (subOrgCount > 0) {
			// 此部门下包含下级部门，不能删除。
			throw new ErrorException("SORG02", null);
		}
		
		// 根据orgId查找"调出单位"为该部门的工单信息
		outSheetCount = dbResourcePrepareList.countWhere(" OUT_ORG_ID ='"+ orgId+ "' OR  OUT_STATION_ID='" + orgId+ "'");
		if (outSheetCount > 0) {
			// 存在调出单位为该机构（基站）的工单信息，不能删除。
			throw new ErrorException("SHEET01", null);
		}
		
		// 根据orgId查找"调入单位"为该部门的工单信息
		inSheetCount = dbResourcePrepareList.countWhere(" IN_ORG_ID ='"+ orgId+ "' OR  IN_STATION_ID='" + orgId+ "'");
		if (inSheetCount > 0) {
			//存在调入单位为该机构（基站）的工单信息，不能删除。
			throw new ErrorException("SHEET02", null);
		}

		// 删除部门
		dbOrg.deleteByKey(orgId);
	}

}
