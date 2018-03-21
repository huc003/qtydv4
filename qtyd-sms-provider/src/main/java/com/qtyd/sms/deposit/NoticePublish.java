package com.qtyd.sms.deposit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
* @author hucheng E-mail:459382234@qq.com
* @version 创建时间：2018年3月17日 上午11:41:15
* 类说明
*/
@Service
public class NoticePublish extends MessagePublish{
	
	private Logger logger = LoggerFactory.getLogger(NoticePublish.class);

	@Override
	public void pubishMessage() {
		logger.info("通知短信发送中...");
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
