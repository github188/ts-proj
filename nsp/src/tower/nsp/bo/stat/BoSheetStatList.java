package tower.nsp.bo.stat;


import org.apache.log4j.Logger;

import tower.common.util.DateFunc;
import tower.common.util.Page;
import tower.common.util.PubFunc;
import tower.nsp.db.DbResourcePrepareList;
import tower.nsp.db.DbResourcePrepareSheet;
import tower.nsp.db.DbSysOrg;
import tower.nsp.en.EnSysOrg;
import tower.tmvc.ErrorException;
import tower.tmvc.QueryResult;
import tower.tmvc.QueryResultRow;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
/**
 * 功能概述：根据页面输入的查询条件，查询返回符合条件的工单列表信息。
 * @author 吴国景 2008-10-17 下午03:22:09
 */
public class BoSheetStatList implements RootBo {
	/**
	 * 1、检查是否输入了必要的查询条件，其中调度日期和调度工单ID其中一个为必输项；若未输入必要的查询条件，则抛出异常SS0101；
	 * 2、自sessionXml中取得当前用户的所属机构ORG_ID；并根据当前用户所属机构的ORG_ID，查询得到机构信息；
	 * 3、构造查询条件中的机构条件部分：
		如果当前机构的上级机构ID为空或''时（当前机构为“青岛移动”），则：
   			不构造机构查询条件
		如果当前机构的上级机构ID不为空或''时（当前机构为“分公司”），则：
   			调入机构='当前用户的所属机构'
	 * 4、构造查询条件：
		如输入了调度日期，则（调度日期>=开始日期 AND 调度日期<=截止日期）
		如输入了工单ID，则（工单ID LIKE '%工单ID%'）
		如输入了工单状态，则（工单明细状态='处理状态'）
		如输入了设备类别，则（设备类别='设备类别'）
		如输入了设备型号，则（设备型号='设备型号'）
		如输入了领用人姓名，则（领用人姓名 LIKE '%领用人姓名%'）
		如输入了施工人姓名，则（施工人姓名 LIKE '%施工人姓名%'）
	 * 5、使用构造的查询条件，自工单表和工单明细表中查询符合条件的工单明细列表，并按工单ID、工单明细ID升序排列；
		SELECT * FROM RESOURCE_PREPARE_SHEET, RESOURCE_PREPARE_LIST 
    	WHERE RESOURCE_PREPARE_SHEET.SHEET_ID = RESOURCE_PREPARE_LIST.SHEET_ID
    	AND 查询条件
    	ORDER BY 工单ID ASC, 工单明细ID ASC；
	 *6、如未查询到符合条件的工单明细列表，则抛出异常SS0102；
	 *7、如查询到符合条件的工单明细列表，保存信息到requestXml中；
	 *8、处理完毕；
	 */
	@SuppressWarnings("static-access")
	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//声明调度工单db、en
		@SuppressWarnings("unused")
		DbResourcePrepareList dbResourcePrepareList;
		DbSysOrg dbSysOrg;
		
		@SuppressWarnings("unused")
		DbResourcePrepareSheet dbResourceSheet;
		EnSysOrg enSysOrg;
		
		//声明参数
		String prepareDate_start;
		String prepareDate_end;
		String sheetId;
		String listStatus;
		String classId;
		String classFlag;
		String takeUserName;
		String consUserName;
		
		String orgId;
		

		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		prepareDate_start = requestXml.getInputValue("QPREPAREDATE_START");
		prepareDate_end = requestXml.getInputValue("QPREPAREDATE_END");
		sheetId = requestXml.getInputValue("QSHEET_ID");
		listStatus = requestXml.getInputValue("QLIST_STATUS");
		classId= requestXml.getInputValue("QRESOURCE_CLASS_ID");
		classFlag = requestXml.getInputValue("QRESOURCE_CLASS_FLAG");
		takeUserName = requestXml.getInputValue("QTAKE_USER_NAME");
		consUserName = requestXml.getInputValue("QCONS_USER_NAME");
		
//		orgId = sessionXml.getInputValue("ORG_ID");
		orgId = sessionXml.getItemValue("SYS_USER", 1, "USER_ORG_ID");
		
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbResourcePrepareList = new DbResourcePrepareList(transaction,null);
		dbResourceSheet = new DbResourcePrepareSheet(transaction,null);
		dbSysOrg = new DbSysOrg(transaction,null);
		
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		QueryResult rs = null;
		QueryResult rs1 = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select a.SHEET_ID,b.PREPARE_DATE,a.LIST_STATUS,c.ORG_NAME '调出单位',d.ORG_NAME '调出基站',e.CLASS_NAME,f.TYPE_NAME,a.AMOUNT_PREPARE,g.ORG_NAME '调入单位',h.ORG_NAME '调入基站',a.TAKE_USER_NAME,a.TAKE_DATE,a.CONS_USER_NAME,a.CONS_FIN_DATE,a.CONS_ACK_DATETIME,a.LIST_ID,e.CLASS_ID,f.TYPE_ID,g.ORG_ID"
				+ " from  RESOURCE_PREPARE_LIST a inner join RESOURCE_PREPARE_SHEET  b on a.SHEET_ID =b.SHEET_ID"
				+ " left join SYS_ORG c  on  a.OUT_ORG_ID = c.ORG_ID"
				+ " left join SYS_ORG d  on  a.OUT_STATION_ID = d.ORG_ID"
				+ " left join RESOURCE_CLASS e  on a.RESOURCE_CLASS_ID = e.CLASS_ID"
				+ " left join RESOURCE_TYPE f on a.RESOURCE_TYPE_ID = f.TYPE_ID"
				+ " left join SYS_ORG g on   a.IN_ORG_ID = g.ORG_ID"
				+ " left join SYS_ORG h on  a.IN_STATION_ID = h.ORG_ID"
				+ " where 1=1");
		if(prepareDate_start !=  null && prepareDate_start.length() != 0){
			sql.append(" and ");
			sql.append(" b.PREPARE_DATE >= ");
			sql.append(Transaction.formatString(DateFunc.ParseDateTime(prepareDate_start)));
		}
		if(prepareDate_end != null && prepareDate_end.length() != 0){
			sql.append(" and ");
			sql.append(" b.PREPARE_DATE <= ");
			sql.append(Transaction.formatString(DateFunc.ParseDateTime(prepareDate_end)));
		}
		if(sheetId != null && sheetId.length() != 0){
			sql.append(" and ");
			sql.append(" a.SHEET_ID LIKE '%");
			sql.append(sheetId);
			sql.append("%'");
		}
		if(listStatus != null && listStatus.length() != 0){
			sql.append(" and ");
			sql.append(" a.LIST_STATUS = ");
			sql.append(Transaction.formatString(listStatus));
		}
		if(listStatus.equals("") && listStatus.length() ==0){
			sql.append( " and ");
			sql.append(" a.LIST_STATUS <> '0' ");
		}
		if(classId != null && classId.length() > 0){
			//判断资源类型标志，如果标志为C则根据类别进行查询其余按照型号查询
			if(classFlag != null && classFlag.length() > 0){
				if(sql.toString().length() > 0){
					sql.append(" and ");
				}
				if(classFlag.equals("C")){
					sql.append("e.CLASS_ID = ");
				}else{
					sql.append("f.TYPE_ID = ");
				}
				sql.append(transaction.formatString(classId));
			}
		}
		
		
		if(takeUserName != null && takeUserName.length() != 0){
			sql.append(" and ");
			sql.append("a.TAKE_USER_NAME LIKE '%");
			sql.append(takeUserName);
			sql.append("%'");
		}
		if(consUserName != null && consUserName.length() != 0){
			sql.append(" and ");
			sql.append("a.CONS_USER_NAME LIKE '%");
			sql.append(consUserName);
			sql.append("%'");
			
		}
		
		enSysOrg = dbSysOrg.findByKey(orgId);
		if(enSysOrg.getParentId() != "" && enSysOrg.getParentId().length() != 0){
			sql.append(" and ");
			sql.append("g.ORG_ID= ");
			sql.append(transaction.formatString(orgId));
		}
//		if(orgId != null && orgId.length() != 0){
//			sql.append(" and ");
//			sql.append(" IN_ORG_ID LIKE	");
//			sql.append(Transaction.formatString(orgId));
//		}
		sql.append(" order by a.LIST_ID");
		
		int page = Page.SetPageInfo(transaction, null, requestXml,
				PubFunc.LEN_PAGE_COUNT, sql.toString());
		
		rs = transaction.doQuery(null, sql.toString(), page,
				PubFunc.LEN_PAGE_COUNT);
		for(int i=0; i<rs.size(); i++){
			QueryResultRow rsRow = rs.get(i);
			if(rsRow != null){
//				System.out.println("&&&&&&&&&&&&&");
//				System.out.println(rsRow.getString(0));
				int row = requestXml.addRow("DRESOURCE_PREPARE_LIST");
				requestXml.setItemValue("DRESOURCE_PREPARE_LIST", row, "SHEET_ID", rsRow.getString(1));
//				System.out.println("sheetId = "+rsRow.getString(1));
				requestXml.setItemValue("DRESOURCE_PREPARE_LIST", row, "PREPARE_DATE", rsRow.getString(2));
				requestXml.setItemValue("DRESOURCE_PREPARE_LIST", row, "LIST_STATUS", rsRow.getString(3));
				requestXml.setItemValue("DRESOURCE_PREPARE_LIST", row, "OUT_ORG_NAME", rsRow.getString(4));
//				System.out.println("OUT_ORG_NAME = "+rsRow.getString(4));
				requestXml.setItemValue("DRESOURCE_PREPARE_LIST", row, "OUT_STATION_NAME", rsRow.getString(5));
//				System.out.println("OUT_STATION_NAME ="+rsRow.getString(5));
				requestXml.setItemValue("DRESOURCE_PREPARE_LIST", row, "RESOURCE_CLASS_NAME", rsRow.getString(6));
				requestXml.setItemValue("DRESOURCE_PREPARE_LIST", row, "RESOURCE_TYPE_NAME", rsRow.getString(7));
				requestXml.setItemValue("DRESOURCE_PREPARE_LIST", row, "AMOUNT_PREPARE", rsRow.getLong(8));
				requestXml.setItemValue("DRESOURCE_PREPARE_LIST", row, "IN_ORG_NAME", rsRow.getString(9));
				requestXml.setItemValue("DRESOURCE_PREPARE_LIST", row, "IN_STATION_NAME", rsRow.getString(10));
				requestXml.setItemValue("DRESOURCE_PREPARE_LIST", row, "TAKE_USER_NAME", rsRow.getString(11));
				requestXml.setItemValue("DRESOURCE_PREPARE_LIST", row, "TAKE_DATE", rsRow.getString(12));
				requestXml.setItemValue("DRESOURCE_PREPARE_LIST", row, "CONS_USER_NAME", rsRow.getString(13));
				requestXml.setItemValue("DRESOURCE_PREPARE_LIST", row, "CONS_FIN_DATE", rsRow.getString(14));
				requestXml.setItemValue("DRESOURCE_PREPARE_LIST", row, "CONS_ACK_DATETIME", rsRow.getString(15));
				requestXml.setItemValue("DRESOURCE_PREPARE_LIST", row, "LIST_ID", rsRow.getString(16));
				
			}
		}
		
		rs1 = transaction.doQuery(null,  sql.toString());
		for(int i=0; i<rs1.size(); i++){
			QueryResultRow rsRow = rs1.get(i);
			if(rsRow != null){
				int row = requestXml.addRow("QRESOURCE_PREPARE_LIST");
				requestXml.setItemValue("QRESOURCE_PREPARE_LIST", row, "SHEET_ID", rsRow.getString(1));
				requestXml.setItemValue("QRESOURCE_PREPARE_LIST", row, "PREPARE_DATE", rsRow.getString(2));
				requestXml.setItemValue("QRESOURCE_PREPARE_LIST", row, "LIST_STATUS", rsRow.getString(3));
				requestXml.setItemValue("QRESOURCE_PREPARE_LIST", row, "OUT_ORG_NAME", rsRow.getString(4));
				requestXml.setItemValue("QRESOURCE_PREPARE_LIST", row, "OUT_STATION_NAME", rsRow.getString(5));
				requestXml.setItemValue("QRESOURCE_PREPARE_LIST", row, "RESOURCE_CLASS_NAME", rsRow.getString(6));
				requestXml.setItemValue("QRESOURCE_PREPARE_LIST", row, "RESOURCE_TYPE_NAME", rsRow.getString(7));
				requestXml.setItemValue("QRESOURCE_PREPARE_LIST", row, "AMOUNT_PREPARE", rsRow.getLong(8));
				requestXml.setItemValue("QRESOURCE_PREPARE_LIST", row, "IN_ORG_NAME", rsRow.getString(9));
				requestXml.setItemValue("QRESOURCE_PREPARE_LIST", row, "IN_STATION_NAME", rsRow.getString(10));
				requestXml.setItemValue("QRESOURCE_PREPARE_LIST", row, "TAKE_USER_NAME", rsRow.getString(11));
				requestXml.setItemValue("QRESOURCE_PREPARE_LIST", row, "TAKE_DATE", rsRow.getString(12));
				requestXml.setItemValue("QRESOURCE_PREPARE_LIST", row, "CONS_USER_NAME", rsRow.getString(13));
				requestXml.setItemValue("QRESOURCE_PREPARE_LIST", row, "CONS_FIN_DATE", rsRow.getString(14));
				requestXml.setItemValue("QRESOURCE_PREPARE_LIST", row, "CONS_ACK_DATETIME", rsRow.getString(15));
				requestXml.setItemValue("QRESOURCE_PREPARE_LIST", row, "LIST_ID", rsRow.getString(16));
				
			}
		}
		
		
	}

}
