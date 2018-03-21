package com.qtyd.sms.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qtyd.sms.beans.MessageBean;
import com.qtyd.sms.deposit.MessagePublish;
import com.qtyd.utils.ThreadPoolUtils;

/**
* @author hucheng E-mail:459382234@qq.com
* @version 创建时间：2018年3月17日 上午11:20:41
* 类说明
*/
public class PublishThread extends MonitorThread{
	
	private Logger logger = LoggerFactory.getLogger(PublishThread.class);
	
	private MessageBean messageBean = null;
	
	public MessagePublish messagePublish = null;
	
	public PublishThread(MessagePublish messagePublish,MessageBean messageBean) {
		this.messagePublish = messagePublish;
		this.messageBean = messageBean;
	}

	@Override
	public void run() {
		while(true) {
			if (Thread.currentThread() instanceof MonitorThread)
                ((MonitorThread) Thread.currentThread()).Tick();
			messagePublish.pubishMessage();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
