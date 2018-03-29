package com.qtyd.service.impl;

import com.qtyd.dao.UserMapper;
import com.qtyd.model.User;
import com.qtyd.service.FundsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 资金相关实现类
 * Created by huc on 2017/12/20.
 */
@Service
public class FundsServiceImpl implements FundsService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User userFundsByUserId(Long userId) {
        User user = userMapper.selectByPrimaryKey(1274265);
        return user;
    }
}
