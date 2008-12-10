package tower.nsp.bo.sheet;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.nsp.db.DbResourceOrgAmount;
import tower.nsp.db.DbResourcePrepareList;
import tower.nsp.en.EnResourceOrgAmount;
import tower.nsp.en.EnResourcePrepareList;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoSheetOpen implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
        /***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//调度工单明细db en
		DbResourcePrepareList dbResourcePrepareList;
		EnResourcePrepareList enResourcePrepareList;
		
		//机构库存db en
		DbResourceOrgAmount dbResourceOrgAmount;
		EnResourceOrgAmount enResourceOrgAmount;
		
		//获取参数：工单明细IDs
		String [] listIds;
		
		//其他
		Vector vEnResourcePrepareList;
		StringBuffer str = new StringBuffer();
		StringBuffer sqlWhere = new StringBuffer();
		StringBuffer sql ;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		listIds = requestXml.getInputValues("LIST_ID");
		
		 for(int i=0;i<listIds.length;i++){
			 if(str.toString().length() == 0){
				 str.append("'");
				 str.append(listIds[i]);
				 str.append("'");
			 }else{
				 str.append(",");
				 str.append("'");
				 str.append(listIds[i]);
				 str.append("'");
			 }
		 }
		 if(str.toString().length()!= 0){
			 str.insert(0, "(");
			 str.append(")");
		 }
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		 dbResourcePrepareList = new DbResourcePrepareList(transaction, null);
		 dbResourceOrgAmount = new DbResourceOrgAmount(transaction, null);
		 enResourcePrepareList = new EnResourcePrepareList();
		 enResourceOrgAmount = new EnResourceOrgAmount();
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 //根据“调度工单明细ID(SHEET_ID)”从“调度工单明细表(RESOURCE_PREPARE_LIST)”中更新
		 //该工单下的所有工单明细的“工单明细状态((LIST_STATUS)”为“下发”；
		 if(str.toString().length()!= 0){
			 sqlWhere.append(" LIST_ID IN ");
			 sqlWhere.append(str);
		 }
		 enResourcePrepareList.setListStatus("1");
		 dbResourcePrepareList.updateWhere(sqlWhere.toString(), enResourcePrepareList);
		 //更新所有工单明细中“调出单位(OUT_ORG_ID)”的“机构资源库存表(RESOURCE_ORG_AMOUNT)”的“预出库数量(PRE_OUT_AMOUNT)”
		 vEnResourcePrepareList = dbResourcePrepareList.findAllWhere(sqlWhere.toString());
		 for(int i =0;i<vEnResourcePrepareList.size();i++){
			 enResourcePrepareList =(EnResourcePrepareList) vEnResourcePrepareList.get(i);
			 if(enResourcePrepareList != null ){
				 sql = new StringBuffer();
			 	sql.append(" UPDATE RESOURCE_ORG_AMOUNT  SET ");
				sql.append(" PRE_OUT_AMOUNT= PRE_OUT_AMOUNT+");
				sql.append(enResourcePrepareList.getAmountPrepare());
				sql.append(" WHERE ORG_ID=");
				if(enResourcePrepareList.getOutStationId() != null && enResourcePrepareList.getOutStationId().length()>0){
					sql.append(Transaction.formatString(enResourcePrepareList.getOutStationId()));
				}else{
					sql.append(Transaction.formatString(enResourcePrepareList.getOutOrgId()));
				}
				sql.append(" AND RESOURCE_TYPE_ID =");
				sql.append(Transaction.formatString(enResourcePrepareList.getResourceTypeId()));
				transaction.doUpdate(null, sql.toString());
			 }
		 }
	}

}
