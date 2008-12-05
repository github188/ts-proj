package tower.nsp.bo.buyin;


import org.apache.log4j.Logger;
import tower.nsp.db.DbResourceBuyinList;
import tower.nsp.db.DbResourceOrgAmount;
import tower.nsp.en.EnResourceBuyinList;
import tower.nsp.en.EnResourceOrgAmount;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
/**
 * 功能概述：根据外购入库登记ID删除入库登记信息。
 * @author 吴国景 2008-10-17 下午03:06:47
 */
public class BoBuyInDel implements RootBo {
	/**
	 * 1、从页面获取参数：外购入库登记ID(LIST_ID)；                                         
	 * 2、检查获取的参数：外购入库登记ID(LIST_ID)是否为，如果为空则抛出异常BI0102：                                                                                                                                                   
	 * 3、根据外购入库登记ID(LIST_ID)从资源外购入库登记表(RESOURCE_BUYIN_LIST) 删除记录；通同时更新该机构的库存。     
	 */
	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//采购入库db、en
		DbResourceBuyinList dbResourceBuyinList;
		EnResourceBuyinList enResourceBuyinList;
		
		//声明参数
		String listId;
		
		//其他
		StringBuffer sql = new StringBuffer();
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		listId = requestXml.getInputValue("LIST_ID");
		
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbResourceBuyinList = new DbResourceBuyinList(transaction,null);
		enResourceBuyinList = new EnResourceBuyinList();
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		//检查获取的参数：外购入库登记ID(LIST_ID)是否为，如果为空则抛出异常BI0102：  
		if(listId == null || listId.length()==0 ){
			throw new ErrorException("BI0102",null);
		}else{
			enResourceBuyinList = dbResourceBuyinList.findByKey(listId);
			if(enResourceBuyinList != null){
				//检查是出库还是入库：如果是出库则：STOCK_AMOUNT= STOCK_AMOUNT+enResourceBuyinList.getInAmount()
				//否则STOCK_AMOUNT= STOCK_AMOUNT-enResourceBuyinList.getInAmount()
				
				sql.append(" UPDATE RESOURCE_ORG_AMOUNT  SET ");
				if(enResourceBuyinList.getInOutFlag().equals("I")){
					sql.append(" STOCK_AMOUNT= STOCK_AMOUNT-");
				}else if(enResourceBuyinList.getInOutFlag().equals("O")){
					sql.append(" STOCK_AMOUNT= STOCK_AMOUNT+");
				}
				sql.append(enResourceBuyinList.getInAmount());
				sql.append(" WHERE ORG_ID=");
				sql.append(transaction.formatString(enResourceBuyinList.getOrgId()));
				sql.append(" AND RESOURCE_TYPE_ID =");
				sql.append(transaction.formatString(enResourceBuyinList.getResourceTypeId()));
				transaction.doUpdate(null, sql.toString());
			}
			
			//删除记录
			dbResourceBuyinList.deleteByKey(listId);
			
			
		}
	}

}
