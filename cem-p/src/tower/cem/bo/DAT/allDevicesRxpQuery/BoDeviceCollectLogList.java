package tower.cem.bo.DAT.allDevicesRxpQuery;

import org.apache.log4j.Logger;

import tower.common.util.DateFunc;
import tower.common.util.Page;
import tower.common.util.PubFunc;
import tower.tmvc.ErrorException;
import tower.tmvc.QueryResult;
import tower.tmvc.QueryResultRow;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

public class BoDeviceCollectLogList implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml,
			XMLWrap applicationXml, Logger logger) throws ErrorException {

		// 查询条件
		String sendId; // 指令发送编号

		// 其他
		StringBuffer sql = new StringBuffer();

		QueryResult rs = null;
		/*****************************************************************************************************
		 * 获取输入
		 ****************************************************************************************************/
		sendId = requestXml.getInputValue("SEND_ID");
		/*****************************************************************************************************
		 * 创建数据库连接、实例化DB、EN
		 ****************************************************************************************************/
		transaction.createDefaultConnection(null, true);
		/*****************************************************************************************************
		 * 执行业务逻辑、输出
		 ****************************************************************************************************/
		sql.append(" select a.SEND_ID,b.DEVICE_NAME_CN,e.TYPE_NAME_CN,a.DEVICE_IP,a.COLLECT_BEGIN, a.STATUS,a.COLLECT_END,a.DEVICE_ID"
						+ " from DEVICE_COLLECT_LOG a ,DEVICE_INFO b ,DEVICE_TYPE e"
						+ " where  a.DEVICE_ID = b.DEVICE_ID "
						+ " and b.TYPE_ID = e.TYPE_ID "
						+ " and a.SEND_ID = ");
		sql.append(Transaction.formatString(sendId));

		int page = Page.SetPageInfo(transaction, null, requestXml, PubFunc.LEN_PAGE_COUNT, sql.toString());
		rs = transaction.doQuery(null, sql.toString(), page, PubFunc.LEN_PAGE_COUNT);
		for (int i = 0; i < rs.size(); i++) {
			QueryResultRow rsRow = rs.get(i);
			if (rsRow != null) {
				int row = requestXml.addRow("DEVICE_COLLECT_LOG");
				requestXml.setItemValue("DEVICE_COLLECT_LOG", row, "SEND_ID", rsRow.getString("SEND_ID"));
				requestXml.setItemValue("DEVICE_COLLECT_LOG", row, "DEVICE_NAME_CN", rsRow
						.getString("DEVICE_NAME_CN"));
				requestXml.setItemValue("DEVICE_COLLECT_LOG", row, "TYPE_NAME_CN", rsRow
						.getString("TYPE_NAME_CN"));
				requestXml.setItemValue("DEVICE_COLLECT_LOG", row, "DEVICE_IP", rsRow.getString("DEVICE_IP"));
				requestXml.setItemValue("DEVICE_COLLECT_LOG", row, "COLLECT_BEGIN", DateFunc
						.FormatDateTime(rsRow.getString("COLLECT_BEGIN")));
				requestXml.setItemValue("DEVICE_COLLECT_LOG", row, "STATUS", rsRow.getString("STATUS"));
				requestXml.setItemValue("DEVICE_COLLECT_LOG", row, "COLLECT_END", DateFunc
						.FormatDateTime(rsRow.getString("COLLECT_END")));
				requestXml.setItemValue("DEVICE_COLLECT_LOG", row, "DEVICE_ID", rsRow.getString("DEVICE_ID"));
			}
		}

	}
}
