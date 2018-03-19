package com.qtyd.sms.deposit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qtyd.config.RedisUtils;
import com.qtyd.sms.beans.MessageBean;

/**
* @author hucheng E-mail:459382234@qq.com
* @version 创建时间：2018年3月17日 上午11:27:29
* 类说明
*/
@Service
public class VerificationPublish extends MessagePublish{
	
	@Autowired
	private MessageBean messageBean;
	
	@Autowired
	private RedisUtils redisUtils;
	
	@Autowired
	private com.qtyd.utils.RedisUtils redisUtils2;
	
	private Logger logger = LoggerFactory.getLogger(VerificationPublish.class);

	@Override
	public void pubishMessage() {
		
		
		//将信息放入redis
		
		redisUtils.push("static", "123456");
		redisUtils2.push("static2", "1234567");
		
		
		logger.info("验证码短信发送中...");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		messageBean.setSleep(Integer.parseInt(((new Date().getTime()/1000)-messageBean.getSleepTimestamps())+""));
	}

}
