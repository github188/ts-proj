package cn.toso.ops.server.bo;

import org.apache.log4j.Logger;

import cn.toso.ops.util.PacketParser;

import tmvc.common.ErrorException;
import tmvc.common.RootBo;
import tmvc.common.Transaction;
import tmvc.common.XMLWrap;

public class BoExample implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		String userId; // 输入参数:用户ID
		int row;
		
		// 若是只是查询数据库,将第二参数自动提交标志设为true
		transaction.createDefaultConnection(null, true);
		// 若是有更新的语句,将自动提交标志设为false
		// transaction.createDefaultConnection(null, false);
		
		// 取得输入参数值:用户ID
		userId = requestXml.getInputValue("USER_ID");
		
		// 根据用户ID,查询用户信息
		/*
		 DbTUserInfo dbUser = new DbTUserInfo(transaction,null);
		 EnTUserInfo enUser = dbUser.findByKey(userId);
		 */
		
		
		// 将结果放入返回信息中
		row = requestXml.addRow(PacketParser.RESPONSE_ROW_NAME);
		//即:row = requestXml.addRow("RESPONSE_INFO");
		
		requestXml.setItemValue(PacketParser.RESPONSE_ROW_NAME, row, "USER_ID", userId);
		requestXml.setItemValue(PacketParser.RESPONSE_ROW_NAME, row, "USER_NAME", "张三");
		requestXml.setItemValue(PacketParser.RESPONSE_ROW_NAME, row, "ID_NO", "370212197808082531");
		
		requestXml.setItemValue(PacketParser.RESPONSE_ROW_NAME, row, "USER_ID","112233445511223344550001");
		requestXml.setItemValue(PacketParser.RESPONSE_ROW_NAME, row, "USER_NAME","无名小卒");
		requestXml.setItemValue(PacketParser.RESPONSE_ROW_NAME, row, "ID_NO","370212197808082531");
		requestXml.setItemValue(PacketParser.RESPONSE_ROW_NAME, row, "ADDRESS","青岛市市南区");
		requestXml.setItemValue(PacketParser.RESPONSE_ROW_NAME, row, "ZIP_CODE","266000");
		requestXml.setItemValue(PacketParser.RESPONSE_ROW_NAME, row, "PHONE","13969795632");
		requestXml.setItemValue(PacketParser.RESPONSE_ROW_NAME, row, "REG_UNIT_NO","0001");
		requestXml.setItemValue(PacketParser.RESPONSE_ROW_NAME, row, "UNIT_NO","0101");
		requestXml.setItemValue(PacketParser.RESPONSE_ROW_NAME, row, "ECODE_USER","AAA");
		requestXml.setItemValue(PacketParser.RESPONSE_ROW_NAME, row, "USER_STATUS","1");
		requestXml.setItemValue(PacketParser.RESPONSE_ROW_NAME, row, "CREATE_OPERATOR","000001");
		requestXml.setItemValue(PacketParser.RESPONSE_ROW_NAME, row, "CREATE_DATETIME","20080801150145");
		requestXml.setItemValue(PacketParser.RESPONSE_ROW_NAME, row, "MODIFY_OPERATOR","000002");
		requestXml.setItemValue(PacketParser.RESPONSE_ROW_NAME, row, "MODIFY_DATETIME","20080801150146");
		requestXml.setItemValue(PacketParser.RESPONSE_ROW_NAME, row, "DELETE_OPERATOR","000003");
		requestXml.setItemValue(PacketParser.RESPONSE_ROW_NAME, row, "DELETE_DATETIME","20080801150147");
		requestXml.setItemValue(PacketParser.RESPONSE_ROW_NAME, row, "CHANELS","01");
		requestXml.setItemValue(PacketParser.RESPONSE_ROW_NAME, row, "ASSOCIATED_USERS","");
	}

}
