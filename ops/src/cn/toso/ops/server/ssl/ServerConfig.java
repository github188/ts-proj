package cn.toso.ops.server.ssl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

import cn.toso.ops.util.ConfigException;


class ServerConfig {
	public int port;

	public String keyPath;

	public String keyStorePass;

	public String keyPassword;

	public int scoutCount;

	public int scoutMaxSize;

	public long scoutFreeTimeAllowed;

	public int dispatcherMaxSize;

	public int dispatcherMinSize;

	public long dispatcherKeepAliveTime;

	public String packetConfigPath;

	public String packetElementsFileName;

	public String packetHeaderFileName;

	public String tradeDefDirectory;

	public String functionsXmlPath;

	public String transactionXmlPath;

	public String errorMsgXmlPath;

	public String loggerConfigFilePath;

	public String authServerConnParaFilePath;

	public ServerConfig() {

	}

	public static ServerConfig createConfig(String propertiesFilename)
			throws ConfigException, IOException {
		ServerConfig serverConfig = new ServerConfig();
		FileInputStream fis;
		Properties props;
		String tmp;

		// 读取配置信息
		fis = new FileInputStream(propertiesFilename);

		props = new Properties();
		props.load(fis);
		// *********************************************************************
		// 配置:监听端口,key路径,keyStorePass,keyPassword *************************
		// *********************************************************************
		// 监听端口
		tmp = props.getProperty("port");
		if (tmp == null || tmp.trim().length() == 0) {
			throw new ConfigException("port");
		}
		try {
			serverConfig.port = Integer.parseInt(tmp);
		} catch (NumberFormatException e) {
			throw new ConfigException("port", tmp);
		}

		// key路径
		tmp = props.getProperty("keyPath");
		if (tmp == null || tmp.trim().length() == 0) {
			throw new ConfigException("keyPath");
		}
		serverConfig.keyPath = tmp;

		// keyStorePass
		tmp = props.getProperty("keyStorePass");
		if (tmp == null || tmp.trim().length() == 0) {
			throw new ConfigException("keyStorePass");
		}
		serverConfig.keyStorePass = tmp;

		// keyPassword
		tmp = props.getProperty("keyPassword");
		if (tmp == null || tmp.trim().length() == 0) {
			throw new ConfigException("keyPassword");
		}
		serverConfig.keyPassword = tmp;

		// *********************************************************************
		// 配置:数据监测者数目,每个监测者监控的连接的最多数目,允许每个Socket空闲的时间 ******
		// *********************************************************************
		// 监测者数目
		tmp = props.getProperty("scoutCount");
		if (tmp == null || tmp.trim().length() == 0) {
			throw new ConfigException("scoutCount");
		}
		try {
			serverConfig.scoutCount = Integer.parseInt(tmp);
		} catch (NumberFormatException e) {
			throw new ConfigException("scoutCount", tmp);
		}

		// 监控连接最多数目
		tmp = props.getProperty("scoutMaxSize");
		if (tmp == null || tmp.trim().length() == 0) {
			throw new ConfigException("scoutMaxSize");
		}
		try {
			serverConfig.scoutMaxSize = Integer.parseInt(tmp);
		} catch (NumberFormatException e) {
			throw new ConfigException("scoutMaxSize", tmp);
		}

		// 允许每个Socket空闲的时间
		tmp = props.getProperty("scoutFreeTimeAllowed");
		if (tmp == null || tmp.trim().length() == 0) {
			throw new ConfigException("scoutFreeTimeAllowed");
		}
		try {
			serverConfig.scoutFreeTimeAllowed = Long.parseLong(tmp);
		} catch (Exception e) {
			throw new ConfigException("scoutFreeTimeAllowed", tmp);
		}

		// *********************************************************************
		// 配置:数据处理派发者:线程池最大值,线程池最小值,线程保持活动的时间 ***************
		// *********************************************************************
		// 线程池最大值
		tmp = props.getProperty("dispatcherMaxSize");
		if (tmp == null || tmp.trim().length() == 0) {
			throw new ConfigException("dispatcherMaxSize");
		}
		try {
			serverConfig.dispatcherMaxSize = Integer.parseInt(tmp);
		} catch (NumberFormatException e) {
			throw new ConfigException("dispatcherMaxSize", tmp);
		}
		// 线程池最小值
		tmp = props.getProperty("dispatcherMinSize");
		if (tmp == null || tmp.trim().length() == 0) {
			throw new ConfigException("dispatcherMinSize");
		}
		try {
			serverConfig.dispatcherMinSize = Integer.parseInt(tmp);
		} catch (NumberFormatException e) {
			throw new ConfigException("dispatcherMinSize", tmp);
		}
		// 线程保持活动的时间
		tmp = props.getProperty("dispatcherKeepAliveTime");
		if (tmp == null || tmp.trim().length() == 0) {
			throw new ConfigException("dispatcherKeepAliveTime");
		}
		try {
			serverConfig.dispatcherKeepAliveTime = Long.parseLong(tmp);
		} catch (Exception e) {
			throw new ConfigException("dispatcherKeepAliveTime", tmp);
		}

		// *********************************************************************
		// 配置:配置文件目录,报文要素定义文件名,报文头定义文件名,各交易传递定义文件目录 ******
		// *********************************************************************
		// 配置文件目录
		tmp = props.getProperty("packetConfigPath");
		if (tmp == null || tmp.trim().length() == 0) {
			throw new ConfigException("packetConfigPath");
		}
		serverConfig.packetConfigPath = tmp;

		// 报文要素定义文件名
		tmp = props.getProperty("packetElementsFileName");
		if (tmp == null || tmp.trim().length() == 0) {
			throw new ConfigException("packetElementsFileName");
		}
		serverConfig.packetElementsFileName = tmp;

		// 报文头定义文件名
		tmp = props.getProperty("packetHeaderFileName");
		if (tmp == null || tmp.trim().length() == 0) {
			throw new ConfigException("packetHeaderFileName");
		}
		serverConfig.packetHeaderFileName = tmp;

		// 各交易传递定义文件目录
		tmp = props.getProperty("packetDirectory");
		if (tmp == null || tmp.trim().length() == 0) {
			throw new ConfigException("packetDirectory");
		}
		serverConfig.tradeDefDirectory = tmp;

		// *********************************************************************
		// 配置:功能配置文件路径,事务配置文件路径,错误配置文件路径 ***********************
		// *********************************************************************
		// 功能配置文件路径
		tmp = props.getProperty("functionsXmlPath");
		if (tmp == null || tmp.trim().length() == 0) {
			throw new ConfigException("functionsXmlPath");
		}
		serverConfig.functionsXmlPath = tmp;

		// 事务配置文件路径
		tmp = props.getProperty("transactionXmlPath");
		if (tmp == null || tmp.trim().length() == 0) {
			throw new ConfigException("transactionXmlPath");
		}
		serverConfig.transactionXmlPath = tmp;

		// 错误配置文件路径
		tmp = props.getProperty("errorMsgXmlPath");
		if (tmp == null || tmp.trim().length() == 0) {
			throw new ConfigException("errorMsgXmlPath");
		}
		serverConfig.errorMsgXmlPath = tmp;

		tmp = props.getProperty("loggerConfigFilePath");
		if (tmp == null || tmp.trim().length() == 0) {
			throw new ConfigException("loggerConfigFilePath");
		}
		serverConfig.loggerConfigFilePath = tmp;

		Properties logProp;
		InputStream inputStream;
		try {
			logProp = new Properties();
			inputStream = new FileInputStream(serverConfig.loggerConfigFilePath);
			logProp.load(inputStream);
			// 替换其中的常量
			Enumeration enumKey = logProp.keys();
			String key;
			String value;
			int pos;
			String keyAppPath = "{APP-PATH}";
			String keyValue = System.getProperty("user.dir", "")+"/";
			while (enumKey.hasMoreElements()) {
				key = (String) enumKey.nextElement();
				value = logProp.getProperty(key);
				if (value != null) {
					pos = value.indexOf(keyAppPath);
					if (pos >= 0) {
						value = value.substring(0, pos) + keyValue
								+ value.substring(pos + keyAppPath.length());
						logProp.setProperty(key, value);
					}
				}
			}
			PropertyConfigurator.configure(logProp);
		} catch (IOException e) {
			throw new ConfigException("loggerConfigFilePath",
					serverConfig.loggerConfigFilePath);
		}

		tmp = props.getProperty("authServerConnParaFilePath");
		if (tmp == null || tmp.trim().length() == 0) {
			throw new ConfigException("authServerConnParaFilePath");
		}
		serverConfig.authServerConnParaFilePath = tmp;

		return serverConfig;
	}
}