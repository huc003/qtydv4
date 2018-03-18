package com.qtyd.sms.thread;
/**
* @author hucheng E-mail:459382234@qq.com
* @version 创建时间：2018年3月17日 上午11:18:15
* 类说明
*/
public class MonitorThread extends Thread{
	protected long lastTurn = 0 ;
	protected long MaxWaitTime = 10 ;
	
	public MonitorThread() {
		super() ;
	}
	
	public MonitorThread(Runnable runnable) {
		super(runnable) ;
	}

	public void Tick(){
		lastTurn = System.currentTimeMillis() / 1000 ;
	}
	
	public boolean isAbnormal() {
		if(lastTurn == 0)
			return true ;
		long turn = System.currentTimeMillis() / 1000 - lastTurn ;
		if(turn <= MaxWaitTime )
			return true ;
		else
			return false;
	}
}
