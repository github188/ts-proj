package cn.toso.ops.client.ssl;

import java.io.FileNotFoundException;
import java.io.IOException;

import se.todos.FilterException;
import se.todos.SSLServerConnection;
import se.todos.SocketErrorException;
import tower.tmvc.XMLWrap;
import cn.toso.ops.util.ConfigException;
import cn.toso.ops.util.ElementConfig;
import cn.toso.ops.util.PacketConfig;
import cn.toso.ops.util.PacketParser;

public class ClientConnection {

    private byte[] bufRecv = new byte[1024];

    private SSLServerConnection conn;

    private XMLWrap headerXml;

    private XMLWrap packetXml;

    private ClientConfig clientConfig;

    private PacketParser parser;

    private int headerByteLength;// 报文头字节长度

    private String errorCode;

    private ClientConnection() {

    }

    public static ClientConnection createClientConnection() {
	ClientConnection res = new ClientConnection();
	String configFileName = "eap_client.properties";
	// 初始化
	try {
	    res.init(configFileName);
	} catch (FileNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    return null;
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    return null;
	} catch (ConfigException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    return null;
	}

	// 开始Todos SSL Connection
	try {
	    res.conn = new SSLServerConnection(res.clientConfig.hostAddress, res.clientConfig.portNumber,
		    res.clientConfig.maxWaitTimeForHandshakeToComplete, res.clientConfig.keyStorePath,
		    res.clientConfig.passPhrase.toCharArray());
	} catch (FilterException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	    return null;
	}

	// // 初始化SSL Connection
	// try {
	// res.conn.init();
	// } catch (SocketErrorException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// return null;
	// }
	return res;
    }

    public void init(String configFileName) throws FileNotFoundException, IOException, ConfigException {
	String propertiesFilename;

	// 读取Properties
	propertiesFilename = configFileName == null ? "eap_server.properties" : configFileName;
	clientConfig = ClientConfig.createConfig(propertiesFilename);

	// 实例化PacketParser
	ElementConfig elementConfig = new ElementConfig();
	elementConfig.loadFromFile(clientConfig.packetConfigPath + "/" + clientConfig.packetElementsFileName);
	ElementConfig headerConfig = new ElementConfig();
	headerConfig.loadFromFile(clientConfig.packetConfigPath + "/" + clientConfig.packetHeaderFileName);
	PacketConfig packetConfig = new PacketConfig();
	packetConfig.loadFromDirectory(clientConfig.packetConfigPath + "/" + clientConfig.packetDirectory,
		elementConfig);
	parser = new PacketParser(headerConfig, packetConfig);

	headerByteLength = parser.headerConfig.elementsByteLength;
    }

    public void closeConnection() {
	try {
	    conn.closeConnection();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    public int sendData(XMLWrap packetHeaderXmlSend, XMLWrap packetXmlSend) {
	byte[] bufSend;// 发送的数据
	byte[] recvData;// 接收的数据

	byte[] headerData;
	byte[] packetData;

	String trCode;
	String retCode;

	// 构造发送数据
	bufSend = parser.xmlToBytes(packetHeaderXmlSend, packetXmlSend, PacketParser.PACKET_FLAG_REQUEST);

	// 发送并接收数据
	try {
	    recvData = conn.sendAndReceive(bufSend, bufRecv, 1);
	} catch (SocketErrorException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    return -1;
	}

	// 处理接收数据
	// System.out.println("Received Data:["+new String(recvData)+"]");
	if (recvData.length < headerByteLength) {
	    return -1;
	}

	// 拆分出报文头数据
	headerData = new byte[headerByteLength];
	System.arraycopy(recvData, 0, headerData, 0, headerByteLength);

	// System.out.println("Received Header:["+new String(headerData)+"]");
	// 解析报文头数据
	headerXml = parser.bytesToHeaderXml(headerData);

	// 取得返回码
	retCode = headerXml.getInputValue("RETCODE");

	// 拆分出报文数据
	if ("000000".equals(retCode) && recvData.length > headerByteLength) {
	    packetData = new byte[recvData.length - headerByteLength];
	    System.arraycopy(recvData, headerByteLength, packetData, 0, recvData.length - headerByteLength);
	    // System.out.println("Received Packet:["+new
                // String(packetData)+"]");

	    trCode = headerXml.getInputValue("TRCODE");
	    this.packetXml = parser.bytesToPacketXml(packetData, trCode, PacketParser.PACKET_FLAG_RESPONSE);
	} else {
	    // System.out.println("Received Packet:[]");
	    this.packetXml = new XMLWrap();
	}

	return 0;
    }

    public XMLWrap getHeaderXml() {
	return headerXml;
    }

    public XMLWrap getPacketXml() {
	return packetXml;
    }

    public String getErrorCode() {
	return errorCode;
    }

    public ClientConfig getClientConfig() {
	return clientConfig;
    }
}
