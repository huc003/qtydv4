package com.qtyd.sms.thread;

import com.qtyd.sms.deposit.MessagePublish;

/**
* @author hucheng E-mail:459382234@qq.com
* @version 创建时间：2018年3月17日 上午11:20:41
* 类说明
*/
public class PublishThread extends MonitorThread{
	
	
	public MessagePublish messagePublish = null;
	
	public PublishThread(MessagePublish messagePublish) {
		this.messagePublish = messagePublish;
	}

	@Override
	public void run() {
		while(true) {
			if (Thread.currentThread() instanceof MonitorThread)
                ((MonitorThread) Thread.currentThread()).Tick();
			messagePublish.pubishMessage();
		}
	}
	
}
