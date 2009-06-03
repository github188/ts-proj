package cn.toso.ops.util;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 报文要素操作类
 * 
 * @author suilaiji
 */
public class PacketConfig {

	/**
	 * 按key,value分别为funcId和packet的方式存储的报文Map
	 */
	public Map packetsMap;

	/**
	 * 存储多个Exception
	 */
	public List errors;

	/**
	 * 存储多个String
	 */
	public List warns;

	public Packet getPacket(String funcId) {
		if (packetsMap == null) {
			return null;
		}
		Packet res = null;
		if (packetsMap.containsKey(funcId)) {
			res = (Packet) packetsMap.get(funcId);
		}
		return res;
	}

	public void loadFromDirectory(String directoryName,ElementConfig elementConfig) {
		File xmlDir;
		FileFilter filter;
		File[] xmlFiles;
		File xmlFile;
		Packet packet;

		xmlDir = new File(directoryName);

		if (!xmlDir.isDirectory()) {
			return;
		}

		filter = new FileFilter() {
			public boolean accept(File pathname) {
				if (pathname.getName().toLowerCase().endsWith(".xml")) {
					return true;
				}
				return false;
			}
		};
		xmlFiles = xmlDir.listFiles(filter);

		packetsMap = new HashMap();

		for (int i = 0; i < xmlFiles.length; i++) {
			xmlFile = xmlFiles[i];

			packet = new Packet();
			packet.loadFromFile(xmlFile);

			if (packet.errors != null) {
				addErrors(packet.errors);
				continue;
			}
			if (packet.warns != null) {
				addWarns(packet.errors);
				continue;
			}
			packet.associateWithElement(elementConfig);
			packetsMap.put(packet.funcId, packet);
		}
	}

	private void addErrors(Collection errorCollection) {
		if (errors == null) {
			errors = new ArrayList();
		}
		errors.addAll(errorCollection);
	}

	private void addWarns(Collection warnCollection) {
		if (warns == null) {
			warns = new ArrayList();
		}
		warns.addAll(warnCollection);
	}

	public String toString() {
		StringBuffer res = new StringBuffer();
		res.append("[");
		Iterator iter = packetsMap.keySet().iterator();
		Object key;
		res.append("packets:");
		res.append("[");
		while (iter.hasNext()) {
			key = iter.next();
			res.append(key);
			res.append("=");
			res.append(packetsMap.get(key));
			if (iter.hasNext()) {
				res.append(",");
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
