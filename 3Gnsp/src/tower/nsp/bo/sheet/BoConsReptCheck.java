package tower.nsp.bo.sheet;

import org.apache.log4j.Logger;

import tower.common.util.DateFunc;
import tower.nsp.db.DbResourcePrepareList;
import tower.nsp.db.DbResourceType;
import tower.nsp.db.DbSysOrg;
import tower.nsp.en.EnResourcePrepareList;
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
 * @author 黄云敬 2008-10-17 上午09:58:50
 */
public class BoConsReptCheck implements RootBo {

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
		//机构
		DbSysOrg dbSysOrg;
		EnSysOrg enSysOrg;
		//资源型号
		DbResourceType dbResourceType;
		EnResourceType enResourceType;
		
		String listId;				//调度工单明细Id
		String amountFeedBack;		//施工反馈数量
		String amountBefore;		//施工前数量
		String consUserName;		//施工人姓名
		String consFinDate;			//完工日期
		String spareOrgId;			//施工剩余入库单位
		
		String consFinOperUserId;	//完成操作人CONS_FIN_OPER_USERID
		String consFinOperDatetime;	//CONS_FIN_OPER_DATETIME
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		
		consFinOperUserId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		consFinOperDatetime = DateFunc.GenNowTime();
		
		listId = requestXml.getInputValue("LIST_ID");
		amountBefore = requestXml.getInputValue("AMOUNT_BEFORE_CONS");
		amountFeedBack = requestXml.getInputValue("AMOUNT_FEED_BACK");
		consUserName = requestXml.getInputValue("CONS_USER_NAME");
		consFinDate = requestXml.getInputValue("CONS_FIN_DATE");
		spareOrgId = requestXml.getInputValue("SPARE_ORG_ID");
		//spareOrgParent = requestXml.getInputValue("SPARE_ORG_PARENT_ID");
		//spareOrgFlag = requestXml.getInputValue("SPARE_ORG_FLAG");
		
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		
		transaction.createDefaultConnection(null, false);
		dbResourcePrepareList = new DbResourcePrepareList(transaction,null);
		dbSysOrg = new DbSysOrg(transaction,null);
		dbResourceType = new DbResourceType(transaction,null);
		
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 
		if(listId != null && listId.length() > 0){
			enResourcePrepareList = dbResourcePrepareList.findByKey(listId);
			if(amountBefore != null && amountBefore.length() > 0 
					&& amountFeedBack != null && amountFeedBack.length() > 0 
					&& consUserName != null && consUserName.length() > 0 
					&& consFinDate != null && consFinDate.length() > 0
					&& spareOrgId != null && spareOrgId.length() > 0){
				
				if(enResourcePrepareList.getAmountPrepare() >= Long.parseLong(amountFeedBack)){
					//工单明细信息
					enResourcePrepareList.setConsFinDate(DateFunc.ParseDateTime(consFinDate));
					enResourcePrepareList.setConsFinOperDatetime(consFinOperDatetime);
					enResourcePrepareList.setConsFinOperUserid(consFinOperUserId);
					enResourcePrepareList.setConsUserName(consUserName);
					//施工反馈数量
					enResourcePrepareList.setAmountFeedBack(Long.parseLong(amountFeedBack));
					//施工前数量
					enResourcePrepareList.setAmountBeforeCons(Long.parseLong(amountBefore));
					//施工后数量
					enResourcePrepareList.setAmountAfterCons(enResourcePrepareList.getAmountBeforeCons() + enResourcePrepareList.getAmountFeedBack());
					//施工后配置数
					enResourceType = dbResourceType.findByKey(enResourcePrepareList.getResourceTypeId());
					enResourcePrepareList.setConfAmountAfterCons(enResourcePrepareList.getAmountAfterCons() * enResourceType.getTypeConfAmount());
					//施工剩余数
					enResourcePrepareList.setAmountDiff(enResourcePrepareList.getAmountPrepare() - enResourcePrepareList.getAmountFeedBack());
					//判断入库单位是否为基站
					enSysOrg = dbSysOrg.findByKey(spareOrgId);
					if(enSysOrg.getStationFlag().equals("Y")){
						enResourcePrepareList.setDiffInOrgId(enSysOrg.getParentId());
						enResourcePrepareList.setDiffInStationId(enSysOrg.getOrgId());
					}else{
						enResourcePrepareList.setDiffInOrgId(enSysOrg.getOrgId());
					}
					enResourcePrepareList.setListStatus("5");
					dbResourcePrepareList.updateByKey(listId, enResourcePrepareList);
					
				}else{
					throw new ErrorException("CR0006",null);
				}
			}else{
				throw new ErrorException("CR0005",null);
			}
		}else{
			throw new ErrorException("CR0004",null);
		}
	}

}
