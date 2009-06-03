package cn.toso.ops.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class AuthServerConnPara {

	public String authServerClassName;

	public int acExpireDays;

	public String hostAddress;

	public String hostPort;

	public String maxWaitTime;

	public String keystorePath;

	public String keystorePass;
	
	public String otpTimeLimit;

	public String CODE;
	
	public String APPCODE;
	
	public String CHANNELCODE;
	
	public String DEVICENO;
	
	public String futureCardFilePath;

	public synchronized void fillToMap(Map paraMap) {
		paraMap.put("hostAddress", hostAddress);
		paraMap.put("hostPort", hostPort);
		paraMap.put("maxWaitTime", maxWaitTime);
		paraMap.put("keystorePath", keystorePath);
		paraMap.put("keystorePass", keystorePass);
	}

	public synchronized HashMap buildParaMap() {
		HashMap res = new HashMap();
		fillToMap(res);
		return res;
	}

	public static AuthServerConnPara createConfig(String propertiesFilename)
			throws IOException {
		AuthServerConnPara res = new AuthServerConnPara();
		FileInputStream fis;
		Properties props;
		fis = new FileInputStream(propertiesFilename);

		props = new Properties();
		props.load(fis);

		res.authServerClassName = props.getProperty("authServerClassName");
		res.acExpireDays = Integer.parseInt(props.getProperty("expireDays", "10"));
		res.hostAddress = props.getProperty("hostAddress");
		res.hostPort = props.getProperty("hostPort");
		res.maxWaitTime = props.getProperty("maxWaitTime");
		res.keystorePath = props.getProperty("keystorePath");
		res.keystorePass = props.getProperty("keystorePass");
		res.otpTimeLimit = props.getProperty("otpTimeLimit");
		
		res.CODE = props.getProperty("CODE");
		res.APPCODE = props.getProperty("APPCODE");
		res.CHANNELCODE = props.getProperty("CHANNELCODE");
		res.DEVICENO = props.getProperty("DEVICENO");
		
		res.futureCardFilePath = props.getProperty("futureCardFilePath");
		return res;
	}
}
