package com.qtyd.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
* @author huc E-mail:459382234@qq.com
* @version 创建时间：2018年2月28日 上午11:49:36
* 类说明
*/
public class PropertiesUtils {
	 private static Logger logger = Logger.getLogger(PropertiesUtils.class);
	  
	  static Properties properties = new Properties();
	  
	  static
	  {
	    PropertiesUtils p = new PropertiesUtils();
	    p.test();
	  }
	  
	  public void test() {
	    try {
	      InputStream is = getClass().getClassLoader().getResourceAsStream("application.properties");
	      properties.load(is);
	      is.close();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	  }
	  
	  public static String getProperties(String key) {
	    return properties.getProperty(key);
	  }
	  
	  public static void main(String[] args)
	  {
	    System.out.println(getProperties("spring.profiles.active"));
	  }
}
