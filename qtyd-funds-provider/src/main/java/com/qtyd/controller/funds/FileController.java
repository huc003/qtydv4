package com.qtyd.controller.funds;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qtyd.model.User;
import com.qtyd.service.funds.FileService;
import com.qtyd.service.user.UserService;
import com.qtyd.utils.ExportExcelUtils;
import com.qtyd.utils.ExportUtils;

@RestController
@RequestMapping({"/file"})
@Api(value="onlinestore", description="文件解析类")
public class FileController{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FileService fileService;
	
	@RequestMapping(value={"/log_file"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	@ApiOperation(value="日志文件解析", notes="")
	public Set<String> file(@RequestParam("fileName") String fileName,@RequestParam("path") String path){
		return fileService.analysisLog(fileName,path);
	}
	
	@RequestMapping(value={"/download"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	@ApiOperation(value="日志文件解析", notes="")
	public String download(HttpServletResponse response) throws IOException{
		String sheetName = "用户信息";
		String title = "user_id,type_id,`order`,username,password,paypassword,islock,invite_userid,invite_money,real_status,card_type,card_id,card_pic1,card_pic2,nation,realname,invest_integral,integral,status,avatar_status,email_status,phone_status,video_status,scene_status,email,sex,litpic,tel,phone,qq,wangwang,email_temp,email_status_temp,birthday,province,city,area,address,logintime,addtime,addip,uptime,upip,lasttime, lastip, chongzu_id, cz_money, cz_cash, chongzu_new_id, idcardpic, job,is_company, reginvitename, reg_source, trackid, sina_status, sina_uid, nick_name,realname_time, reg_port, real_port, real_page, addip_province, phone_province, is_borrow_tender,is_account_recharge, is_payment_password, withhold, is_birthday_remind, tracktype_id,is_lazy_tender, device_status, task_marker, platcust, xiamen_status, is_payment_password_sina,logout_status";
		ExportExcelUtils.download(response,userService.allUser(), sheetName, title);
		return "SUCCESS";
	}
	
}
