package tower.nsp.bo.sheet;


import org.apache.log4j.Logger;

import tower.nsp.db.DbResourcePrepareList;
import tower.tmvc.ErrorException;
import tower.tmvc.QueryResult;
import tower.tmvc.QueryResultRow;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
/**
 * 功能概述：根据查询条件获取满足条件的工单信息。默认查询状态为“下发”和“已接收”、调入单位是本单位的数据。
 * @author fanlj 2008-10-16  下午03:41:57
 */
public class BoRecvSheetList implements RootBo {

	@SuppressWarnings("static-access")
	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
        /***********************************************************************
		 * 声明变量
		 **********************************************************************/
		// 调度工单明细db en
		DbResourcePrepareList dbResourcePrepareList;
		//EnResourcePrepareList enResourcePrepareList;
		
		//获取参数：调出单位(OUT_ORG_ID)、调出基站(OUT_STATION_ID)
		//调出设备类型(RESOURCE_CLASS_ID)、调出设备型号(RESOURCE_TYPE_ID)
		//工单明细状态(LIST_STATUS)、从session中获取当前用户所属机构ID。
		String remindListId;	//提醒桌面点某一条记录时
		String outOrgId;
		String resourceId;
		String resourceFlag;
		String listStatus;
		String userOrgId;
		
		//其他
		StringBuffer sqlWhere;
		QueryResult rs;
		QueryResultRow rsRow;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		remindListId = requestXml.getInputValue("REMIND_LIST_ID");
		outOrgId = requestXml.getInputValue("OUT_ORG_ID");
		resourceId = requestXml.getInputValue("RESOURCE_ID");
		resourceFlag = requestXml.getInputValue("RESOURCE_FLAG");
		listStatus = requestXml.getInputValue("LIST_STATUS");
		userOrgId = sessionXml.getItemValue("SYS_USER", 1, "USER_ORG_ID");
		
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		 dbResourcePrepareList = new DbResourcePrepareList(transaction,null);
		 dbResourcePrepareList.setOrderBy(" ORDER BY r.LIST_STATUS");
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 //检查用户所属机构ID是否为空，如果为空则抛出异常：RS0100；
		 if(userOrgId == null || userOrgId.length()  ==0){
			 throw new ErrorException("RS0100",null);
		 }
		 
		 //组装查询语句： 
		 sqlWhere = new StringBuffer();
		 sqlWhere.append(" select  r.*,s.* ,c.class_name,t.type_name ,outSta.org_name OUT_STATION_NAME, outOrg.org_name OUT_ORG_NAME,inSta.org_name IN_STATION_NAME, inOrg.org_name IN_ORG_NAME ");
		 sqlWhere.append(" from nsp.resource_prepare_list r ");
		 sqlWhere.append("  left join nsp.sys_org outOrg on  r.out_org_id = outOrg.org_id");
		 sqlWhere.append("  left join nsp.sys_org outSta on  r.out_station_id = outSta.org_id");
		 sqlWhere.append("  left join nsp.sys_org inOrg on  r.in_org_id = inOrg.org_id");
		 sqlWhere.append("  left join nsp.sys_org inSta on  r.in_station_id = inSta.org_id");
		 sqlWhere.append("  left join nsp.resource_class c on  r.resource_class_id = c.class_id");
		 sqlWhere.append("  left join nsp.resource_type t on r.resource_type_id = t.type_id");
		 sqlWhere.append("  left join nsp.resource_prepare_sheet s on r.sheet_id = s.sheet_id");
		 sqlWhere.append(" WHERE r.IN_ORG_ID = ");
		 sqlWhere.append(transaction.formatString(userOrgId));
//		 sqlWhere.append(" OR r.IN_STATION_ID = ");
//		 sqlWhere.append(transaction.formatString(userOrgId));
//		 sqlWhere.append(" ) ");
		 
		 if(remindListId != null && remindListId.length() !=0){
			 sqlWhere.append(" AND r.LIST_ID=");
			 sqlWhere.append(transaction.formatString(remindListId));
		 }
		 if(listStatus != null && listStatus.length() !=0){
			 sqlWhere.append(" AND r.LIST_STATUS=");
			 sqlWhere.append(transaction.formatString(listStatus));
		 }else{
			 sqlWhere.append(" AND  r.LIST_STATUS IN (1,2)");
		 }
		 if(outOrgId != null && outOrgId.length() !=0){
			 sqlWhere.append(" AND r.OUT_ORG_ID=");
			 sqlWhere.append(transaction.formatString(outOrgId));
		 }
		 if(resourceFlag != null && resourceFlag.length() !=0){
			 if(resourceFlag.equals("C")){
				 sqlWhere.append(" AND r.RESOURCE_CLASS_ID=");
				 sqlWhere.append(transaction.formatString(resourceId));
			 }else if(resourceFlag.equals("T")){
				 sqlWhere.append(" AND r.RESOURCE_TYPE_ID=");
				 sqlWhere.append(transaction.formatString(resourceId));
			 }
		 }
		
		 sqlWhere.append(" ORDER BY LIST_STATUS ASC");
		 System.out.println(sqlWhere.toString());
		 //根据输入的查询条件从“调度工单明细(RESOURCE_PREPARE_LIST)”表中获取满足条件的数据并按照调度工单明细状态升序排序：
		 rs = transaction.doQuery(null, sqlWhere.toString());
		 
		 //如果为查询到满足条件的数据则抛出异常：RS0102；
			 for(int i=0;i<rs.size();i++){
				rsRow = rs.get(i);
				int row = requestXml.addRow("SHEET_PREPARE_LIST");
				requestXml.setItemValue("SHEET_PREPARE_LIST", row, "SHEET_ID", rsRow.getString("SHEET_ID"));
				requestXml.setItemValue("SHEET_PREPARE_LIST", row, "PREPARE_DATE", rsRow.getString("PREPARE_DATE"));
				requestXml.setItemValue("SHEET_PREPARE_LIST", row, "LIST_ID", rsRow.getString("LIST_ID"));
				requestXml.setItemValue("SHEET_PREPARE_LIST", row, "LIST_STATUS", rsRow.getString("LIST_STATUS"));
				requestXml.setItemValue("SHEET_PREPARE_LIST", row, "OUT_ORG_NAME", rsRow.getString("OUT_ORG_NAME"));
				requestXml.setItemValue("SHEET_PREPARE_LIST", row, "OUT_STATION_NAME", rsRow.getString("OUT_STATION_NAME"));
				requestXml.setItemValue("SHEET_PREPARE_LIST", row, "IN_ORG_NAME", rsRow.getString("IN_ORG_NAME"));
				requestXml.setItemValue("SHEET_PREPARE_LIST", row, "IN_STATION_NAME", rsRow.getString("IN_STATION_NAME"));
				requestXml.setItemValue("SHEET_PREPARE_LIST", row, "RESOURCE_CLASS_NAME", rsRow.getString("class_name"));
				requestXml.setItemValue("SHEET_PREPARE_LIST", row, "RESOURCE_TYPE_NAME", rsRow.getString("type_name"));
				requestXml.setItemValue("SHEET_PREPARE_LIST", row, "AMOUNT_PREPARE", rsRow.getString("AMOUNT_PREPARE"));
					
		 }
	}

}
