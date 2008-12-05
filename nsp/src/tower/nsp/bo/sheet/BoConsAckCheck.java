package tower.nsp.bo.sheet;

import org.apache.log4j.Logger;

import tower.common.util.DateFunc;
import tower.nsp.db.DbResourceOrgAmount;
import tower.nsp.db.DbResourcePrepareList;
import tower.nsp.db.DbResourceType;
import tower.nsp.db.DbSysOrg;
import tower.nsp.en.EnResourceOrgAmount;
import tower.nsp.en.EnResourcePrepareList;
import tower.nsp.en.EnResourceType;
import tower.nsp.en.EnSysOrg;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 
 * 功能概述：保存施工确认信息
 * 
 * @author 黄云敬 2008-10-17 上午10:19:23
 */
public class BoConsAckCheck implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		// TODO Auto-generated method stub

		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		
		//调度工单明细
		DbResourcePrepareList dbResourcePrepareList;
		EnResourcePrepareList enResourcePrepareList;
		//资源库存
		DbResourceOrgAmount dbResourceOrgAmount;
		EnResourceOrgAmount enResourceOrgAmountIn;
		EnResourceOrgAmount enResourceOrgAmountSpare;
		//机构
		DbSysOrg dbSysOrg;
		EnSysOrg enSysOrg;
		//资源型号
		DbResourceType dbResourceType;
		EnResourceType enResourceType;
		
		String listId;				//调度工单明细Id
		String amountFeedBackAck;	//施工反馈确认数量
		Long  amountFeedBack;		//施工反馈数量
		String consAckUserId;		//施工确认操作员
		String consAckDateTime;		//施工确认日期
		
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		
		consAckUserId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		consAckDateTime = DateFunc.GenNowTime();
		
		listId = requestXml.getInputValue("LIST_ID");
		amountFeedBackAck = requestXml.getInputValue("AMOUNT_FEED_BACK_ACK");
		
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		
		transaction.createDefaultConnection(null, false);
		dbResourcePrepareList = new DbResourcePrepareList(transaction,null);
		dbResourceOrgAmount = new DbResourceOrgAmount(transaction,null);
		dbSysOrg = new DbSysOrg(transaction,null);
		dbResourceType = new DbResourceType(transaction,null);
		
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 
		if(listId != null && listId.length() > 0){
			enResourcePrepareList = dbResourcePrepareList.findByKey(listId);
			if(enResourcePrepareList != null){
				if(enResourcePrepareList.getAmountFeedBack() >= Long.parseLong(amountFeedBackAck)){
					String inUnitId;
					String diffInUnitId;
					//获取调度入库单位的库存信息
					if(enResourcePrepareList.getInStationId()!= null && enResourcePrepareList.getInStationId().length() > 0){
						inUnitId = enResourcePrepareList.getInStationId();
						//enResourceOrgAmountIn = dbResourceOrgAmount.findByKey(enResourcePrepareList.getOutStationId(), enResourcePrepareList.getResourceTypeId());
					}else{
						inUnitId = enResourcePrepareList.getInOrgId();
						//enResourceOrgAmountIn = dbResourceOrgAmount.findByKey(enResourcePrepareList.getOutOrgId(), enResourcePrepareList.getResourceTypeId());
					}
					enResourceOrgAmountIn = dbResourceOrgAmount.findByKey(inUnitId, enResourcePrepareList.getResourceTypeId());
					
					//更新调度工单明细
					
					//施工反馈确认数量
					enResourcePrepareList.setAmountFeedBack(Long.parseLong(amountFeedBackAck));
					amountFeedBack = enResourcePrepareList.getAmountFeedBack();
					//施工后数量
					enResourcePrepareList.setAmountAfterCons(enResourcePrepareList.getAmountBeforeCons() + Long.parseLong(amountFeedBackAck));
					//施工后配置数
					enResourceType = dbResourceType.findByKey(enResourcePrepareList.getResourceTypeId());
					enResourcePrepareList.setConfAmountAfterCons(enResourcePrepareList.getAmountAfterCons() * enResourceType.getTypeConfAmount());
					//施工剩余数
					enResourcePrepareList.setAmountDiff(enResourcePrepareList.getAmountPrepare() - Long.parseLong(amountFeedBackAck));
					
					//施工剩余入库单位
					if(enResourcePrepareList.getDiffInStationId() != null && enResourcePrepareList.getDiffInStationId().length() > 0){
						diffInUnitId = enResourcePrepareList.getDiffInStationId();
					}else{
						diffInUnitId = enResourcePrepareList.getDiffInOrgId();
					}
					enResourcePrepareList.setListStatus("6");
					
					//施工确认信息
					enResourcePrepareList.setConsAckUserid(consAckUserId);
					enResourcePrepareList.setConsAckDatetime(consAckDateTime);
					
					dbResourcePrepareList.updateByKey(listId, enResourcePrepareList);
					
					/*//更新施工单位库存
					enResourceOrgAmountIn.setOnlineAmount(enResourceOrgAmountIn.getOnlineAmount() - amountFeedBack + Long.parseLong(amountFeedBackAck));
					dbResourceOrgAmount.updateByKey(inUnitId, enResourcePrepareList.getResourceTypeId(), enResourceOrgAmountIn);
					
					//更新剩余入库单位库存
					enResourceOrgAmountSpare.setStockAmount(enResourceOrgAmountSpare.getStockAmount() - amountFeedBack + Long.parseLong(amountFeedBackAck));
					dbResourceOrgAmount.updateByKey(enResourceOrgAmountSpare.getOrgId(), enResourcePrepareList.getResourceTypeId(), enResourceOrgAmountSpare);
					*/
					String sqlUpdate="update RESOURCE_ORG_AMOUNT r set r.ONLINE_AMOUNT = r.ONLINE_AMOUNT + " + amountFeedBack
						+ ", r.INCONS_AMOUNT = r.INCONS_AMOUNT - " + enResourcePrepareList.getAmountPrepare()
						+ " where r.ORG_ID = " + inUnitId + " and RESOURCE_TYPE_ID = " + enResourcePrepareList.getResourceTypeId();
					transaction.doUpdate(null, sqlUpdate);
					enResourceOrgAmountSpare = dbResourceOrgAmount.findByKey(diffInUnitId, enResourcePrepareList.getResourceTypeId());
					if(enResourceOrgAmountSpare != null){
						String sqlUpdateIn="update RESOURCE_ORG_AMOUNT r set r.STOCK_AMOUNT = r.STOCK_AMOUNT + " + enResourcePrepareList.getAmountDiff()
						+ " where r.ORG_ID = " + inUnitId + " and RESOURCE_TYPE_ID = " + enResourcePrepareList.getResourceTypeId();
						
						System.out.println("sqlUpdateIn"+sqlUpdateIn.toString());
						transaction.doUpdate(null, sqlUpdateIn);
					}else{
						enResourceOrgAmountSpare = new EnResourceOrgAmount();
						enResourceOrgAmountSpare.setResourceTypeId(enResourcePrepareList.getResourceTypeId());
						enResourceOrgAmountSpare.setOrgId(diffInUnitId);
						enResourceOrgAmountSpare.setStockAmount(enResourcePrepareList.getAmountDiff());
						dbResourceOrgAmount.insert(enResourceOrgAmountSpare);
					}
				}else{
					if(enResourcePrepareList.getAmountFeedBack() < Long.parseLong(amountFeedBackAck)){
						throw new ErrorException("CA0007",null);
					}
				}
			}else{
				throw new ErrorException("CA0006",null);
			}
		}else{
			throw new ErrorException("CA0004",null);
		}
	}

}
