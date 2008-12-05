package tower.nsp.bo.sheet;

import org.apache.log4j.Logger;

import tower.common.util.DateFunc;
import tower.common.util.SysIdCreator;
import tower.nsp.common.util.IdCreatorDefine;
import tower.nsp.db.DbResourceOrgAmount;
import tower.nsp.db.DbResourcePrepareList;
import tower.nsp.db.DbResourcePrepareSheet;
import tower.nsp.db.DbResourceType;
import tower.nsp.en.EnResourceOrgAmount;
import tower.nsp.en.EnResourcePrepareList;
import tower.nsp.en.EnResourcePrepareSheet;
import tower.nsp.en.EnResourceType;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 功能描述：增加工单明细
 * 
 * @author fanlj 2008-10-16 下午02:50:19
 */
public class BoSheetPrepareAdd implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
        /***********************************************************************
		 * 声明变量
		 **********************************************************************/
		// 调度工单明细db en
		DbResourcePrepareList dbResourcePrepareList;
		EnResourcePrepareList enResourcePrepareList;
		
		//资源库存db en
		DbResourceOrgAmount dbResourceOrgAmount;
		EnResourceOrgAmount enResourceOrgAmount;
		
		//调度工单db en
		DbResourcePrepareSheet dbResourcePrepareSheet;
		EnResourcePrepareSheet enResourcePrepareSheet;
		
		//资源型号
		DbResourceType dbResourceType;
		EnResourceType enResourceType;
		
		//获取参数：工单Id、调度工单明细ID(LIST_ID)、调出单位(OUT_ORG_ID)、
		//调出基站(OUT_STATION_ID)、调出设备类型(RESOURCE_CLASS_ID)、
		//调出设备型号(RESOURCE_TYPE_ID)、调出数量(AMOUNT_PREPARE)、
		//调入单位(IN_ORG_ID)、调入基站(IN_STATION_ID)； 
		String sheetId;
		String listId;
		
		String outOrgId;
		String outStationFlag;
		String outStationId="";
		String outOrgParentId;
		
		String resourceClassId;
		String resourceTypeId;
		
		String amountPrepare;
		String oldAmountPrepare;
		
		String inOrgId;
		String inStationFlag;
		String inStationId="";
		String inOrgParentId;
		
		String listStatus;
		String outOrgName;
		//String resourceTypeName;
		
		String userId;
		String now;
		
		long amountPrepare1;
		long oldAmountPrepare1;
		//其他
		StringBuffer sql = new StringBuffer();
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		
		userId = sessionXml.getItemValue("SYS_USER", 1,"USER_ID");
		now = DateFunc.GenNowTime().substring(0, 8);
		
		sheetId = requestXml.getInputValue("SHEET_ID");
		
		listId = requestXml.getInputValue("LIST_ID");
		
		outOrgId = requestXml.getInputValue("OUT_ORG_ID");
		outStationFlag = requestXml.getInputValue("OUT_STATION_FLAG");
		outOrgParentId = requestXml.getInputValue("OUT_ORG_PARENT_ID");
		
		//resourceClassId = requestXml.getInputValue("RESOURCE_CLASS_ID");
		resourceTypeId = requestXml.getInputValue("RESOURCE_TYPE_ID");
		amountPrepare = requestXml.getInputValue("AMOUNT_PREPARE");
		oldAmountPrepare = requestXml.getInputValue("OLD_AMOUNT_PREPARE");
		
		inOrgId = requestXml.getInputValue("IN_ORG_ID");
		inOrgParentId = requestXml.getInputValue("IN_ORG_PARENT_ID");
		inStationFlag = requestXml.getInputValue("IN_STATION_FLAG");
		
		listStatus = requestXml.getInputValue("LIST_STATUS");
		outOrgName = requestXml.getInputValue("OUT_ORG_NAME");
		//resourceTypeName =  requestXml.getInputValue("RESOURCE_TYPE_NAME");
		
		 if(amountPrepare != null && amountPrepare.length()!=0){
			 amountPrepare1=Long.parseLong(amountPrepare);
		 }else{
			 amountPrepare1=0;
		 }
		 if(oldAmountPrepare != null && oldAmountPrepare.length()!=0){
			 oldAmountPrepare1=Long.parseLong(oldAmountPrepare);
		 }else{
			 oldAmountPrepare1=0;
		 }
		
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 
		 transaction.createDefaultConnection(null, true);
		 dbResourcePrepareList = new DbResourcePrepareList(transaction,null);
		 enResourcePrepareList = new EnResourcePrepareList();
		 dbResourceOrgAmount = new DbResourceOrgAmount(transaction,null);
		 dbResourcePrepareSheet = new DbResourcePrepareSheet(transaction,null);
		 dbResourceType = new DbResourceType(transaction,null);
		 
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 
		 //验证录入信息：调出单位(OUT_ORG_ID)和调出基站(OUT_STATION_ID)至少有一个不能为空；如果为空则抛出异常OS0201 ；
		 //调出设备类型(RESOURCE_CLASS_ID)不能为空，如果为空则抛出异常OS0202；                
		 //调出设备型号(RESOURCE_TYPE_ID)不能为空,如果为空则抛出异常OS0203；      
		 //调入单位(IN_ORG_ID)、调入基站(IN_STATION_ID)至少有一个不能为空,如果为空则抛出异常OS0204； 
		 //System.out.println("outOrgId="+outOrgId+outStationFlag+outOrgParentId);
		 //System.out.println("inOrgId=" + inOrgId+inOrgParentId+inStationFlag);
		 //System.out.println("resourceTypeId=" + resourceTypeId);
		 if((outOrgId == null || outOrgId.length()==0 ) ){
			 throw new ErrorException("OS0201",null);
		 }
		 if((inOrgId == null || inOrgId.length()==0 )){
			 throw new ErrorException("OS0204",null);
		 }
		
		 if(resourceTypeId == null || resourceTypeId.length()==0 ){
			 throw new ErrorException("OS0203",null);
		 }else{
			 enResourceType = dbResourceType.findByKey(resourceTypeId);
			 //获取型号类别
			 if(enResourceType != null){
				 resourceClassId = enResourceType.getResourceClassId();
			 }else{
				 resourceClassId = "";
				 //未输入必输项：调出设备类型，请重新输入！
				 throw new ErrorException("OS0202",null);
			 }
		 }
		 if(outStationFlag.equals("Y")){
			 outStationId = outOrgId;
			 outOrgId = outOrgParentId;
		 }
		 if(inStationFlag.equals("Y")){
			 inStationId = inOrgId;
			 inOrgId = inOrgParentId;
		 }
		 
		 //判断下发的工单明细中调出单位中该资源类型的库存是否存在，如果不存在抛出异常：OS0206:{0}机构下发{1}资源类的库存不存在，请增加库存！
		 int count=0;
		 if(outStationId != null && outStationId.length()>0){
			 count = dbResourceOrgAmount.countByKey(outStationId, resourceTypeId);
		 }else{
			 count = dbResourceOrgAmount.countByKey(outOrgId, resourceTypeId);
		 }
		if(count <=0){
			throw new ErrorException("OS0206",new  Object[]{outOrgName,enResourceType.getTypeName()});
		}else{
		 
			 //修改工单信息，根据sheetId是否存在，判断工单信息是添加还是编辑
			if(sheetId == null || sheetId.length() ==0 ){
				 enResourcePrepareSheet = new EnResourcePrepareSheet();
				 sheetId = SysIdCreator.GenNextId(transaction, null,
							IdCreatorDefine.ID_TYPE_SHEET_ID,
							IdCreatorDefine.ID_LEN_SHEET_ID);
				 enResourcePrepareSheet.setSheetId(sheetId);
				 enResourcePrepareSheet.setPrepareDate(now);
				 enResourcePrepareSheet.setPrepareUserId(userId);
				 dbResourcePrepareSheet.insert(enResourcePrepareSheet);
				 requestXml.setInputValue("SHEET_ID", 1, sheetId);
			 }else{
				 enResourcePrepareSheet = dbResourcePrepareSheet.findByKey(sheetId);
				 enResourcePrepareSheet.setPrepareDate(now);
				 enResourcePrepareSheet.setPrepareUserId(userId);
				 dbResourcePrepareSheet.updateByKey(sheetId, enResourcePrepareSheet);
			 }
			
			 //根据“调度工单明细ID(LIST_ID)”判断是编辑还是添加：“调度工单明细ID(LIST_ID)”为空则为添加；不为空则为编辑
			 enResourcePrepareList.setOutOrgId(outOrgId);
			 enResourcePrepareList.setOutStationId(outStationId);
			 enResourcePrepareList.setResourceClassId(resourceClassId);
			 enResourcePrepareList.setResourceTypeId(resourceTypeId);
			 enResourcePrepareList.setAmountPrepare(amountPrepare1);
			 enResourcePrepareList.setInOrgId(inOrgId);
			 enResourcePrepareList.setSheetId(enResourcePrepareSheet.getSheetId());
			 enResourcePrepareList.setInStationId(inStationId);
			 enResourcePrepareList.setListStatus("0");
			 if(listId == null || listId.length() ==0){
				 listId= SysIdCreator.GenNextId(transaction, null,
						 IdCreatorDefine.ID_TYPE_LIST_ID,
						 IdCreatorDefine.ID_LEN_LIST_ID);
				
				 enResourcePrepareList.setListId(listId);
				 dbResourcePrepareList.insert(enResourcePrepareList);
			 }else{
				 dbResourcePrepareList.updateByKey(listId, enResourcePrepareList);
				 
				 //如果工单的状态为"已下发"、“已接收”则同时更新库存：从该库存减去更新前的数量；
	//			 if(listStatus.equals("1") ||listStatus.equals("２")){
	//				 long amount = oldAmountPrepare1-amountPrepare1;
	//			 	sql.append(" UPDATE RESOURCE_ORG_AMOUNT  SET ");
	//				sql.append(" PRE_OUT_AMOUNT= PRE_OUT_AMOUNT-");
	//				sql.append(amount);
	//				sql.append(" WHERE ORG_ID=");
	//				if(outStationId != null && outStationId.length()>0){
	//					sql.append(transaction.formatString(outStationId));
	//				}else{
	//					sql.append(transaction.formatString(outOrgId));
	//				}
	//				sql.append(" AND RESOURCE_TYPE_ID =");
	//				sql.append(transaction.formatString(resourceTypeId));
	//				transaction.doUpdate(null, sql.toString());
	//			 }
				 
			 }
		}

	}

}
