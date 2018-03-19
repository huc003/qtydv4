package com.qtyd;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
/***
 * 项目启动类
 */
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.qtyd.config.RedisConfig;
import com.qtyd.config.SessionConfig;
import com.qtyd.sms.publish.PublishStart;
import com.qtyd.utils.RedisUtils;
@Configuration
@Import({RedisConfig.class,SessionConfig.class,com.qtyd.config.RedisUtils.class,RedisUtils.class})
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ComponentScan(basePackages={"com.qtyd.db","com.qtyd.dao","com.qtyd.sms","com.qtyd.service"})
@MapperScan(basePackages={"com.qtyd.dao"}, sqlSessionFactoryRef="sqlSessionFactory")
public class SmsProviderApplication implements EmbeddedServletContainerCustomizer,CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(SmsProviderApplication.class);
	
	@Autowired
	private PublishStart publishStart;
	
	public static void main(String[] args){
		args = new String[2];
		args[0] = "verification";
		args[1] = "notice";
	    SpringApplication.run(SmsProviderApplication.class, args);
	}
	  
	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
		c.setIgnoreUnresolvablePlaceholders(true);
		return c;
	}

	 /**
	 * 自定义端口
	 * @param container
	 */
	public void customize(ConfigurableEmbeddedServletContainer container) {
	    container.setPort(8888);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("消息队列执行开始......");
		publishStart.start(args);
		logger.info("消息队列执行结束......");
	}
}
