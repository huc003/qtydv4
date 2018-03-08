package com.qtyd.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
* @author huc E-mail:459382234@qq.com
* @version 创建时间：2018年3月5日 下午2:45:07
* 类说明
*/
public class ConversionUtils {
	
	/***
	 * Object转换成Map
	 * @param obj
	 * @return
	 * @throws IllegalAccessException
	 */
	 public static Map<String, Object> objectToMap(Object obj) throws IllegalAccessException {
         Map<String, Object> map = new LinkedHashMap<String, Object>();
         Class<?> clazz = obj.getClass();
         for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = field.get(obj);
            map.put(fieldName, value);
         }
         return map;
	 }
}
