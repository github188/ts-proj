package tower.cem.bo.MAI.temp;


import org.apache.log4j.Logger;

import tower.cem.db.DbMaintainCommandsTemplate;
import tower.cem.en.EnCommandsSendList;
import tower.cem.en.EnMaintainCommandsTemplate;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 功能描述：根据从页面获取参数从维护指令模板（MAINTAIN_COMMANDS_TEMPLATE）中获取指令模板信息。
 * @author flj
 *
 */
public class BoTempDetail implements RootBo{

	public void doBusiness(Transaction transaction, XMLWrap requestXml, 
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		
		//维护指令模板db en
		DbMaintainCommandsTemplate dbMaintainCommandsTemplate;
		EnMaintainCommandsTemplate enMaintainCommandsTemplate;
		
		//指令模板编号
		String tempId;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		tempId = requestXml.getInputValue("TEMP_ID");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		 dbMaintainCommandsTemplate = new DbMaintainCommandsTemplate(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 enMaintainCommandsTemplate = dbMaintainCommandsTemplate.findByKey(tempId);
		 dbMaintainCommandsTemplate.setToXml(requestXml, enMaintainCommandsTemplate);
	}
}
