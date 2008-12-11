package tower.nsp.bo.define.org;

import org.apache.log4j.Logger;

import tower.nsp.db.DbResourceClass;
import tower.nsp.db.DbResourceOrgAmount;
import tower.nsp.db.DbResourceType;
import tower.nsp.db.DbSysOrg;
import tower.nsp.en.EnResourceClass;
import tower.nsp.en.EnResourceOrgAmount;
import tower.nsp.en.EnResourceType;
import tower.nsp.en.EnSysOrg;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoAmountTypeDetail implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//机构db en
		DbSysOrg dbSysOrg;
		EnSysOrg enSysOrg;
		
		//资源库存db en
		DbResourceOrgAmount dbResourceOrgAmount;
		EnResourceOrgAmount enResourceOrgAmount;
		
		//资源型号db、en
		DbResourceType dbResourceType;
		EnResourceType enResourceType;
		//资源类别db、en
		DbResourceClass dbResourceClass;
		EnResourceClass enResourceClass;
		
		//获取参数：
		String orgId;
		String resourceTypeId;
		
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		orgId = requestXml.getInputValue("ORG_ID");
		resourceTypeId = requestXml.getInputValue("TYPE_ID");
		
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		 dbSysOrg = new DbSysOrg(transaction,null);
		 dbResourceOrgAmount = new DbResourceOrgAmount(transaction,null);
		 dbResourceType = new DbResourceType(transaction,null);
		 dbResourceClass = new DbResourceClass(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 //机构信息
		 if(orgId == null || orgId.length() ==0){
			 throw new ErrorException("AM0101",null);
		 }
		 enSysOrg = dbSysOrg.findByKey(orgId);
		 if(enSysOrg !=null ){
			 dbSysOrg.setToXml(requestXml, enSysOrg);
		 }else{
			 throw new ErrorException("AM0102",null);
		 }
		 
		 //类别、型号信息
		 if(resourceTypeId == null || resourceTypeId.length() == 0){
			 throw new ErrorException("AM0103",null);
		 }
		 enResourceType = dbResourceType.findByKey(resourceTypeId);
		 if(enResourceType != null){
			 dbResourceType.setToXml(requestXml, enResourceType);
			 enResourceClass = dbResourceClass.findByKey(enResourceType.getResourceClassId());
			 if(enResourceClass != null){
				 requestXml.setItemValue("RESOURCE_TYPE", 1, "CLASS_NAME", enResourceClass.getClassName());
			 }
		 }
		 //库存信息
		 enResourceOrgAmount = dbResourceOrgAmount.findByKey(orgId, resourceTypeId);
		 if(enResourceOrgAmount != null){
			 dbResourceOrgAmount.setToXml(requestXml, enResourceOrgAmount);
		 }
		 
	}
}
