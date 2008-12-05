package tower.nsp.bo.sheet;



import org.apache.log4j.Logger;

import tower.nsp.db.DbResourceOrgAmount;
import tower.nsp.db.DbResourcePrepareList;
import tower.nsp.db.DbResourcePrepareSheet;
import tower.nsp.en.EnResourceOrgAmount;
import tower.nsp.en.EnResourcePrepareSheet;
import tower.tmvc.ErrorException;
import tower.tmvc.QueryResult;
import tower.tmvc.QueryResultRow;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 功能概述：根据调度工单ID从调度工单明细表中获取该工单下的工单明细。
 * 
 * @author fanlj 2008-10-15 下午10:02:03
 */
public class BoSheetPrepareList implements RootBo {

	@SuppressWarnings("static-access")
	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//调度工单明细db en
		DbResourcePrepareList dbResourcePrepareList;
		
		// 调度工单db en
		DbResourcePrepareSheet dbResourcePrepareSheet;
		EnResourcePrepareSheet enResourcePrepareSheet;
		
		//资源库存db en
		DbResourceOrgAmount dbResourceOrgAmount;
		EnResourceOrgAmount enResourceOrgAmount;
		
		//输入参数：调度工单ID
		String sheetId;
		
		// 其他
		StringBuffer sql;
		QueryResult rs;
		QueryResultRow rsRow;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		sheetId = requestXml.getInputValue("SHEET_ID");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		 dbResourcePrepareList = new DbResourcePrepareList(transaction, null);
		 dbResourcePrepareSheet = new DbResourcePrepareSheet(transaction,null);
		 dbResourceOrgAmount = new DbResourceOrgAmount(transaction,null);
		 enResourcePrepareSheet = new EnResourcePrepareSheet();
		 dbResourcePrepareList.setOrderBy(" ORDER BY LIST_STATUS ASC");
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 //获取工单信息
		 enResourcePrepareSheet = dbResourcePrepareSheet.findByKey(sheetId);
		 dbResourcePrepareSheet.setToXml(requestXml, enResourcePrepareSheet);
		 //检查参数工单ID是否为空，如果为空抛出异常：OS0101。
			if (sheetId == null || sheetId.length() == 0) {
				throw new ErrorException("OS0101", null);
			}
			
		 //根据“调度工单ID(SHEET_ID) ”从“调度工单明细表(RESOURCE_PREPARE_LIST)”中获取该
		 //工单下的所有工单明细并按照工单明细状态升序排序：	
			sql = new StringBuffer();
			sql.append(" select  r.*,c.class_name,t.type_name ,inSta.org_name IN_STATION_NAME ,outSta.org_name OUT_STATION_NAME ,inOrg.org_name IN_ORG_NAME, outOrg.org_name OUT_ORG_NAME ");
			sql.append(" from nsp.resource_prepare_list r ");
			sql.append("  left  join nsp.sys_org outOrg on  r.out_org_id = outOrg.org_id");
			sql.append("  left join nsp.sys_org inOrg on inOrg.org_id = r.in_org_id ");
			sql.append("  left join nsp.sys_org outSta on  r.out_station_id = outSta.org_id ");
			sql.append("  left join nsp.sys_org inSta on r.in_station_id = inSta.org_id  ");
			sql.append("  left join nsp.resource_class c on r.resource_class_id= c.class_id ");
			sql.append("  left join nsp.resource_type t on r.resource_type_id= t.type_id ");
			sql.append("  where r.sheet_id=");
			sql.append(transaction.formatString(sheetId));
			sql.append("  order by r.LIST_STATUS ");
			rs = transaction.doQuery(null, sql.toString());
		 //把查询到的数据返回到页面
			for(int i=0;i<rs.size();i++){
				rsRow = rs.get(i);
				int row = requestXml.addRow("SHEET_PREPARE_LIST");
				requestXml.setItemValue("SHEET_PREPARE_LIST", row, "LIST_ID", rsRow.getString("LIST_ID"));
				requestXml.setItemValue("SHEET_PREPARE_LIST", row, "LIST_STATUS", rsRow.getString("LIST_STATUS"));
				requestXml.setItemValue("SHEET_PREPARE_LIST", row, "OUT_ORG_NAME", rsRow.getString("OUT_ORG_NAME"));
				requestXml.setItemValue("SHEET_PREPARE_LIST", row, "OUT_STATION_NAME", rsRow.getString("OUT_STATION_NAME"));
				requestXml.setItemValue("SHEET_PREPARE_LIST", row, "RESOURCE_CLASS_NAME", rsRow.getString("class_name"));
				requestXml.setItemValue("SHEET_PREPARE_LIST", row, "RESOURCE_TYPE_NAME", rsRow.getString("type_name"));
				requestXml.setItemValue("SHEET_PREPARE_LIST", row, "AMOUNT_PREPARE", rsRow.getString("AMOUNT_PREPARE"));
				requestXml.setItemValue("SHEET_PREPARE_LIST", row, "IN_ORG_NAME", rsRow.getString("IN_ORG_NAME"));
				requestXml.setItemValue("SHEET_PREPARE_LIST", row, "IN_STATION_NAME", rsRow.getString("IN_STATION_NAME"));
				if(rsRow.getString("OUT_STATION_ID") != null && rsRow.getString("OUT_STATION_ID").length() >0 ){
					enResourceOrgAmount = dbResourceOrgAmount.findByKey(rsRow.getString("OUT_STATION_ID"), rsRow.getString("RESOURCE_TYPE_ID"));
				}else{
					enResourceOrgAmount = dbResourceOrgAmount.findByKey(rsRow.getString("OUT_ORG_ID"), rsRow.getString("RESOURCE_TYPE_ID"));
				}
				if(enResourceOrgAmount != null){
					requestXml.setItemValue("SHEET_PREPARE_LIST", row, "STOCK_AMOUNT",enResourceOrgAmount.getStockAmount());
					requestXml.setItemValue("SHEET_PREPARE_LIST", row, "PRE_OUT_AMOUNT", enResourceOrgAmount.getPreOutAmount());
					requestXml.setItemValue("SHEET_PREPARE_LIST", row, "PRE_IN_AMOUNT", enResourceOrgAmount.getPreInAmount());
				}
			}
	}

}
