package tower.nsp.bo.stat;

import org.apache.log4j.Logger;

import tower.nsp.db.DbSysOrg;
import tower.nsp.en.EnSysOrg;
import tower.tmvc.ErrorException;
import tower.tmvc.QueryResult;
import tower.tmvc.QueryResultRow;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
/**
 * 
 * 功能概述：库存统计详细
 * 
 * @author 黄云敬 
 */
public class BoAmountEveryList implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		// TODO Auto-generated method stub

		DbSysOrg dbSysOrg;
		EnSysOrg enSysOrg;
		
		QueryResult rsAmount;
		QueryResultRow rowAmount;
		
		String typeId;
		String orgId;
		
		String className="";
		String typeName="";

		/*****************************************************************************************************
		 * 创建数据库连接、实例化DB、EN
		 ****************************************************************************************************/
		transaction.createDefaultConnection(null, true);
		dbSysOrg = new DbSysOrg(transaction,null);

		/*****************************************************************************************************
		 * 获取输入
		 ****************************************************************************************************/

		orgId = requestXml.getInputValue("ORG_ID");
		typeId = requestXml.getInputValue("TYPE_ID");

		/*****************************************************************************************************
		 * 执行业务逻辑、输出
		 ****************************************************************************************************/
		if(orgId != null && orgId.length() > 0 && typeId != null && typeId.length() > 0){
			//保存参数
			if(requestXml.getRowCount("STAT_LIST_EVERY") == 0 ){
				requestXml.addRow("STAT_LIST_EVERY");
			}
			requestXml.setItemValue("STAT_LIST_EVERY", 1, "STAT_ORG_ID", orgId);
			requestXml.setItemValue("STAT_LIST_EVERY", 1, "STAT_TYPE_ID", typeId);
			
			
			//获取资源信息类别名称、型号名称
			String classSql = "SELECT * FROM resource_type r ,resource_class s where" +
					" r.resource_class_id = s.class_id and r.type_id='"+ typeId+"'";
			rsAmount = transaction.doQuery(null,classSql);
			if(rsAmount != null){
				rowAmount = rsAmount.get(0);
				if(rowAmount != null){
					className = rowAmount.getString("class_name");
					typeName = rowAmount.getString("type_name");
				}
			}
			System.out.println(className+typeName);
			requestXml.setItemValue("STAT_LIST_EVERY", 1, "CLASS_NAME", className);
			requestXml.setItemValue("STAT_LIST_EVERY", 1, "TYPE_NAME", typeName);
			
			System.out.println("className"+requestXml.getItemValue("STAT_LIST_EVERY", 1, "CLASS_NAME"));
			System.out.println("typeName"+requestXml.getItemValue("STAT_LIST_EVERY", 1, "TYPE_NAME"));
			
			enSysOrg = dbSysOrg.findByKey(orgId);
			//根据公司的父节点判断该公司是分公司还是总公司
			if(enSysOrg.getParentId() != null && enSysOrg.getParentId().length() > 0){
				//获取摸个型号的库存、在线、坏件数量
				String sql = "SELECT * FROM resource_org_amount r,sys_org s  where r.org_id = s.org_id and " +
						"( s.org_id = '" + orgId +"' or s.parent_id = '"+
						orgId + "')";
				rsAmount = transaction.doQuery(null,sql);
				if(rsAmount != null){
					for(int i = 0 ; i < rsAmount.size() ; i++){
						rowAmount = rsAmount.get(i);
						if(rowAmount != null){
							int row = requestXml.addRow("AMOUNT_STAT_LIST");
							enSysOrg = dbSysOrg.findByKey(rowAmount.getString("PARENT_ID"));
							requestXml.setItemValue("AMOUNT_STAT_LIST", row, "SYS_PARENTORG_NAME", enSysOrg.getOrgName());
							requestXml.setItemValue("AMOUNT_STAT_LIST", row, "SYS_ORG_NAME", rowAmount.getString("ORG_NAME"));
							requestXml.setItemValue("AMOUNT_STAT_LIST", row, "STOCK_AMOUNT", rowAmount.getString("STOCK_AMOUNT"));
							requestXml.setItemValue("AMOUNT_STAT_LIST", row, "INCONS_AMOUNT", rowAmount.getString("INCONS_AMOUNT"));
							requestXml.setItemValue("AMOUNT_STAT_LIST", row, "BAD_AMOUNT", rowAmount.getString("BAD_AMOUNT"));
							long all =  Long.parseLong(rowAmount.getString("BAD_AMOUNT"))
								+Long.parseLong(rowAmount.getString("INCONS_AMOUNT"))
								+Long.parseLong(rowAmount.getString("STOCK_AMOUNT"));
							requestXml.setItemValue("AMOUNT_STAT_LIST", row, "ALL_AMOUNT",String.valueOf(all));
						}
					}
				}
			}else{
				//获取摸个型号的库存、在线、坏件数量
				String sql = "SELECT * FROM resource_org_amount r,sys_org s  where r.org_id = s.org_id ";
				rsAmount = transaction.doQuery(null,sql);
				if(rsAmount != null){
					for(int i = 0 ; i < rsAmount.size() ; i++){
						rowAmount = rsAmount.get(i);
						if(rowAmount != null){
							int row = requestXml.addRow("AMOUNT_STAT_LIST");
							enSysOrg = dbSysOrg.findByKey(rowAmount.getString("PARENT_ID"));
							requestXml.setItemValue("AMOUNT_STAT_LIST", row, "SYS_PARENTORG_NAME", enSysOrg.getOrgName());
							requestXml.setItemValue("AMOUNT_STAT_LIST", row, "SYS_ORG_NAME", rowAmount.getString("ORG_NAME"));
							requestXml.setItemValue("AMOUNT_STAT_LIST", row, "STOCK_AMOUNT", rowAmount.getString("STOCK_AMOUNT"));
							requestXml.setItemValue("AMOUNT_STAT_LIST", row, "INCONS_AMOUNT", rowAmount.getString("INCONS_AMOUNT"));
							requestXml.setItemValue("AMOUNT_STAT_LIST", row, "BAD_AMOUNT", rowAmount.getString("BAD_AMOUNT"));
							long all =  Long.parseLong(rowAmount.getString("BAD_AMOUNT"))
								+Long.parseLong(rowAmount.getString("INCONS_AMOUNT"))
								+Long.parseLong(rowAmount.getString("STOCK_AMOUNT"));
							requestXml.setItemValue("AMOUNT_STAT_LIST", row, "ALL_AMOUNT",String.valueOf(all));
						}
					}
				}
			}
		}
	}
}
