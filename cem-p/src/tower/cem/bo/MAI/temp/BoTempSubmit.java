package tower.cem.bo.MAI.temp;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbDevicePortType;
import tower.cem.db.DbMaintainCommandsTemplate;
import tower.cem.en.EnDevicePortType;
import tower.cem.en.EnMaintainCommandsTemplate;
import tower.cem.util.IdCreatorDefine;
import tower.common.util.SysIdCreator;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 功能描述：根据从页面获取的参数向设备端口类型定义表（DEVICE_PORT_TYPE）中添加记录。
 * @author flj
 *
 */
public class BoTempSubmit implements RootBo{

	public void doBusiness(Transaction transaction, XMLWrap requestXml, 
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//维护指令模板db en
		DbMaintainCommandsTemplate dbMaintainCommandsTemplate;
		EnMaintainCommandsTemplate enMaintainCommandsTemplate;
		
		//获取页面参数
		String tempId;    //维护指令模板编号
		String tempName;  //维护指令模板名称
		String tempDesc;  //维护指令模板说明
		String tempCont;  //维护指令模板内容
		
		
		//其他
		Vector vTemp;
		StringBuffer sql1;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		tempId = requestXml.getInputValue("TEMP_ID");
		tempName = requestXml.getInputValue("TEMP_NAME");
		tempDesc = requestXml.getInputValue("TEMP_DESC");
		tempCont = requestXml.getInputValue("TEMP_CONT");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		 dbMaintainCommandsTemplate = new DbMaintainCommandsTemplate(transaction,null);
		 enMaintainCommandsTemplate = new EnMaintainCommandsTemplate();
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 //判断添加的维护指令模板名称在系统中是否，如果已存在，则抛出异常。
		  sql1 = new StringBuffer(" TEMP_NAME ='"
					+ tempName+ "'");
		  enMaintainCommandsTemplate.setTempName(tempName);
		  enMaintainCommandsTemplate.setTempDesc(tempDesc);
		  enMaintainCommandsTemplate.setTempCont(tempCont);
	          //判断是添加还是编辑：
				if(tempId == null || tempId.length() <= 0){
					tempId = SysIdCreator.GenNextId(transaction, null,
							IdCreatorDefine.ID_TYPE_TEMP_ID,
							IdCreatorDefine.ID_LEN_TEMP_ID);
					vTemp = dbMaintainCommandsTemplate.findAllWhere(sql1.toString());
				if (vTemp.size() > 0) {
						throw new ErrorException("MCT002", new Object[] {  tempName });//MCT001:维护指令模板名称:{0}在系统中已存在,请重新输入。
				}
					
					enMaintainCommandsTemplate.setTempId(tempId);
					dbMaintainCommandsTemplate.insert(enMaintainCommandsTemplate);
				}else{
					sql1.append(" AND TEMP_ID != '" + tempId + "'");
					vTemp = dbMaintainCommandsTemplate.findAllWhere(sql1.toString());
					if (vTemp.size() > 0) {
							throw new ErrorException("MCT002", new Object[] {  tempName });//MCT001:维护指令模板名称:{0}在系统中已存在,请重新输入。
					}
					dbMaintainCommandsTemplate.updateByKey(tempId, enMaintainCommandsTemplate);
				}
	}
}
