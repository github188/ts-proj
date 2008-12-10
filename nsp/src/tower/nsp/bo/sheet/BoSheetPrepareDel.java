package tower.nsp.bo.sheet;

import org.apache.log4j.Logger;

import tower.nsp.db.DbResourcePrepareList;
import tower.nsp.en.EnResourcePrepareList;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 功能概述：
 * 
 * @author fanlj 2008-10-16 上午10:50:33
 */
public class BoSheetPrepareDel implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml,
			XMLWrap applicationXml, Logger logger) throws ErrorException {

		/*****************************************************************************************************
		 * 声明变量
		 ****************************************************************************************************/
		// 调度工单明细db en
		DbResourcePrepareList dbResourcePrepareList;
		EnResourcePrepareList enResourcePrepareList;

		// 获取参数：工单明细ID
		String listId;
		// String listSat;

		// 其他
		StringBuffer sql = new StringBuffer();
		/*****************************************************************************************************
		 * 获取输入
		 ****************************************************************************************************/
		listId = requestXml.getInputValue("LIST_ID");
		// listSat = requestXml.getInputValue("LIST_STATUS");
		/*****************************************************************************************************
		 * 创建数据库连接、实例化DB、EN
		 ****************************************************************************************************/
		transaction.createDefaultConnection(null, true);
		dbResourcePrepareList = new DbResourcePrepareList(transaction, null);
		/*****************************************************************************************************
		 * 执行业务逻辑、输出
		 ****************************************************************************************************/
		// 检查从页面获取的参数是否为空，如果为空则抛出异常OS0205；
		if (listId == null || listId.length() == 0) {
			throw new ErrorException("OS0205", null);
		} else {
			// 根据“调度工单明细ID(LIST_ID)”从“调度工单明细表(RESOURCE_PREPARE_LIST)”获取该记录。
			enResourcePrepareList = dbResourcePrepareList.findByKey(listId);

			// 根据“调度工单明细ID(LIST_ID)”从“调度工单明细表(RESOURCE_PREPARE_LIST)”
			// 检查该记录并根据“调度工单明细状态(LIST_STATUS)”判断如果是“未下发”、“下发”、“已接收”状态则可以删除；
			// 如果是状态是"已下发"或者“已接收”，则同时更新该机构的库存；如果是"未下发"则不用更新。
			// 如果不是则抛出异常OS0200。
			if (enResourcePrepareList != null) {
				if (!enResourcePrepareList.getListStatus().equals("1")
						&& !enResourcePrepareList.getListStatus().equals("0")
						&& !enResourcePrepareList.getListStatus().equals("2")) {
					throw new ErrorException("OS0200", null);
				} else {
					// 如果工单的状态为"已下发"则同时更新库存：从该库存减去更新前的数量；
					if (enResourcePrepareList.getListStatus().equals("1")
							|| enResourcePrepareList.getListStatus().equals("2")) {
						sql.append(" UPDATE RESOURCE_ORG_AMOUNT  SET ");
						sql.append(" PRE_OUT_AMOUNT= PRE_OUT_AMOUNT-");
						sql.append(enResourcePrepareList.getAmountPrepare());
						sql.append(" WHERE ORG_ID=");
						if (enResourcePrepareList.getOutStationId() != null
								&& enResourcePrepareList.getOutStationId().length() > 0) {
							sql.append(Transaction.formatString(enResourcePrepareList.getOutStationId()));
						} else {
							sql.append(Transaction.formatString(enResourcePrepareList.getOutOrgId()));
						}
						sql.append(" AND RESOURCE_TYPE_ID =");
						sql.append(Transaction.formatString(enResourcePrepareList.getResourceTypeId()));
						transaction.doUpdate(null, sql.toString());
					}
					// 删除记录
					dbResourcePrepareList.deleteByKey(listId);
				}
			}

		}
	}

}
