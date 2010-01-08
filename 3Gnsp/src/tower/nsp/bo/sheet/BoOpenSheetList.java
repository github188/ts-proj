package tower.nsp.bo.sheet;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.common.util.DateFunc;
import tower.common.util.Page;
import tower.common.util.PubFunc;
import tower.nsp.db.DbResourcePrepareList;
import tower.nsp.db.DbResourcePrepareSheet;
import tower.nsp.db.DbSysUser;
import tower.nsp.en.EnResourcePrepareSheet;
import tower.nsp.en.EnSysUser;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
/**
 * 功能概述：根据查询条件获取满足条件的工单信息。
 * @author fanlj 2008-10-15  下午11:04:43
 */
public class BoOpenSheetList implements RootBo {

	@SuppressWarnings("static-access")
	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
        /***********************************************************************
		 * 声明变量
		 **********************************************************************/
		// 调度工单db en
		DbResourcePrepareSheet dbResourcePrepareSheet;
		EnResourcePrepareSheet enResourcePrepareSheet;
		
		// 调度工单明细db en
		DbResourcePrepareList dbResourcePrepareList;
		
		//人员db en
		DbSysUser dbSysUser;
		EnSysUser enSysUser;
		
		//获取参数：调度工单ID(SHEET_ID)、调度日期(PREPARE_DATE)  
		String sheetId;
		String prepareDateBgn;
		String prepareDateEnd;
		String flag;
		
		// 其他
		Vector vEnResourcePrepareSheet = new Vector();
		StringBuffer sqlWhere;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		sheetId = requestXml.getInputValue("QSHEET_ID");
		prepareDateBgn = requestXml.getInputValue("PREPARE_DATE_BNG");
		prepareDateEnd = requestXml.getInputValue("PREPARE_DATE_END");
		flag = requestXml.getInputValue("FLAG");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		 dbResourcePrepareSheet = new DbResourcePrepareSheet(transaction,null);
		 dbResourcePrepareList = new DbResourcePrepareList(transaction,null);
		 dbSysUser = new DbSysUser(transaction,null);
		 dbResourcePrepareSheet.setOrderBy(" ORDER BY SHEET_ID DESC");
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 //组装查询语句
		 sqlWhere = new StringBuffer();
		 if(sheetId != null && sheetId.length() !=0){
			 if(sqlWhere.toString().length()>0){
				 sqlWhere.append(" AND ");
			 }
			 sqlWhere.append("  SHEET_ID LIKE '%");
			 sqlWhere.append(sheetId);
			 sqlWhere.append("%'");
		 }
		 if(prepareDateBgn != null && prepareDateBgn.length() !=0){
			 if(sqlWhere.toString().length()>0){
				 sqlWhere.append(" AND ");
			 }
			 sqlWhere.append("  PREPARE_DATE>=");
			 sqlWhere.append(transaction.formatString(DateFunc.ParseDateTime(prepareDateBgn)));
		 }
		 if(prepareDateEnd != null && prepareDateEnd.length() !=0){
			 if(sqlWhere.toString().length()>0){
				 sqlWhere.append(" AND ");
			 }
			 sqlWhere.append("  PREPARE_DATE<=");
			 sqlWhere.append(transaction.formatString(DateFunc.ParseDateTime(prepareDateEnd)));
		 }
		 
		 //根据查询条件从“资源调度工单(RESOURCE_PREPARE_SHEET)”表中获取满足条件的数据，并按照调度日期降序排序：
		 if(sqlWhere.toString().length()>0){
			 Page.SetPageInfo(transaction, null, requestXml,dbResourcePrepareSheet,
						PubFunc.LEN_PAGE_COUNT,"RESOURCE_PREPARE_SHEET", sqlWhere.toString());
			 vEnResourcePrepareSheet = dbResourcePrepareSheet.findAllWhere(sqlWhere.toString());
		 }else{
			 if(flag == null || flag.length() <=0){
				 Page.SetPageInfo(transaction, null, requestXml,dbResourcePrepareSheet,
							PubFunc.LEN_PAGE_COUNT,"RESOURCE_PREPARE_SHEET", null);
				 vEnResourcePrepareSheet = dbResourcePrepareSheet.findAll();
			 }
			
		 }
		 
//		 //如果未查出满足条件的数据则抛出异常：OS0103
//		 if(vEnResourcePrepareSheet.size() <= 0){
//			 throw new ErrorException("OS0103",null);
//		 }else{
			 
			 //否则把查询到的数据返回到页面。注：从查询出的所有数据中根据“调度工单号(SHEET_ID)”从“调度工单明细表(RESOURCE_PREPARE_LIST)”
			 //中检查该工单下的明细列表中是否有工单明细状态不是"未下发"，“下发”，“已接收”的即：LIST_STATUS NOT IN(0,1,2)，如果存在则设置该工单不
			 //可进行删除即在页面不显示删除按钮；否则可进行删除:0不可以删除；1可以删除。  
			 for(int i=0;i<vEnResourcePrepareSheet.size();i++){
				 enResourcePrepareSheet = (EnResourcePrepareSheet)vEnResourcePrepareSheet.get(i);
				 int row = dbResourcePrepareSheet.setToXml(requestXml, enResourcePrepareSheet);
				 enSysUser = dbSysUser.findByKey(enResourcePrepareSheet.getPrepareUserId());
				 if(enSysUser != null){
					 requestXml.setItemValue("RESOURCE_PREPARE_SHEET", row, "PREPARE_USER_NAME", enSysUser.getUserName());
				 }
				 
				 sqlWhere  = new StringBuffer();
				 sqlWhere.append(" SHEET_ID=");
				 sqlWhere.append(transaction.formatString(enResourcePrepareSheet.getSheetId()));
				 sqlWhere.append(" AND LIST_STATUS NOT IN(0,1,2)");
				 int count = dbResourcePrepareList.countWhere(sqlWhere.toString());
				 if(count > 0){
					 requestXml.setItemValue("RESOURCE_PREPARE_SHEET", row, "IS_DEL", "0");
				 }else{
					 requestXml.setItemValue("RESOURCE_PREPARE_SHEET", row, "IS_DEL", "1");
				 }
		 }
	}

}
