package tower.nsp.bo.define.res;


import org.apache.log4j.Logger;

import tower.nsp.db.DbResourceOrgAmount;
import tower.nsp.db.DbResourcePrepareList;
import tower.nsp.db.DbResourceType;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
/**
 * 功能概述：删除数据
 * @author 吴国景 2008-10-16 下午03:35:16
 */
public class BoResModelDelete implements RootBo {
	
	/**
	 * 1、接受界面中传入的参数:资源型号Id；                                              
	 * 2、判断该参数是否为空，若为空，则抛出异常RD0111；                     
	 * 3、从资源调度工单明细表（RESOURCE_PREPARE_LIST）中，查询所属资源类别ID等于该id的记录，若记录不为空，则抛出异常RD0109；                                         
	 * 4、从机构资源库存表（RESOURCE_ORG_AMOUNT）中，查询所属资源类别ID等于该id的记录，若记录不为空，则抛出异常RD0112；                                   
	 * 5、调用delete语句删除该记录；                                                             
	 * 6、结束。                     
	 */
	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//声明资源型号db、en
		DbResourceType dbResourceType;
		
		//声明资源调度工单明细的db、en
		DbResourcePrepareList dbResourcePrepareList;
		
		//声明资源库存的db、en
		DbResourceOrgAmount dbResourceOrgAmount;
		
		//参数声明
		String typeId;
		
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		typeId = requestXml.getInputValue("TYPE_ID");
		
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbResourceType = new DbResourceType(transaction,null);
		dbResourceOrgAmount = new DbResourceOrgAmount(transaction,null);
		dbResourcePrepareList = new DbResourcePrepareList(transaction,null);
		
		
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		if(typeId == null || typeId.length() ==0){
			throw new ErrorException("RD0111",null);
		}else{
			//从机构资源库存表（RESOURCE_ORG_AMOUNT）中，查询所属资源类别ID等于该id的记录，若记录不为空，则抛出异常RD0112； 
			int count = dbResourceOrgAmount.countWhere(" RESOURCE_TYPE_ID='"+typeId+"'");
			if(count != 0){
				throw new ErrorException("RD0112",null);
			}
			//从资源调度工单明细表（RESOURCE_PREPARE_LIST）中，查询所属资源类别ID等于该id的记录，若记录不为空，则抛出异常RD0109；
			int count1 = dbResourcePrepareList.countWhere(" RESOURCE_TYPE_ID='"+typeId+"'");
			if(count1 != 0){
				throw new ErrorException("RD0109",null);
			}
			
			//删除该信息
			dbResourceType.deleteByKey(typeId);
		}
	}

}
