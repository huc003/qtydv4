package com.qtyd.db;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

/**
* @author huc E-mail:459382234@qq.com
* @version 创建时间：2018年2月11日 下午4:15:42
* 类说明
*/
//@Component("dataSourceConfig")
@Configuration
public class DB {
	
	public static void main(String[] args) {
		
	}
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource(){
		return new DataSource();
	}

	@Bean(name = "sqlSessionFactory")
//	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mapper/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}
}
