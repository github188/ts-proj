package tower.cem.bo.MAI.temp;

import java.util.Vector;

import org.apache.log4j.Logger;

import tower.cem.db.DbDevicePortType;
import tower.cem.db.DbMaintainCommandsTemplate;
import tower.cem.en.EnDevicePortType;
import tower.cem.en.EnMaintainCommandsTemplate;
import tower.common.util.Page;
import tower.common.util.PubFunc;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 功能描述：根据从页面获取的查询条件从维护指令模板（MAINTAIN_COMMANDS_TEMPLATE）中获取满足条件的记录。
 * @author flj
 *
 */
public class BoTempList implements RootBo{

	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml, XMLWrap applicationXml, Logger logger) throws ErrorException {
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/
		//维护指令模板db en
		DbMaintainCommandsTemplate dbMaintainCommandsTemplate;
		EnMaintainCommandsTemplate enMaintainCommandsTemplate;
		
		//查询条件：维护指令模板名称、维护指令模板说明
		String tempName;
		String tempDesc;
		
		//其他
		Vector maintainCommandsTemplates;
		StringBuffer sqlWhere;
		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		tempName = requestXml.getInputValue("QTEMP_NAME");
		tempDesc = requestXml.getInputValue("QTEMP_DESC");
		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		 transaction.createDefaultConnection(null, true);
		 dbMaintainCommandsTemplate = new DbMaintainCommandsTemplate(transaction,null);
		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		 //根据查询条件组装查询语句
		 sqlWhere = new StringBuffer();
			if (tempName != null && tempName.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" TEMP_NAME  LIKE'%" + tempName + "%'");
				} else {
					sqlWhere.append(" AND TEMP_NAME LIKE '%" + tempName + "%'");
				}
			}
			if (tempDesc != null && tempDesc.length() != 0) {
				if (sqlWhere == null || sqlWhere.length() == 0) {
					sqlWhere.append(" TEMP_DESC LIKE '%" + tempDesc + "%'");
				} else {
					sqlWhere.append(" AND TEMP_DESC LIKE '%" + tempDesc + "%'");
				}
			}

         //查询表，将符合条件的保存到requestXml中返回。
			if (sqlWhere != null && sqlWhere.length() != 0) {
				Page.SetPageInfo(transaction, null, requestXml, dbMaintainCommandsTemplate,
						PubFunc.LEN_PAGE_COUNT, "MAINTAIN_COMMANDS_TEMPLATE", sqlWhere.toString());
				maintainCommandsTemplates = dbMaintainCommandsTemplate.findAllWhere(sqlWhere.toString());

			} else {
				Page.SetPageInfo(transaction, null, requestXml, dbMaintainCommandsTemplate,
						PubFunc.LEN_PAGE_COUNT, "MAINTAIN_COMMANDS_TEMPLATE", null);
				maintainCommandsTemplates = dbMaintainCommandsTemplate.findAll();
		    }
			dbMaintainCommandsTemplate.setAllToXml(requestXml, maintainCommandsTemplates);
	}
}
