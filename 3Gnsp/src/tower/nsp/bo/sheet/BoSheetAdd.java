package tower.nsp.bo.sheet;

import org.apache.log4j.Logger;

import tower.common.util.DateFunc;
import tower.common.util.SysIdCreator;
import tower.nsp.common.util.IdCreatorDefine;
import tower.nsp.db.DbResourcePrepareSheet;
import tower.nsp.en.EnResourcePrepareSheet;
import tower.tmvc.ErrorException;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 功能描述：增加调度工单信息。
 * 
 * @author fanlj 2008-10-16 上午10:09:30
 */
public class BoSheetAdd implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml,
			XMLWrap applicationXml, Logger logger) throws ErrorException {
		/*****************************************************************************************************
		 * 声明变量
		 ****************************************************************************************************/
		// 调度工单db en
		DbResourcePrepareSheet dbResourcePrepareSheet;
		EnResourcePrepareSheet enResourcePrepareSheet;

		// 获取参数:工单ID
		String sheetId;

		// 从session获取当前登录人员的ID；获取当前日期
		String userId;
		String now;

		/*****************************************************************************************************
		 * 获取输入
		 ****************************************************************************************************/
		sheetId = requestXml.getInputValue("SHEET_ID");
		userId = sessionXml.getItemValue("SYS_USER", 1, "USER_ID");
		now = DateFunc.GenNowTime().substring(0, 8);
		/*****************************************************************************************************
		 * 创建数据库连接、实例化DB、EN
		 ****************************************************************************************************/
		transaction.createDefaultConnection(null, true);
		dbResourcePrepareSheet = new DbResourcePrepareSheet(transaction, null);
		enResourcePrepareSheet = new EnResourcePrepareSheet();
		/*****************************************************************************************************
		 * 执行业务逻辑、输出
		 ****************************************************************************************************/
		// 检查userId是否为空，如果为空则抛出异常OS0102。
		if (userId == null || userId.length() == 0) {
			throw new ErrorException("OS0102", null);
		} else {
			// 检查从页面获取的工单Id是否为空，如果为空则往“资源调度工单(RESOURCE_PREPARE_SHEET)”
			// 增加一条记录；如果不为空则根据调度工单ID更新“调度日期(PREPARE_DATE)”和“派单人(PREPARE_USER_ID)”.
			if (sheetId == null || sheetId.length() == 0) {
				sheetId = SysIdCreator.GenNextId(transaction, null, IdCreatorDefine.ID_TYPE_SHEET_ID,
						IdCreatorDefine.ID_LEN_SHEET_ID);
				enResourcePrepareSheet.setSheetId(sheetId);
				enResourcePrepareSheet.setPrepareDate(now);
				enResourcePrepareSheet.setPrepareUserId(userId);
				dbResourcePrepareSheet.insert(enResourcePrepareSheet);
			} else {
				enResourcePrepareSheet.setPrepareDate(now);
				enResourcePrepareSheet.setPrepareUserId(userId);
				dbResourcePrepareSheet.updateByKey(sheetId, enResourcePrepareSheet);
			}
			if (requestXml.getInputRowCount("SHEET_ID") <= 0) {
				requestXml.addInputRow("SHEET_ID");
				requestXml.setInputValue("SHEET_ID", 1, sheetId);
			}

		}

	}

}
