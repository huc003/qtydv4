package com.qtyd.thread;

import java.util.List;

import com.qtyd.model.User;

/**
* @author huc E-mail:459382234@qq.com
* @version 创建时间：2018年3月16日 上午9:30:43
* 类说明
*/
public class RetainThread extends CommonThread{
	
	private List<User> list = null;
	
	public RetainThread(List<User> list) {
		this.list = list;
	}

	@Override
	public void run() {
		for (User user2 : list) {
			System.out.println("刷新留存："+user2.getUsername());
		}
		System.out.println(Thread.currentThread().getName()+"执行定时任务中......");
	}
	
}
