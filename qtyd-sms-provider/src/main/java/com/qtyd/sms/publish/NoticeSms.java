package com.qtyd.sms.publish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.qtyd.sms.beans.MessageBean;
import com.qtyd.sms.deposit.NoticePublish;
import com.qtyd.sms.thread.PublishThread;

/**
* @author hucheng E-mail:459382234@qq.com
* @version 创建时间：2018年3月17日 上午11:40:50
* 类说明
*/
@Component
public class NoticeSms {
	
	@Autowired
	private MessageBean messageBean;
	
	@Autowired
	private NoticePublish noticePublish;
	
	public void main(String[] arge) {
		new PublishThread(noticePublish,messageBean).start();
	}
}
