package tower.nsp.bo.sheet;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.common.util.DateFunc;
import tower.common.util.Page;
import tower.common.util.PubFunc;
import tower.nsp.db.DbResourceClass;
import tower.nsp.db.DbResourcePrepareList;
import tower.nsp.db.DbResourcePrepareSheet;
import tower.nsp.db.DbResourceType;
import tower.nsp.db.DbSysOrg;
import tower.nsp.en.EnResourceClass;
import tower.nsp.en.EnResourcePrepareList;
import tower.nsp.en.EnResourcePrepareSheet;
import tower.nsp.en.EnResourceType;
import tower.nsp.en.EnSysOrg;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 
 * 功能概述：调度入库列表查询
 * 
 * @author 黄云敬 2008-10-16 下午05:22:01
 */
public class BoResourceInList implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		// TODO Auto-generated method stub

		/***********************************************************************
		 * 声明变量
		 **********************************************************************/

		DbResourcePrepareList dbResourcePrepareList;
		EnResourcePrepareList enResourcePrepareList;
		DbResourcePrepareSheet dbResourcePrepareSheet;
		EnResourcePrepareSheet enResourcePrepareSheet;
		DbSysOrg dbSysOrg;
		EnSysOrg enSysOrg;
		EnSysOrg enSysOrgP;
		DbResourceClass dbResourceClass;
		EnResourceClass enResourceClass;
		DbResourceType dbResourceType;
		EnResourceType enResourceType;
		Vector resourceIns;

		StringBuffer sql = new StringBuffer();
		StringBuffer sqlIn = new StringBuffer();

		// 用户信息
		String orgId;

		// 条件
		String sheetId; // 调度单编号
		String outOrgId; // 调入单位
		String classId; // 资源类型
		String classFlag; // 资源类型标志
		String prepareDateFrom; // 调度日期
		String prepareDateTo;
		String takeUserName; // 领取人
		String takeDateFrom; // 领取日期
		String takeDateTo;

		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		// 获取用户信息
		orgId = sessionXml.getItemValue("SYS_USER", 1, "USER_ORG_ID");
		// 获取条件
		sheetId = requestXml.getInputValue("SHEET_ID");
		outOrgId = requestXml.getInputValue("ORG_ID");
		classId = requestXml.getInputValue("RESOURCE_CLASS_ID");
		classFlag = requestXml.getInputValue("RESOURCE_CLASS_FLAG");
		prepareDateFrom = requestXml.getInputValue("PREPARE_DATE_FROM");
		prepareDateTo = requestXml.getInputValue("PREPARE_DATE_TO");
		takeUserName = requestXml.getInputValue("TAKE_UESR_NAME");
		takeDateFrom = requestXml.getInputValue("TAKE_DATE_FROM");
		takeDateTo = requestXml.getInputValue("TAKE_DATE_TO");

		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/

		transaction.createDefaultConnection(null, true);
		dbResourcePrepareList = new DbResourcePrepareList(transaction, null);
		dbResourcePrepareSheet = new DbResourcePrepareSheet(transaction, null);
		dbSysOrg = new DbSysOrg(transaction,null);
		dbResourceClass = new DbResourceClass(transaction,null);
		dbResourceType = new DbResourceType(transaction,null);

		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/

		if (prepareDateFrom != null && prepareDateFrom.length() > 0) {
			if(sqlIn.toString().length() > 0){
				sqlIn.append(" and ");
			}
			sqlIn.append("PREPARE_DATE >= ");
			sqlIn.append(Transaction.formatString(DateFunc.ParseDateTime(prepareDateFrom)));
		}
		if (prepareDateTo != null && prepareDateTo.length() > 0) {
			if(sqlIn.toString().length() > 0){
				sqlIn.append(" and ");
			}
			sqlIn.append("PREPARE_DATE <= ");
			sqlIn.append(Transaction.formatString(DateFunc.ParseDateTime(prepareDateTo)));
		}
		if (sheetId != null && sheetId.length() > 0) {
			if(sql.toString().length() > 0){
				sql.append(" and ");
			}
			sql.append("SHEET_ID like '%");
			sql.append(sheetId);
			sql.append("%'");
		}
		if (outOrgId != null && outOrgId.length() > 0) {
			if(sql.toString().length() > 0){
				sql.append(" and ");
			}
			sql.append("OUT_ORG_ID = ");
			sql.append(Transaction.formatString(outOrgId));
		}
		// 判断查询条件是否为空，调入单位、调度单编号、调度日期中三项必须至少输入任意一项
		/*if (sqlIn.toString().length() == 0 && sql.toString().length() == 0) {
			throw new ErrorException("RI0002", null);
		}*/
		if (orgId == null || orgId.length() == 0) {
			throw new ErrorException("RI0001", null);
		} else {
			if(sql.toString().length() > 0){
				sql.append(" and ");
			}
			sql.append("LIST_STATUS = '3' and ");
			sql.append("IN_ORG_ID = ");
			sql.append(Transaction.formatString(orgId));

		}
		if (classId != null && classId.length() > 0) {
			if(classFlag != null && classFlag.length() > 0){
				if(sql.toString().length() > 0){
					sql.append(" and ");
				}
				if(classFlag.equals("C")){
					sql.append("RESOURCE_CLASS_ID = ");
				}else{
					sql.append("RESOURCE_TYPE_ID = ");
				}
				sql.append(Transaction.formatString(classId));
			}
		}
		if (takeUserName != null && takeUserName.length() > 0) {
			if(sql.toString().length() > 0){
				sql.append(" and ");
			}
			sql.append("TAKE_USER_NAME like '%");
			sql.append(takeUserName);
			sql.append("%'");
		}
		if (takeDateFrom != null && takeDateFrom.length() > 0) {
			if(sql.toString().length() > 0){
				sql.append(" and ");
			}
			sql.append("TAKE_DATE >=");
			sql.append(Transaction.formatString(DateFunc.ParseDateTime(takeDateFrom)));
		}
		if (takeDateTo != null && takeDateTo.length() > 0) {
			if(sql.toString().length() > 0){
				sql.append(" and ");
			}
			sql.append("TAKE_DATE <=");
			sql.append(Transaction.formatString(DateFunc.ParseDateTime(takeDateTo)));
		}
		if (sqlIn.toString().length() > 0) {
			if(sql.toString().length() > 0){
				sql.append(" and ");
			}
			sql.append("SHEET_ID in (");
			sql.append("select SHEET_ID from RESOURCE_PREPARE_SHEET where ");
			sql.append(sqlIn.toString());
			sql.append(")");
		}
		Page.SetPageInfo(transaction, null, requestXml, dbResourcePrepareList,
				PubFunc.LEN_PAGE_COUNT, "RESOURCE_PREPARE_LIST", sql.toString());
		resourceIns = dbResourcePrepareList.findAllWhere(sql.toString());
		if (resourceIns != null && resourceIns.size() > 0) {
			for (int i = 0; i < resourceIns.size(); i++) {
				enResourcePrepareList = (EnResourcePrepareList) resourceIns
						.get(i);
				enResourcePrepareSheet = dbResourcePrepareSheet.findByKey(enResourcePrepareList.getSheetId());
				enResourceClass = dbResourceClass.findByKey(enResourcePrepareList.getResourceClassId());
				enResourceType = dbResourceType.findByKey(enResourcePrepareList.getResourceTypeId());
				enSysOrg = dbSysOrg.findByKey(enResourcePrepareList.getOutOrgId());
				String outStation ;
				if(enResourcePrepareList.getOutStationId() != null && enResourcePrepareList.getOutStationId().length() > 0){
					enSysOrgP = dbSysOrg.findByKey(enResourcePrepareList.getOutStationId());
					outStation = enSysOrgP.getOrgName();
				}else{
					outStation = "";
				}
				int row = dbResourcePrepareList.setToXml(requestXml, enResourcePrepareList);
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "OUT_ORG_NAME", enSysOrg.getOrgName());
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "OUT_STATION_NAME", outStation);
				enSysOrg = dbSysOrg.findByKey(enResourcePrepareList.getInOrgId());
				String inStation ;
				if(enResourcePrepareList.getInStationId() != null && enResourcePrepareList.getInStationId().length() > 0){
					enSysOrgP = dbSysOrg.findByKey(enResourcePrepareList.getInStationId());
					inStation = enSysOrgP.getOrgName();
				}else{
					inStation = "";
				}
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "IN_ORG_NAME", enSysOrg.getOrgName());
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "IN_STATION_NAME", inStation);
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "CLASS_NAME", enResourceClass.getClassName());
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "TYPE_NAME", enResourceType.getTypeName());
				if(enResourcePrepareSheet != null){
					requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "PREPARE_DATE", DateFunc.FormatDateTime(enResourcePrepareSheet.getPrepareDate()));
				}else{
					requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "PREPARE_DATE","");
				}
			}
		}
	}

}
