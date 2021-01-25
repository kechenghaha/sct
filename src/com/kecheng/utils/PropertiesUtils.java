package com.kecheng.utils;

import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
/**
 * 加载配置文件，返回DataSource数据源。
 * @author 克城之子haha
 *
 */

public class PropertiesUtils {
	
	private static Properties properties = new Properties();
	
	static {
		
		try {
			InputStream inputStream = PropertiesUtils.class.getClassLoader().getResourceAsStream("db.properties");
			properties.load(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static DataSource getDataSource() {
		try {
			return BasicDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
	
}
