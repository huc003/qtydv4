package com.qtyd.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
* @author huc E-mail:459382234@qq.com
* @version 创建时间：2018年3月12日 下午5:11:21
* 类说明
*/
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400*30)
public class SessionConfig {

}
