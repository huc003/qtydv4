package com.qtyd.dao;

import com.qtyd.model.UserReward;

public interface UserRewardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserReward record);

    int insertSelective(UserReward record);

    UserReward selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserReward record);

    int updateByPrimaryKey(UserReward record);
}