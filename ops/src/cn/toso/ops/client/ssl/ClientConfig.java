package cn.toso.ops.client.ssl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import cn.toso.ops.util.ConfigException;


public class ClientConfig {
	public String hostAddress;

	public int portNumber;

	public int maxWaitTimeForHandshakeToComplete;

	public String keyStorePath;

	public String passPhrase;

	public String packetConfigPath;

	public String packetElementsFileName;

	public String packetHeaderFileName;

	public String packetDirectory;

	public String errorMsgXmlPath;

	public String CODE;

	public String APPCODE;

	public String CHANNELCODE;

	// public String UNITNO;

	public String DEVICENO;

	// public String TELLID;

	public ClientConfig() {

	}

	public static ClientConfig createConfig(String propertiesFilename)
			throws ConfigException, IOException {
		ClientConfig clientConfig = new ClientConfig();
		FileInputStream fis;
		Properties props;
		String tmp;

		// 读取配置信息
		fis = new FileInputStream(propertiesFilename);

		props = new Properties();
		props.load(fis);

		// *********************************************************************
		// 配置:主机IP或机器名,端口号,最大等待握手时间,keyStorePath,passPhrase ********
		// *********************************************************************
		// 主机地址
		tmp = props.getProperty("hostAddress");
		if (tmp == null || tmp.trim().length() == 0) {
			throw new ConfigException("hostAddress");
		}
		clientConfig.hostAddress = tmp;

		// 端口号
		tmp = props.getProperty("portNumber");
		if (tmp == null || tmp.trim().length() == 0) {
			throw new ConfigException("portNumber");
		}
		try {
			clientConfig.portNumber = Integer.parseInt(tmp);
		} catch (NumberFormatException e) {
			throw new ConfigException("portNumber", tmp);
		}

		// SSL握手最大等待时间
		tmp = props.getProperty("maxWaitTimeForHandshakeToComplete");
		if (tmp == null || tmp.trim().length() == 0) {
			throw new ConfigException("maxWaitTimeForHandshakeToComplete");
		}
		try {
			clientConfig.maxWaitTimeForHandshakeToComplete = Integer
					.parseInt(tmp);
		} catch (NumberFormatException e) {
			throw new ConfigException("maxWaitTimeForHandshakeToComplete", tmp);
		}

		// keyStorePath
		tmp = props.getProperty("keyStorePath");
		if (tmp == null || tmp.trim().length() == 0) {
			throw new ConfigException("keyStorePath");
		}
		clientConfig.keyStorePath = tmp;

		// passPhrase
		tmp = props.getProperty("passPhrase");
		if (tmp == null || tmp.trim().length() == 0) {
			throw new ConfigException("passPhrase");
		}
		clientConfig.passPhrase = tmp;

		// *********************************************************************
		// 配置:配置文件目录,报文要素定义文件名,报文头定义文件名,各交易传递定义文件目录 ******
		// *********************************************************************
		// 配置文件目录
		tmp = props.getProperty("packetConfigPath");
		if (tmp == null || tmp.trim().length() == 0) {
			throw new ConfigException("packetConfigPath");
		}
		clientConfig.packetConfigPath = tmp;

		// 报文要素定义文件名
		tmp = props.getProperty("packetElementsFileName");
		if (tmp == null || tmp.trim().length() == 0) {
			throw new ConfigException("packetElementsFileName");
		}
		clientConfig.packetElementsFileName = tmp;

		// 报文头定义文件名
		tmp = props.getProperty("packetHeaderFileName");
		if (tmp == null || tmp.trim().length() == 0) {
			throw new ConfigException("packetHeaderFileName");
		}
		clientConfig.packetHeaderFileName = tmp;

		// 各交易传递定义文件目录
		tmp = props.getProperty("packetDirectory");
		if (tmp == null || tmp.trim().length() == 0) {
			throw new ConfigException("packetDirectory");
		}
		clientConfig.packetDirectory = tmp;

		// *********************************************************************
		// 配置:功能配置文件路径,事务配置文件路径,错误配置文件路径 ***********************
		// *********************************************************************

		// 错误配置文件路径
		tmp = props.getProperty("errorMsgXmlPath");
		if (tmp == null || tmp.trim().length() == 0) {
			throw new ConfigException("errorMsgXmlPath");
		}
		clientConfig.errorMsgXmlPath = tmp;

		// 报文头要素CODE缺省值
		tmp = props.getProperty("CODE");
		if (tmp == null || tmp.trim().length() == 0) {
			throw new ConfigException("CODE");
		}
		clientConfig.CODE = tmp;

		// 报文头要素APPCODE缺省值
		tmp = props.getProperty("APPCODE");
		if (tmp == null || tmp.trim().length() == 0) {
			throw new ConfigException("APPCODE");
		}
		clientConfig.APPCODE = tmp;

		// 报文头要素CHANNELCODE缺省值
		tmp = props.getProperty("CHANNELCODE");
		if (tmp == null || tmp.trim().length() == 0) {
			throw new ConfigException("CHANNELCODE");
		}
		clientConfig.CHANNELCODE = tmp;

		// //报文头要素UNITNO缺省值
		// tmp = props.getProperty("UNITNO");
		// if (tmp == null || tmp.trim().length() == 0) {
		// throw new ConfigException("UNITNO");
		// }
		// clientConfig.UNITNO = tmp;

		// 报文头要素DEVICENO缺省值
		tmp = props.getProperty("DEVICENO");
		if (tmp == null || tmp.trim().length() == 0) {
			throw new ConfigException("DEVICENO");
		}
		clientConfig.DEVICENO = tmp;

		// //报文头要素TELLID缺省值
		// tmp = props.getProperty("TELLID");
		// if (tmp == null || tmp.trim().length() == 0) {
		// throw new ConfigException("TELLID");
		// }
		// clientConfig.TELLID = tmp;

		return clientConfig;
	}
}
