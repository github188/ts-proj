package cn.toso.ops.server.ssl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

import tower.tmvc.XMLWrap;
import EDU.oswego.cs.dl.util.concurrent.Sync;

public class ExchangeInfo {
    private Socket socket;

    private NBChannel nbChannel;

    private ReadableByteChannel readChannel;

    private WritableByteChannel writeChannel;

    Sync readLock;

    private ByteArrayOutputStream headerData;

    private ByteArrayOutputStream packetData;

    private boolean readingHeader;

    private int expectLength;

    private int remainLength;

    private boolean isFree;

    private long lastAccessTime;

    private XMLWrap headerXml;

    /**
         * 初始化，设置Socket，开始读取
         * 
         * @param socket
         * @param expectLength
         * @throws IOException
         */
    public ExchangeInfo(Socket socket) throws IOException {
	this.socket = socket;
	nbChannel = new NBChannel(socket);
	readChannel = (ReadableByteChannel) nbChannel;
	writeChannel = (WritableByteChannel) nbChannel;
	this.isFree = true;
    }

    public void startHeader(int headerLength) {
	headerData = new ByteArrayOutputStream(headerLength);
	expectLength = headerLength;
	remainLength = headerLength;
	readingHeader = true;
    }

    public void startPacket(int packetLength) {
	packetData = new ByteArrayOutputStream(packetLength);
	expectLength = packetLength;
	remainLength = packetLength;
	readingHeader = false;
    }

    public void append(byte[] bArray) {
	try {
	    if (readingHeader) {
		headerData.write(bArray);
		remainLength -= bArray.length;
	    } else {
		packetData.write(bArray);
		remainLength -= bArray.length;
	    }
	} catch (IOException e) {
	    // do nothing
	}
    }

    public int getRemainLength() {
	return remainLength;
    }

    public void setRemainLength(int remainLength) {
	this.remainLength = remainLength;
    }

    public int getExpectLength() {
	return expectLength;
    }

    public ByteArrayOutputStream getHeaderData() {
	return headerData;
    }

    public ByteArrayOutputStream getPacketData() {
	return packetData;
    }

    public ReadableByteChannel getReadChannel() {
	return readChannel;
    }

    public boolean isReadingHeader() {
	return readingHeader;
    }

    public Socket getSocket() {
	return socket;
    }

    public WritableByteChannel getWriteChannel() {
	return writeChannel;
    }

    public boolean isFree() {
	return isFree;
    }

    public void setFree(boolean isFree) {
	this.isFree = isFree;
    }

    public long getLastAccessTime() {
	return lastAccessTime;
    }

    public void setLastAccessTime(long lastAccesTime) {
	this.lastAccessTime = lastAccesTime;
    }

    public XMLWrap getHeaderXml() {
	return headerXml;
    }

    public void setHeaderXml(XMLWrap headerXml) {
	this.headerXml = headerXml;
    }

}
