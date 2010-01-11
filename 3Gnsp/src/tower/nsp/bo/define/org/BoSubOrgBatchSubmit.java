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
 * 功能概述：批量提交小区信息
 * 1、获取页面提交的excel文件
 * 2、读取excel文件内容
 * 1)从提交的excel文件读取"小区标识"、"小区名"、"频点"、"扰码"、"小区类型"、”联系人“和”联系方式“为空、”是否为小区“默认为”是“、
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
	String orgCode="";
	String orgName;
	String frePoint="";  
	String perCode="";
	String orgType="";
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
		sheet = wb.getSheet("小区信息");
		
		//判断是否找到名称为"小区信息"的表单
		if(sheet == null){
			throw new ErrorException("OS0219",new Object[] { "小区信息"});
		}
		//获取总行数
		int rowNum = sheet.getLastRowNum();
		
		//循环读取excel中的数据
		for(int i=1;i<rowNum+1;i++){
			row = sheet.getRow(i);
			cell = row.getCell((short)0);
			if(cell != null ){
				orgCode = String.valueOf(Math.round(cell.getNumericCellValue()));
			}
			cell = row.getCell((short)1);
			//小区名称不能为空：AM0303:"小区名称"不能为空，请检查小区信息excel表中是否存在"小区名称"为空的记录。
			if(cell == null ){
				throw new ErrorException("AM0303",null);
			}else{
				orgName = cell.getStringCellValue();
			}
			//频点
			cell = row.getCell((short)2);
			if(cell != null ){
				frePoint = perCode =  String.valueOf(Math.round(cell.getNumericCellValue()));
			}
			//扰码
			cell = row.getCell((short)3);
			if(cell != null ){
				perCode =  String.valueOf(Math.round(cell.getNumericCellValue()));
			}
			//小区类型:1:室内小区 2：室外小区
			cell = row.getCell((short)4);
			if(cell != null ){
				orgType = cell.getStringCellValue();
				if(orgType != null && orgType.length()>0){
					if(orgType.equals("室内小区")){
						orgType = "1";
					}
					if(orgType.equals("室外小区")){
						orgType = "2";
					}
				}
			}
			
			//验证是否存在相同名称或相同编号的小区
			int sameNameCount = dbOrg.countWhere(" ORG_NAME='"+orgName+"' and STATION_FLAG='Y'");
			if(sameNameCount > 0){
				//orgName已存在，请修改小区名称
				throw new ErrorException("AM0300",new Object[] { orgName});
			}
//			int sameCodeCount = dbOrg.countWhere(" ORG_CODE='"+orgCode+"' and STATION_FLAG='Y'");
//			if(sameCodeCount > 0){
//				//orgCode已存在，请修改小区标识
//				throw new ErrorException("AM0301",new Object[] { orgCode});
//			}
			
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
			enOrg.setFrePoint(frePoint);
			enOrg.setPerCode(perCode);
			enOrg.setOrgType(orgType);
			// 添加至数据库
			dbOrg.insert(enOrg);
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
	}
	
	
}
