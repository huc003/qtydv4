package com.qtyd.sms.publish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qtyd.sms.beans.MessageBean;
import com.qtyd.sms.deposit.VerificationPublish;
import com.qtyd.sms.thread.PublishThread;
import com.qtyd.utils.ThreadPoolUtils;

/**
* @author hucheng E-mail:459382234@qq.com
* @version 创建时间：2018年3月17日 上午11:13:18
* 类说明
*/
@Component
public class VerificationSms {
	
	@Autowired
	private MessageBean messageBean;
	
	@Autowired
	private VerificationPublish verificationPublish;
	
	public void main(String[] args) {
//		messageBean.setSleepTimestamps(new Date().getTime()/1000);
		//启动线程
//		ThreadPoolUtils.execute(new PublishThread(verificationPublish,messageBean));
		new PublishThread(verificationPublish,messageBean).start();
	}
	
	
}
