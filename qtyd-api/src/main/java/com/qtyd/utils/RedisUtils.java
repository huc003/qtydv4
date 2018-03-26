package com.qtyd.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
* @author huc E-mail:459382234@qq.com
* @version 创建时间：2018年3月19日 下午2:30:42
* 类说明
*/
@Component
public class RedisUtils {
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	public Long lpush(String key,String value){
		return stringRedisTemplate.opsForList().leftPush(key, value);
	}
	
	public String pop(String key){
		return stringRedisTemplate.opsForList().leftPop(key);
	}
	
	public Long rpush(String key,String value){
		return stringRedisTemplate.opsForList().rightPush(key, value);
	}
	
	public String out(String key){
		return stringRedisTemplate.opsForList().rightPop(key);
	}
	
	public Long length(String key){
		return stringRedisTemplate.opsForList().size(key);
	}
	
	public List<String> range(String key,int start,int end){
		return stringRedisTemplate.opsForList().range(key, start, end);
	}
	
	public void remove(String key,int count,String value){
		stringRedisTemplate.opsForList().remove(key, count, value);
	}
	
	public String index(String key,long index){
		return stringRedisTemplate.opsForList().index(key, index);
	}
	
	public void set(String key,long index,String value){
		stringRedisTemplate.opsForList().set(key, index, value);
	}
	
	public void trim(String key,long start,long end){
		stringRedisTemplate.opsForList().trim(key, start, end);
	}
	
	
	
}
