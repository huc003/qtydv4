package com.qtyd.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
* @author huc E-mail:459382234@qq.com
* @version 创建时间：2018年3月19日 上午9:53:35
* 类说明
*/
@SuppressWarnings("static-access")
public class ThreadPoolUtils {
	
	private static Executors executors = null;
	private static ExecutorService executorService;
	
	static{
		executorService = executors.newScheduledThreadPool(10);
	}
	
	public static void execute(Runnable runnable){
		executorService.execute(runnable);
	}
	
	public static void shutdown(){
		executorService.shutdown();
	}
	
}
