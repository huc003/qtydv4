package com.qtyd;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
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
@Configuration
@Import({Swagger2.class,RedisConfig.class,SessionConfig.class})
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ComponentScan(basePackages={"com.qtyd.db", "com.qtyd.dao", "com.qtyd.controller", "com.qtyd.service"})
@MapperScan(basePackages={"com.qtyd.dao"}, sqlSessionFactoryRef="sqlSessionFactory")
public class FundsProviderApplication {
	public static void main(String[] args)
	  {
	    SpringApplication.run(FundsProviderApplication.class, args);
	  }
	  
	  @Bean
	  public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
	    PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
	    c.setIgnoreUnresolvablePlaceholders(true);
	    return c;
	  }
}
