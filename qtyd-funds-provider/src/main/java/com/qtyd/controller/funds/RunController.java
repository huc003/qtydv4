package com.qtyd.controller.funds;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.qtyd.utils.PropertiesUtils;

/**
* @author huc E-mail:459382234@qq.com
* @version 创建时间：2018年2月12日 上午9:51:52
* springboot启动执行
*/
@Component
public class RunController implements ApplicationRunner{
	
//	private Logger logger = Logger.getLogger(FundsProviderApplication.class);
	
	private Logger logger = LoggerFactory.getLogger(RunController.class);
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		String active = PropertiesUtils.getProperties("spring.profiles.active");
	    String activeName = "";
	    if (active.equals("dev")) {
	      activeName = "数据库环境=开发环境";
	    } else if (active.equals("test")) {
	      activeName = "数据库环境=测试环境";
	    } else if (active.equals("prod")) {
	      activeName = "数据库环境=正式环境";
	    }
	    logger.info(activeName);
	    logger.error("错误日志");
	    System.out.println(activeName);
	}

}
