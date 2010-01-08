package tower.nsp.bo.sheet;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.common.util.DateFunc;
import tower.common.util.Page;
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
import tower.common.util.PubFunc;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 
 * 功能概述：根据查询条件查询出列表内容
 * 
 * @author 黄云敬 2008-10-16 下午05:19:57
 */
public class BoResourceOutList implements RootBo {

	
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
		Vector resourceOuts;
		
		String orgId;				//用户所属机构
		
		String sheetId;				//调度单编号
		String inOrgId;				//调入单位
		String classId;				//资源类型	
		String classFlag;			//资源类型标志
		String prepareDateFrom;		//调度日期
		String prepareDateTo;
		
		StringBuffer sql = new StringBuffer();
		StringBuffer sqlIn = new StringBuffer();
		
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		
		orgId = sessionXml.getItemValue("SYS_USER", 1, "USER_ORG_ID");
		
		sheetId = requestXml.getInputValue("QSHEET_ID");
		inOrgId = requestXml.getInputValue("QIN_ORG_ID");
		classId = requestXml.getInputValue("QRESOURCE_CLASS_ID");
		classFlag = requestXml.getInputValue("QRESOURCE_CLASS_FLAG");
		prepareDateFrom = requestXml.getInputValue("QPREPARE_DATE_FROM");
		prepareDateTo = requestXml.getInputValue("QPREPARE_DATE_TO");
		
		
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		
		transaction.createDefaultConnection(null, true);
		dbResourcePrepareList = new DbResourcePrepareList(transaction,null);
		dbResourcePrepareSheet = new DbResourcePrepareSheet(transaction,null);
		dbSysOrg = new DbSysOrg(transaction,null);
		dbResourceClass = new DbResourceClass(transaction,null);
		dbResourceType = new DbResourceType(transaction,null);
		
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		
		//判断条件：调度日期开始、截止
		if(prepareDateFrom != null && prepareDateFrom.length() > 0){
			sqlIn.append("PREPARE_DATE >= ");
			sqlIn.append(Transaction.formatString(DateFunc.ParseDateTime(prepareDateFrom)));
		}
		if(prepareDateTo != null && prepareDateTo.length() > 0){
			if(sqlIn.toString().length() > 0){
				sqlIn.append(" and ");
			}
			sqlIn.append("PREPARE_DATE <= ");
			sqlIn.append(Transaction.formatString(DateFunc.ParseDateTime(prepareDateTo)));
		}
		//判断条件：调度单编号
		if(sheetId != null && sheetId.length() > 0){
			if(sql.toString().length() > 0){
				sql.append(" and ");
			}
			sql.append("SHEET_ID like'%");
			sql.append(sheetId);
			sql.append("%'");
		}
		if(inOrgId != null && inOrgId.length() > 0){
			if(sql.toString().length() > 0){
				sql.append(" and ");
			}
			sql.append("IN_ORG_ID = ");
			sql.append(Transaction.formatString(inOrgId));
		}
		//判断查询条件是否为空，调入单位、调度单编号、调度日期中三项必须至少输入任意一项
		/*if(sqlIn.toString().length()== 0 && sql.toString().length() == 0){
			throw new ErrorException("RO0006",null);
		}*/
		//若果获取机构Id为空则抛出异常
		if(orgId == null || orgId.length() == 0){
			throw new ErrorException("RO0001",null);
		}else{
			if(sql.toString().length() > 0){
				sql.append(" and ");
			}
			sql.append("LIST_STATUS = '2' and ");
			sql.append("OUT_ORG_ID = ");
			sql.append(Transaction.formatString(orgId));
		}
		//判断条件：资源类型
		if(classId != null && classId.length() > 0){
			//判断资源类型标志，如果标志为C则根据类别进行查询其余按照型号查询
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
		if(sqlIn.toString().length() > 0){
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
		resourceOuts = dbResourcePrepareList.findAllWhere(sql.toString());
		if(resourceOuts != null && resourceOuts.size() > 0){
			for(int i = 0 ; i < resourceOuts.size() ; i++){
				enResourcePrepareList = (EnResourcePrepareList) resourceOuts.get(i);
				enResourcePrepareSheet = dbResourcePrepareSheet.findByKey(enResourcePrepareList.getSheetId());
				enResourceClass = dbResourceClass.findByKey(enResourcePrepareList.getResourceClassId());
				enResourceType = dbResourceType.findByKey(enResourcePrepareList.getResourceTypeId());
				enSysOrg = dbSysOrg.findByKey(enResourcePrepareList.getInOrgId());
				//根据调入基站是否为空显示调入基站的机构名称
				String inStation ;
				if(enResourcePrepareList.getInStationId() != null && enResourcePrepareList.getInStationId().length() > 0){
					enSysOrgP = dbSysOrg.findByKey(enResourcePrepareList.getInStationId());
					inStation = enSysOrgP.getOrgName();
				}else{
					inStation = "";
				}
				int row = dbResourcePrepareList.setToXml(requestXml, enResourcePrepareList);
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "IN_ORG_NAME", enSysOrg.getOrgName());
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "IN_STATION_NAME", inStation);
				String outStation ;
				if(enResourcePrepareList.getOutStationId() != null && enResourcePrepareList.getOutStationId().length() > 0){
					enSysOrgP = dbSysOrg.findByKey(enResourcePrepareList.getOutStationId());
					outStation = enSysOrgP.getOrgName();
				}else{
					outStation = "";
				}
				enSysOrg = dbSysOrg.findByKey(enResourcePrepareList.getOutOrgId());
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "OUT_ORG_NAME", enSysOrg.getOrgName());
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "OUT_STATION_NAME", outStation);
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "CLASS_NAME", enResourceClass.getClassName());
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "TYPE_NAME", enResourceType.getTypeName());
				if(enResourcePrepareSheet != null){
					requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "PREPARE_DATE", DateFunc.FormatDateTime(enResourcePrepareSheet.getPrepareDate()));
				}else{
					requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "PREPARE_DATE", "");
				}
			}
		}
	}

}
