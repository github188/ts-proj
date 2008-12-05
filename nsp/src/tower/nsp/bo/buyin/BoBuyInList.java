 package tower.nsp.bo.buyin;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.common.util.DateFunc;
import tower.common.util.Page;
import tower.common.util.PubFunc;
import tower.nsp.db.DbResourceBuyinList;
import tower.tmvc.ErrorException;
import tower.tmvc.QueryResult;
import tower.tmvc.QueryResultRow;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 *  功能概述：从资源外购入库登记表中获取满足条件的外购入库登记信息。
 * @author 吴国景 2008-10-17 下午02:20:44
 */

public class BoBuyInList implements RootBo{

	
	@SuppressWarnings("static-access")
	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//采购入库db en
		DbResourceBuyinList dbResourceBuyinList;
		
		//输入参数：资源型号、入库登记日期(开始日期-结束日期)、备注及说明
		String orgId;
		String inOutFlag;
		String resourceTypeId;
		String inOperDateTimeBng;
		String inOperDateTimeEnd;
		String inRemark;
		
		//其他
		Vector vEnResourceBuyinList;
		StringBuffer sql;
		StringBuffer sqlWhere;
		QueryResult rs;
		QueryResultRow rsRow;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		orgId = requestXml.getInputValue("IN_ORGID");
		inOutFlag = requestXml.getInputValue("IN_OUT_FLAG");
		resourceTypeId = requestXml.getInputValue("TYPE_ID");
		inOperDateTimeBng = requestXml.getInputValue("IN_OPER_DATETIME_BNG");
		inOperDateTimeEnd = requestXml.getInputValue("IN_OPER_DATETIME_END");
		inRemark = requestXml.getInputValue("IN_REMARK");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		 dbResourceBuyinList = new DbResourceBuyinList(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 sql = new StringBuffer();
		 sql.append(" select  l.* ,s.org_name,t.type_name,u.user_name "); 
		 sql.append(" from nsp.resource_buyin_list l ");
		sql.append(" join nsp.sys_org s on s.org_id = l.org_id ");
		 sql.append(" left join nsp.resource_type t on t.type_id=l.resource_type_id ");
		 sql.append(" left join nsp.sys_user u on u.user_id=l.in_oper_userId ");
		 
		 //组装查询条件
		 sqlWhere = new StringBuffer();
		 if(orgId != null && orgId.length() !=0){
			 if(sqlWhere.toString().length()>0){
				 sqlWhere.append(" AND ");
			 }
			 sqlWhere.append("  l.ORG_ID=");
			 sqlWhere.append(transaction.formatString(orgId));
		 }
		 if(inOutFlag != null && inOutFlag.length() !=0){
			 if(sqlWhere.toString().length()>0){
				 sqlWhere.append(" AND ");
			 }
			 sqlWhere.append("  l.IN_OUT_FLAG=");
			 sqlWhere.append(transaction.formatString(inOutFlag));
		 }
		 if(resourceTypeId != null && resourceTypeId.length() !=0){
			 if(sqlWhere.toString().length()>0){
				 sqlWhere.append(" AND ");
			 }
			 sqlWhere.append("  l.RESOURCE_TYPE_ID=");
			 sqlWhere.append(transaction.formatString(resourceTypeId));
		 }
		 if(inOperDateTimeBng != null && inOperDateTimeBng.length() !=0){
			 if(sqlWhere.toString().length()>0){
				 sqlWhere.append(" AND ");
			 }
			 sqlWhere.append("  l.IN_OPER_DATETIME >=");
			 sqlWhere.append(transaction.formatString(DateFunc.ParseDateTime(inOperDateTimeBng)+"000000"));
		 }
		 if(inOperDateTimeEnd != null && inOperDateTimeEnd.length() !=0){
			 if(sqlWhere.toString().length()>0){
				 sqlWhere.append(" AND ");
			 }
			 sqlWhere.append("  l.IN_OPER_DATETIME<=");
			 sqlWhere.append(transaction.formatString(DateFunc.ParseDateTime(inOperDateTimeEnd)+"999999"));
		 }
		 if(inRemark != null && inRemark.length() !=0){
			 if(sqlWhere.toString().length()>0){
				 sqlWhere.append(" AND ");
			 }
			 sqlWhere.append("  l.IN_REMARK LIKE '%");
			 sqlWhere.append(inRemark);
			 sqlWhere.append("%'");
		 }
		 if(sqlWhere.toString().length() >0){
			 sqlWhere.insert(0, " where ");
			 sql.append(sqlWhere);
		 }
		 sql.append(" ORDER BY l.IN_OPER_DATETIME DESC,t.RESOURCE_CLASS_ID ASC , t.TYPE_ID ASC");
		 //查询操作并把查询到的数据返回到页面
		 int page = Page.SetPageInfo(transaction, null, requestXml,
					PubFunc.LEN_PAGE_COUNT, sql.toString());
		 rs = transaction.doQuery(null, sql.toString(),page,PubFunc.LEN_PAGE_COUNT);
		 for(int i=0;i<rs.size();i++){
			 rsRow = rs.get(i);
			 int row = requestXml.addRow("RESOURCE_BUYIN_LIST");
			 requestXml.setItemValue("RESOURCE_BUYIN_LIST", row, "LIST_ID", rsRow.getString("LIST_ID"));
			 requestXml.setItemValue("RESOURCE_BUYIN_LIST", row, "IN_OUT_FLAG", rsRow.getString("IN_OUT_FLAG"));
			 requestXml.setItemValue("RESOURCE_BUYIN_LIST", row, "TYPE_NAME", rsRow.getString("type_name"));
			 requestXml.setItemValue("RESOURCE_BUYIN_LIST", row, "ORG_NAME", rsRow.getString("org_name"));
			 requestXml.setItemValue("RESOURCE_BUYIN_LIST", row, "IN_AMOUNT", rsRow.getString("IN_AMOUNT"));
			 requestXml.setItemValue("RESOURCE_BUYIN_LIST", row, "USER_NAME", rsRow.getString("user_name"));
			 requestXml.setItemValue("RESOURCE_BUYIN_LIST", row, "IN_OPER_DATETIME", rsRow.getString("IN_OPER_DATETIME"));
		 }
	}

}