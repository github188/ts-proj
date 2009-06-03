package cn.toso.ops.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jConfigLoader {
	public static boolean loadConfig(String configFilePath, String appPath) {
		Properties logProp;
		InputStream inputStream;
		boolean loaded;
		// Exception ex;

		logProp = new Properties();
		try {
			inputStream = new FileInputStream(configFilePath);
			logProp.load(inputStream);
			// ex = null;
			loaded = true;
		} catch (FileNotFoundException e) {
			// ex = e;
			loaded = false;
		} catch (IOException e) {
			// ex = e;
			loaded = false;
		}
		if (loaded) {
			// 替换其中的常量
			Enumeration enumKey = logProp.keys();
			String key;
			String value;
			int pos;
			String keyAppPath = "{APP-PATH}";
			String keyValue;
			if (appPath == null) {
				keyValue = System.getProperty("user.dir", "") + "/";
			} else {
				keyValue = appPath;
			}
			while (enumKey.hasMoreElements()) {
				key = (String) enumKey.nextElement();
				value = logProp.getProperty(key);
				if (value != null) {
					pos = value.indexOf(keyAppPath);
					if (pos >= 0) {
						value = value.substring(0, pos) + keyValue
								+ value.substring(pos + keyAppPath.length());
						logProp.setProperty(key, value);
					}
				}
			}
			PropertyConfigurator.configure(logProp);
		} else {
			/**
			 * # 默认日志级别ERROR。其他可供选择的级别包括INFO和DEBUG
			 * log4j.rootLogger=DEBUG,ROOT,stdout
			 * log4j.appender.ROOT=org.apache.log4j.RollingFileAppender
			 * log4j.appender.ROOT.File={APP-PATH}WEB-INF/logs/FileBase.log
			 * log4j.appender.ROOT.MaxFileSize=1000KB # 保留5个旧的日志文件
			 * log4j.appender.ROOT.MaxBackupIndex=5
			 * log4j.appender.ROOT.layout=org.apache.log4j.PatternLayout #
			 * 日志格式：按照WebSphere通用日志格式相似的方式记录
			 * log4j.appender.ROOT.layout.ConversionPattern=[%d] %-5p
			 * (%c.java:%L) - %m%n
			 * log4j.appender.stdout=org.apache.log4j.ConsoleAppender
			 * log4j.appender.stdout.layout=org.apache.log4j.PatternLayout #
			 * Pattern to output the caller's file name and line number.
			 * log4j.appender.stdout.layout.ConversionPattern=[%d] %-5p
			 * (%c.java:%L) - %m%n
			 */
			logProp.put("log4j.rootLogger", "INFO,ROOT,stdout");
			logProp.put("log4j.appender.ROOT",
					"org.apache.log4j.RollingFileAppender");
			logProp.put("log4j.appender.ROOT.File", "log4j.log");
			logProp.put("log4j.appender.ROOT.MaxFileSize", "1024KB");
			logProp.put("log4j.appender.ROOT.MaxBackupIndex", "5");
			logProp.put("log4j.appender.ROOT.layout",
					"org.apache.log4j.PatternLayout");
			logProp.put("log4j.appender.ROOT.layout.ConversionPattern",
					"[%d] %-5p (%c.java:%L) - %m%n");
			logProp.put("log4j.appender.stdout",
					"org.apache.log4j.ConsoleAppender");
			logProp.put("log4j.appender.stdout.layout",
					"org.apache.log4j.PatternLayout");
			logProp.put("log4j.appender.stdout.layout.ConversionPattern",
					"[%d] %-5p (%c.java:%L) - %m%n");
			PropertyConfigurator.configure(logProp);

			Logger.getLogger(Log4jConfigLoader.class).warn(
					"Can not load log config file!");
		}

		return loaded;
	}

	public static boolean loadConfig(String configFilePath) {
		return loadConfig(configFilePath, null);
	}
}
