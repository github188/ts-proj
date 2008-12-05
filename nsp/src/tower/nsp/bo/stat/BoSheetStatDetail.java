package tower.nsp.bo.stat;


import org.apache.log4j.Logger;


import tower.nsp.db.DbResourceClass;
import tower.nsp.db.DbResourcePrepareList;
import tower.nsp.db.DbResourcePrepareSheet;
import tower.nsp.db.DbResourceType;
import tower.nsp.db.DbSysOrg;
import tower.nsp.db.DbSysUser;
import tower.nsp.en.EnResourceClass;
import tower.nsp.en.EnResourcePrepareList;
import tower.nsp.en.EnResourcePrepareSheet;
import tower.nsp.en.EnResourceType;
import tower.nsp.en.EnSysOrg;
import tower.nsp.en.EnSysUser;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
/**
 * 功能概述：根据工单明细ID查询并返回工单明细的详细信息。
 * @author 吴国景 2008-10-20 上午10:00:08
 */
public class BoSheetStatDetail implements RootBo {

	/**
	 * 详细的处理步骤说明：
	 * 1、检查是否输入了必要的查询条件：调度工单明细ID；若未输入，则抛出异常SS0201；
	 * 2、查询工单及工单明细的详细信息：
		SELECT * FROM RESOURCE_PREPARE_SHEET, RESOURCE_PREPARE_LIST WHERE RESOURCE_PREPARE_LIST.LIST_ID = '工单明细ID'；
	 * 3、如未查询到符合条件的工单明细详细信息，则抛出异常SS0202；
	 * 4、如查询到符合条件的工单及工单明细的详细信息，则保存信息到requestXml中；
	 * 5、处理完毕；
	 */
	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {

		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//生成工单明细db、en
		DbResourcePrepareList  dbResourcePrepareList;
		EnResourcePrepareList  enResourcePerpareList;
		
		//工单db、en
		DbResourcePrepareSheet dbResourcePrepareSheet;
		EnResourcePrepareSheet enResourcePrepareSheet;
		
		//机构db、en
		DbSysOrg  dbSysOrg;
		EnSysOrg  enSysOrg;
		
		//设备类别db、en
		DbResourceClass dbResourceClass;
		EnResourceClass enResourceClass;

		//设备型号db、en
		DbResourceType dbResourceType;
		EnResourceType enResourceType;
		
		//施工确认人员db、en
		DbSysUser dbSysUser;
		EnSysUser enSysUser;
		
		
		//参数变量
		String listId;  //工单明细id
		
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		listId = requestXml.getInputValue("LIST_ID");
		
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, false);
		dbResourcePrepareList = new DbResourcePrepareList(transaction,null);
		dbResourcePrepareSheet = new DbResourcePrepareSheet(transaction,null);
		dbSysOrg = new DbSysOrg(transaction,null);
		dbResourceClass = new DbResourceClass(transaction,null);
		dbResourceType = new DbResourceType(transaction, null);
		dbSysUser = new DbSysUser(transaction,null);
		
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		if(listId == null && listId.length() == 0){
			throw new ErrorException("SS0201",null);
		}
		enResourcePerpareList = dbResourcePrepareList.findByKey(listId);
		if(enResourcePerpareList != null){
			int row = dbResourcePrepareList.setToXml(requestXml, enResourcePerpareList);
			//取出工单
			enResourcePrepareSheet = dbResourcePrepareSheet.findByKey(enResourcePerpareList.getSheetId());
			if(enResourcePrepareSheet != null){
				requestXml.setItemValue("RESOURCE_PREPARE_LIST",row,"PREPARE_DATE",enResourcePrepareSheet.getPrepareDate());
			}
			
			//取出调出单位
			enSysOrg = dbSysOrg.findByKey(enResourcePerpareList.getOutOrgId());
			if(enSysOrg != null){
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row,"OUT_ORG_NAME", enSysOrg.getOrgName());
			}
			//取出调入单位
			enSysOrg = null;
			enSysOrg = dbSysOrg.findByKey(enResourcePerpareList.getInOrgId());
			if(enSysOrg != null){
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "IN_ORG_NAME", enSysOrg.getOrgName());
			}
			//取出剩余入库单位
			enSysOrg = null;
			enSysOrg = dbSysOrg.findByKey(enResourcePerpareList.getDiffInOrgId());
			if(enSysOrg != null){
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "DIFF_IN_ORG_NAME", enSysOrg.getOrgName());
			}
			//取出剩余入库基站DIFF_IN_STATION_ID
			enSysOrg = null;
			enSysOrg = dbSysOrg.findByKey(enResourcePerpareList.getDiffInStationId());
			if(enSysOrg != null){
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "DIFF_IN_STATION_NAME", enSysOrg.getOrgName());
			}
			//取出调出基站
			enSysOrg = null;
			enSysOrg = dbSysOrg.findByKey(enResourcePerpareList.getOutStationId());
			if(enSysOrg != null){
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "OUT_STATION_NAME", enSysOrg.getOrgName());
			}
			//取出调入基站
			enSysOrg = null;
			enSysOrg = dbSysOrg.findByKey(enResourcePerpareList.getInStationId());
			if(enSysOrg != null){
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "IN_STATION_NAME", enSysOrg.getOrgName());
			}
			//取出设备类别
			enResourceClass = new EnResourceClass();
			enResourceClass = dbResourceClass.findByKey(enResourcePerpareList.getResourceClassId());
			if(enResourceClass != null){
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "RESOURCE_CLASS_NAME", enResourceClass.getClassName());
			}
			//取出设备型号
			enResourceType = new EnResourceType();
			enResourceType = dbResourceType.findByKey(enResourcePerpareList.getResourceTypeId());
			if(enResourceType != null){
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "RESOURCE_TYPE_NAME", enResourceType.getTypeName());
			}
			//取出施工确认操作人员
			enSysUser = new EnSysUser();
			enSysUser = dbSysUser.findByKey(enResourcePerpareList.getConsAckUserid());
			if(enSysUser != null){
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "CONS_ACK_USERNAME", enSysUser.getUserName());
			}
			//取出出库操作人员
			enSysUser = new EnSysUser();
			enSysUser = dbSysUser.findByKey(enResourcePerpareList.getOutOperUserid());
			if(enSysUser != null){
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "OUT_OPER_USERNAME", enSysUser.getUserName());
			}
			//取出入库操作人员
			enSysUser = new EnSysUser();
			enSysUser = dbSysUser.findByKey(enResourcePerpareList.getInOperUserid());
			if(enSysUser != null){
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "IN_OPER_USERNAME", enSysUser.getUserName());
			}
			//取出完工登记操作员
			enSysUser = new EnSysUser();
			enSysUser = dbSysUser.findByKey(enResourcePerpareList.getConsFinOperUserid());
			if(enSysUser != null){
				requestXml.setItemValue("RESOURCE_PREPARE_LIST", row, "CONS_FIN_OPER_USERNAME", enSysUser.getUserName());
			}
		}
	}

}
