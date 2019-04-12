package com.fenger.sys.mapper;

import com.fenger.sys.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);
    User selectByLoginname(String loginname);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}