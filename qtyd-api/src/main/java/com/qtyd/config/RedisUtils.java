package com.qtyd.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
* @author huc E-mail:459382234@qq.com
* @version 创建时间：2018年3月19日 下午3:30:25
* 类说明
*/
@Component
public class RedisUtils {
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	public Long push(String key,String value){
		return redisTemplate.opsForList().leftPush(key, value);
	}
}
