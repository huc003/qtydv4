package com.qtyd.sms.beans;

import org.springframework.stereotype.Component;

/**
* @author huc E-mail:459382234@qq.com
* @version 创建时间：2018年3月19日 上午9:31:18
* 类说明
*/
@Component
public class MessageBean {

	private int sleep = 0;
	
	private long sleepTimestamps = 0;
	
	public void setSleep(int sleep){
		this.sleep = sleep;
	}
	
	public int getSleep(){
		return this.sleep;
	}

	public long getSleepTimestamps() {
		return sleepTimestamps;
	}

	public void setSleepTimestamps(long sleepTimestamps) {
		this.sleepTimestamps = sleepTimestamps;
	}
	
	
	
	
}
