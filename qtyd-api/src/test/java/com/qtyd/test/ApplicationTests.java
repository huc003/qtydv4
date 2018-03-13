package com.qtyd.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
* @author huc E-mail:459382234@qq.com
* @version 创建时间：2018年3月12日 下午4:06:01
* 类说明
*/
public class ApplicationTests {
	@Autowired
	private static StringRedisTemplate stringRedisTemplate;
	
	public static void main(String[] args) {
		// 保存字符串
		stringRedisTemplate.opsForValue().set("aaa", "111");
		System.out.println(stringRedisTemplate.opsForValue().get("aaa"));
	}
}
