package tower.nsp.bo.stat;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.common.util.Page;
import tower.common.util.PubFunc;
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

public class AmountStatEveryList implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		// TODO Auto-generated method stub

		DbResourceType dbResourceType;
		EnResourceType enResourceType;
		DbResourceClass dbResourceClass;
		EnResourceClass enResourceClass;
		
		String typeId;
		String orgId;
		//统计字段标志1、为在线数量2、为库存数量3、施工占用数量4、为坏件数量
		String amountFlag;
		
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, true);
		dbResourceType = new DbResourceType(transaction, null);
		dbResourceClass = new DbResourceClass(transaction, null);
		
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		
		orgId = requestXml.getInputValue("ORG_ID");
		typeId = requestXml.getInputValue("TYPE_ID");
		amountFlag = requestXml.getInputValue("AMOUNT_FLAG");
		
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		if(amountFlag != null && amountFlag.length() > 0){
			String className = "";
			String typeName = "";
			if(typeId != null && typeId.length() > 0){
				enResourceType = dbResourceType.findByKey(typeId);
				enResourceClass = dbResourceClass.findByKey(enResourceType.getResourceClassId());
				if(enResourceType != null){
					typeName = enResourceType.getTypeName();
				}
				if(enResourceClass != null){
					className = enResourceClass.getClassName();
				}
			}
			if(requestXml.getRowCount("LIST_EVERY_NAME") == 0){
				requestXml.addRow("LIST_EVERY_NAME");
			}
			requestXml.setItemValue("LIST_EVERY_NAME", 1, "TYPE_NAME", typeName);
			requestXml.setItemValue("LIST_EVERY_NAME", 1, "CLASS_NAME", className);
			//根据统计字段标志存放在页面上显示的内容，以及获取那个字段的值
			if(amountFlag.equals("1")){
				//根据条件向requestXml对象中存放数据
				result(transaction,requestXml,"ONLINE_AMOUNT",orgId,typeId);
				requestXml.setItemValue("LIST_EVERY_NAME", 1, "HD_TITLE", "ONLINE_AMOUNT");
				requestXml.setItemValue("LIST_EVERY_NAME", 1, "HR_TITLE", "在线数量");
			}
			if(amountFlag.equals("2")){
				result(transaction,requestXml,"STOCK_AMOUNT",orgId,typeId);
				requestXml.setItemValue("LIST_EVERY_NAME", 1, "HD_TITLE", "STOCK_AMOUNT");
				requestXml.setItemValue("LIST_EVERY_NAME", 1, "HR_TITLE", "库存数量");
			}
			if(amountFlag.equals("3")){
				result(transaction,requestXml,"INCONS_AMOUNT",orgId,typeId);
				requestXml.setItemValue("LIST_EVERY_NAME", 1, "HD_TITLE", "INCONS_AMOUNT");
				requestXml.setItemValue("LIST_EVERY_NAME", 1, "HR_TITLE", "施工占用");
			}
			if(amountFlag.equals("4")){
				result(transaction,requestXml,"BAD_AMOUNT",orgId,typeId);
				requestXml.setItemValue("LIST_EVERY_NAME", 1, "HD_TITLE", "BAD_AMOUNT");
				requestXml.setItemValue("LIST_EVERY_NAME", 1, "HR_TITLE", "坏件数量");
			}
		}
	}
	/**
	 * 根据机构、类型、字段名统计出某个机构某个类型下对应的字段的值并存放到requestXml对象中，供页面读取
	 * @param transaction
	 * @param requestXml
	 * @param name 查询的字段名
	 * @param orgId 机构名称
	 * @param typeId 型号名称
	 * @throws ErrorException
	 */
	public void result(Transaction transaction, XMLWrap requestXml,
			String name,String orgId,String typeId) throws ErrorException{
		
		DbSysOrg dbSysOrg;
		EnSysOrg enSysOrg;
		Vector sysOrgs;
		
		DbResourceOrgAmount dbResourceOrgAmount;
		EnResourceOrgAmount enResourceOrgAmount;
		Vector amounts;
		
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, true);
		dbSysOrg = new DbSysOrg(transaction, null);
		dbResourceOrgAmount = new DbResourceOrgAmount(transaction, null);
		
		enSysOrg = dbSysOrg.findByKey(orgId);
		StringBuffer sql = new StringBuffer();
		StringBuffer sqlIn = new StringBuffer();
		StringBuffer sqlOrgIn = new StringBuffer();
		/*SELECT * FROM nsp.resource_org_amount r where org_id
		in(select org_id from nsp.sys_org where parent_id = "000003") or org_id = "000003";
		*/
		if(enSysOrg.getParentId() != null && enSysOrg.getParentId().length() > 0){
			sqlIn = new StringBuffer();
			sqlOrgIn = new StringBuffer();
			sqlIn.append(" select org_id from sys_org where parent_id = ");
			sqlIn.append(enSysOrg.getOrgId());
			sqlOrgIn.append(" = '");
			sqlOrgIn.append(enSysOrg.getOrgId());
			sqlOrgIn.append("'");
		}else{
			sqlIn = new StringBuffer();
			sqlOrgIn = new StringBuffer();
			sysOrgs = dbSysOrg.findAllWhere(" parent_id = '" + enSysOrg.getOrgId() + "'");
			sqlOrgIn.append("in ('");
			if(sysOrgs != null && sysOrgs.size() > 0){
				for(int i = 0 ; i < sysOrgs.size() ; i++){
					enSysOrg = (EnSysOrg) sysOrgs.get(i);
					sqlOrgIn.append(enSysOrg.getOrgId());
					sqlOrgIn.append("','");
				}
			}
			sqlOrgIn.append("')");
			sqlIn.append(" select org_id from sys_org where parent_id ");
			sqlIn.append(sqlOrgIn.toString());
		}
		if(name != null && name.length() > 0 && typeId != null && typeId.length() > 0){
			sql.append(" resource_type_id = ");
			sql.append(transaction.formatString(typeId));
			sql.append(" and ");
			sql.append(name);
			sql.append(" > 0 ");
			sql.append(" and (org_id in (");
			sql.append(sqlIn.toString());
			sql.append(")");
			sql.append(" or org_id ");
			sql.append(sqlOrgIn.toString());
			sql.append(")");
		}
		Page.SetPageInfo(transaction, null, requestXml, dbResourceOrgAmount,
				PubFunc.LEN_PAGE_COUNT, "RESOURCE_ORG_AMOUNT", sql.toString());
		amounts = dbResourceOrgAmount.findAllWhere(sql.toString());
		if(amounts != null && amounts.size() > 0){
			for(int j = 0 ; j < amounts.size() ; j ++){
				enResourceOrgAmount = (EnResourceOrgAmount) amounts.get(j);
				int row = dbResourceOrgAmount.setToXml(requestXml, enResourceOrgAmount);
				enSysOrg = dbSysOrg.findByKey(enResourceOrgAmount.getOrgId());
				requestXml.setItemValue("RESOURCE_ORG_AMOUNT", row, "ORG_NAME", enSysOrg.getOrgName());
				enSysOrg = dbSysOrg.findByKey(enSysOrg.getParentId());
				requestXml.setItemValue("RESOURCE_ORG_AMOUNT", row, "ORG_PARENT_NAME", enSysOrg.getOrgName());
			}
		}
		
	}

}
