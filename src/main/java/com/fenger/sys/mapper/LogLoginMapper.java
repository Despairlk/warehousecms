package com.fenger.sys.mapper;

import com.fenger.sys.domain.LogLogin;
import com.fenger.sys.vo.LogLoginVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LogLoginMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LogLogin record);

    int insertSelective(LogLogin record);

    LogLogin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogLogin record);

    int updateByPrimaryKey(LogLogin record);
    List<LogLogin> queryAllLogLogin(LogLoginVo record);
}