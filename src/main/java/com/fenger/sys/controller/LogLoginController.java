package com.fenger.sys.controller;


import com.fenger.sys.contast.SysConstast;
import com.fenger.sys.domain.User;
import com.fenger.sys.service.LogLoginService;
import com.fenger.sys.utils.DataGirdView;
import com.fenger.sys.utils.WebUtils;
import com.fenger.sys.vo.LogLoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class LogLoginController {
    private final static String NOTICE_PREFIX_NOTICE = "logLogin/";

    @Autowired
    LogLoginService logLoginService;

    @ResponseBody
    @RequestMapping(NOTICE_PREFIX_NOTICE + "loadAllLogLogin")
    private DataGirdView loadAllLogLogin(LogLoginVo logLoginVo) {
        return this.logLoginService.queryAllLogLogin(logLoginVo);
    }

    @ResponseBody
    @RequestMapping(NOTICE_PREFIX_NOTICE + "addLogLogin")
    private DataGirdView addLogLogin(LogLoginVo logLoginVo) {
        HttpSession session = WebUtils.getCurrentSession();
        User user = (User) session.getAttribute("user");
        HttpServletRequest request = WebUtils.getCurrentRequest();
        String ip = request.getRemoteAddr();
        logLoginVo.setLoginname(user.getName()+"-"+user.getLoginname());
        logLoginVo.setLoginip(ip);
        logLoginVo.setLogintime(new Date());
        try {
            this.logLoginService.addLogLogin(logLoginVo);
            return new DataGirdView(SysConstast.SUCCESS_CODE, SysConstast.ADD_SUCCESS_MSG, 1L, null);
        } catch (Exception e) {
            e.printStackTrace();
            return new DataGirdView(SysConstast.ERROR_CODE, SysConstast.ADD_ERROR_MSG, 0L, null);
        }
    }


    @ResponseBody
    @RequestMapping(NOTICE_PREFIX_NOTICE + "deleteLogLogin")
    private DataGirdView deleteLogLogin(LogLoginVo logLoginVo) {

        try {
            this.logLoginService.deleteLogLogin(logLoginVo.getId());
            return new DataGirdView(SysConstast.SUCCESS_CODE, SysConstast.DELETE_SUCCESS_MSG, 1L, null);
        } catch (Exception e) {
            e.printStackTrace();
            return new DataGirdView(SysConstast.ERROR_CODE, SysConstast.DELETE_ERROR_MSG, 0L, null);
        }
    }

    @ResponseBody
    @RequestMapping(NOTICE_PREFIX_NOTICE + "deleteListLogLogin")
    private DataGirdView deleteListLogLogin(@RequestParam(value="id[]", required = false) String[] id) {
        System.out.println("--------------------");
        System.out.println(id);
        for (int i = 0; i < id.length; i++) {
            String s = id[i];
            System.out.println(s);
        }
        return new DataGirdView(SysConstast.ERROR_CODE, SysConstast.DELETE_ERROR_MSG, 0L, null);
    }

}
