package com.fenger.sys.controller;

import com.fenger.sys.contast.SysConstast;
import com.fenger.sys.domain.Dept;
import com.fenger.sys.domain.User;
import com.fenger.sys.service.DeptService;
import com.fenger.sys.service.DeptService;
import com.fenger.sys.utils.*;
import com.fenger.sys.vo.DeptVo;
import com.fenger.sys.vo.DeptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DeptController {

    private final static String URL_MENU = "dept/";


    @Autowired
    DeptService deptService;

    @ResponseBody
    @RequestMapping(URL_MENU+"loadAllLeftDeptTree")
    public DtreeJson loadAllLeftDeptTree(DeptVo deptVo){
        HttpSession session = WebUtils.getCurrentSession();
        deptVo.setAvailable(SysConstast.AVAILABLE_TRUE);
        List<Dept> depts = null;
            depts=deptService.queryAllDept(deptVo);
        List<DtreeNode> dtreeNodes = new ArrayList<>();
        for (Dept dept : depts) {
            Integer id =dept.getId();
            String title = dept.getName();
            String checkArr = "0";
            Integer parentId = dept.getPid();
            Boolean spread = dept.getOpen()==SysConstast.STATUS_OPEN_TRUE?true:false;
            String iconClass = "";
            dtreeNodes.add(new DtreeNode(id,title,checkArr,parentId,spread,iconClass));
        }

        return new DtreeJson(SysConstast.SUCCESS_CODE,SysConstast.SUCCESS_MSG,dtreeNodes);
    }
    @ResponseBody
    @RequestMapping(URL_MENU+"loadAllDeptForTable")
    public DataGirdView loadAllDeptForTable(DeptVo deptVo){
        deptVo.setAvailable(SysConstast.AVAILABLE_TRUE);
        return this.deptService.queryAllDeptForPage(deptVo);
    }

}
