package com.fenger.sys.controller;


import com.fenger.sys.contast.SysConstast;
import com.fenger.sys.domain.User;
import com.fenger.sys.service.NoticeService;
import com.fenger.sys.utils.DataGirdView;
import com.fenger.sys.utils.WebUtils;
import com.fenger.sys.vo.NoticeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class NoticeController {
    private final static String NOTICE_PREFIX_NOTICE = "notice/";

    @Autowired
    NoticeService noticeService;

    @ResponseBody
    @RequestMapping(NOTICE_PREFIX_NOTICE + "loadAllNotice")
    private DataGirdView loadAllNotice(NoticeVo noticeVo) {
        return this.noticeService.queryAllNotice(noticeVo);
    }

    @ResponseBody
    @RequestMapping(NOTICE_PREFIX_NOTICE + "addNotice")
    private DataGirdView addNotice(NoticeVo noticeVo) {
        noticeVo.setCreatetime(new Date());
        HttpSession session = WebUtils.getCurrentSession();
        User user = (User) session.getAttribute("user");
        noticeVo.setOpername(user.getName());
        try {
            this.noticeService.addNotice(noticeVo);
            return new DataGirdView(SysConstast.SUCCESS_CODE, SysConstast.ADD_SUCCESS_MSG, 1L, null);
        } catch (Exception e) {
            e.printStackTrace();
            return new DataGirdView(SysConstast.ERROR_CODE, SysConstast.ADD_ERROR_MSG, 0L, null);
        }
    }

    @ResponseBody
    @RequestMapping(NOTICE_PREFIX_NOTICE + "updateNotice")
    private DataGirdView updateNotice(NoticeVo noticeVo) {

        try {
            this.noticeService.updateNotice(noticeVo);
            return new DataGirdView(SysConstast.SUCCESS_CODE, SysConstast.UPDATE_SUCCESS_MSG, 1L, null);
        } catch (Exception e) {
            e.printStackTrace();
            return new DataGirdView(SysConstast.ERROR_CODE, SysConstast.UPDATE_ERROR_MSG, 0L, null);
        }
    }

    @ResponseBody
    @RequestMapping(NOTICE_PREFIX_NOTICE + "deleteNotice")
    private DataGirdView deleteNotice(NoticeVo noticeVo) {

        try {
            this.noticeService.deleteNotice(noticeVo.getId());
            return new DataGirdView(SysConstast.SUCCESS_CODE, SysConstast.DELETE_SUCCESS_MSG, 1L, null);
        } catch (Exception e) {
            e.printStackTrace();
            return new DataGirdView(SysConstast.ERROR_CODE, SysConstast.DELETE_ERROR_MSG, 0L, null);
        }
    }


    @ResponseBody
    @RequestMapping(NOTICE_PREFIX_NOTICE + "deleteListNotice")
    private DataGirdView deleteListNotice(@RequestParam(value="id[]", required = false) String[] id) {
        System.out.println("--------------------");
        System.out.println(id);
        for (int i = 0; i < id.length; i++) {
            String s = id[i];
            System.out.println(s);
        }
        return new DataGirdView(SysConstast.ERROR_CODE, SysConstast.DELETE_ERROR_MSG, 0L, null);
    }

}
