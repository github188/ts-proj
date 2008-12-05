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
 * 功能概述：根据条件查询出所有施工已经完成需要确认的调度工单明细
 * 
 * @author 黄云敬 2008-10-17 上午10:18:07
 */
public class BoConsAckList implements RootBo {

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
		EnSysOrg enSysOrgIn;
		EnSysOrg enSysOrgDiff;
		DbResourceClass dbResourceClass;
		EnResourceClass enResourceClass;
		DbResourceType dbResourceType;
		EnResourceType enResourceType;
		Vector resourceIns;
		
		StringBuffer sql = new StringBuffer();
		StringBuffer sqlIn = new StringBuffer();
		
		//用户信息
		String userId;
		String orgId;
		
		//条件
		String sheetId; 				//调度单编号
		String inOrgId;					//调出单位
		String classId;					//资源类型	
		String classFlag;				//资源类型标志
		String prepareDateFrom;			//调度日期
		String prepareDateTo;
		String takeDateFrom;			//领取日期
		String takeDateTo;
		
		String consUserName;			//施工人
		String consFinDateFrom;			//施工完成日期
		String consFinDateTo;
		String takeUserName;			//领取人
		String inOperDateFrom;			//入库日期
		String inOperDateTo;
		
		
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		
		//获取用户信息
		userId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		orgId = sessionXml.getItemValue("SYS_USER", 1, "USER_ORG_ID");
		//获取条件
		sheetId = requestXml.getInputValue("SHEET_ID");
		inOrgId = requestXml.getInputValue("IN_ORG_ID");
		classId = requestXml.getInputValue("RESOURCE_CLASS_ID");
		classFlag = requestXml.getInputValue("RESOURCE_CLASS_FLAG");
		prepareDateFrom = requestXml.getInputValue("PREPARE_DATE_FROM");
		prepareDateTo = requestXml.getInputValue("PREPARE_DATE_TO");
		takeUserName = requestXml.getInputValue("TAKE_UESR_NAME");
		inOperDateFrom = requestXml.getInputValue("CONS_ACK_DATETIME_FROM");
		inOperDateTo = requestXml.getInputValue("CONS_ACK_DATETIME_TO");
		consUserName = requestXml.getInputValue("CONS_USER_NAME");
		takeDateFrom = requestXml.getInputValue("TAKE_DATE_FROM");
		takeDateTo = requestXml.getInputValue("TAKE_DATE_TO");
		consFinDateFrom = requestXml.getInputValue("CONS_FIN_DATE_FROM");
		consFinDateTo = requestXml.getInputValue("CONS_FIN_DATE_TO");
		
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
		if(prepareDateFrom != null && prepareDateFrom.length() > 0){
			if(sqlIn.toString().length() > 0){
				sqlIn.append(" and ");
			}
			sqlIn.append("PREPARE_DATE >= ");
			sqlIn.append(transaction.formatString(DateFunc.ParseDateTime(prepareDateFrom)));
		}
		if(prepareDateTo != null && prepareDateTo.length() > 0){
			if(sqlIn.toString().length() > 0){
				sqlIn.append(" and ");
			}
			sqlIn.append("PREPARE_DATE <= ");
			sqlIn.append(transaction.formatString(DateFunc.ParseDateTime(prepareDateTo)));
		}
		if(sheetId != null && sheetId.length() > 0){
			if(sql.toString().length() > 0){
				sql.append(" and ");
			}
			sql.append("SHEET_ID like '%");
			sql.append(sheetId);
			sql.append("%'");
		}
		if(inOrgId != null && inOrgId.length() > 0){
			if(sql.toString().length() > 0){
				sql.append(" and ");
			}
			sql.append("IN_ORG_ID = ");
			sql.append(inOrgId);
		}
		//判断查询条件是否为空，调入单位、调度单编号、调度日期中三项必须至少输入任意一项
		/*if(sqlIn.toString().length()== 0 && sql.toString().length() == 0){
			throw new ErrorException("CA0002",null);
		}*/
		if(orgId == null || orgId.length() == 0){
			throw new ErrorException("CA0001",null);
		}else{
			if(sql.toString().length() > 0){
				sql.append(" and ");
			}
			sql.append("LIST_STATUS = '5'");
		}
		if(classId != null && classId.length() > 0){
			if(classFlag != null && classFlag.length() > 0){
				if(sql.toString().length() > 0){
					sql.append(" and ");
				}
				if(classFlag.equals("C")){
					sql.append("RESOURCE_CLASS_ID = ");
				}else{
					sql.append("RESOURCE_TYPE_ID = ");
				}
				sql.append(transaction.formatString(classId));
			}
		}
		//领取人
		if(takeUserName != null && takeUserName.length() > 0){
			if(sql.toString().length() > 0){
				sql.append(" and ");
			}
			sql.append("TAKE_USER_NAME like '%");
			sql.append(takeUserName);
			sql.append("%'");
		}
		//领取日期
		if(takeDateFrom != null && takeDateFrom.length() > 0){
			if(sql.toString().length() > 0){
				sql.append(" and ");
			}
			sql.append(" TAKE_DATE >= ");
			sql.append(transaction.formatString(DateFunc.ParseDateTime(takeDateFrom)));
		}
		if(takeDateTo != null && takeDateTo.length() > 0){
			if(sql.toString().length() > 0){
				sql.append(" and ");
			}
			sql.append(" TAKE_DATE <= ");
			sql.append(transaction.formatString(DateFunc.ParseDateTime(takeDateTo)));
		}
		//入库日期
		if(inOperDateFrom != null && inOperDateFrom.length() > 0){
			if(sql.toString().length() > 0){
				sql.append(" and ");
			}
			sql.append("CONS_ACK_DATETIME >=");
			sql.append(transaction.formatString(DateFunc.ParseDateTime(inOperDateFrom))+"000000");
		}
		if(inOperDateTo != null && inOperDateTo.length() > 0){
			if(sql.toString().length() > 0){
				sql.append(" and ");
			}
			sql.append("CONS_ACK_DATETIME <=");
			sql.append(transaction.formatString(DateFunc.ParseDateTime(inOperDateTo))+"235959");
		}
		//施工人
		if(consUserName != null && consUserName.length() > 0){
			if(sql.toString().length() > 0){
				sql.append(" and ");
			}
			sql.append("CONS_USER_NAME like'%");
			sql.append(consUserName);
			sql.append("%'");
		}
		//施工完成日期
		if(consFinDateFrom != null && consFinDateFrom.length() > 0){
			if(sql.toString().length() > 0){
				sql.append(" and ");
			}
			sql.append("CONS_FIN_DATE >= ");
			sql.append(transaction.formatString(DateFunc.ParseDateTime(consFinDateFrom)));
		}
		if(consFinDateTo != null && consFinDateTo.length() > 0){
			if(sql.toString().length() > 0){
				sql.append(" and ");
			}
			sql.append("CONS_FIN_DATE <= ");
			sql.append(transaction.formatString(DateFunc.ParseDateTime(consFinDateTo)));
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
		if(resourceIns != null && resourceIns.size() > 0){
			for(int i = 0 ; i < resourceIns.size() ; i++){
				enResourcePrepareList = (EnResourcePrepareList) resourceIns.get(i);
				enResourcePrepareSheet = dbResourcePrepareSheet.findByKey(enResourcePrepareList.getSheetId());
				enResourceClass = dbResourceClass.findByKey(enResourcePrepareList.getResourceClassId());
				enResourceType = dbResourceType.findByKey(enResourcePrepareList.getResourceTypeId());
				String inStation;
				if(enResourcePrepareList.getInStationId() != null && enResourcePrepareList.getInStationId().length() > 0){
					enSysOrgIn = dbSysOrg.findByKey(enResourcePrepareList.getInStationId());
					inStation = enSysOrgIn.getOrgName();
				}else{
					inStation = "";
				}
				enSysOrgIn = dbSysOrg.findByKey(enResourcePrepareList.getInOrgId());
				int row = dbResourcePrepareList.setToXml(requestXml, enResourcePrepareList);
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "IN_ORG_NAME", enSysOrgIn.getOrgName());
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "IN_STATION_NAME", inStation);
				String outStation;
				if(enResourcePrepareList.getOutStationId() != null && enResourcePrepareList.getOutStationId().length() > 0){
					enSysOrgDiff = dbSysOrg.findByKey(enResourcePrepareList.getOutStationId());
					outStation = enSysOrgDiff.getOrgName();
				}else{
					outStation = "";
				}
				enSysOrgDiff = dbSysOrg.findByKey(enResourcePrepareList.getOutOrgId());
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "OUT_ORG_NAME", enSysOrgDiff.getOrgName());
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "OUT_STATION_NAME", outStation);
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "CLASS_NAME", enResourceClass.getClassName());
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "TYPE_NAME", enResourceType.getTypeName());
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "PREPARE_DATE", enResourcePrepareSheet.getPrepareDate());
			}
		}
	}
}
