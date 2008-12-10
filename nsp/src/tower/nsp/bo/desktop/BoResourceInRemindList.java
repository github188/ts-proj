package tower.nsp.bo.desktop;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.common.util.DateFunc;
import tower.nsp.db.DbResourceClass;
import tower.nsp.db.DbResourcePrepareList;
import tower.nsp.db.DbResourcePrepareSheet;
import tower.nsp.db.DbResourceType;
import tower.nsp.db.DbSysOrg;
import tower.nsp.en.EnResourceClass;
import tower.nsp.en.EnResourcePrepareList;
import tower.nsp.en.EnResourcePrepareSheet;
import tower.nsp.en.EnResourceType;
import tower.nsp.en.EnSysOrg;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 
 * 功能概述：获取等待入库的工单信息
 * 
 * @author fanlj 2008-10-29 上午10:43:17
 */
public class BoResourceInRemindList implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml,
			XMLWrap applicationXml, Logger logger) throws ErrorException {
		// TODO Auto-generated method stub

		/*****************************************************************************************************
		 * 声明变量
		 ****************************************************************************************************/

		DbResourcePrepareList dbResourcePrepareList;
		EnResourcePrepareList enResourcePrepareList;
		DbResourcePrepareSheet dbResourcePrepareSheet;
		EnResourcePrepareSheet enResourcePrepareSheet;
		DbSysOrg dbSysOrg;
		EnSysOrg enSysOrg;
		EnSysOrg enSysOrgP;
		DbResourceClass dbResourceClass;
		EnResourceClass enResourceClass;
		DbResourceType dbResourceType;
		EnResourceType enResourceType;
		Vector resourceIns;

		StringBuffer sql = new StringBuffer();

		// 用户信息
		String orgId;

		// 条件
		String remindListId; // 调度单明细Id

		/*****************************************************************************************************
		 * 获取输入
		 ****************************************************************************************************/
		orgId = sessionXml.getItemValue("SYS_USER", 1, "USER_ORG_ID");
		// 获取条件
		remindListId = requestXml.getInputValue("REMIND_LIST_ID");

		/*****************************************************************************************************
		 * 创建数据库连接、实例化DB、EN
		 ****************************************************************************************************/

		transaction.createDefaultConnection(null, true);
		dbResourcePrepareList = new DbResourcePrepareList(transaction, null);
		dbResourcePrepareSheet = new DbResourcePrepareSheet(transaction, null);
		dbSysOrg = new DbSysOrg(transaction, null);
		dbResourceClass = new DbResourceClass(transaction, null);
		dbResourceType = new DbResourceType(transaction, null);

		/*****************************************************************************************************
		 * 执行业务逻辑、输出
		 ****************************************************************************************************/

		if (orgId == null || orgId.length() == 0) {
			throw new ErrorException("RI0001", null);
		} else {
			if (sql.toString().length() > 0) {
				sql.append(" and ");
			}
			sql.append("LIST_STATUS = '3' and ");
			sql.append("IN_ORG_ID = ");
			sql.append(Transaction.formatString(orgId));

		}
		if (remindListId != null && remindListId.length() > 0) {
			if (sql.toString().length() > 0) {
				sql.append(" and ");
			}
			sql.append("LIST_ID =");
			sql.append(Transaction.formatString(remindListId));
		}
		resourceIns = dbResourcePrepareList.findAllWhere(sql.toString());
		if (resourceIns != null && resourceIns.size() > 0) {
			for (int i = 0; i < resourceIns.size(); i++) {
				enResourcePrepareList = (EnResourcePrepareList) resourceIns.get(i);
				enResourcePrepareSheet = dbResourcePrepareSheet.findByKey(enResourcePrepareList.getSheetId());
				enResourceClass = dbResourceClass.findByKey(enResourcePrepareList.getResourceClassId());
				enResourceType = dbResourceType.findByKey(enResourcePrepareList.getResourceTypeId());
				enSysOrg = dbSysOrg.findByKey(enResourcePrepareList.getOutOrgId());
				String outStation;
				if (enResourcePrepareList.getOutStationId() != null
						&& enResourcePrepareList.getOutStationId().length() > 0) {
					enSysOrgP = dbSysOrg.findByKey(enResourcePrepareList.getOutStationId());
					outStation = enSysOrgP.getOrgName();
				} else {
					outStation = "";
				}
				int row = dbResourcePrepareList.setToXml(requestXml, enResourcePrepareList);
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "OUT_ORG_NAME", enSysOrg.getOrgName());
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "OUT_STATION_NAME", outStation);
				enSysOrg = dbSysOrg.findByKey(enResourcePrepareList.getInOrgId());
				String inStation;
				if (enResourcePrepareList.getInStationId() != null
						&& enResourcePrepareList.getInStationId().length() > 0) {
					enSysOrgP = dbSysOrg.findByKey(enResourcePrepareList.getInStationId());
					inStation = enSysOrgP.getOrgName();
				} else {
					inStation = "";
				}
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "IN_ORG_NAME", enSysOrg.getOrgName());
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "IN_STATION_NAME", inStation);
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "CLASS_NAME", enResourceClass
						.getClassName());
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "TYPE_NAME", enResourceType
						.getTypeName());
				if (enResourcePrepareSheet != null) {
					requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "PREPARE_DATE", DateFunc
							.FormatDateTime(enResourcePrepareSheet.getPrepareDate()));
				} else {
					requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "PREPARE_DATE", "");
				}
			}
		}
	}

}
