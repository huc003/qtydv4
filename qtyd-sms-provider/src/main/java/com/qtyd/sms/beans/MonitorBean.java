package com.qtyd.sms.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

import ch.qos.logback.core.joran.spi.XMLUtil;

/**
* @author huc E-mail:459382234@qq.com
* @version 创建时间：2018年3月26日 下午2:16:42
* 类说明
*/
public class MonitorBean {
	private String service_id = "" ;
	private String service_name = "" ;
	
	private int total = 0 ;
	private int normal = 0 ;
	private int abnormal = 0 ;
	private String abnormalMessage = null ;

	private Logger logger = LoggerFactory.getLogger(XMLUtil.class);
	public MonitorBean(){}
	
	public MonitorBean(JSONObject json){
		try{
			service_id = json.getString("service_id") ;
			service_name = json.getString("service_name") ;
			total = json.getInteger("total") ;
			normal = json.getInteger("normal") ;
			abnormal = json.getInteger("abnormal") ;
			abnormalMessage = json.getString("abnormalMessage") ;
			
		}catch(Exception e){
		    logger.error(e.getMessage(),e);
		}
	}
	
	public JSONObject toJson(){
		try{
			JSONObject json = new JSONObject() ;
			json.put("service_id", service_id) ;
			json.put("service_name", service_name) ;
			json.put("total", total) ;
			json.put("normal", normal) ;
			json.put("abnormal", abnormal) ;
			json.put("abnormalMessage", abnormalMessage) ;
			return json ;
		}catch(Exception e){
		    logger.error(e.getMessage(),e);
			return null ;
		}
	}
	
	
	public String getService_id() {
		return service_id;
	}

	public void setService_id(String service_id) {
		this.service_id = service_id;
	}

	public String getService_name() {
		return service_name;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getNormal() {
		return normal;
	}
	public void setNormal(int normal) {
		this.normal = normal;
	}
	public int getAbnormal() {
		return abnormal;
	}
	public void setAbnormal(int abnormal) {
		this.abnormal = abnormal;
	}

	public String getAbnormalMessage() {
		return abnormalMessage;
	}

	public void setAbnormalMessage(String abnormalMessage) {
		this.abnormalMessage = abnormalMessage;
	}
}
