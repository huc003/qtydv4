package com.qtyd.service.impl;

import java.security.PrivilegedActionException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qtyd.dao.UserMapper;
import com.qtyd.dao.UserRewardMapper;
import com.qtyd.model.User;
import com.qtyd.service.ScheduledTaskService;
import com.qtyd.thread.PerformanceThread;
import com.qtyd.thread.RetainThread;

/**
* @author huc E-mail:459382234@qq.com
* @version 创建时间：2018年3月15日 下午4:11:52
* 类说明
*/
@Service
public class ScheduledTaskServiceImpl implements ScheduledTaskService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserRewardMapper userRewardMapper;
	
//	static List<User> list = null;
	
	@Override
	public void task_0() {
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		User user = new User();
		user.setUserId(1274265);
		final List<User> list = userMapper.selectByUser(user);
		
		executorService.execute(new RetainThread(list));//刷新留存
		executorService.execute(new PerformanceThread(list));//刷新业绩
//		new RetainThread(list).start();
		
//		executorService.execute(new Runnable() {
//			@Override
//			public void run() {
//				for (User user2 : list) {
//					System.out.println("刷新成长值："+user2.getUsername());
//				}
//				System.out.println(Thread.currentThread().getName()+"执行定时任务中......");
//			}
//		});//刷新成长值
		
		executorService.shutdown();
		
	}

}
