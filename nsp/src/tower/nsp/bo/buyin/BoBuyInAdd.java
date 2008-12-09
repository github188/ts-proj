package tower.nsp.bo.buyin;

import java.util.Date;

import org.apache.log4j.Logger;

import tower.common.util.DateFunc;
import tower.common.util.SysIdCreator;
import tower.common.util.SysIdCreatorDefine;
import tower.nsp.common.util.IdCreatorDefine;
import tower.nsp.db.DbResourceBuyinList;
import tower.nsp.db.DbResourceOrgAmount;
import tower.nsp.db.DbResourceType;
import tower.nsp.db.DbSysOrg;
import tower.nsp.en.EnResourceBuyinList;
import tower.nsp.en.EnResourceOrgAmount;
import tower.nsp.en.EnResourceType;
import tower.nsp.en.EnSysOrg;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
/**
 * 功能概述：保存采购入库登记信息。
 * @author 吴国景 2008-10-17 下午02:23:19
 */
public class BoBuyInAdd implements RootBo {
	/**
	 * 1、从页面获取参数：资源型号(RESOURCE_TYPE_ID)、出/入库数量(IN_AMOUNT)、出/入库标志(IN_OUT_FLAG)、
	 * 	  备注及说明(IN_REMARK)；获取当前日期赋值给IN_OPER_DATETIME；
	 * 	  从session中获取当前操作员ID赋值给IN_OPER_USERID；                                                                     
	 * 2、检查：“入库机构(ORG_ID)”不能为空，如果为空则抛出异常BI0100；“资源型号(RESOURCE_TYPE_ID)”不能为空，如果为空则抛出异常BI0101；                                                                                                                         
	 * 3、检查通过则往资源外购入库登记表(RESOURCE_BUYIN_LIST)表中插入一条记录；                                                 
	 * 4、更新入库机构的机构资源库存表(RESOURCE_ORG_AMOUNT)的库存数量(STOCK_AMOUNT)。                                                                                                                                                  
	 */
	@SuppressWarnings("static-access")
	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//声明资源外购入库登记表db、en
		DbResourceBuyinList dbResourceBuyinList;
		EnResourceBuyinList enResourceBuyinList;
		
		//资源库存db en
		DbResourceOrgAmount dbResourceOrgAmount;
		EnResourceOrgAmount enResourceOrgAmount;
		
		//机构db en
		DbSysOrg dbSysOrg;
		EnSysOrg enSysOrg;
		
		// 声明资源型号db、en
		DbResourceType dbResourceType;
		EnResourceType enResourceType;
		
		//参数声明
		String inOutFlag;
		String orgId;
		String resourceTypeId;
		String inAmount;
		String inRemark;
		String inOperUserid;
		String inOperDatetime;
		String listId;
		
		//其他
		StringBuffer sql = new StringBuffer();
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		orgId = requestXml.getInputValue("IN_ORGID");
		inOutFlag = requestXml.getInputValue("IN_OUT_FLAG");
		resourceTypeId = requestXml.getInputValue("TYPE_ID");
		inAmount = requestXml.getInputValue("IN_AMOUNT");
		inRemark = requestXml.getInputValue("IN_REMARK");
		inOperDatetime = DateFunc.GenNowTime();DateFunc.GenDate(new Date());
		
		inOperUserid = sessionXml.getItemValue("SYS_USER",1,"USER_ID");
		listId = null;
		
		if(requestXml.getInputRowCount("IN_OPER_DATETIME_BNG")<=0){
			requestXml.addInputRow("IN_OPER_DATETIME_BNG");
			requestXml.setInputValue("IN_OPER_DATETIME_BNG", 1, DateFunc.FormatDateTime(inOperDatetime).substring(0, 10));
		}
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbResourceBuyinList = new DbResourceBuyinList(transaction,null);
		dbResourceOrgAmount = new DbResourceOrgAmount(transaction,null);
		dbSysOrg = new DbSysOrg(transaction,null);
		dbResourceType = new DbResourceType(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		if(orgId == null || orgId.length() == 0){
			throw new ErrorException("BI0100",null);
		}else{
			enSysOrg = dbSysOrg.findByKey(orgId);
		}
		if(resourceTypeId ==null || resourceTypeId.length() ==0 ){
			throw new ErrorException("BI0101",null);
		}else{
			enResourceType = dbResourceType.findByKey(resourceTypeId);
		}
		//自动生成id
		listId = SysIdCreator.GenNextId(transaction, null,
					IdCreatorDefine.ID_TYPE_LIST_ID,
					IdCreatorDefine.ID_LEN_LIST_ID);
		enResourceBuyinList = new EnResourceBuyinList();
		enResourceBuyinList.setListId(listId);
		enResourceBuyinList.setInAmount(Long.parseLong(inAmount));
		enResourceBuyinList.setInOperDatetime(inOperDatetime);
		enResourceBuyinList.setInOperUserid(inOperUserid);
		enResourceBuyinList.setInRemark(inRemark);
		enResourceBuyinList.setInOutFlag(inOutFlag);
		enResourceBuyinList.setOrgId(orgId);
		enResourceBuyinList.setResourceTypeId(resourceTypeId);
		
		//往资源外购入库登记表(RESOURCE_BUYIN_LIST)表中插入一条记录；  
		dbResourceBuyinList.insert(enResourceBuyinList);
		
		//如果是入库则入库机构的库存+采购数量；如果是出库则出库机构的库存-采购数量
		if(inOutFlag.equals("I")){
			
			//更新入库机构的机构资源库存表(RESOURCE_ORG_AMOUNT)的库存数量(STOCK_AMOUNT);如果库存不存在建立库存。
			int count = dbResourceOrgAmount.countByKey(orgId, resourceTypeId);
			if(count <= 0){
				enResourceOrgAmount = new EnResourceOrgAmount();
				enResourceOrgAmount.setOrgId(orgId);
				enResourceOrgAmount.setResourceTypeId(resourceTypeId);
				if(inAmount != null && inAmount.length() > 0){
					enResourceOrgAmount.setStockAmount(Long.parseLong(inAmount));
				}else{
					enResourceOrgAmount.setStockAmount(0);
				}
				enResourceOrgAmount.setInconsAmount(0);
				enResourceOrgAmount.setOnlineAmount(0);
				enResourceOrgAmount.setPreOutAmount(0);
				enResourceOrgAmount.setPreInAmount(0);
				dbResourceOrgAmount.insert(enResourceOrgAmount);
			}else{
				sql.append(" UPDATE RESOURCE_ORG_AMOUNT  SET ");
				sql.append(" STOCK_AMOUNT= STOCK_AMOUNT+");
				sql.append(inAmount);
				sql.append(" WHERE ORG_ID=");
				sql.append(transaction.formatString(orgId));
				sql.append(" AND RESOURCE_TYPE_ID =");
				sql.append(transaction.formatString(resourceTypeId));
				transaction.doUpdate(null, sql.toString());
			}
		}else{
			enResourceOrgAmount = dbResourceOrgAmount.findByKey(orgId, resourceTypeId);
			if(enResourceOrgAmount != null){
				if(inAmount != null && inAmount.length() > 0){
					//出库时，如果当前调出数据大于库存数量，抛出异常：出库数量大于当前库存，请返回并重新输入！
					if(Long.parseLong(inAmount) > enResourceOrgAmount.getStockAmount()){
						throw new ErrorException("BI0105",null);
					}else{
						sql.append(" UPDATE RESOURCE_ORG_AMOUNT  SET ");
						sql.append(" STOCK_AMOUNT= STOCK_AMOUNT-");
						sql.append(inAmount);
						sql.append(" WHERE ORG_ID=");
						sql.append(transaction.formatString(orgId));
						sql.append(" AND RESOURCE_TYPE_ID =");
						sql.append(transaction.formatString(resourceTypeId));
						transaction.doUpdate(null, sql.toString());
					}
				}else{
					//BI0106:调出数量不能为空，请返回并重新输入！
					throw new ErrorException("BI0106",null);
				}	
			}else{
				//BI0107：'{0}'机构下'{1}'资源类型的库存不存在，请创建库存！
				throw new ErrorException("BI0107",new  Object[]{enSysOrg.getOrgName(),enResourceType.getTypeName()});
			}
		}
	}

}
