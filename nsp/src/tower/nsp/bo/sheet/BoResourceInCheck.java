package tower.nsp.bo.sheet;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.common.util.DateFunc;
import tower.nsp.db.DbResourceBuyinList;
import tower.nsp.db.DbResourceOrgAmount;
import tower.nsp.db.DbResourcePrepareList;
import tower.nsp.db.DbResourcePrepareSheet;
import tower.nsp.en.EnResourceOrgAmount;
import tower.nsp.en.EnResourcePrepareList;
import tower.nsp.en.EnResourcePrepareSheet;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 
 * 功能概述：调度入库修改入库操作员、入库日期
 * 
 * @author 黄云敬 2008-10-17 
 */
public class BoResourceInCheck implements RootBo {

	/**
	 * 
	 */
	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		// TODO Auto-generated method stub

		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		

		//资源库存
		DbResourceOrgAmount dbResourceOrgAmount;
		EnResourceOrgAmount enResourceOrgAmountIn;
		//调度工单明细
		DbResourcePrepareList dbResourcePrepareList;
		EnResourcePrepareList enResourcePrepareList;
		Vector resourceIns;
		
		String[] listId;
		String inOperUser;
		String inOperDatetime;
		
		StringBuffer sql = new StringBuffer();
		
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		
		listId = requestXml.getInputValues("LIST_ID");
		inOperUser = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		inOperDatetime = DateFunc.GenNowTime();
		
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		
		transaction.createDefaultConnection(null, true);
		dbResourcePrepareList = new DbResourcePrepareList(transaction,null);
		dbResourceOrgAmount = new DbResourceOrgAmount(transaction,null);
		
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		if(listId != null && listId.length > 0){
			sql.append("LIST_ID in('");
			for(int i = 0 ; i < listId.length ; i++){
				sql.append(listId[i]);
				sql.append("','");
			}
			sql.append("')");
			resourceIns = dbResourcePrepareList.findAllWhere(sql.toString());
			if(resourceIns != null && resourceIns.size() > 0){
				for(int i = 0 ; i < resourceIns.size() ; i++){
					enResourcePrepareList = (EnResourcePrepareList) resourceIns.get(i);
					String inUnitId;
					//获取调度入库单位的库存信息
					if(enResourcePrepareList.getInStationId()!= null && enResourcePrepareList.getInStationId().length() > 0){
						inUnitId = enResourcePrepareList.getInStationId();
						//enResourceOrgAmountIn = dbResourceOrgAmount.findByKey(enResourcePrepareList.getOutStationId(), enResourcePrepareList.getResourceTypeId());
					}else{
						inUnitId = enResourcePrepareList.getInOrgId();
						//enResourceOrgAmountIn = dbResourceOrgAmount.findByKey(enResourcePrepareList.getOutOrgId(), enResourcePrepareList.getResourceTypeId());
					}
					enResourceOrgAmountIn = dbResourceOrgAmount.findByKey(inUnitId, enResourcePrepareList.getResourceTypeId());
					//更新库存和工单明细信息
					enResourcePrepareList.setInOperDatetime(inOperDatetime);
					enResourcePrepareList.setInOperUserid(inOperUser);
					enResourcePrepareList.setListStatus("4");
					dbResourcePrepareList.updateByKey(listId[i], enResourcePrepareList);
					
					if(enResourceOrgAmountIn != null){
						String sqlUpdateIn = "update RESOURCE_ORG_AMOUNT r set r.PRE_IN_AMOUNT = " +
							"r.PRE_IN_AMOUNT - " + enResourcePrepareList.getAmountPrepare()+
							",r.INCONS_AMOUNT = r.INCONS_AMOUNT + " + enResourcePrepareList.getAmountPrepare()+
							" where r.ORG_ID = " + inUnitId + " and RESOURCE_TYPE_ID = " + enResourcePrepareList.getResourceTypeId();
						transaction.doUpdate(null, sqlUpdateIn);
						//enResourceOrgAmountIn.setPreInAmount(enResourceOrgAmountIn.getPreInAmount() - enResourcePrepareList.getAmountPrepare());
						//enResourceOrgAmountIn.setInconsAmount(enResourceOrgAmountIn.getInconsAmount() - enResourcePrepareList.getAmountPrepare());
						//dbResourceOrgAmount.updateByKey(inUnitId, enResourcePrepareList.getResourceTypeId(), enResourceOrgAmountIn);
					}
					
				}
			}else{
				throw new ErrorException("RI0003",null);
			}
		}else{
			throw new ErrorException("RI0004",null);
		}
	}

}
