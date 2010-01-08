package tower.nsp.bo.sheet;

import java.io.IOException;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import tower.common.util.DateFunc;
import tower.common.util.SysIdCreator;
import tower.nsp.common.util.IdCreatorDefine;
import tower.nsp.db.DbResourceOrgAmount;
import tower.nsp.db.DbResourcePrepareList;
import tower.nsp.db.DbResourcePrepareSheet;
import tower.nsp.db.DbResourceType;
import tower.nsp.db.DbSysOrg;
import tower.nsp.en.EnResourceOrgAmount;
import tower.nsp.en.EnResourcePrepareList;
import tower.nsp.en.EnResourcePrepareSheet;
import tower.nsp.en.EnResourceType;
import tower.nsp.en.EnSysOrg;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
import tower.tmvc.util.UploadFile;
/**
 * 
 * @author fanlj
 * 功能描述：批量导入调度工单
 * 1、 根据excel表中的“调出单位名称”、“设备型号名称”、“调入单位名称”从数据库中查找相应的 Id。查找调入/调出单位时，需判断是否为基站，
If 是基站
 需获取基站ID和上级分公司ID。
Else
只获取分公司Id。
2、 在将工单明细读入数据库之前，首先添加一条工单记录。每次批量导入将默认为一批工单。
 *
 */
public class BoSheetPrepareBatchAdd implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		
		/*****************************************************************************************************
		 * 声明变量
		 ****************************************************************************************************/
		// 调度工单明细db en
		DbResourcePrepareList dbResourcePrepareList;
		EnResourcePrepareList enResourcePrepareList;

		// 资源库存db en
		DbResourceOrgAmount dbResourceOrgAmount;
		EnResourceOrgAmount enResourceOrgAmount;

		// 调度工单db en
		DbResourcePrepareSheet dbResourcePrepareSheet;
		EnResourcePrepareSheet enResourcePrepareSheet;

		// 资源型号db en
		DbResourceType dbResourceType;
		EnResourceType enResourceType;
		
		//机构 db,en
		DbSysOrg dbOrg;
		EnSysOrg enOrg;

		// 获取参数：工单Id、调度工单明细ID(LIST_ID)、调出单位(OUT_ORG_ID)、
		// 调出基站(OUT_STATION_ID)、调出设备类型(RESOURCE_CLASS_ID)、
		// 调出设备型号(RESOURCE_TYPE_ID)、调出数量(AMOUNT_PREPARE)、调出设备状态(OUT_RESOURCE_STATUS)
		// 调入单位(IN_ORG_ID)、调入基站(IN_STATION_ID)、调入单位是否为新的基站(NEW_STATION_FLAG)。
		String sheetId;
		String listId;

		String outOrgId;
		String outStationFlag;
		String outStationId = "";
		String outResourceStatus;
		String outOrgName;
		
		String resourceClassId;
		String resourceTypeId;
		String resourceTypeName;

		double  amountPrepare;

		String inOrgId;
		String inStationFlag;
		String inStationId = "";
		String inOrgParentId;
		String newStationFlag;
		String inOrgName;
		

		String userId;
		String now;

		
		//上传文件
		UploadFile uploadFile;
		
		POIFSFileSystem fs ;
		HSSFWorkbook wb ;
		
		HSSFRow row ;
		HSSFCell cell;
		HSSFSheet sheet;
		
		Vector vector;
		/*****************************************************************************************************
		 * 获取输入
		 ****************************************************************************************************/
		sheetId = requestXml.getInputValue("SHEET_ID");
		uploadFile = (UploadFile)requestXml.getInputObject("READ_FILE");
		userId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		now = DateFunc.GenNowTime().substring(0, 8);
		/*****************************************************************************************************
		 * 创建数据库连接、实例化DB、EN
		 ****************************************************************************************************/
		transaction.createDefaultConnection(null, true);
		dbResourcePrepareList = new DbResourcePrepareList(transaction, null);
		enResourcePrepareList = new EnResourcePrepareList();
		dbResourceOrgAmount = new DbResourceOrgAmount(transaction, null);
		dbResourcePrepareSheet = new DbResourcePrepareSheet(transaction, null);
		enResourcePrepareSheet = new EnResourcePrepareSheet();
		dbResourceType = new DbResourceType(transaction, null);
		dbOrg = new DbSysOrg(transaction, null);
		enOrg = new EnSysOrg();
		/*****************************************************************************************************
		 * 执行业务逻辑、输出
		 ****************************************************************************************************/
		//判断sheetId是否为空，如果为空则是从工单列表页面进行批量导入，需新增一条工单记录；
		//如果不为空，则是从工单明细列表页面进行批量导入。
		if(sheetId == null || sheetId.length()  == 0){
			sheetId = SysIdCreator.GenNextId(transaction, null, IdCreatorDefine.ID_TYPE_SHEET_ID,
					IdCreatorDefine.ID_LEN_SHEET_ID);
			enResourcePrepareSheet.setSheetId(sheetId);
			enResourcePrepareSheet.setPrepareUserId(userId);
			enResourcePrepareSheet.setPrepareDate(now);
			dbResourcePrepareSheet.insert(enResourcePrepareSheet);
			
		}
		int row1 = requestXml.addInputRow("SHEET_ID");
		requestXml.setInputValue("SHEET_ID", row1, sheetId);
		//读取文件流
		try {
			fs = new POIFSFileSystem(uploadFile.getInputStream());
			wb = new HSSFWorkbook(fs);
			
			//获取表单
			sheet = wb.getSheet("工单信息");
			
			//判断是否找到名称为"工单信息"的表单
			if(sheet == null){
				throw new ErrorException("OS0219",new Object[] { "工单信息"});
			}
			//获取总行数
			int rowNum = sheet.getLastRowNum();
			
			//读取excel表中的数据
			for(int i=1;i<rowNum+1;i++){
				row = sheet.getRow(i);
				
				//调出单位
				cell = row.getCell((short)0);
				//调出单位不能为空：OS0210:"调出单位"不能为空，请检查工单明细信息excel表中第i条记录的"调出单位"为是否空。
				if(cell == null ){
					throw new ErrorException("OS0210",new Object[] { i});
				}else{
					outOrgName = cell.getStringCellValue();
					//根据调出单位名称获取调出单位ID
					if(outOrgName != null && outOrgName.length() != 0){
						vector = dbOrg.findAllWhere("  org_name='"+outOrgName+"' ");
						if(vector != null && vector.size() != 0){
								enOrg = (EnSysOrg)vector.get(0);
								if(enOrg != null){
									//判断调出单位是否为基站，如果是基站，同时需要获取该基站的上级分公司ID
									outStationFlag = enOrg.getStationFlag();
									if(outStationFlag.equals("Y")){
										outOrgId = enOrg.getParentId();
										outStationId =enOrg.getOrgId();
									}else{
										outOrgId = enOrg.getOrgId();
									}
								}else{
									//OS0216:未查找到名称为'{0}'的调出单位，请在机构定义中查找并确认该机构信息是否录入系统。
									throw new ErrorException("OS0216",new Object[] {outOrgName});
								}
								
						}else{
							//OS0216:未查找到名称为'{0}'的调出单位，请在机构定义中查找并确认该机构信息是否录入系统。
							throw new ErrorException("OS0216",new Object[] {outOrgName});
						}
					}else{
						throw new ErrorException("OS0210",new Object[] { i});
					}
				}
				
				
				
				//调出设备型号
				cell = row.getCell((short)1);
				//调出设备型号不能为空：OS0211:"调出设备型号"不能为空，请检查工单明细信息excel表中第i条记录的"调出设备型号"为是否空。
				if(cell == null ){
					throw new ErrorException("OS0211",new Object[] { i});
				}else{
					resourceTypeName = cell.getStringCellValue();
					//根据调出设备型号获取调出设备型号Id
					if(resourceTypeName != null && resourceTypeName.length() != 0){
						vector = dbResourceType.findAllWhere(" type_name='"+resourceTypeName+ "' ");
						if(vector != null && vector.size() != 0){
							enResourceType = (EnResourceType)vector.get(0);
							if(enResourceType != null){
								resourceClassId = enResourceType.getResourceClassId();
								resourceTypeId = enResourceType.getTypeId();
							}else{
								//OS0218:未查找到名称为'{0}'的调出单位，请在机构定义中查找并确认该机构信息是否录入系统。
								throw new ErrorException("OS0218",new Object[] {outOrgName});
							}	
						}else{
							//OS0218:未查找到名称为'{0}'的调出单位，请在机构定义中查找并确认该机构信息是否录入系统。
							throw new ErrorException("OS0218",new Object[] {outOrgName});
						}
					}else{
						//调出设备型号不能为空：OS0211:"调出设备型号"不能为空，请检查工单明细信息excel表中第i条记录的"调出设备型号"为是否空。
						throw new ErrorException("OS0211",new Object[] { i});
					}
				}
				
				
				
				//调出设备状态
				cell = row.getCell((short)2);
				//调出设备状态不能为空：OS0212:"调出设备状态"不能为空，请检查工单明细信息excel表中第i条记录的"调出设备状态"为是否空。
				if(cell == null ){
					throw new ErrorException("OS0212",new Object[] { i});
				}else{
					outResourceStatus = cell.getStringCellValue();
					if(outResourceStatus != null && outResourceStatus.length()!=0){
						//0:库存设备 1:在线设备
						if(outResourceStatus.equals("在线")){
							outResourceStatus = "1";
						}else if(outResourceStatus.equals("库存")){
							outResourceStatus = "0";
						}else{
							throw new ErrorException("OS0220",null);
						}
					}else{
						throw new ErrorException("OS0212",new Object[] { i});
					}
				}
				
				
				
				
				//调出设备数量
				cell = row.getCell((short)3);
				//调出设备数量不能为空：OS0213:"调出设备数量"不能为空，请检查工单明细信息excel表中第i条记录的"调出设备数量"为是否空。
				if(cell == null ){
					throw new ErrorException("OS0213",new Object[] { i});
				}else{
					amountPrepare = cell.getNumericCellValue();
				}
				
				
				
				
				//调入单位
				cell = row.getCell((short)4);
				//调入单位不能为空：OS0214:"调入单位"不能为空，请检查工单明细信息excel表中第i条记录的"调入单位"为是否空。
				if(cell == null ){
					throw new ErrorException("OS0214",new Object[] { i});
				}else{
					inOrgName = cell.getStringCellValue();
					if(inOrgName != null && inOrgName.length() != 0){
						vector = dbOrg.findAllWhere(" org_name='"+inOrgName+ "' ");
						if(vector != null && vector.size() != 0){
								enOrg = (EnSysOrg)vector.get(0);
								if(enOrg != null){
									//判断调出单位是否为基站，如果是基站，同时需要获取该基站的上级分公司ID
									inStationFlag = enOrg.getStationFlag();
									if(inStationFlag.equals("Y")){
										inOrgId = enOrg.getParentId();
										inStationId =enOrg.getOrgId();
									}else{
										inOrgId = enOrg.getOrgId();
									}
								}else{
									//OS0217:未查找到名称为'{0}'的调入单位信息，请在机构定义中查找并确认该机构信息是否录入系统。
									throw new ErrorException("OS0217",new Object[] {inOrgName});
								}
								
						}else{
							//OS0217:未查找到名称为'{0}'的调入单位信息，请在机构定义中查找并确认该机构信息是否录入系统。
							throw new ErrorException("OS0217",new Object[] {inOrgName});
						}
					}else{
						throw new ErrorException("OS0210",new Object[] { i});
					}
				}
				
				
				
				//是否为新建基站
				cell = row.getCell((short)5);
				//是否为新建基站不能为空：OS0215:"是否为新建基站"不能为空，请检查工单明细信息excel表中第i条记录的"是否为新建基站"为是否空。
				if(cell == null ){
					throw new ErrorException("OS0215",new Object[] { i});
				}else{
					newStationFlag = cell.getStringCellValue();
					if(outResourceStatus != null && outResourceStatus.length()!=0){
						//0:否 1:是
						if(outResourceStatus.equals("否")){
							newStationFlag = "0";
						}else{
							newStationFlag = "1";
						}
						
					}else{
						throw new ErrorException("OS0215",new Object[] { i});
					}
				}
				
				
				// 判断下发的工单明细中调出单位中该资源类型的库存是否存在，如果不存在则抛出异常：OS0206:{0}机构下发{1}资源类的库存不存在，请增加库存！
				long count = 0;
				if (outStationId != null && outStationId.length() > 0) {
					count = dbResourceOrgAmount.countByKey(outStationId, resourceTypeId);
					enResourceOrgAmount = dbResourceOrgAmount.findByKey(outStationId, resourceTypeId);
				} else {
					count = dbResourceOrgAmount.countByKey(outOrgId, resourceTypeId);
					enResourceOrgAmount = dbResourceOrgAmount.findByKey(outOrgId, resourceTypeId);
				}
				
				if (count <= 0) {
					throw new ErrorException("OS0206", new Object[] { outOrgName, resourceTypeName });
				} 
				
				//判断调出的是在线设备还是库存设备(0:库存设备 1:在线设备)
				if(outResourceStatus.equals("0")){
					//如果调出数量大于库存数量，则抛出异常：OS0208:'{0}'的 '{1}'型号的设备库存不足，无法完成调度，请增加库存数量！
					if(amountPrepare > enResourceOrgAmount.getStockAmount()){
						throw new ErrorException("OS0208",new Object[] { outOrgName, resourceTypeName });
					}
				}else if(outResourceStatus.equals("1")){
					//如果调出数量大于在线数量，则抛出异常：OS0209:'{0}'的 '{1}'型号的设备在线数量不足，无法完成调度！
					if(amountPrepare > enResourceOrgAmount.getOnlineAmount()){
						throw new ErrorException("OS0209",new Object[] { outOrgName, resourceTypeName });
					}
				}
				
				
				
				
				//读取数据到数据库
				listId = SysIdCreator.GenNextId(transaction, null, IdCreatorDefine.ID_TYPE_LIST_ID,
						IdCreatorDefine.ID_LEN_LIST_ID);
				enResourcePrepareList.setListId(listId);
				enResourcePrepareList.setOutOrgId(outOrgId);
				enResourcePrepareList.setOutStationId(outStationId);
				enResourcePrepareList.setOutResourceStatus(outResourceStatus);
				enResourcePrepareList.setResourceClassId(resourceClassId);
				enResourcePrepareList.setResourceTypeId(resourceTypeId);
				enResourcePrepareList.setAmountPrepare((long)amountPrepare);
				enResourcePrepareList.setInOrgId(inOrgId);
				enResourcePrepareList.setSheetId(enResourcePrepareSheet.getSheetId());
				enResourcePrepareList.setInStationId(inStationId);
				enResourcePrepareList.setNewStationFlag(newStationFlag);
				enResourcePrepareList.setListStatus("0");
				dbResourcePrepareList.insert(enResourcePrepareList);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		 

		

	}

}
