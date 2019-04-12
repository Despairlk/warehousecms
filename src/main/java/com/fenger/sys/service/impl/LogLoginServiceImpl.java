package com.fenger.sys.service.impl;

import com.fenger.sys.contast.SysConstast;
import com.fenger.sys.domain.LogLogin;
import com.fenger.sys.mapper.LogLoginMapper;
import com.fenger.sys.service.LogLoginService;
import com.fenger.sys.utils.DataGirdView;
import com.fenger.sys.vo.LogLoginVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogLoginServiceImpl implements LogLoginService {

    @Autowired
    LogLoginMapper logLoginMapper;
    @Override
    public DataGirdView queryAllLogLogin(LogLoginVo logLoginVo) {
        Page<Object> page = PageHelper.startPage(logLoginVo.getPage(), logLoginVo.getLimit());
        List<LogLogin> logLogins = this.logLoginMapper.queryAllLogLogin(logLoginVo);

        return new DataGirdView(SysConstast.SUCCESS_CODE,SysConstast.SUCCESS_MSG,page.getTotal(),logLogins);
    }

    @Override
    public void addLogLogin(LogLoginVo logLoginVo) {
        this.logLoginMapper.insertSelective(logLoginVo);
    }

    @Override
    public void updateLogLogin(LogLoginVo logLoginVo) {
        this.logLoginMapper.updateByPrimaryKeySelective(logLoginVo);
    }

    @Override
    public void deleteLogLogin(Integer id) {
        this.logLoginMapper.deleteByPrimaryKey(id);
    }
}
