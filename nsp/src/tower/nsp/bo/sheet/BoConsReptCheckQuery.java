package tower.nsp.bo.sheet;

import org.apache.log4j.Logger;

import tower.nsp.db.DbResourceBuyinList;
import tower.nsp.db.DbResourceClass;
import tower.nsp.db.DbResourceOrgAmount;
import tower.nsp.db.DbResourcePrepareList;
import tower.nsp.db.DbResourcePrepareSheet;
import tower.nsp.db.DbResourceType;
import tower.nsp.db.DbSysOrg;
import tower.nsp.en.EnResourceClass;
import tower.nsp.en.EnResourceOrgAmount;
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
 * 功能概述：施工反馈详工单细信息，获取工单明细ID
 * 
 * @author 黄云敬 2008-10-17 上午09:58:30
 */
public class BoConsReptCheckQuery implements RootBo {
	
	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		// TODO Auto-generated method stub

		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//工单明细
		DbResourcePrepareList dbResourcePrepareList;
		EnResourcePrepareList enResourcePrepareList;
		//工单信息
		DbResourcePrepareSheet dbResourcePrepareSheet;
		EnResourcePrepareSheet enResourcePrepareSheet;
		//资源库存
		DbResourceOrgAmount dbResourceOrgAmount;
		EnResourceOrgAmount enResourceOrgAmountIn;
		DbResourceClass dbResourceClass;
		EnResourceClass enResourceClass;
		DbResourceType dbResourceType;
		EnResourceType enResourceType;
		DbSysOrg dbSysOrg;
		EnSysOrg enSysOrg;
		EnSysOrg enSysOrgP;
		
		String listId;
		
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		
		listId = requestXml.getInputValue("LIST_ID");
		
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		
		transaction.createDefaultConnection(null, true);
		dbResourcePrepareList = new DbResourcePrepareList(transaction,null);
		dbResourcePrepareSheet = new DbResourcePrepareSheet(transaction,null);
		dbResourceOrgAmount = new DbResourceOrgAmount(transaction,null);
		dbResourceClass = new DbResourceClass(transaction,null);
		dbResourceType = new DbResourceType(transaction,null);
		dbSysOrg = new DbSysOrg(transaction,null);
		
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 
		if(listId != null && listId.length() > 0){
			enResourcePrepareList = dbResourcePrepareList.findByKey(listId);
			String inUnitId;
			//获取调度入库单位的库存信息
			if(enResourcePrepareList.getInStationId()!= null && enResourcePrepareList.getInStationId().length() > 0){
				inUnitId = enResourcePrepareList.getInStationId();
			}else{
				inUnitId = enResourcePrepareList.getInOrgId();
			}
			enResourceOrgAmountIn = dbResourceOrgAmount.findByKey(inUnitId, enResourcePrepareList.getResourceTypeId());

			enResourcePrepareSheet = dbResourcePrepareSheet.findByKey(enResourcePrepareList.getSheetId());
			enResourceClass = dbResourceClass.findByKey(enResourcePrepareList.getResourceClassId());
			enResourceType = dbResourceType.findByKey(enResourcePrepareList.getResourceTypeId());
			
			enSysOrg = dbSysOrg.findByKey(enResourcePrepareList.getOutOrgId());
			String outStation ;
			if(enResourcePrepareList.getOutStationId() != null && enResourcePrepareList.getOutStationId().length() > 0){
				enSysOrgP = dbSysOrg.findByKey(enResourcePrepareList.getOutStationId());
				outStation = enSysOrgP.getOrgName();
			}else{
				outStation = "";
			}
			int row = dbResourcePrepareList.setToXml(requestXml, enResourcePrepareList);
			requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "OUT_ORG_NAME", enSysOrg.getOrgName());
			requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "OUT_STATION_NAME", outStation);
			enSysOrg = dbSysOrg.findByKey(enResourcePrepareList.getInOrgId());
			String inStation ;
			if(enResourcePrepareList.getInStationId() != null && enResourcePrepareList.getInStationId().length() > 0){
				enSysOrgP = dbSysOrg.findByKey(enResourcePrepareList.getInStationId());
				inStation = enSysOrgP.getOrgName();
			}else{
				inStation = "";
			}
			requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "IN_ORG_NAME", enSysOrg.getOrgName());
			requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "IN_STATION_NAME", inStation);
			
			requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "AMOUNT_BEFORE_CONS_FEE", enResourceOrgAmountIn.getOnlineAmount());
			requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "PREPARE_DATE", enResourcePrepareSheet.getPrepareDate());
			requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "TYPE_NAME", enResourceType.getTypeName());
			requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "CLASS_NAME", enResourceClass.getClassName());
		}else{
			throw new ErrorException("CR0004",null);
		}
		
	}

}
