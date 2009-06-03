package cn.toso.ops.server.bo;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.log4j.Logger;

import tmvc.common.ErrorException;
import tmvc.common.RootBo;
import tmvc.common.Transaction;
import tmvc.common.XMLWrap;
import cn.toso.ops.example.oath.TimebasedOnetimePassword;
import cn.toso.ops.util.PacketParser;

public class BoEapRetrieveOTP implements RootBo {

    public void doBusiness(Transaction transaction, XMLWrap requestXml, XMLWrap sessionXml,
	    XMLWrap applicationXml, Logger logger) throws ErrorException {
	String userId; // 输入参数，必输项
	// String signData; // 输入参数，必输项

	int iRow;

	// 取得输入参数值
	userId = requestXml.getInputValue("USER_ID").trim();
	if (userId == null || userId.length() == 0) {
	    throw new ErrorException("AP2401", null);// RET_CODE="AP2401"
	    // 没有提交必要的输入参数USER_ID
	}
	// signData = requestXml.getInputValue("SIGN_DATA").trim();

	try {

	    // sample for event based OTP gen, parameter is counter.
	    String seed = "4C45B409121F21463200EF094004FFFA9B5E1DAD";
	    String time = "0";
	    Date myDate = Calendar.getInstance().getTime();
	    BigInteger b = new BigInteger("0");
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    df.setTimeZone(TimeZone.getTimeZone("UTC"));

	    myDate.setTime(new Date().getTime());
	    System.out.print("| " + myDate.getTime() + " |  " + df.format(myDate) + "  |");
	    b = new BigInteger("0" + myDate.getTime());
	    b = b.divide(new BigInteger("30000"));
	    time = b.toString(16).toUpperCase();

	    while (time.length() < 16)
		time = "0" + time;
	    System.out.print(" " + time + " | ");
	    StringBuffer otp = new StringBuffer(TimebasedOnetimePassword.generateTOTP(seed, time, "6"));
	    System.out.println(otp + " |");

	    System.out.println("+------------+-----------------------+------------------+--------+");

	    // 保存短信动态密码/电子签名到返回信息中
	    iRow = requestXml.addRow(PacketParser.RESPONSE_ROW_NAME);
	    requestXml.setItemValue(PacketParser.RESPONSE_ROW_NAME, iRow, "OTP", otp.toString());

	} catch (Exception e) {
	    e.printStackTrace();
	}

    }
}