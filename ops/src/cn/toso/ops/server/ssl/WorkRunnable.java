package cn.toso.ops.server.ssl;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

import org.apache.log4j.Logger;

import cn.toso.ops.server.control.ControlInitException;
import cn.toso.ops.server.control.ControlPool;
import cn.toso.ops.server.control.EapApiControl;
import cn.toso.ops.util.PacketParser;
import cn.toso.ops.util.PubFunc;
import cn.toso.ops.util.SeqNoGennor;

import tmvc.common.ErrorException;
import tmvc.common.XMLWrap;

public class WorkRunnable implements Runnable {
	ExchangeInfo exInfo;

	PacketParser parser;

	ControlPool controlPool;

	EapApiControl eapApiControl;

	Logger logger;

	public WorkRunnable(ExchangeInfo exchangeInfo, PacketParser parser,
			ControlPool controlPool) {
		this.exInfo = exchangeInfo;
		this.parser = parser;
		this.controlPool = controlPool;
		logger = Logger.getLogger(this.getClass());
	}

	public void run() {
		ReadableByteChannel readChannel = exInfo.getReadChannel();
		ByteBuffer rBuf;
		byte[] bBuf;
		int res;
		XMLWrap headerXml;
		int packetLength;

		try {
			// System.out.println("TIME RUN BGN\t"+System.currentTimeMillis());
			// exInfo.getReadLock().acquire();
			if (exInfo.isReadingHeader()) {
				// 若是读Header
				// ********************************************************

				if (exInfo.getRemainLength() > 0) {
					// 若没读完Header
					// 读取Header
					rBuf = ByteBuffer.allocate(exInfo.getRemainLength());
					res = readChannel.read(rBuf);
					if (res > 0) {
						// 读到数了
						rBuf.flip();
						bBuf = rBuf.array();
						exInfo.append(bBuf);
					}
				}

				if (exInfo.getRemainLength() == 0) {
					// 若读完Header***************************************
					// 解析Header
					headerXml = parser.bytesToHeaderXml(exInfo.getHeaderData()
							.toByteArray());
					exInfo.setHeaderXml(headerXml);

					// startPacket(ParseResult.length),
					packetLength = Integer.parseInt(headerXml
							.getInputValue("PACKETLENGTH"));
					exInfo.startPacket(packetLength);
					// 读取Packet
					rBuf = ByteBuffer.allocate(packetLength);
					rBuf.clear();
					res = readChannel.read(rBuf);
					if (res > 0) {
						rBuf.flip();
						bBuf = rBuf.array();
						exInfo.append(bBuf);
					}
					if (exInfo.getRemainLength() == 0) {
						// 若读完Packet*****************************
						// 处理数据
						doBo();
						// startHeader(PacketHeaderConfig.length)
						exInfo
								.startHeader(parser.headerConfig.elementsByteLength);
						// 结束(若读完Packet)************************
					}

					// 若未读完Packet,返回

				}// 结束(若读完Header)**********************************

				// 若未读完Header,返回

				// 结束(若是读Header)
				// ***************************************************
			} else {
				// 若是读Packet
				// ********************************************************
				if (exInfo.getRemainLength() > 0) {
					// 若未读完Packet
					// 读取Packet
					rBuf = ByteBuffer.allocate(exInfo.getRemainLength());
					res = readChannel.read(rBuf);
					if (res > 0) {
						rBuf.flip();
						bBuf = rBuf.array();
						exInfo.append(bBuf);
					}
				}

				if (exInfo.getRemainLength() == 0) {
					// 若读完Packet*****************************
					// 处理数据
					doBo();
					// startHeader(PacketHeaderConfig.length)
					exInfo.startHeader(parser.headerConfig.elementsByteLength);
					// 结束(若读完Packet)************************

				}
				// 若未读完Packet,返回

				// 结束(若是读Packet)
				// ***************************************************
			}
			// System.out.println("TIME RUN END\t"+System.currentTimeMillis());
			// exInfo.getSocket().close();
		} catch (IOException e) {
			logger.error("run() IO Error", e);
		} finally {
			exInfo.setFree(true);
			// exInfo.getReadLock().release();
		}
	}

	/**
	 * 处理数据
	 * 
	 * @param headerXml
	 * @param packetData
	 * @param writeChannel
	 */
	private void doBo() {
		WritableByteChannel writeChannel;
		byte[] bPacketData;
		XMLWrap headerXml;
		XMLWrap packetXml;
		String trCode;

		byte[] dataSend;
		String retCode = "000000";

		if (logger.isInfoEnabled()) {
			logger.info("Received Header:["
					+ new String(exInfo.getHeaderData().toByteArray()) + "]");
			logger.info("Received Packet:["
					+ new String(exInfo.getPacketData().toByteArray()) + "]");
		}

		bPacketData = exInfo.getPacketData().toByteArray();
		headerXml = exInfo.getHeaderXml();
		trCode = headerXml.getInputValue("TRCODE");
		// 解析Packet
		packetXml = parser.bytesToPacketXml(bPacketData, trCode,
				PacketParser.PACKET_FLAG_REQUEST);
		// 设置FUNC_ID
		packetXml.addInputRow("FUNC_ID");
		packetXml.setInputValue("FUNC_ID", 1, trCode);

		try {
			// 交给Bo处理
			// System.out.println("TIME GET CONTROL
			// BGN\t"+System.currentTimeMillis());
			eapApiControl = controlPool.get();
			// System.out.println("TIME GET CONTROL
			// END\t"+System.currentTimeMillis());

			// 验证服务器连接参数
			if (headerXml.getInputRowCount("AuthServerConnPara") == 0) {
				headerXml.addInputRow("AuthServerConnPara");
			}
			headerXml.setInputValue("AuthServerConnPara", 1,
					eapApiControl.authServerConnPara);

			// 序号
			if (headerXml.getInputRowCount("SEQ_NO") == 0) {
				headerXml.addInputRow("SEQ_NO");
			}
			headerXml.setInputValue("SEQ_NO", 1, SeqNoGennor.createGennor()
					.next());

			// 交易日期/时间
			String now = PubFunc.GenNowTime();
			if (headerXml.getInputRowCount("TRDATE") == 0) {
				headerXml.addInputRow("TRDATE");
			}
			headerXml.setInputValue("TRDATE", 1, now.substring(0, 8));

			if (headerXml.getInputRowCount("TRTIME") == 0) {
				headerXml.addInputRow("TRTIME");
			}
			headerXml.setInputValue("TRTIME", 1, now.substring(8));

			// System.out.println("TIME CTRL BGN
			// SERVICE\t"+System.currentTimeMillis());
			eapApiControl.service(headerXml, packetXml);
			// System.out.println("TIME CTRL END
			// SERVICE\t"+System.currentTimeMillis());
		} catch (ControlInitException e) {
			logger.error("doBo() get control Error", e);
			retCode = "CTRL01";
		} catch (ErrorException e) {
			logger.error("doBo() error from control", e);
			retCode = e.getCode();
		} finally {
			controlPool.put(eapApiControl);
		}

		// 打包Bo处理结果
		if (headerXml.getInputRowCount("RETCODE") == 0) {
			headerXml.addInputRow("RETCODE");
		}
		headerXml.setInputValue("RETCODE", 1, retCode);
		// 处理结果发给客户端
		// System.out.println("TIME SEND:XML TO BYTES
		// BGN\t"+System.currentTimeMillis());
		dataSend = parser.xmlToBytes(headerXml, packetXml,
				PacketParser.PACKET_FLAG_RESPONSE);
		// System.out.println("TIME SEND:XML TO BYTES
		// END\t"+System.currentTimeMillis());

		if (logger.isInfoEnabled()) {
			logger.info("Send Data:[" + new String(dataSend) + "]");
		}
		ByteBuffer bBuf = ByteBuffer.wrap(dataSend);
		try {
			// System.out.println("TIME SEND:WRITE
			// BGN\t"+System.currentTimeMillis());
			writeChannel = exInfo.getWriteChannel();
			writeChannel.write(bBuf);
			// System.out.println("TIME SEND:WRITE
			// END\t"+System.currentTimeMillis());
		} catch (IOException e) {
			logger.error("doBo() write data to client Error", e);
		}
	}
}
