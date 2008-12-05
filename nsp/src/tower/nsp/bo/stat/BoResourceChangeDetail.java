package tower.nsp.bo.stat;

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
/**
 * 
 *功能概述：坏件调换
 * @author fanlj 2008-11-4  上午10:08:26
 */
public class BoResourceChangeDetail implements RootBo{

	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//资源库存db en
		DbResourceOrgAmount dbResourceOrgAmount;
		EnResourceOrgAmount enResourceOrgAmount;
		
		//机构db en
		DbSysOrg dbSysOrg;
		EnSysOrg enSysOrg;
		
		//资源类型db en
		DbResourceType dbResourceType;
		EnResourceType enResourceType;
		
		//资源类别db en
		DbResourceClass dbResourceClass;
		EnResourceClass enResourceTClass;
		
		//获取输入
		String orgId;
		String resourceTypeId;
		
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		orgId = requestXml.getInputValue("ORG_ID");
		resourceTypeId = requestXml.getInputValue("RESOURCE_TYPE_ID");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		dbResourceOrgAmount = new DbResourceOrgAmount(transaction,null);
		dbSysOrg = new DbSysOrg(transaction,null);
		dbResourceType = new DbResourceType(transaction,null);
		dbResourceClass = new DbResourceClass(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		//根据机构ID，取得机构信息.
		 enSysOrg = dbSysOrg.findByKey(orgId);
		int row1 = dbSysOrg.setToXml(requestXml, enSysOrg);
		 enSysOrg = dbSysOrg.findByKey(enSysOrg.getParentId());
		 if(enSysOrg != null){
			 requestXml.setItemValue("SYS_ORG", row1, "PARENT_ORG_NAME", enSysOrg.getOrgName());
		 }
		 
		 //根据机构ID和资源型号ID获取该机构该资源的配置信息
		 enResourceOrgAmount = dbResourceOrgAmount.findByKey(orgId, resourceTypeId);
		 if(enResourceOrgAmount != null){
			 int row2 = dbResourceOrgAmount.setToXml(requestXml, enResourceOrgAmount);
			 enSysOrg = dbSysOrg.findByKey(enResourceOrgAmount.getOrgId());
			 if(enSysOrg != null){
			 	requestXml.setItemValue("RESOURCE_ORG_AMOUNT", row2, "ORG_NAME", enSysOrg.getOrgName());
			 }
			 enResourceType = dbResourceType.findByKey(resourceTypeId);
			 if(enResourceType != null){
				 	requestXml.setItemValue("RESOURCE_ORG_AMOUNT", row2, "TYPE_NAME", enResourceType.getTypeName());
			 }
			 enResourceTClass = dbResourceClass.findByKey(enResourceType.getResourceClassId());
			 if(enResourceTClass != null){
				 	requestXml.setItemValue("RESOURCE_ORG_AMOUNT", row2, "CLASS_NAME", enResourceTClass.getClassName());
			 }
			 
		 }
	}

}
