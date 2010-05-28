package tower.nsp.bo.define.org;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import tower.common.util.SysIdCreator;
import tower.nsp.common.util.IdCreatorDefine;
import tower.nsp.db.DbSysOrg;
import tower.nsp.en.EnSysOrg;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
import tower.tmvc.util.UploadFile;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
/**
 * 
 * @author fanlj
 * 功能概述：批量提交基站信息
 * 1、获取页面提交的excel文件
 * 2、读取excel文件内容
 * 1)从提交的excel文件读取"基站编号"、"基站名称"、”联系人“和”联系方式“为空、”是否为基站“默认为”是“、
 * ”外购入库“默认为”否“。
 *
 */
public class BoSubOrgBatchSubmit implements RootBo {
	
	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
	/***********************************************************************
	 * 声明变量
	 **********************************************************************/
	//db  en
	DbSysOrg dbOrg;
	EnSysOrg enOrg;
	//上传文件
	UploadFile uploadFile;
	
	//上级机构Id
	String parentId;
	
	//机构信息
	String orgId;
	String orgCode;
	String orgName;
	String statioFlag="Y";
	String buyInFlag="N";
	
	POIFSFileSystem fs ;
	HSSFWorkbook wb ;
	
	HSSFRow row ;
	HSSFCell cell;
	HSSFSheet sheet;
	/***********************************************************************
	 * 获取参数
	 **********************************************************************/
	uploadFile = (UploadFile)requestXml.getInputObject("READ_FILE");
	parentId = requestXml.getInputValue("PARENT_ID");
	sessionXml.addRow("SYS_ORG");
	sessionXml.setItemValue("SYS_ORG", 1, "PARENT_ORG_ID", parentId);
	
	/***********************************************************************
	 * 创建数据库连接，初始化DB，EN
	 **********************************************************************/
	transaction.createDefaultConnection(null, false);
	dbOrg = new DbSysOrg(transaction, null);
	enOrg = new EnSysOrg();
	/***********************************************************************
	 * 业务处理
	 **********************************************************************/
	
	try {
		//读取文件流
		fs = new POIFSFileSystem(uploadFile.getInputStream());
		wb = new HSSFWorkbook(fs);
		
		//获取表单
		sheet = wb.getSheet("基站信息");
		
		//判断是否找到名称为"基站信息"的表单
		if(sheet == null){
			throw new ErrorException("OS0219",new Object[] { "基站信息"});
		}
		//获取总行数
		int rowNum = sheet.getLastRowNum();
		
		//循环读取excel中的数据
		for(int i=1;i<rowNum+1;i++){
			row = sheet.getRow(i);
			cell = row.getCell((short)0);
			//基站编号不能为空：AM0302:"基站编号"不能为空，请检查基站信息excel表中是否存在"基站编号"为空的记录。
			if(cell == null ){
				throw new ErrorException("AM0302",null);
			}else{
				orgCode = cell.getStringCellValue();
			}
			cell = row.getCell((short)1);
			//基站名称不能为空：AM0303:"基站名称"不能为空，请检查基站信息excel表中是否存在"基站名称"为空的记录。
			if(cell == null ){
				throw new ErrorException("AM0303",null);
			}else{
				orgName = cell.getStringCellValue();
			}
			if(orgName != null && orgName.length() > 0){
//				验证是否存在相同名称或相同编号的基站
				int sameNameCount = dbOrg.countWhere(" ORG_NAME='"+orgName+"' and STATION_FLAG='Y'");
				if(sameNameCount > 0){
					//orgName已存在，请修改基站名称
					throw new ErrorException("AM0300",new Object[] {orgName});
				}
				int sameCodeCount = dbOrg.countWhere(" ORG_CODE='"+orgCode+"' and STATION_FLAG='Y'");
				if(sameCodeCount > 0){
					//orgCode已存在，请修改基站编号
					throw new ErrorException("AM0301",new Object[] {orgCode});
				}
				
				//获取orgId
				orgId = SysIdCreator.GenNextId(transaction, null,
						IdCreatorDefine.ID_TYPE_ORG_ID,
						IdCreatorDefine.ID_LEN_ORG_ID);
				enOrg.setOrgId(orgId);
				enOrg.setOrgName(orgName);
				enOrg.setParentId(parentId);
				enOrg.setStationFlag(statioFlag);
				enOrg.setBuyInFlag(buyInFlag);
				enOrg.setOrgCode(orgCode);
				
				// 添加至数据库
				dbOrg.insert(enOrg);
			}
			
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
	}
	
	
}
