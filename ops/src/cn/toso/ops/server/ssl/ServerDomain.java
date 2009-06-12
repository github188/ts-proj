package cn.toso.ops.server.ssl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

import org.apache.log4j.Logger;

import cn.toso.ops.server.control.ControlInitException;
import cn.toso.ops.server.control.ControlPool;
import cn.toso.ops.util.ConfigException;
import cn.toso.ops.util.ElementConfig;
import cn.toso.ops.util.PacketConfig;
import cn.toso.ops.util.PacketParser;


public class ServerDomain implements Runnable {

	PacketParser parser;

	WorkScoutManager scoutManager;

	WorkDispatcher dispatcher;

	ControlPool controlPool;

	ServerConfig serverConfig;

	Logger logger;

	public static void main(String[] args) {
		try {
			String configFileName = null;
			if (args.length > 0) {
				configFileName = args[0];
			}
			ServerDomain serverDomain = new ServerDomain();
			serverDomain.init(configFileName);
			Thread workThread = new Thread(serverDomain, "workThread");
			Thread stopThread = new Thread(new StopRunnable(workThread,
					"stop.txt"), "stopThread");
			workThread.start();
			stopThread.start();
		} catch (FileNotFoundException e) {
			error("main()", "Missing config file:" + e.toString());
		} catch (IOException e) {
			error("main()", "Reading config file error:" + e.toString());
		} catch (ConfigException e) {
			error("main()", "Config error:" + e.toString());
		} catch (ControlInitException e) {
			error("main()", "Control init error:" + e.toString());
		}
	}

	public ServerDomain() {
		logger = Logger.getLogger(this.getClass());
	}

	public void run() {

		try {
			SSLServerSocket server = getServerSocket(serverConfig.port);

			if (server == null) {
				logger.error("Starting failed.");
				return;
			}

			if (logger.isInfoEnabled()) {
				logger.info("Waintting for connectting on port "
						+ serverConfig.port);
			}

			Socket socket;
			ExchangeInfo exchangeInfo;

			scoutManager.startScout();

			while (true) {
				if (scoutManager.isOverflow()) {
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						logger.error("run() sleep Error", e);
					}
				}
				try {
					socket = server.accept();
				} catch (IOException e) {
					error("ServerMain.run()::accept", "Net IO error:"
							+ e.toString());
					continue;
				}
				// System.out.println("TIME
				// ACCEPT\t"+System.currentTimeMillis());
				try {
					((SSLSocket) socket).startHandshake();
				} catch (IOException e) {
					error("ServerMain.run()::startHandshake", "Net IO error:"
							+ e.toString());
					continue;
				}
				// System.out.println("TIME HANDSHAKE
				// END\t"+System.currentTimeMillis());
				if (logger.isInfoEnabled()) {
					logger.info("Client accepted:" + socket);
				}
				try {
					exchangeInfo = new ExchangeInfo(socket);
				} catch (IOException e) {
					error("ServerMain.run()::create ExchangeInfo",
							"Net IO error:" + e.toString());
					continue;
				}
				exchangeInfo
						.startHeader(parser.headerConfig.elementsByteLength);
				// System.out.println("TIME ADD TO SCOUT
				// MANAGER\t"+System.currentTimeMillis());
				scoutManager.addExchangeInfo(exchangeInfo);
			}
		} catch (NullPointerException e) {
			error("ServerMain.run()", "Null Pointer error:" + e.toString());
		} finally {
			scoutManager.stopScout();
			dispatcher.stopDispatch();
		}
	}

	public void init(String configFileName) throws FileNotFoundException,
			IOException, ConfigException, ControlInitException {
		String propertiesFilename;

		// 读取Properties
		propertiesFilename = configFileName == null ? "eap_server.properties"
				: configFileName;
		System.out.println("EapServerDomain#init : Use config file '"
				+ configFileName + "'.");
		serverConfig = ServerConfig.createConfig(propertiesFilename);

		// 实例化PacketParser
		ElementConfig elementConfig = new ElementConfig();
		elementConfig.loadFromFile(serverConfig.packetConfigPath + "/"
				+ serverConfig.packetElementsFileName);
		if (elementConfig.errors != null) {
			logger.error(elementConfig.errors);
			throw new ControlInitException("EAPPacketElements.xml readError.");
		}

		ElementConfig headerConfig = new ElementConfig();
		headerConfig.loadFromFile(serverConfig.packetConfigPath + "/"
				+ serverConfig.packetHeaderFileName);
		if (headerConfig.errors != null) {
			logger.error(headerConfig.errors);
			throw new ControlInitException("EAPPacketHeader.xml readError.");
		}

		PacketConfig packetConfig = new PacketConfig();
		packetConfig.loadFromDirectory(serverConfig.packetConfigPath + "/"
				+ serverConfig.tradeDefDirectory, elementConfig);
		if (packetConfig.errors != null) {
			logger.error(packetConfig.errors);
			throw new ControlInitException("packetConfig files readError.");
		}

		parser = new PacketParser(headerConfig, packetConfig);

		controlPool = new ControlPool(serverConfig.functionsXmlPath,
				serverConfig.transactionXmlPath, serverConfig.errorMsgXmlPath,
				serverConfig.authServerConnParaFilePath);

		// 实例化WorkDispatcher
		dispatcher = new WorkDispatcher(parser, serverConfig.dispatcherMaxSize,
				serverConfig.dispatcherMinSize,
				serverConfig.dispatcherKeepAliveTime, controlPool);

		// 实例化WorkScoutManager
		scoutManager = new WorkScoutManager(dispatcher,
				serverConfig.scoutCount, serverConfig.scoutMaxSize,
				serverConfig.scoutFreeTimeAllowed);
	}

	/**
	 * @param port
	 *            监听的端口号
	 * @return 返回一个SSLServerSocket对象
	 */

	private SSLServerSocket getServerSocket(int thePort) {
		SSLServerSocket s = null;

		try {
			String key = serverConfig.keyPath;// "Cert"; // 要使用的证书名

			char keyStorePass[] = serverConfig.keyStorePass.toCharArray();// "520084".toCharArray();
			// //
			// 证书密码

			char keyPassword[] = serverConfig.keyPassword.toCharArray();// "520084".toCharArray();
			// //
			// 证书别称所使用的主要密码

			KeyStore ks = KeyStore.getInstance("JKS"); // 创建JKS密钥库

			ks.load(new FileInputStream(key), keyStorePass);

			// 创建管理JKS密钥库的X.509密钥管理器
			KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");

			kmf.init(ks, keyPassword);

			SSLContext sslContext = SSLContext.getInstance("SSLv3");

			sslContext.init(kmf.getKeyManagers(), null, null);

			// 根据上面配置的SSL上下文来产生SSLServerSocketFactory,与通常的产生方法不同
			SSLServerSocketFactory factory = sslContext
					.getServerSocketFactory();

			s = (SSLServerSocket) factory.createServerSocket(thePort);
		} catch (KeyManagementException e) {
			logger.error("SSL error", e);
		} catch (KeyStoreException e) {
			logger.error("SSL error", e);
		} catch (NoSuchAlgorithmException e) {
			logger.error("SSL error", e);
		} catch (CertificateException e) {
			logger.error("SSL error", e);
		} catch (FileNotFoundException e) {
			logger.error("SSL error", e);
		} catch (UnrecoverableKeyException e) {
			logger.error("SSL error", e);
		} catch (IOException e) {
			logger.error("SSL error", e);
		}

		return (s);
	}

	static void error(String pos, String msg) {
		System.err.print("Pos:" + pos);
		System.err.println("  Msg:" + msg);
	}
}
