package com.qtyd.controller.funds;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qtyd.service.funds.FileService;

@RestController
@RequestMapping({"/file"})
@Api(value="onlinestore", description="文件解析类")
public class FileController{
	
	@Autowired
	private FileService fileService;
	
	@RequestMapping(value={"/log_file"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	@ApiOperation(value="日志文件解析", notes="")
	public Set<String> file(@RequestParam("fileName") String fileName,@RequestParam("path") String path){
		return fileService.analysisLog(fileName,path);
//		return "日志文件解析";
	}
	
}
