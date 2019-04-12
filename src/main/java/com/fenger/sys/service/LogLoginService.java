package com.fenger.sys.service;


import com.fenger.sys.utils.DataGirdView;
import com.fenger.sys.vo.LogLoginVo;


public interface LogLoginService {

    DataGirdView queryAllLogLogin(LogLoginVo logLoginVo);

    void addLogLogin(LogLoginVo logLoginVo);
    void updateLogLogin(LogLoginVo logLoginVo);
    void deleteLogLogin(Integer id);

}
