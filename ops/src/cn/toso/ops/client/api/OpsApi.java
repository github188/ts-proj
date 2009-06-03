package cn.toso.ops.client.api;

import java.io.File;
import java.io.IOException;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import tmvc.common.FatalException;
import tmvc.common.XMLWrap;
import tmvc.common.config.ErrorMsg;
import tmvc.common.config.ErrorMsgConfig;
import cn.toso.ops.client.entity.ResponseData;
import cn.toso.ops.client.ssl.ClientConfig;
import cn.toso.ops.client.ssl.ClientConnection;

public class OpsApi {
    static final int ROW_COUNT_PER_GETTING = 1;

    static final String IN_PARA_REQ_ERRCODE = "P00001";

    static final String OUT_PARA_REQ_ERRCODE = "P00002";

    /**
         * 用于连接服务器的SSL客户端连接
         */
    ClientConnection clientConn;

    /**
         * 客户端配置
         */
    ClientConfig config;

    /**
         * 用于发送的报文头内容
         */
    XMLWrap headerXmlSend;

    /**
         * 用于发送的报文体内容
         */
    XMLWrap packetXmlSend;

    /**
         * 用于保存对接收的报文头的引用
         */
    XMLWrap headerXmlRecv;

    /**
         * 用于保存对接收的报文体的引用
         */
    XMLWrap packetXmlRecv;

    /**
         * 用于保存错误代号
         */
    String errorCode;

    /**
         * 
         * 
         */
    ErrorMsgConfig errorMsgConfig;

    public OpsApi() {
	clientConn = ClientConnection.createClientConnection();
	config = clientConn.getClientConfig();

	Document doc;
	SAXBuilder builder = new SAXBuilder();
	try {
	    doc = builder.build(new File(config.errorMsgXmlPath));
	    errorMsgConfig = new ErrorMsgConfig(doc);
	} catch (JDOMException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (FatalException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    public String getErrorCode() {
	return errorCode;
    }

    public String getErrorMessage() {
	if (errorMsgConfig == null) {
	    return errorCode + "  Note:Can not find the file errors.xml! Or it's format is invalid!";
	}
	ErrorMsg msg = errorMsgConfig.getErrorMsg(errorCode);
	if (msg == null) {
	    return errorCode + " Note:Can not find config for this error code in file errors.xml";
	}
	if (msg.getMessage() == null || msg.getMessage().trim().length() == 0) {
	    return errorCode + " Note:Can not find message node for this error code in file errors.xml";
	}
	return msg.getMessage();
    }

    public void closeConnection() {
	clientConn.closeConnection();
    }

    /**
         * 验证动态密码；返回单条记录的API方法。
         * 
         * @param userId
         *                required
         * @param otp
         *                required
         * @param rd
         *                required
         * @return 0 - success; -1 - failure.
         */
    public int eapVerifyCode(String userId, String otp, ResponseData rd) {
	rd.setInt("OTPS_LEFT", 0);
	clearErrorCode();
	int res = 0;

	// 检查参数
	if (userId == null || userId.length() == 0) {
	    this.errorCode = IN_PARA_REQ_ERRCODE;
	    return -1;
	}
	if (otp == null || otp.length() == 0) {
	    this.errorCode = IN_PARA_REQ_ERRCODE;
	    return -1;
	}
	if (rd == null) {
	    this.errorCode = OUT_PARA_REQ_ERRCODE;
	    return -1;
	}

	// 准备发送数据:报文头
	headerXmlSend = buildHeaderXmlSend();
	headerXmlSend.addInputRow("TRCODE");
	headerXmlSend.setInputValue("TRCODE", 1, "0013");

	// 准备发送数据:报文
	packetXmlSend = new XMLWrap();
	packetXmlSend.addInputRow("USER_ID");
	packetXmlSend.setInputValue("USER_ID", 1, userId);
	packetXmlSend.addInputRow("OTP");
	packetXmlSend.setInputValue("OTP", 1, otp);

	// 发送请求报文
	res = clientConn.sendData(headerXmlSend, packetXmlSend);

	// 判断有无出错
	if (res == -1) {
	    this.errorCode = clientConn.getErrorCode();
	    return res;
	}

	// 取得返回数据
	headerXmlRecv = clientConn.getHeaderXml();
	packetXmlRecv = clientConn.getPacketXml();

	String retCode = headerXmlRecv.getInputValue("RETCODE");

	if (!"000000".equals(retCode)) {
	    res = -1;
	    this.errorCode = retCode;
	    return res;
	}

	// OTP_LEFT
	// int otpsLeft = Integer.parseInt(packetXmlRecv.getItemValue(
	// "RESPONSE_INFO", 1, "OTPS_LEFT"));
	// rd.setInt("OTPS_LEFT", otpsLeft);
	return res;
    }

    /**
         * 获取短信动态密码/电子签名；返回单条记录的API方法。
         * 
         * @param userId
         *                required
         * @param signData
         *                required
         * @param rd
         *                required
         * @return 0 - success; -1 - failure.
         */
    public int eapRetrieveOTP(String userId, String signData, ResponseData rd) {
	clearErrorCode();
	int res = 0;

	// 检查参数
	if (userId == null || userId.length() == 0) {
	    this.errorCode = IN_PARA_REQ_ERRCODE;
	    return -1;
	}

	if (rd == null) {
	    this.errorCode = OUT_PARA_REQ_ERRCODE;
	    return -1;
	}

	// 准备发送数据:报文头
	headerXmlSend = buildHeaderXmlSend();
	headerXmlSend.addInputRow("TRCODE");
	headerXmlSend.setInputValue("TRCODE", 1, "0024");

	// 准备发送数据:报文
	packetXmlSend = new XMLWrap();
	packetXmlSend.addInputRow("USER_ID");
	packetXmlSend.setInputValue("USER_ID", 1, userId);
	packetXmlSend.addInputRow("SIGN_DATA");
	packetXmlSend.setInputValue("SIGN_DATA", 1, signData);

	// 发送请求报文
	res = clientConn.sendData(headerXmlSend, packetXmlSend);

	// 判断有无出错
	if (res == -1) {
	    this.errorCode = clientConn.getErrorCode();
	    return res;
	}

	// 取得返回数据
	headerXmlRecv = clientConn.getHeaderXml();
	packetXmlRecv = clientConn.getPacketXml();

	String retCode = headerXmlRecv.getInputValue("RETCODE");

	if (!"000000".equals(retCode)) {
	    res = -1;
	    this.errorCode = retCode;
	    return res;
	}
	String otp = headerXmlRecv.getItemValue("RESPONSE_INFO", 1, "OTP");
	rd.setString("OTP", otp);
	return res;
    }

    private void clearErrorCode() {
	errorCode = null;
    }

    private XMLWrap buildHeaderXmlSend() {
	XMLWrap res = new XMLWrap();
	res.addInputRow("CODE");
	res.setInputValue("CODE", 1, config.CODE);
	res.addInputRow("APPCODE");
	res.setInputValue("APPCODE", 1, config.APPCODE);
	res.addInputRow("CHANNELCODE");
	res.setInputValue("CHANNELCODE", 1, config.CHANNELCODE);
	// res.addInputRow("UNITNO");
	// res.setInputValue("UNITNO", 1, config.UNITNO);
	res.addInputRow("DEVICENO");
	res.setInputValue("DEVICENO", 1, config.DEVICENO);
	// res.addInputRow("TELLID");
	// res.setInputValue("TELLID", 1, config.TELLID);
	return res;
    }
}
