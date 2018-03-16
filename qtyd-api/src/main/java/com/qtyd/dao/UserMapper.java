package com.qtyd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qtyd.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKeyWithBLOBs(User record);

    int updateByPrimaryKey(User record);
    
    List<Object> select(@Param("where") String where);
    
    List<User> selectByUser(@Param("user") User record);
}