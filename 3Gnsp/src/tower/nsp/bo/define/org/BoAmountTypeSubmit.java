package tower.nsp.bo.define.org;

import org.apache.log4j.Logger;

import tower.nsp.db.DbResourceOrgAmount;
import tower.nsp.en.EnResourceOrgAmount;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoAmountTypeSubmit implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		 /***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//库存db、en
		DbResourceOrgAmount dbResourceOrgAmount;
		EnResourceOrgAmount enResourceOrgAmount;
		
		//参数
		String orgId;
		String typeId;
		String stockAmount;
		String preOutAmount;
		String preInAmount;
		String inconsAmount;
		String onlineAmount;
		String badAmount;
		//判断是添加还是编辑的参数
		String isAddFlag;
		
		
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		isAddFlag = requestXml.getInputValue("IsAddFlag");
		orgId = requestXml.getInputValue("ORG_ID");
		typeId = requestXml.getInputValue("TYPE_ID");
		stockAmount= requestXml.getInputValue("STOCK_AMOUNT");
		preOutAmount=requestXml.getInputValue("PRE_OUT_AMOUNT");
		preInAmount = requestXml.getInputValue("PRE_IN_AMOUNT");
		inconsAmount = requestXml.getInputValue("INCONS_AMOUNT");
		onlineAmount= requestXml.getInputValue("ONLINE_AMOUNT");
		badAmount=requestXml.getInputValue("BAD_AMOUNT");
		
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbResourceOrgAmount = new DbResourceOrgAmount(transaction,null);
		enResourceOrgAmount = new EnResourceOrgAmount();
		
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		if(typeId == null || typeId.length() ==0){
			throw new ErrorException("AM0202",null);
		}
		if(orgId ==null || orgId.length()==0){
			throw new ErrorException("AM0203",null);
		}
		if(isAddFlag.equals("Y")){
			//添加
			int count = dbResourceOrgAmount.countWhere(" ORG_ID='"+orgId+"' and RESOURCE_TYPE_ID='"+typeId+"'");
			if(count > 0){
				throw new ErrorException("AM0201",null);
			}else{
				enResourceOrgAmount.setOrgId(orgId);
				enResourceOrgAmount.setResourceTypeId(typeId);
				enResourceOrgAmount.setStockAmount(Long.parseLong(stockAmount));
				enResourceOrgAmount.setPreOutAmount(Long.parseLong(preOutAmount));
				enResourceOrgAmount.setPreInAmount(Long.parseLong(preInAmount));
				enResourceOrgAmount.setInconsAmount(Long.parseLong(inconsAmount));
				enResourceOrgAmount.setOnlineAmount(Long.parseLong(onlineAmount));
				enResourceOrgAmount.setBadAmount(Long.parseLong(badAmount));
				
				dbResourceOrgAmount.insert(enResourceOrgAmount);
			}
		}else if("N".equals(isAddFlag)){//编辑
			enResourceOrgAmount.setStockAmount(Long.parseLong(stockAmount));
			enResourceOrgAmount.setPreOutAmount(Long.parseLong(preOutAmount));
			enResourceOrgAmount.setPreInAmount(Long.parseLong(preInAmount));
			enResourceOrgAmount.setInconsAmount(Long.parseLong(inconsAmount));
			enResourceOrgAmount.setOnlineAmount(Long.parseLong(onlineAmount));
			enResourceOrgAmount.setBadAmount(Long.parseLong(badAmount));
			
			dbResourceOrgAmount.updateByKey(orgId, typeId, enResourceOrgAmount);
		}
		
	}

}
