package tower.nsp.bo.sheet;

import org.apache.log4j.Logger;

import tower.nsp.db.DbResourcePrepareList;
import tower.nsp.db.DbResourceType;
import tower.nsp.db.DbSysOrg;
import tower.nsp.en.EnResourcePrepareList;
import tower.nsp.en.EnResourceType;
import tower.nsp.en.EnSysOrg;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 功能概述：根据调度工单明细ID获取工单明细信息
 * 
 * @author fanlj 2008-10-16 下午03:12:52
 */
public class BoSheetPrepareDetail implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		// 调度工单明细db en
		DbResourcePrepareList dbResourcePrepareList;
		EnResourcePrepareList enResourcePrepareList;

		// 资源型号db en
		DbResourceType dbResourceType;
		EnResourceType enResourceType;

		// 机构db en
		DbSysOrg dbSysOrg;
		EnSysOrg enSysOrg;

		// 获取参数：工单明细ID
		String listId;

		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		listId = requestXml.getInputValue("LIST_ID");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, true);
		dbResourcePrepareList = new DbResourcePrepareList(transaction, null);
		dbResourceType = new DbResourceType(transaction, null);
		dbSysOrg = new DbSysOrg(transaction, null);
		enResourcePrepareList = new EnResourcePrepareList();
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		// 检查“调度工单明细ID(LIST_ID)”是否为空，如果为空则抛出异常OS0205。
		if (listId == null || listId.length() == 0) {
			throw new ErrorException("OS0205", null);
		}

		// 根据“调度工单明细ID(LIST_ID)”从“调度工单明细表(RESOURCE_PREPARE_LIST)”获取该记录。
		enResourcePrepareList = dbResourcePrepareList.findByKey(listId);
		int row = dbResourcePrepareList.setToXml(requestXml,
				enResourcePrepareList);
		if (enResourcePrepareList != null) {
			// 如果调出基站不为空，则调出单位name即是调出基站ID和name；否则为调出机构的name
			if (enResourcePrepareList.getOutStationId() != null
					&& enResourcePrepareList.getOutStationId().length() != 0) {
				enSysOrg = dbSysOrg.findByKey(enResourcePrepareList
						.getOutStationId());
				//requestXml.setItemValue("RESOURCE_PREPARE_LIST", row,
				//		"OUT_ORG_ID", enResourcePrepareList.getOutStationId());
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row,
						"OUT_ORG_NAME", enSysOrg.getOrgName());
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row,
						"OUT_STATION_FLAG", "Y");
			} else {
				enSysOrg = dbSysOrg.findByKey(enResourcePrepareList
						.getOutOrgId());
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row,
						"OUT_ORG_NAME", enSysOrg.getOrgName());
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row,
						"OUT_STATION_FLAG", "N");
			}
			// 如果调入基站不为空，则调入单位ID和name即时调入基站name；否则为调入机构的name
			if (enResourcePrepareList.getInStationId() != null
					&& enResourcePrepareList.getInStationId().length() != 0) {
				enSysOrg = dbSysOrg.findByKey(enResourcePrepareList
						.getInStationId());
				//requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "IN_ORG_ID",
				//		enResourcePrepareList.getInStationId());
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row,
						"IN_ORG_NAME", enSysOrg.getOrgName());
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row,
						"IN_STATION_FLAG", "Y");
			} else {
				enSysOrg = dbSysOrg.findByKey(enResourcePrepareList
						.getInOrgId());
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row,
						"IN_ORG_NAME", enSysOrg.getOrgName());
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row,
						"IN_STATION_FLAG", "N");
			}

			enResourceType = dbResourceType.findByKey(enResourcePrepareList
					.getResourceTypeId());
			requestXml.setItemValue("RESOURCE_PREPARE_LIST", row,
					"RESOURCE_TYPE_NAME",enResourceType.getTypeName());
		}
	}

}
