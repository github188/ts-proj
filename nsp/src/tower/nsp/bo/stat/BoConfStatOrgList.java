package tower.nsp.bo.stat;

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

/**
 * 
 * 功能概述：根据查询条件，查询符合条件的机构/基站列表。
 * 
 * @author fanlj 2008-10-17 上午09:59:02
 */
public class BoConfStatOrgList implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml,
			XMLWrap applicationXml, Logger logger) throws ErrorException {

		/*****************************************************************************************************
		 * 声明变量
		 ****************************************************************************************************/
		// 机构db en
		DbSysOrg dbSysOrg;
		EnSysOrg enSysOrg;

		// 获取参数：
		String orgId;
		String orgName;
		String orgCode;
		String stationFlag;

		// 其他
		Vector vEnSysOrg;
		StringBuffer sqlWhere;
		/*****************************************************************************************************
		 * 获取输入
		 ****************************************************************************************************/
		orgId = sessionXml.getItemValue("SYS_USER", 1, "USER_ORG_ID");
		orgName = requestXml.getInputValue("ORG_NAME");
		orgCode = requestXml.getInputValue("ORG_CODE");
		stationFlag = requestXml.getInputValue("STATION_FLAG");
		/*****************************************************************************************************
		 * 创建数据库连接、实例化DB、EN
		 ****************************************************************************************************/
		transaction.createDefaultConnection(null, true);
		dbSysOrg = new DbSysOrg(transaction, null);
		dbSysOrg.setOrderBy(" ORDER BY ORG_ID ASC");
		enSysOrg = new EnSysOrg();
		/*****************************************************************************************************
		 * 执行业务逻辑、输出
		 ****************************************************************************************************/
		// 构造查询条件:
		sqlWhere = new StringBuffer();
		sqlWhere.append(" 1=1");
		if (orgName != null && orgName.length() != 0) {
			sqlWhere.append(" AND ORG_NAME LIKE '%");
			sqlWhere.append(orgName);
			sqlWhere.append("%'");
		}
		if (orgCode != null && orgCode.length() != 0) {
			sqlWhere.append(" AND ORG_CODE LIKE '%");
			sqlWhere.append(orgCode);
			sqlWhere.append("%'");
		}
		if (stationFlag != null && stationFlag.length() != 0) {
			sqlWhere.append(" AND STATION_FLAG =");
			sqlWhere.append(Transaction.formatString(stationFlag));
		}
		// 构造查询条件中的机构条件部分：如果当前机构的上级机构ID为空或''时（当前机构为“青岛移动”），则：查询所有数据
		// 如果当前机构的上级机构ID不为空或''时（当前机构为“分公司”），则：查询本级及下级机构
		enSysOrg = dbSysOrg.findByKey(orgId);
		if (enSysOrg != null) {
			if (enSysOrg.getParentId() != null && enSysOrg.getParentId().length() != 0) {
				sqlWhere.append(" AND ( PARENT_ID=");
				sqlWhere.append(Transaction.formatString(orgId));
				sqlWhere.append(" OR ORG_ID=");
				sqlWhere.append(Transaction.formatString(orgId));
				sqlWhere.append(" ) ");
			}
		}
		// 使用构造的查询条件，自机构表查询符合条件的机构列表，并按机构ID升序排列；
		if (sqlWhere.toString().length() > 0) {
			Page.SetPageInfo(transaction, null, requestXml, dbSysOrg, PubFunc.LEN_PAGE_COUNT, "sys_org",
					sqlWhere.toString());
			vEnSysOrg = dbSysOrg.findAllWhere(sqlWhere.toString());
		} else {
			Page
					.SetPageInfo(transaction, null, requestXml, dbSysOrg, PubFunc.LEN_PAGE_COUNT, "sys_org",
							null);
			vEnSysOrg = dbSysOrg.findAll();
		}

		for (int i = 0; i < vEnSysOrg.size(); i++) {
			enSysOrg = (EnSysOrg) vEnSysOrg.get(i);
			int row = dbSysOrg.setToXml(requestXml, enSysOrg);
			enSysOrg = dbSysOrg.findByKey(enSysOrg.getParentId());
			if (enSysOrg != null) {
				requestXml.setItemValue("SYS_ORG", row, "PARENT_ORG_NAME", enSysOrg.getOrgName());
			}
		}

	}

}
