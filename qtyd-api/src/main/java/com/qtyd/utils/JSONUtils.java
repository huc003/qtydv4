package com.qtyd.utils;

 
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.gson.Gson;
 

public class JSONUtils {

	private boolean compress;
	private final static int INDENTFACTOR = 4;

	public JSONUtils() {
		compress = true;
	}

	public JSONUtils(boolean compress) {
		this.compress = compress;
	}

	public String toJSON(String root, Object object) throws Exception {
		JSONObject jsonObj = getJSON(root, object);
		return toJSON(jsonObj);
	}

	public String toJSON(JSONObject jsonObj) throws Exception {
		if (jsonObj == null)
			return "";
		if (compress){
			return jsonObj.toString();
		}else{
			return jsonObj.toString(INDENTFACTOR);
		}
	}
	
	public boolean toJSON(String root, Object object, String filename)
			throws Exception {
		JSONObject jsonObj = getJSON(root, object);
		return toJSON(jsonObj, filename);
	}
	
	public boolean toJSON(JSONObject jsonObj, String filename)
	        throws Exception
	    {
	        File file;
	        Writer writer;
	        if(jsonObj == null)
	            return false;
	        file = new File(filename);
	        if(!file.getParentFile().exists() && !file.getParentFile().mkdirs())
	            return false;
	        if(file.exists() && !file.delete())
	            return false;
	        writer = null;
	        try
	        {
	            writer = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
	            jsonObj.write(writer);
	        }
	        catch(JSONException e)
	        {
	            throw new JSONException((new StringBuilder(String.valueOf(CommonUtils.getTraceInfo()))).append(e.getMessage()).toString());
	        }        
	        writer.close();
	        return true;
	    }

	public JSONObject getJSON(String root, Object object) throws Exception {
		if (root == null || root.trim().length() == 0)
			throw new Exception("root error");
		if (object == null) {
			return null;
		} else {
			JSONObject jsonObj = new JSONObject();
			jsonObj.put(root, object);
			return jsonObj;
		}
	}
	
	/**
	 *  将map集合转换成json字符串 ,不支持嵌套转换
	 * @param map map集合 键，值对应
	 * @return json字符串
	 */
	public static String toJson(Map<String,String> map){
		return new Gson().toJson(map);
	}
	/**
	 *  用com.alibaba.fastjson.JSONObject.toJSONString (带null)
	 * @return json字符串
	 */
	public static String toJson(Object obj){
		return com.alibaba.fastjson.JSONObject.toJSONString(obj, SerializerFeature.WriteMapNullValue);
	}
	/**
	 *  用com.alibaba.fastjson.JSONObject.parseArray
	 * @return json字符串
	 */
	public static List<Object> jsontoList(String json){
		return com.alibaba.fastjson.JSONObject.parseArray(json);
	}
	/**
	 *  用com.alibaba.fastjson.JSON.parseObject
	 * @return json字符串
	 */
	public static Map<String,Object> jsontoMap(String json){
		return JSON.parseObject(json);
	}
	
	public static <T> T toJsonString(String json,Class<T> classOfT){
		return new Gson().fromJson(json, classOfT);
	}
	
	public JSONObject string2JSON(String str, String split)
			throws JSONException {
		JSONObject json = new JSONObject();
		String arrStr[] = str.split(split);
		for (int i = 0; i < arrStr.length; i++) {
			String arrKeyValue[] = arrStr[i].split("=");
			json.put(arrKeyValue[0],
					arrStr[i].substring(arrKeyValue[0].length() + 1));
		}

		return json;
	}
	
	/**
	 * 从json HASH表达式中获取一个map，改map支持嵌套功能
	 * @param jsonString JSON字符串
	 * @return Map<code><</code>String, Object>
	 * @throws JSONException 
	 */
	public static Map<String, String> getJson2Map(String jsonString) throws JSONException {
		JSONObject jsonObject = new JSONObject(jsonString);
		Iterator<?> keyIter = jsonObject.keys();
		String key;
		String value;
		Map<String, String> valueMap = new HashMap<String, String>();
		while (keyIter.hasNext())
		{
			key = String.valueOf(keyIter.next());
			value = jsonObject.getString(key);
			valueMap.put(key, value);
		}
		return valueMap;
	}
	
	/**
	 * json转换Map
	 * @param jsonString
	 * @return
	 * @throws JSONException
	 */
	public static Map<String, Object> getMap4Json(String jsonString) throws JSONException {
		JSONObject jsonObject = new JSONObject(jsonString);
		return getMapFromJson(jsonObject);
	}
	
	public static Map<String,Object> getMapFromJson(JSONObject jsonObject) throws JSONException{
		Iterator<?> ite = jsonObject.keys();
		Map<String, Object> valueMap = new HashMap<String, Object>();
		while(ite.hasNext()){
			String key = String.valueOf(ite.next()) ;
			Object object = jsonObject.get(key) ;
			if(object instanceof JSONObject){
				valueMap.put(key, getMapFromJson((JSONObject)object)) ;
			} else if (object instanceof JSONArray){
				valueMap.put(key,getListFromJsonArray((JSONArray)object));
			} else {
				if(object == JSONObject.NULL){
					valueMap.put(key,null);
				} else {
					valueMap.put(key,object);
				}
			}
		}
		return valueMap ;
	}
	
	public static List<Object> getListFromJsonArray(JSONArray jsonarray) throws JSONException{
		List<Object> list = new ArrayList<Object>() ;
		for(int i = 0 ; i < jsonarray.length() ; i++){
			Object object = jsonarray.get(i) ;
			if(object instanceof JSONObject){
				list.add(getMapFromJson((JSONObject)object)) ;
			} else if (object instanceof JSONArray){
				list.add(getListFromJsonArray((JSONArray)object)) ;
			} else {
				if(object == JSONObject.NULL){
					list.add(null) ;
				}else{
					list.add(object);
				}
			}
		}
		return list ;
	}

	@SuppressWarnings("unchecked")
	public static List<Map<String, Object>> getListFromJsonStr(String json) {
		List<Object> rs = jsontoList(json);
		
		List<Map<String, Object>> resultList= new ArrayList<Map<String, Object>>();
		for (int i = 0; i < rs.size(); i++) {
			resultList.add((Map<String,Object>)rs.get(i));
		}
		return resultList;
	}
}
