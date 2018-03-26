package com.qtyd.sms.deposit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	
	List<String> list = new ArrayList<String>();
	
	private Logger logger = LoggerFactory.getLogger(VerificationPublish.class);

	@Override
	public void pubishMessage() {
		
		
		//将信息放入redis
		
//		redisUtils.push("static", new Random().nextInt(1000000000)+"");
		
		
//		
		String r= new Random().nextInt(1000000000)+"";
		redisUtils2.lpush("static", r);
//		System.out.println(redisUtils2.index("static", 1l));
//		System.out.println("======"+redisUtils.pop("static"));
//		redisUtils2.remove("static", 0, r);
//		System.out.println(redisUtils2.pop("static"));
//			
//		
//		String s = redisUtils.pop("static");
//		
//		list.add(s);
//		System.out.println("list-size:"+list.size());
//		logger.info("验证码短信发送中...");
//		
//		
//		for (String string : list) {
//			System.out.println("===========----"+string);
//		}
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		messageBean.setSleep(Integer.parseInt(((new Date().getTime()/1000)-messageBean.getSleepTimestamps())+""));
	}

}
