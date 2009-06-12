package cn.toso.ops.util;

public class ConfigException extends Exception {
	
	private static final long serialVersionUID = 4487524366121806854L;

	public ConfigException(String configItem) {
		super("Missing config:" + configItem);
	}

	public ConfigException(String configItem, String configValue) {
		super("Invalid config:" + configItem + ",value:" + configValue);
	}
}
