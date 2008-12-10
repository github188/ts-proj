package tower.nsp.bo.sheet;

import org.apache.log4j.Logger;

import tower.common.util.DateFunc;
import tower.nsp.db.DbResourceClass;
import tower.nsp.db.DbResourceOrgAmount;
import tower.nsp.db.DbResourcePrepareList;
import tower.nsp.db.DbResourceType;
import tower.nsp.en.EnResourceClass;
import tower.nsp.en.EnResourceOrgAmount;
import tower.nsp.en.EnResourcePrepareList;
import tower.nsp.en.EnResourceType;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 
 * 功能概述：获取领取人领取日期更新RESOURCE_PREPARE_LIST
 * 
 * @author 黄云敬 2008-10-16 下午05:20:31
 */
public class BoResourceOutCheck implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		// TODO Auto-generated method stub

		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		// 资源库存
		DbResourceOrgAmount dbResourceOrgAmount;
		EnResourceOrgAmount enResourceOrgAmountOut;
		// 调度工单明细
		EnResourceOrgAmount enResourceOrgAmountIn;
		DbResourcePrepareList dbResourcePrepareList;
		// RESOURCE_CLASS
		DbResourceClass dbResourceClass;
		EnResourceClass enResourceClass;
		// RESOURCE_TYPE
		DbResourceType dbResourceType;
		EnResourceType enResourceType;

		EnResourcePrepareList enResourcePrepareList;

		String takeUserName;
		String takeDate;
		String outOperUser;
		String outOperDate;
		String listId;
		String outType;

		/***********************************************************************
		 * 获取输入
		 **********************************************************************/

		outOperUser = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		listId = requestXml.getInputValue("LIST_ID");
		takeUserName = requestXml.getInputValue("TAKE_USER_NAME");
		takeDate = requestXml.getInputValue("TAKE_DATE");
		outType = requestXml.getInputValue("OUT_RESOURCE_STATUS");
		outOperDate = DateFunc.GenNowTime();

		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/

		transaction.createDefaultConnection(null, true);
		dbResourceOrgAmount = new DbResourceOrgAmount(transaction, null);
		dbResourcePrepareList = new DbResourcePrepareList(transaction, null);
		dbResourceClass = new DbResourceClass(transaction, null);
		dbResourceType = new DbResourceType(transaction, null);

		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/

		//判断是否选择了要出库的工单
		if (listId != null && listId.length() > 0) {
			
			//判断是否输入了出库登记信息，领取人、领取日期
			if (takeUserName != null && takeUserName.length() > 0
					&& takeDate != null && takeDate.length() > 0) {
				
				//判断是否获取出库操作员为空
				if (outOperUser != null && outOperUser.length() > 0) {
						// 获取调度工单明细信息
						enResourcePrepareList = dbResourcePrepareList
								.findByKey(listId);
						// 获取调度出库单位的库存信息
						String outUnitId;
						String inUnitId;
						
						//获取要出库的单位（分公司、基站）
						if (enResourcePrepareList.getOutStationId() != null
								&& enResourcePrepareList.getOutStationId()
										.length() > 0) {
							outUnitId = enResourcePrepareList.getOutStationId();
						} else {
							outUnitId = enResourcePrepareList.getOutOrgId();
						}
						enResourceOrgAmountOut = dbResourceOrgAmount.findByKey(
								outUnitId, enResourcePrepareList
										.getResourceTypeId());
						
						if (enResourceOrgAmountOut != null) {
							
							//判断调出或库存是否存在负数，如果出现抛出异常
							if (enResourceOrgAmountOut.getStockAmount()
									- enResourcePrepareList.getAmountPrepare() < 0) {
								enResourceClass = dbResourceClass.findByKey(enResourcePrepareList.getResourceClassId());
								enResourceType = dbResourceType.findByKey(enResourcePrepareList.getResourceTypeId());
								String[] message = {enResourceClass.getClassName(),enResourceType.getTypeName() };
								throw new ErrorException("RO0003", message);
							}else{

								// 获取调度入库单位的库存信息
								if (enResourcePrepareList.getInStationId() != null
										&& enResourcePrepareList.getInStationId()
												.length() > 0) {
									inUnitId = enResourcePrepareList
											.getInStationId();
								} else {
									inUnitId = enResourcePrepareList.getInOrgId();
								}
								enResourceOrgAmountIn = dbResourceOrgAmount
										.findByKey(inUnitId, enResourcePrepareList
												.getResourceTypeId());
								
								// 更新库存和工单明细信息
								enResourcePrepareList
										.setOutOperDatetime(outOperDate);
								enResourcePrepareList.setOutOperUserid(outOperUser);
								enResourcePrepareList.setTakeDate(DateFunc.ParseDateTime(takeDate));
								enResourcePrepareList.setTakeUserName(takeUserName);
								enResourcePrepareList.setListStatus("3");
								dbResourcePrepareList.updateByKey(listId,
										enResourcePrepareList);
	
								//判断是从库存中调度还是在在线中调度
								if(outType == null || outType.length() == 0 ){
									throw new ErrorException("RO0008",null);
								}else{
									String sqlUpdate;
									if(outType.equals("0")){
										sqlUpdate = "update RESOURCE_ORG_AMOUNT r set r.STOCK_AMOUNT = " +
										"r.STOCK_AMOUNT - " + enResourcePrepareList.getAmountPrepare()+
										" , r.PRE_OUT_AMOUNT = r.PRE_OUT_AMOUNT - "+ enResourcePrepareList.getAmountPrepare()+
										" where r.ORG_ID = " + outUnitId + " and RESOURCE_TYPE_ID = " + enResourcePrepareList.getResourceTypeId();
									}else{
										sqlUpdate = "update RESOURCE_ORG_AMOUNT r set r.ONLINE_AMOUNT = " +
										"r.ONLINE_AMOUNT - " + enResourcePrepareList.getAmountPrepare()+
										" , r.PRE_OUT_AMOUNT = r.PRE_OUT_AMOUNT - "+ enResourcePrepareList.getAmountPrepare()+
										" where r.ORG_ID = " + outUnitId + " and RESOURCE_TYPE_ID = " + enResourcePrepareList.getResourceTypeId();
									}
									transaction.doUpdate(null, sqlUpdate);
								}
	
								//判断调入单位或基站的库存对象是否存在，如果存在更新库存，如果不存在添加库存对象
								if(enResourceOrgAmountIn != null){
									String sqlUpdateIn = "update RESOURCE_ORG_AMOUNT r set r.PRE_IN_AMOUNT = " +
										"r.PRE_IN_AMOUNT + " + enResourcePrepareList.getAmountPrepare() +
										" where r.ORG_ID = " + inUnitId + " and RESOURCE_TYPE_ID = " + enResourcePrepareList.getResourceTypeId();
										transaction.doUpdate(null, sqlUpdateIn);
								}else{
									enResourceOrgAmountIn = new EnResourceOrgAmount();
									enResourceOrgAmountIn.setOnlineAmount(0);
									enResourceOrgAmountIn.setOrgId(inUnitId);
									enResourceOrgAmountIn.setPreInAmount(enResourcePrepareList.getAmountPrepare());
									enResourceOrgAmountIn.setPreOutAmount(0);
									enResourceOrgAmountIn.setInconsAmount(0);
									enResourceOrgAmountIn.setResourceTypeId(enResourcePrepareList.getResourceTypeId());
									enResourceOrgAmountIn.setStockAmount(0);
									dbResourceOrgAmount.insert(enResourceOrgAmountIn);
								}
							}
						}else{
							throw new ErrorException("RO0007", null);
						}
					
				} else {
					throw new ErrorException("RO0001", null);
				}
			} else {
				throw new ErrorException("RO0005", null);
			}
		} else {
			throw new ErrorException("RO0004", null);
		}
	}

}
