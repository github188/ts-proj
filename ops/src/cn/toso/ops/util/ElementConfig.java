package cn.toso.ops.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/**
 * 报文要素操作类
 * 
 * @author suilaiji
 */
public class ElementConfig {
	/**
	 * 存储多个PacketElement
	 */
	public List elementsList;

	/**
	 * 按key,value分别为elementName和element的方式存储的要素Map
	 */
	public Map elementsMap;

	/**
	 * 所有要素的字节长度
	 */
	public int elementsByteLength;

	/**
	 * 存储多个Exception
	 */
	public List errors;

	/**
	 * 存储多个String
	 */
	public List warns;

	/**
	 * XML根要素名
	 */
	public String rootNodeName;

	public PacketElement getElement(String elementName) {
		if (elementsMap == null) {
			return null;
		}
		PacketElement res = null;
		if (elementsMap.containsKey(elementName)) {
			res = (PacketElement) elementsMap.get(elementName);
		}
		return res;
	}

	private void genByteLength() {
		PacketElement element;

		if (elementsList == null) {
			return;
		}

		elementsByteLength = 0;

		for (int i = 0; i < elementsList.size(); i++) {
			element = (PacketElement) elementsList.get(i);

			elementsByteLength += element.length;
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
		Element eValue;
		String sValue;
		String tValue;
		int iValue;

		PacketElement element;

		if (doc == null) {
			addError(new NullPointerException(
					"loadFromJDomDocument:argument doc is null"));
			return;
		}

		if (elementsList == null) {
			elementsList = new ArrayList();
		} else {
			elementsList.clear();
		}
		if (elementsMap == null) {
			elementsMap = new HashMap();
		} else {
			elementsMap.clear();
		}

		// get root element of the xml
		root = doc.getRootElement();
		rootNodeName = root.getName();

		// get children of the root element
		listElement = root.getChildren("element");
		for (int i = 0; i < listElement.size(); i++) {
			// get one child
			eChild = (Element) listElement.get(i);

			// new PacketElement
			element = new PacketElement();

			// get 'name' config of the child
			eValue = eChild.getChild("name");
			if (eValue == null) {
				addWarn("No." + i + " element has no 'name' config.");
				continue;
			}
			sValue = eValue.getTextTrim();
			if (sValue == null || sValue.length() == 0) {
				addWarn("No." + i + " element has empty 'name' config.");
				continue;
			}
			element.name = sValue;

			// get 'description' config of the child, it is not requried.
			eValue = eChild.getChild("description");
			if (eValue != null) {
				sValue = eValue.getTextTrim();
				if (sValue != null) {
					element.description = sValue;
				}
			}
			if (element.description == null) {
				// default value is ""
				element.description = "";
			}

			// get 'length' config of the child
			eValue = eChild.getChild("length");
			if (eValue == null) {
				addWarn("No." + i + " element whose name is '" + element.name
						+ "' has no 'length' config.");
				continue;
			}
			sValue = eValue.getTextTrim();
			if (sValue == null || sValue.length() == 0) {
				addWarn("No." + i + " element whose name is '" + element.name
						+ "' has empty 'length' config.");
				continue;
			}

			try {
				iValue = Integer.parseInt(sValue);
			} catch (NumberFormatException e) {
				addWarn("No." + i + " element, whose name is '" + element.name
						+ "', 'length' config is not int format [" + sValue
						+ "].");
				continue;
			}
			element.length = iValue;

			// get 'fillCharacter' config of the child,default value is ' '
			// valid value can be : '0'(the character)
			// '\13'(ascii 19,radix of 16)
			// '\a5'(ascii 165,radix of 16)
			eValue = eChild.getChild("fillCharacter");
			if (eValue != null) {
				sValue = eValue.getTextTrim();
				tValue = new String(sValue);
				if (sValue != null) {
					if (sValue.length() > 2 && sValue.startsWith("'")
							&& sValue.endsWith("'")) {
						sValue = sValue.substring(1, sValue.length() - 1);
						if (sValue.startsWith("\\")) {
							try {
								iValue = Integer.parseInt(sValue.substring(1),
										16);
							} catch (NumberFormatException e) {
								// warn
								addWarn("No."
										+ i
										+ " element, whose name is '"
										+ element.name
										+ "', has invalid 'fillCharacter' config ["
										+ tValue + "].");
								continue;
							}
						} else if (sValue.getBytes().length == 1) {
							element.fillCharacter = sValue.getBytes()[0];
						} else {
							// warn
							addWarn("No." + i + " element, whose name is '"
									+ element.name
									+ "', has invalid 'fillCharacter' config ["
									+ tValue + "].");
							continue;
						}
					} else {
						// warn
						addWarn("No." + i + " element, whose name is '"
								+ element.name
								+ "', has invalid 'fillCharacter' config ["
								+ tValue + "].");
						continue;
					}
				} else {
					element.fillCharacter = ' ';
				}
			} else {
				element.fillCharacter = ' ';
			}

			// get 'fillMode' config of the child
			eValue = eChild.getChild("fillMode");
			if (eValue != null) {
				sValue = eValue.getTextTrim();
				if (sValue == null || sValue.length() == 0) {
					element.fillMode = PacketElement.FILL_MODE_RIGHT;
				} else {
					if ("right".equalsIgnoreCase(sValue)) {
						element.fillMode = PacketElement.FILL_MODE_RIGHT;
					} else if ("left".equalsIgnoreCase(sValue)) {
						element.fillMode = PacketElement.FILL_MODE_LEFT;
					} else {
						// warn
						addWarn("No." + i + " element, whose name is '"
								+ element.name
								+ "', has invalid 'fillMode' config [" + sValue
								+ "].");
						continue;
					}
				}
			} else {
				element.fillMode = PacketElement.FILL_MODE_RIGHT;
			}

			elementsList.add(element);
			elementsMap.put(element.name, element);
		}
		if ((errors == null || errors.size()==0) && (warns == null || warns.size()==0)) {
			this.genByteLength();
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
		res.append("[");
		res.append("packets:");
		res.append("[");
		for (int i = 0; i < elementsList.size(); i++) {
			if (i > 0) {
				res.append(",");
			}
			res.append(elementsList.get(i));
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
