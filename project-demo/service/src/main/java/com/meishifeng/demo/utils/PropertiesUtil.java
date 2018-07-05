package com.meishifeng.demo.utils;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	private static Properties prop = new Properties();

	static {
		InputStream in;
		try {
			 in = PropertiesUtil.class.getClassLoader().getResourceAsStream("app.properties");
			 prop.load(in);
			// 七牛云文件配置
//			in = PropertiesUtil.class.getClassLoader().getResourceAsStream("/conf/mgrserver.properties");
			prop.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getStr(String key) {
		return prop.getProperty(key).trim();
	}

	public static String getString(String key) {
		return prop.getProperty(key).trim();
	}

	public static Integer getInt(String key) {
		String str = prop.getProperty(key).trim();
		return Integer.valueOf(str);
	}

	public static long getLong(String key) {
		String str = prop.getProperty(key).trim();
		return Long.valueOf(str);
	}
}
