package com.qtyd.sms.monitor;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qtyd.sms.thread.MonitorThread;

/**
* @author huc E-mail:459382234@qq.com
* @version 创建时间：2018年3月26日 下午2:06:56
* 类说明
*/
public class Monitor extends Thread{
	
	public final static List<MonitorThread> threadMonitor = new ArrayList<MonitorThread>();
	
	public static long reportReTurn = 600;
	
	private MonitorReporter monitorReporter;
	
	private Logger logger = LoggerFactory.getLogger(Monitor.class); 
	
	public Monitor(MonitorReporter monitorReporter){
		this.monitorReporter = monitorReporter;
	}
	
	public final static void addThread(MonitorThread thread){
		threadMonitor.add(thread);
	}
	
	public final static void startMonitor(MonitorReporter monitorReporter){
		Monitor monitor = new Monitor(monitorReporter);
		monitor.start();
	}
	
	
	@Override
	public void run() {
		while(true){
			List<MonitorThread> list = null;
			for (MonitorThread monitorThread : threadMonitor) {
				if (State.TERMINATED!=monitorThread.getState()&&monitorThread.isAbnormal()) {
					logger.info(monitorThread+" ===> 正常运行");
				}else{
					if (list==null) {
						list = new ArrayList<MonitorThread>();
					}
					list.add(monitorThread);
				}
			}
			monitorReporter.report(list);
//			for (MonitorThread monitorThread : threadMonitor) {
//				if (State.TERMINATED!= monitorThread.getState() && monitorThread.isAbnormal()) {
//					new 
//				}
//			}
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
