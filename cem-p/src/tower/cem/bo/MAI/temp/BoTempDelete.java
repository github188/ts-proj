package tower.cem.bo.MAI.temp;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbCommandsSendList;
import tower.cem.db.DbDevicePortType;
import tower.cem.db.DbMaintainCommandsTemplate;
import tower.cem.en.EnCommandsSendList;
import tower.cem.en.EnDevicePortType;
import tower.cem.en.EnMaintainCommandsTemplate;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 功能描述：根据从页面获取参数从维护指令模板（MAINTAIN_COMMANDS_TEMPLATE）中删除记录。
 * 1、 维护指令模板已经在指令发送任务表中引用，提示暂时不能删除
 * @author flj
 *
 */
public class BoTempDelete implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml, 
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		
		//维护指令模板db en
		DbMaintainCommandsTemplate dbMaintainCommandsTemplate;
		EnMaintainCommandsTemplate enMaintainCommandsTemplate;
		
		//指令发送任务表db en
		DbCommandsSendList dbCommandsSendList;
		EnCommandsSendList enCommandsSendList;
		
		//指令模板编号
		String tempId;
		
		//其他
		Vector vMaintainCommandsTemplates;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		tempId = requestXml.getInputValue("TEMP_ID");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		 dbMaintainCommandsTemplate = new DbMaintainCommandsTemplate(transaction,null);
		 dbCommandsSendList = new DbCommandsSendList(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 //如维护指令模板已经在指令发送任务表中引用，提示暂时不能删除,抛出异常：MCT001：指令模板{0}经在指令发送任务中使用，该指令模板不能删除。
		 vMaintainCommandsTemplates = dbCommandsSendList.findAllWhere(" TEMPLATE_ID ='"
					+ tempId + "'");
		 //获取指令模板名称
		 enMaintainCommandsTemplate  = dbMaintainCommandsTemplate.findByKey(tempId);
		 if (vMaintainCommandsTemplates.size() > 0) {
				throw new ErrorException("MCT001", new Object[] {enMaintainCommandsTemplate.getTempName()});
			}
		 
		 //根据指令模板编号（tempId）删除指令模板信息
		 dbMaintainCommandsTemplate.deleteByKey(tempId);
		 
	}
}
