package com.fenger.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用于系统管理 页面转发
 */
@Controller
public class SystemController {

    private final static String URL_PREFIX ="main/";



    /**********************部门管理页面**************************/
    /**
     * 部门管理页面
     * @return
     */
    @RequestMapping(URL_PREFIX+"toDeptManager")
    public String toDeptManager(){
        return "sys/dept/deptManager";
    }
    /**
     * 部门管理左侧树页面
     * @return
     */
      @RequestMapping(URL_PREFIX+"toDeptLeftManager")
    public String toDeptLeftManager(){
        return "sys/dept/deptLeftManager";
    }
    /**
     * 部门管理右侧表格页面
     * @return
     */
      @RequestMapping(URL_PREFIX+"toDeptMainManager")
    public String toDeptMainManager(){
        return "sys/dept/deptMainManager";
    }

    /*****************************系统公告页面**********************************/
    @RequestMapping(URL_PREFIX+"toNoticeManager")
    public String toNoticeManager(){
        return "sys/notice/noticeManager";
    }

}
