package com.qtyd.dao.funds;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qtyd.model.User;
import com.qtyd.model.UserWithBLOBs;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserWithBLOBs record);

    int insertSelective(UserWithBLOBs record);

    UserWithBLOBs selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(UserWithBLOBs record);

    int updateByPrimaryKey(User record);
    
    List<Object> select(@Param("where") String where);
}