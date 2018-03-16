package com.qtyd.service.impl;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.qtyd.service.FileService;
import com.qtyd.utils.ReadFromFileUtils;
/**
* @author huc E-mail:459382234@qq.com
* @version 创建时间：2018年2月28日 下午3:18:28
* 类说明
*/
@Service
public class FileServiceImpl implements FileService{

	@Override
	public Set<String> analysisLog(String fileName,String path) {
		Set<String> set = ReadFromFileUtils.readTxt(fileName,path);
		return set;
	}

}
