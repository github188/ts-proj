package tower.nsp.bo.stat;

import org.apache.log4j.Logger;

import tower.nsp.db.DbResourceOrgAmount;
import tower.nsp.db.DbResourceType;
import tower.nsp.db.DbSysOrg;
import tower.nsp.en.EnResourceOrgAmount;
import tower.nsp.en.EnResourceType;
import tower.nsp.en.EnSysOrg;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
/**
 * 
 *功能概述：坏件调换
 * @author fanlj 2008-11-4  上午10:08:26
 */
public class BoResourceChange implements RootBo{

	@SuppressWarnings("static-access")
	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
//		//资源库存db en
//		DbResourceOrgAmount dbResourceOrgAmount;
//		EnResourceOrgAmount enResourceOrgAmount;
//		
//		//机构db en
//		DbSysOrg dbSysOrg;
//		EnSysOrg enSysOrg;
//		
//		//资源类型db en
//		DbResourceType dbResourceType;
//		EnResourceType enResourceType;
		
		//获取输入
		String orgId;
		String resourceTypeId;
		String flag;
		String stockAmount;
		String changeAmount;
		String badAmount;
		long stockAmount1;
		long changeAmount1;
		long badAmount1;
		//其他
		StringBuffer sql = new StringBuffer();
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		orgId = requestXml.getInputValue("ORG_ID");
		resourceTypeId = requestXml.getInputValue("RESOURCE_TYPE_ID");
		flag = requestXml.getInputValue("FLAG");
		stockAmount = requestXml.getInputValue("STOCK_AMOUNT");
		if(stockAmount != null && stockAmount.length() >0){
			stockAmount1 = Long.parseLong(stockAmount);
		}else{
			stockAmount1=0;
		}
		changeAmount = requestXml.getInputValue("CHANGE_AMOUNT");
		if(changeAmount != null && changeAmount.length() >0){
			changeAmount1 = Long.parseLong(changeAmount);
		}else{
			changeAmount1=0;
		}
		badAmount = requestXml.getInputValue("BAD_AMOUNT");
		if(badAmount != null && badAmount.length() >0){
			badAmount1 = Long.parseLong(badAmount);
		}else{
			badAmount1=0;
		}
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
//		dbResourceOrgAmount = new DbResourceOrgAmount(transaction,null);
//		dbSysOrg = new DbSysOrg(transaction,null);
//		dbResourceType = new DbResourceType(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		if(flag != null && flag.length() >0){
			if(flag.equals("GoodToBad")){
				if(changeAmount1 > stockAmount1){
					throw new ErrorException("CF0101",null);
				}else{
					sql.append(" UPDATE RESOURCE_ORG_AMOUNT  SET ");
					sql.append(" STOCK_AMOUNT= STOCK_AMOUNT-");
					sql.append(changeAmount1);
					sql.append(" ,BAD_AMOUNT= BAD_AMOUNT+");
					sql.append(changeAmount1);
					sql.append(" WHERE ORG_ID=");
					sql.append(transaction.formatString(orgId));
					sql.append(" AND RESOURCE_TYPE_ID =");
					sql.append(transaction.formatString(resourceTypeId));
					transaction.doUpdate(null, sql.toString());
				}
			}else if(flag.equals("BadToGood")){
				if(changeAmount1 > badAmount1){
					throw new ErrorException("CF0102",null);
				}else{
					sql.append(" UPDATE RESOURCE_ORG_AMOUNT  SET ");
					sql.append(" STOCK_AMOUNT= STOCK_AMOUNT+");
					sql.append(changeAmount1);
					sql.append(" ,BAD_AMOUNT= BAD_AMOUNT-");
					sql.append(changeAmount1);
					sql.append(" WHERE ORG_ID=");
					sql.append(transaction.formatString(orgId));
					sql.append(" AND RESOURCE_TYPE_ID =");
					sql.append(transaction.formatString(resourceTypeId));
					transaction.doUpdate(null, sql.toString());
				}
			}
		}
	}

}
