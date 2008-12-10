package tower.nsp.bo.desktop;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.nsp.db.DbResourceClass;
import tower.nsp.db.DbResourcePrepareList;
import tower.nsp.db.DbResourcePrepareSheet;
import tower.nsp.db.DbSysOrg;
import tower.nsp.en.EnResourceClass;
import tower.nsp.en.EnResourcePrepareList;
import tower.nsp.en.EnResourcePrepareSheet;
import tower.nsp.en.EnSysOrg;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
/**
 * 
 *功能概述：获取等待：接收、出库、入库、施工确认的工单。
 * @author fanlj 2008-10-16  下午04:37:08
 */
public class BoSheetRemindList implements RootBo {

	@SuppressWarnings({ "static-access", "unchecked" })
	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
        /***********************************************************************
		 * 声明变量
		 **********************************************************************/
		// 调度工单明细db en
		DbResourcePrepareList dbResourcePrepareList;
		EnResourcePrepareList enResourcePrepareList;
		
		// 调度工单db en
		DbResourcePrepareSheet dbResourcePrepareSheet;
		EnResourcePrepareSheet enResourcePrepareSheet;
		
		//资源类别的db、en
		DbResourceClass dbResourceClass;
		EnResourceClass enResourceClass;
		
		//机构 db,en
		DbSysOrg dbOrg;
		EnSysOrg enOrg;
		
		//获取参数：当前用户所属机构ID；
		 String userOrgId;
		 
		 //其他
		 StringBuffer sqlWhere;
		 Vector recList;
		 Vector inList;
		 Vector outList;
		 Vector checkList;
		 Vector vector = new Vector();
		 
		 /***********************************************************************
		 * 获取输入
		 **********************************************************************/
		 userOrgId = sessionXml.getItemValue("SYS_USER", 1, "USER_ORG_ID");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		 dbResourcePrepareList = new DbResourcePrepareList(transaction, null);
		 dbResourceClass = new DbResourceClass(transaction, null);
		 dbResourcePrepareSheet = new DbResourcePrepareSheet(transaction,null);
		 dbOrg = new DbSysOrg(transaction, null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 //检查用户所属机构ID是否为空，如果为空则抛出异常DL0100;
		 if(userOrgId == null || userOrgId.length() ==0){
			 throw new ErrorException("DL0100",null);
		 }
		 //1)等待接收的工单：“工单明细状态(LIST_STATUS)”为“下发”的“调入单位(IN_ORG_ID)”是本机构的工单信息。
		 sqlWhere = new StringBuffer();
		 sqlWhere.append(" LIST_STATUS='1'");
		 sqlWhere.append(" AND IN_ORG_ID=");
		 sqlWhere.append(transaction.formatString(userOrgId));
		 recList = dbResourcePrepareList.findAllWhere(sqlWhere.toString());
		 vector.addAll(recList);
		 
		 //2) 等待出库单的工单： “工单明细状态(LIST_STATUS)”为“已接收”的“调出单位(OUT_ORG_ID)”是本机构的工单信息。
		 sqlWhere = new StringBuffer();
		 sqlWhere.append(" LIST_STATUS=2");
		 sqlWhere.append(" AND OUT_ORG_ID=");
		 sqlWhere.append(transaction.formatString(userOrgId));
		 outList = dbResourcePrepareList.findAllWhere(sqlWhere.toString());
		 vector.addAll(outList);
		 
		 //3)等待入库的工单：“工单明细状态(LIST_STATUS)”为“已出库”的“调入单位(IN_ORG_ID)”是本机构的工单信息。
		 sqlWhere = new StringBuffer();
		 sqlWhere.append(" LIST_STATUS=3");
		 sqlWhere.append(" AND IN_ORG_ID=");
		 sqlWhere.append(transaction.formatString(userOrgId));
		 inList = dbResourcePrepareList.findAllWhere(sqlWhere.toString());
		 vector.addAll(inList);
		 
		 // 4)等待施工确认的工单：“工单明细状态(LIST_STATUS)”为“已完工”的“调入单位(OUT_ORG_ID)”是本机构的下级机构的工单信息
		 //当前用户所在机构的下级机构
		 enOrg = dbOrg.findByKey(userOrgId);
		 if(enOrg != null && (enOrg.getParentId()==null || enOrg.getParentId().length()==0)){
			 sqlWhere = new StringBuffer();
			 sqlWhere.append(" LIST_STATUS='5'");
			 checkList = dbResourcePrepareList.findAllWhere(sqlWhere.toString());
			 vector.addAll(checkList);
		 }
		 //把查询到的数据返回到页面
		 for(int i=0;i<vector.size();i++){
			 enResourcePrepareList =(EnResourcePrepareList) vector.get(i);
			 int row  = dbResourcePrepareList.setToXml(requestXml, enResourcePrepareList);
			 enResourceClass =  dbResourceClass.findByKey(enResourcePrepareList.getResourceClassId());
			 enOrg = dbOrg.findByKey(enResourcePrepareList.getInOrgId());
			 enResourcePrepareSheet = dbResourcePrepareSheet.findByKey(enResourcePrepareList.getSheetId());
			 if(enResourcePrepareSheet != null){
				 requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "SHEET_ID", enResourcePrepareSheet.getSheetId());
				 requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "PREPARE_DATE", enResourcePrepareSheet.getPrepareDate());
			 }
			 if(enResourceClass != null){
				 requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "RESOURCE_CLASS_NAME", enResourceClass.getClassName());
			 }
			 if(enOrg != null){
				 requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "IN_ORG_NAME", enOrg.getOrgName());
			 }
			 enOrg = null;
			 enOrg = dbOrg.findByKey(enResourcePrepareList.getOutOrgId());
			 if(enOrg != null){
				 requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "OUT_ORG_NAME", enOrg.getOrgName());
			 }
			 enOrg = null;
			 enOrg = dbOrg.findByKey(enResourcePrepareList.getOutStationId());
			 if(enOrg != null){
				 requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "OUT_STATION_NAME", enOrg.getOrgName());
			 }
			 enOrg = null;
			 enOrg = dbOrg.findByKey(enResourcePrepareList.getInStationId());
			 if(enOrg != null){
				 requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "IN_STATION_NAME", enOrg.getOrgName());
			 }
		 }
	}

}
