package tower.nsp.bo.sheet;


import org.apache.log4j.Logger;

import tower.common.util.DateFunc;
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
 * 功能概述：获取你选择要调度出库的工单的工单明细ID查找出所有的工单明细ID的基本信息 
 * 
 * @author 黄云敬 2008-10-16 下午05:20:15
 */
public class BoResourceOutCheckList implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		// TODO Auto-generated method stub

		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		DbResourcePrepareList dbResourcePrepareList;
		EnResourcePrepareList enResourcePrepareList;
		DbResourcePrepareSheet dbResourcePrepareSheet;
		EnResourcePrepareSheet enResourcePrepareSheet;
		DbResourceOrgAmount dbResourceOrgAmount;
		EnResourceOrgAmount enResourceOrgAmount;
		DbSysOrg dbSysOrg;
		EnSysOrg enSysOrg;
		EnSysOrg enSysOrgP;
		DbResourceClass dbResourceClass;
		EnResourceClass enResourceClass;
		DbResourceType dbResourceType;
		EnResourceType enResourceType;

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
		dbResourcePrepareSheet = new DbResourcePrepareSheet(transaction, null);
		dbResourceOrgAmount = new DbResourceOrgAmount(transaction, null);
		dbSysOrg = new DbSysOrg(transaction,null);
		dbResourceClass = new DbResourceClass(transaction,null);
		dbResourceType = new DbResourceType(transaction,null);
		
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/

		//判断选择的调度工单明细是否为空
		if(listId != null && listId.length() > 0){
			
			//查找出的调度工单明细信息保存到request对象中
			enResourcePrepareList = dbResourcePrepareList.findByKey(listId);
			enResourcePrepareSheet = dbResourcePrepareSheet.findByKey(enResourcePrepareList.getSheetId());
			enResourceClass = dbResourceClass.findByKey(enResourcePrepareList.getResourceClassId());
			enResourceType = dbResourceType.findByKey(enResourcePrepareList.getResourceTypeId());
			enSysOrg = dbSysOrg.findByKey(enResourcePrepareList.getInOrgId());
			//调出基站库存
			Long outStationAmount = Long.parseLong("0") ;
			if(enResourcePrepareList.getOutStationId() != null && enResourcePrepareList.getOutStationId().length() > 0){
				enResourceOrgAmount  = dbResourceOrgAmount.findByKey(enResourcePrepareList.getOutStationId(), enResourcePrepareList.getResourceTypeId());
				if(enResourceOrgAmount != null){
					outStationAmount = enResourceOrgAmount.getStockAmount();
				}
			}else{
				enResourceOrgAmount  = dbResourceOrgAmount.findByKey(enResourcePrepareList.getOutOrgId(), enResourcePrepareList.getResourceTypeId());
				if(enResourceOrgAmount != null){
					outStationAmount = enResourceOrgAmount.getStockAmount();
				}
			}
			//根据调入基站是否为空显示调入基站的机构名称
			String inStation ;
			if(enResourcePrepareList.getInStationId() != null && enResourcePrepareList.getInStationId().length() > 0){
				enSysOrgP = dbSysOrg.findByKey(enResourcePrepareList.getInStationId());
				inStation = enSysOrgP.getOrgName();
			}else{
				inStation = "";
			}
			int row = dbResourcePrepareList.setToXml(requestXml, enResourcePrepareList);
			requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "IN_ORG_NAME", enSysOrg.getOrgName());
			requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "OUT_ORG_AMOUNT", outStationAmount);
			requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "IN_STATION_NAME", inStation);
			requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "CLASS_NAME", enResourceClass.getClassName());
			requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "TYPE_NAME", enResourceType.getTypeName());
			if(enResourcePrepareSheet != null){
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "PREPARE_DATE", DateFunc.FormatDate(enResourcePrepareSheet.getPrepareDate()));
			}else{
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "PREPARE_DATE", "");
			}	
		}else{
			throw new ErrorException("RO0004",null);
		}
	}
}
