package com.qtyd.sms.monitor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qtyd.sms.beans.MonitorBean;
import com.qtyd.sms.thread.MonitorThread;
import com.qtyd.utils.RedisUtils;

import ch.qos.logback.core.joran.spi.XMLUtil;

/**
* @author huc E-mail:459382234@qq.com
* @version 创建时间：2018年3月26日 下午2:10:15
* 类说明
*/
@Component
public class MonitorReporter {
	
	public final static String APP_NAME = "";
	
	public final static String APP_ID = "";
	
	public final static String SERVICE_NAME = "SERVICE_NAME";
	
	private Logger logger = LoggerFactory.getLogger(XMLUtil.class);
	
	@Autowired
	private RedisUtils redisUtils;
	
	public final void report(List<MonitorThread> list){
		try {
			MonitorBean monitorBean = new MonitorBean();
			monitorBean.setService_id(APP_ID);
			monitorBean.setService_name(SERVICE_NAME);
			monitorBean.setTotal(Monitor.threadMonitor.size());
			if(list==null||list.size()==0){
				monitorBean.setNormal(Monitor.threadMonitor.size());
				monitorBean.setAbnormal(0);
			}else{
				monitorBean.setNormal(Monitor.threadMonitor.size()-list.size());
				monitorBean.setAbnormal(list.size());
				StringBuffer sb = new StringBuffer();
				for (MonitorThread monitorThread : list) {
					sb.append(monitorThread.getName()).append(",");
				}
				monitorBean.setAbnormalMessage(sb.substring(0, sb.length()-1));
				redisUtils.rpush(SERVICE_NAME, monitorBean.toJson().toJSONString());
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		
	}

}
