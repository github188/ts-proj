package cn.toso.ops.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/**
 * 交易参数传递要素定义
 * 
 * @author suilaiji
 */
public class Packet {
	/**
	 * 交易号
	 */
	public String funcId;

	/**
	 * 交易名称
	 */
	public String funcName;

	/**
	 * 交易描述
	 */
	public String funcDesc;

	/**
	 * 请求参数name表
	 */
	public List requests;

	/**
	 * 响应参数name表
	 */
	public List responses;

	/**
	 * 请求参数定义表
	 */
	public List requestElements;

	/**
	 * 响应参数定义表
	 */
	public List responseElements;

	/**
	 * 请求报文字节长度
	 */
	public int requestByteLength;

	/**
	 * 响应报文字节长度
	 */
	public int responseByteLength;

	/**
	 * 存储多个Exception
	 */
	public List errors;

	/**
	 * 存储多个String
	 */
	public List warns;

	public void associateWithElement(ElementConfig eConfig) {
		String elementName;
		PacketElement packetElement;
		
		if (requests == null || responses == null) {
			return;
		}
		
		if (requestElements==null) {
			requestElements = new ArrayList();
		} else {
			requestElements.clear();
		}
		
		if (responseElements==null) {
			responseElements = new ArrayList();
		} else {
			responseElements.clear();
		}
		
		requestByteLength = 0;
		responseByteLength = 0;
		
		for (int i = 0; i < requests.size(); i++) {
			elementName = (String)requests.get(i);
			
			packetElement = eConfig.getElement(elementName);
			
			if (packetElement==null) {
				addWarn("lose config of element named " + elementName);
				continue;
			}
			
			requestElements.add(packetElement);
			
			requestByteLength += packetElement.length;
		}
		
		for (int i = 0; i < responses.size(); i++) {
			elementName = (String)responses.get(i);
			
			packetElement = eConfig.getElement(elementName);
			
			if (packetElement==null) {
				addWarn("lose config of element named " + elementName);
				continue;
			}
			
			responseElements.add(packetElement);
			
			responseByteLength += packetElement.length;
		}
		
	}

	public void loadFromInputStream(InputStream is) {
		SAXBuilder builder = new SAXBuilder();
		Document doc;
		clearError();
		clearWarn();
		try {
			doc = builder.build(is);
			loadFromJDomDocument(doc);
		} catch (JDOMException e) {
			addError(e);
		} catch (IOException e) {
			addError(e);
		}
	}

	public void loadFromReader(Reader reader) {
		SAXBuilder builder = new SAXBuilder();
		Document doc;
		clearError();
		clearWarn();
		try {
			doc = builder.build(reader);
			loadFromJDomDocument(doc);
		} catch (JDOMException e) {
			addError(e);
		} catch (IOException e) {
			addError(e);
		}
	}

	public void loadFromFile(File file) {
		SAXBuilder builder = new SAXBuilder();
		Document doc;
		clearError();
		clearWarn();
		try {
			doc = builder.build(file);
			loadFromJDomDocument(doc);
		} catch (JDOMException e) {
			addError(e);
		} catch (IOException e) {
			addError(e);
		}
	}

	public void loadFromFile(String fileName) {
		SAXBuilder builder = new SAXBuilder();
		File file = new File(fileName);
		Document doc;
		clearError();
		clearWarn();
		try {
			doc = builder.build(file);
			loadFromJDomDocument(doc);
		} catch (JDOMException e) {
			addError(e);
		} catch (IOException e) {
			addError(e);
		}
	}

	private void loadFromJDomDocument(Document doc) {
		Element root;
		List listElement;
		Element eChild;
		String sValue;

		if (doc == null) {
			addError(new NullPointerException(
					"loadFromJDomDocument:argument doc is null"));
			return;
		}

		// clear old value
		funcId = null;
		funcName = null;
		funcDesc = null;
		if (requests == null) {
			requests = new ArrayList();
		} else {
			requests.clear();
		}

		if (responses == null) {
			responses = new ArrayList();
		} else {
			responses.clear();
		}

		// get root element of the xml
		root = doc.getRootElement();

		// get funcId config,required
		sValue = root.getAttributeValue("funcId");
		if (sValue == null) {
			addWarn("No funcId attribute.");
			return;
		}
		funcId = sValue;

		// get funcName config
		sValue = root.getAttributeValue("funcName");
		funcName = sValue;

		// get funcDesc config
		sValue = root.getAttributeValue("funcDesc");
		funcDesc = sValue;

		// get 'request' children of the root element
		eChild = root.getChild("request");
		if (eChild == null) {
			addError(new Exception("loadFromJDomDocument:no request node"));
			return;
		}
		listElement = eChild.getChildren("elementName");
		for (int i = 0; i < listElement.size(); i++) {
			// get one child
			eChild = (Element) listElement.get(i);
			sValue = eChild.getTextTrim();
			if (sValue == null || sValue.length() == 0) {
				addError(new Exception("Invalid request element config."));
				continue;
			}
			requests.add(sValue);
		}

		// get 'response' children of the root element
		eChild = root.getChild("response");
		if (eChild == null) {
			addError(new Exception("loadFromJDomDocument:no response node"));
			return;
		}
		listElement = eChild.getChildren("elementName");
		for (int i = 0; i < listElement.size(); i++) {
			// get one child
			eChild = (Element) listElement.get(i);
			sValue = eChild.getTextTrim();
			if (sValue == null || sValue.length() == 0) {
				addError(new Exception("Invalid response element config."));
				continue;
			}
			responses.add(sValue);
		}
	}

	private void clearWarn() {
		if (warns != null) {
			warns.clear();
		}
	}

	private void clearError() {
		if (errors != null) {
			errors.clear();
		}
	}

	private void addError(Object error) {
		if (this.errors == null) {
			errors = new ArrayList();
		}
		errors.add(error);
	}

	private void addWarn(Object warn) {
		if (this.warns == null) {
			warns = new ArrayList();
		}
		warns.add(warn);
	}

	public String toString() {
		StringBuffer res = new StringBuffer();
		res.append("[funcId:");
		res.append(funcId);
		res.append("; funcName:");
		res.append(funcName);
		res.append("; funcDesc:");
		res.append(funcDesc);
		res.append("; requests:[");
		if (requests == null) {
			res.append("null");
		} else {
			for (int i = 0; i < requests.size(); i++) {
				if (i > 0) {
					res.append(",");
				}
				res.append(requests.get(i));
			}
		}
		res.append("]");

		res.append("; responses:[");
		if (responses == null) {
			res.append("null");
		} else {
			for (int i = 0; i < responses.size(); i++) {
				if (i > 0) {
					res.append(",");
				}
				res.append(responses.get(i));
			}
		}
		res.append("]");

		if (errors != null) {
			res.append("; errors:");
			res.append("[");
			for (int i = 0; i < errors.size(); i++) {
				if (i > 0) {
					res.append(",");
				}
				res.append(errors.get(i));
			}
			res.append("]");
		}

		if (warns != null) {
			res.append("; warns:");
			res.append("[");
			for (int i = 0; i < warns.size(); i++) {
				if (i > 0) {
					res.append(",");
				}
				res.append(warns.get(i));
			}
			res.append("]");
		}

		res.append("]");

		return res.toString();
	}
}
