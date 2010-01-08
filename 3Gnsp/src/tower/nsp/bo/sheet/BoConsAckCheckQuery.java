package tower.nsp.bo.sheet;

import org.apache.log4j.Logger;

import tower.nsp.db.DbSysOrg;
import tower.nsp.db.DbSysUser;
import tower.nsp.en.EnSysOrg;
import tower.nsp.en.EnSysUser;
import tower.tmvc.ErrorException;
import tower.tmvc.QueryResult;
import tower.tmvc.QueryResultRow;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 
 * 功能概述：根据工单明细ID查找出调度工单详细信息
 * 
 * @author 黄云敬 2008-10-17 上午10:18:27
 */
public class BoConsAckCheckQuery implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		// TODO Auto-generated method stub

		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		
		DbSysUser dbSysUser;
		EnSysUser enSysUser;
		DbSysOrg dbSysOrg;
		EnSysOrg enSysOrg;
		EnSysOrg enSysStation;
		
		QueryResult rs;
		QueryResultRow row;
		
		String listId;
		
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		
		listId = requestXml.getInputValue("LIST_ID");
		
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		
		transaction.createDefaultConnection(null, false);
		dbSysUser = new DbSysUser(transaction,null);
		dbSysOrg = new DbSysOrg(transaction,null);
		
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 
		if(listId != null && listId.length() > 0){
			String sql = "select org.* , rt.type_name,rc.class_name ,pre.prepare_date from " 
				+ "(SELECT r.*,inSta.org_name inSta ,outSta.org_name outSta ," 
				+ "inOrg.org_name inOrg, outOrg.org_name outOrg FROM nsp.resource_prepare_list r"
				+ " join nsp.sys_org outOrg on outOrg.org_id = r.out_org_id"
				+ " join nsp.sys_org inOrg on inOrg.org_id = r.in_org_id"
				+ " left join nsp.sys_org outSta on outSta.org_id = r.out_station_id"
				+ " left join nsp.sys_org inSta on inSta.org_id = r.in_station_id) org ,"
				+  " nsp.resource_class rc ,nsp.resource_type rt ,nsp.resource_prepare_sheet pre"
				+ " where org.resource_class_id = rc.class_id and"
				+ " rt.type_id = org.resource_type_id and pre.sheet_id = org.sheet_id and org.list_id = " 
				+ listId + ";";
			rs = transaction.doQuery(null, sql);
			if(rs != null && rs.size()> 0){
				row = rs.get(0);
				if(requestXml.getRowCount("RESOURCE_PREPARE_LIST") == 0){
					requestXml.addRow("RESOURCE_PREPARE_LIST");
				}
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", 1, "SHEET_ID", row.getString("SHEET_ID"));
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", 1, "LIST_ID", row.getString("LIST_ID"));
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", 1, "PREPARE_DATE", row.getString("prepare_date"));
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", 1, "AMOUNT_PREPARE", row.getString("AMOUNT_PREPARE"));
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", 1, "IN_ORG_NAME", row.getString("inOrg"));
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", 1, "OUT_ORG_NAME", row.getString("outOrg"));
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", 1, "OUT_STATION_NAME", row.getString("outSta"));
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", 1, "IN_STATION_NAME", row.getString("inSta"));
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", 1, "TYPE_NAME", row.getString("type_name"));
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", 1, "CLASS_NAME", row.getString("class_name"));
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", 1, "OUT_RESOURCE_STATUS", row.getString("OUT_RESOURCE_STATUS"));
				
				
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", 1, "TAKE_USER_NAME", row.getString("TAKE_USER_NAME"));
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", 1, "TAKE_DATE", row.getString("TAKE_DATE"));
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", 1, "OUT_OPER_DATETIME", row.getString("OUT_OPER_DATETIME"));
				enSysUser = dbSysUser.findByKey(row.getString("OUT_OPER_USERID"));
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", 1, "OUT_OPER_USER_NAME", enSysUser.getUserName());
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", 1, "IN_OPER_DATETIME", row.getString("IN_OPER_DATETIME"));
				enSysUser = dbSysUser.findByKey(row.getString("IN_OPER_USERID"));
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", 1, "IN_OPER_USER_NAME", enSysUser.getUserName());
			
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", 1, "AMOUNT_BEFORE_CONS", row.getString("AMOUNT_BEFORE_CONS"));
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", 1, "AMOUNT_FEED_BACK", row.getString("AMOUNT_FEED_BACK"));
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", 1, "AMOUNT_AFTER_CONS", row.getString("AMOUNT_AFTER_CONS"));
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", 1, "CONF_AMOUNT_AFTER_CONS", row.getString("CONF_AMOUNT_AFTER_CONS"));
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", 1, "AMOUNT_DIFF", row.getString("AMOUNT_DIFF"));
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", 1, "CONS_USER_NAME", row.getString("CONS_USER_NAME"));
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", 1, "CONS_FIN_DATE", row.getString("CONS_FIN_DATE"));
				enSysOrg = dbSysOrg.findByKey(row.getString("DIFF_IN_ORG_ID"));
				enSysStation = dbSysOrg.findByKey(row.getString("DIFF_IN_STATION_ID"));
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", 1, "DIFF_IN_ORG_NAME",enSysOrg.getOrgName());
				if(enSysStation != null){
					requestXml.setItemValue("RESOURCE_PREPARE_LIST", 1, "DIFF_IN_STATION_NAME", enSysStation.getOrgName());
				}else{
					requestXml.setItemValue("RESOURCE_PREPARE_LIST", 1, "DIFF_IN_STATION_NAME", "");
				}
				enSysUser = dbSysUser.findByKey(row.getString("CONS_FIN_OPER_USERID"));
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", 1, "CONS_FIN_OPER_USER_NAME", enSysUser.getUserName());
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", 1, "CONS_FIN_OPER_DATETIME", row.getString("CONS_FIN_OPER_DATETIME"));
				
			}else{
				throw new ErrorException("CA0006",null);
			}
		}else{
			throw new ErrorException("CA0004",null);
		}
	}

}
