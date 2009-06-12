package cn.toso.ops.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import tmvc.common.XMLWrap;

public class PacketParser {
	/**
	 * 报文标志可取值之一,请求报文
	 */
	public static final int PACKET_FLAG_REQUEST = 0;

	/**
	 * 报文标志可取值之一,响应报文
	 */
	public static final int PACKET_FLAG_RESPONSE = 1;
	
	
	public static final String RESPONSE_ROW_NAME = "RESPONSE_INFO";

	/**
	 * 报文配置
	 */
	public PacketConfig packetConfig;

	/**
	 * 报文头配置
	 */
	public ElementConfig headerConfig;

	public PacketParser(ElementConfig headerConfig, PacketConfig packetConfig) {
		this.headerConfig = headerConfig;
		this.packetConfig = packetConfig;
	}

	public byte[] xmlToBytes(XMLWrap packetHeaderXml, XMLWrap packetXml,
			int packetFlag) {
		/*
		 * 检查必输参数是否输入 检查报头定义文件是否存在 #读取报头定义文件 将报文头XML转换成报文串 检查报文要素定义文件是否存在
		 * #读取报文要素定义 根据报文标志,取得相应报文定义文件中的request或response部分 for(i<返回记录数)
		 * 自XML中取得一条报文记录,转换为报文串 返回报文头+报文字节数组
		 */

		// 1024 refer to the capacity,not the content length
		ByteArrayOutputStream headerOs = new ByteArrayOutputStream(1024);
		ByteArrayOutputStream packetOs = new ByteArrayOutputStream(1024);
		ByteArrayOutputStream res = new ByteArrayOutputStream(1024);

		// 转换报文
		// 查询报文配置
		String trCode;
		Packet packet;
		String rowName;
		List elements;
		PacketElement element;
		String value;
		int packetByteLength;
		int rowCount;

		// get funcId/trCode
		trCode = packetHeaderXml.getInputValue("TRCODE");

		packet = packetConfig.getPacket(trCode);

		// trans request or response packet
		if (PACKET_FLAG_REQUEST == packetFlag) {
			rowCount = 1;
			elements = packet.requestElements;
			packetByteLength = packet.requestByteLength;

			for (int item = 0; item < elements.size(); item++) {
				element = (PacketElement) elements.get(item);

				value = packetXml.getInputValue(element.name);
				addToStream(packetOs, element, value);
			}
		} else {
			rowName = RESPONSE_ROW_NAME;
			elements = packet.responseElements;
			packetByteLength = packet.responseByteLength;

			rowCount = packetXml.getRowCount(rowName);
			for (int row = 0; row < rowCount; row++) {

				for (int item = 0; item < elements.size(); item++) {
					element = (PacketElement) elements.get(item);

					value = packetXml.getItemValue(rowName, row + 1,
							element.name);

					addToStream(packetOs, element, value);
				}
			}
		}

		// trans header value
		elements = headerConfig.elementsList;
		// Note: elements.size()-1,because the packetLength is not filled by the
		// caller
		for (int item = 0; item < elements.size() - 1; item++) {
			element = (PacketElement) elements.get(item);

			value = packetHeaderXml.getInputValue(element.name);

			addToStream(headerOs, element, value);
		}

		// calculate packetLenght, the packetLength must be the last element of
		// the config xml
		element = (PacketElement) elements.get(elements.size() - 1);
		value = String.valueOf(rowCount * packetByteLength);
		addToStream(headerOs, element, value);

		try {
			headerOs.writeTo(res);
			packetOs.writeTo(res);
		} catch (IOException e) {
			// ignore
		}
		return res.toByteArray();
	}

	public XMLWrap bytesToHeaderXml(byte[] headerBytes) {
		XMLWrap res = new XMLWrap();

		int from;
		int to;
		List elements;
		PacketElement element;

		elements = headerConfig.elementsList;

		from = 0;
		for (int i = 0; i < elements.size(); i++) {
			element = (PacketElement) elements.get(i);

			to = from + element.length;

			// value = new String(headerBytes, from, to, "UTF-8");

			// res.setItemValue("HEADER_INFO", row, element.name, value);

			addToXml(res, element.name, 1, element, headerBytes, from, to,
					PACKET_FLAG_REQUEST);

			from = to;
		}

		return res;
	}

	public XMLWrap bytesToPacketXml(byte[] packetBytes, String trCode,
			int packetFlag) {
		XMLWrap res = new XMLWrap();

		Packet packet;
		String rowName;
		List elements;
		PacketElement element;
		int from, to;
		int recCount;
		int packetLength;

		packet = packetConfig.getPacket(trCode);

		// trans request or response packet
		if (PACKET_FLAG_REQUEST == packetFlag) {
			// rowName = "REQUEST_INFO";
			elements = packet.requestElements;
			packetLength = packet.requestByteLength;
			recCount = packetBytes.length / packetLength;

			from = 0;

			for (int row = 0; row < recCount; row++) {
				for (int item = 0; item < elements.size(); item++) {
					element = (PacketElement) elements.get(item);

					// value = packetXml.getItemValue(rowName, row + 1,
					// element.name);

					// addToStream(packetOs, element, value);
					to = from + element.length;

					addToXml(res, element.name, 1, element, packetBytes, from,
							to, packetFlag);

					from = to;
				}
			}
		} else {
			rowName = RESPONSE_ROW_NAME;
			elements = packet.responseElements;
			packetLength = packet.responseByteLength;
			recCount = packetBytes.length / packetLength;

			from = 0;
			for (int row = 0; row < recCount; row++) {
				res.addRow(rowName);
				for (int item = 0; item < elements.size(); item++) {
					element = (PacketElement) elements.get(item);

					// value = packetXml.getItemValue(rowName, row + 1,
					// element.name);

					// addToStream(packetOs, element, value);
					to = from + element.length;

					addToXml(res, rowName, row + 1, element, packetBytes, from,
							to, packetFlag);

					from = to;
				}
			}
		}
		return res;
	}

	private void addToXml(XMLWrap xml, String rowName, int row,
			PacketElement element, byte[] byteValue, int from, int to,
			int packetFlag) {
		byte fillChar = element.fillCharacter;
		String value;

		try {
			if (element.fillMode == PacketElement.FILL_MODE_LEFT) {
				while (from<to && byteValue[from] == fillChar) {
					from++;
				}
			} else {
				while (from < to && byteValue[to - 1] == fillChar) {
					to--;
				}
			}

			if (PACKET_FLAG_REQUEST == packetFlag) {
				row = xml.addInputRow(rowName);
			}
			if (from < to) {
				value = new String(byteValue, from, to - from, "UTF-8");
				if (PACKET_FLAG_REQUEST == packetFlag) {
					xml.setInputValue(rowName, row, value);
				} else {
					xml.setItemValue(rowName, row, element.name, value);
				}
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void addToStream(ByteArrayOutputStream baos, PacketElement element,
			String value) {
		byte fillChar = element.fillCharacter;
		byte[] byteValue;
		int fillCharCount;
		try {
			byteValue = value.getBytes("UTF-8");

			if (byteValue.length >= element.length) {
				// cut to fit element.length
				baos.write(byteValue, 0, element.length);
			} else {
				fillCharCount = element.length - byteValue.length;
				if (element.fillMode == PacketElement.FILL_MODE_LEFT) {
					for (int i = 0; i < fillCharCount; i++) {
						baos.write(fillChar);
					}
					baos.write(byteValue);
				} else {
					baos.write(byteValue);
					for (int i = 0; i < fillCharCount; i++) {
						baos.write(fillChar);
					}
				}
			}
		} catch (Exception e) {
			// ignore
		}
	}
}
