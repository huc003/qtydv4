package com.qtyd.controller.funds;

import java.io.IOException;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qtyd.service.FileService;
import com.qtyd.service.UserService;
import com.qtyd.utils.ExportExcelUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

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
	@ApiImplicitParams({
	     @ApiImplicitParam(paramType="query",name="fileName",dataType="String",required=true,value="来自文件地址",defaultValue="d:"),
		 @ApiImplicitParam(paramType="query",name="path",dataType="String",required=true,value="目标文件路径",defaultValue="e:")
	})
	public Set<String> file(@RequestParam("fileName") String fileName,@RequestParam("path") String path){
		return fileService.analysisLog(fileName,path);
	}
	
	@RequestMapping(value={"/download"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	@ApiOperation(value="日志文件解析", notes="")
	public String download(HttpServletResponse response,String title) throws IOException{
		String sheetName = "用户信息";
		//user_id%2Ctype_id%2C%60order%60%2Cusername
//		String title = "user_id,type_id,`order`,username,password,paypassword,islock,invite_userid,invite_money,real_status,card_type,card_id,card_pic1,card_pic2,nation,realname,invest_integral";
		ExportExcelUtils.download(response,userService.allUser(title), sheetName, title);
		return "SUCCESS";
	}
	
}
