package com.qtyd.controller.funds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qtyd.service.ScheduledTaskService;

import io.swagger.annotations.Api;
/**
* @author huc E-mail:459382234@qq.com
* @version 创建时间：2018年3月15日 上午9:02:05
* 类说明
*/
@RestController
@RequestMapping("/task")
@Api(value="onlinestore", description="定时任务类")
public class ScheduledTaskController {
	
	private Logger logger = LoggerFactory.getLogger(FundsController.class);
	
	@Autowired
	private ScheduledTaskService scheduledTaskService;
	
	@RequestMapping(value = "/task_0",method = RequestMethod.POST)
	public String task(){
		
		scheduledTaskService.task_0();
		
		return "success";
	}
}
