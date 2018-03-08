package com.qtyd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qtyd.dao.funds.UserMapper;
import com.qtyd.service.user.UserService;

/**
* @author huc E-mail:459382234@qq.com
* @version 创建时间：2018年3月5日 下午2:50:41
* 类说明
*/
@Service
public class UserServiceImpl implements UserService{

	@Autowired
    private UserMapper userMapper;
	
	@Override
	public List<Object> allUser(String where) {
		// TODO Auto-generated method stub
		return userMapper.select(where);
	}

}
