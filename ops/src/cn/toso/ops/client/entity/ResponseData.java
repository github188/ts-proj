package cn.toso.ops.client.entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 用于调用EAP API时，返回非特定信息的结果集。 以HashMap实现。
 * 
 * @author suilaiji
 */
public class ResponseData {

	/**
	 * 存储名、值对的map
	 */
	private Map map;

	/**
	 * 构造方法中初始化map
	 */
	public ResponseData() {
		this.map = new HashMap();
	}

	/**
	 * 按名，将字符串型的数据保存到ResponseData中。
	 * 
	 * @param fieldName
	 *            名
	 * @param value
	 *            数据
	 */
	public void setString(String fieldName, String value) {
		map.put(fieldName, value);
	}

	/**
	 * 按名，将整型的数据保存到ResponseData中。
	 * 
	 * @param fieldName
	 *            名
	 * @param value
	 *            数据
	 */
	public void setInt(String fieldName, int value) {
		map.put(fieldName, new Integer(value));
	}

	/**
	 * 按名，从ResponseData中取得字符串型的数据。
	 * 
	 * @param fieldName
	 *            名
	 * @return the String value of the field
	 */
	public String getString(String fieldName) {
		String res = null;
		Object value = map.get(fieldName);
		if (value instanceof String) {
			res = (String) value;
		} else {
			if (value != null) {
				res = value.toString();
			}
		}
		return res;
	}

	/**
	 * 按名，从ResponseData中取得整型的数据。
	 * 
	 * @param fieldName
	 *            名
	 * @return 数据
	 */
	public int getInt(String fieldName) {
		int res = 0;
		Object value = map.get(fieldName);
		if (value != null && value instanceof Integer) {
			res = ((Integer) value).intValue();
		}
		return res;
	}

	/**
	 * 将ResponseData中保存的HashMap中的数据名和值toString()，供调试时输出。
	 */
	public String toString() {
		StringBuffer res = new StringBuffer();
		Iterator keys = map.keySet().iterator();
		Object key;
		res.append("[");
		while (keys.hasNext()) {
			key = keys.next();
			res.append(key);
			res.append("=");
			res.append(map.get(key));
			if (keys.hasNext()) {
				res.append(",");
			}
		}
		res.append("]");
		return res.toString();
	}
}
