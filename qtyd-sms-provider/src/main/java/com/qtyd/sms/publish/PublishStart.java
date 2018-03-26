package com.qtyd.sms.publish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qtyd.sms.monitor.Monitor;
import com.qtyd.sms.monitor.MonitorReporter;
import com.qtyd.utils.ThreadPoolUtils;

/**
* @author hucheng E-mail:459382234@qq.com
* @version 创建时间：2018年3月17日 上午11:14:15
* 类说明
*/
@Component
public class PublishStart {
	@Autowired
	private VerificationSms verificationSms;
	
	@Autowired
	private NoticeSms noticeSms;
	
	@Autowired
	private MonitorReporter monitorReporter;
	
	public void start(String[] args) {
		
		for (int i = 0; i < args.length; i++) {
			if(args[i].equals("verification")) {
				verificationSms.main(args);
			}else if(args[i].equals("notice")) {
				noticeSms.main(args);
			}
		}
		
		Monitor.startMonitor(monitorReporter);
		
	}
}
