package com.fenger.sys.controller;

import com.fenger.sys.contast.SysConstast;
import com.fenger.sys.domain.Permission;
import com.fenger.sys.domain.User;
import com.fenger.sys.service.PermissionService;
import com.fenger.sys.utils.*;
import com.fenger.sys.vo.PermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MenuController {

    private final static String URL_MENU = "menu/";


    @Autowired
    PermissionService permissionService;

    @ResponseBody
    @RequestMapping(URL_MENU+"loadAllLeftMenuTree")
    public List<TreeNode> loadAllLeftMenuTree(PermissionVo permissionVo){
        HttpSession session = WebUtils.getCurrentSession();
        permissionVo.setAvailable(SysConstast.AVAILABLE_TRUE);
        permissionVo.setType(SysConstast.TYPE_PERMISSION_MENU);
        User user = (User) session.getAttribute("user");
        List<Permission> permissions = null;
        if(user.getType()==SysConstast.USER_SUPER){
            permissions = permissionService.queryAllPermission(permissionVo);
        }else {
            permissions=permissionService.queryPermissionByUserid(permissionVo,user.getId());
        }
        List<TreeNode> treeNodes = new ArrayList<>();
        for (Permission permission : permissions) {
            Integer id = permission.getId();
            String title = permission.getName();
            String href = permission.getHref();
            String icon = permission.getIcon();
            Boolean spread = permission.getOpen()==SysConstast.STATUS_OPEN_TRUE?true:false;
            Integer pId = permission.getPid();
            treeNodes.add(new TreeNode(id, title, href, icon, spread, pId));
        }

        return TreeNodeUtils.build(treeNodes,1);
    }
    @ResponseBody
    @RequestMapping(URL_MENU+"loadAllLeftDeptTree")
    public DtreeJson loadAllLeftDeptTree(PermissionVo permissionVo){
        HttpSession session = WebUtils.getCurrentSession();
        permissionVo.setAvailable(SysConstast.AVAILABLE_TRUE);
        permissionVo.setType(SysConstast.TYPE_PERMISSION_MENU);
        User user = (User) session.getAttribute("user");
        List<Permission> permissions = null;
        if(user.getType()==SysConstast.USER_SUPER){
            permissions = permissionService.queryAllPermission(permissionVo);
        }else {
            permissions=permissionService.queryPermissionByUserid(permissionVo,user.getId());
        }
        List<DtreeNode> dtreeNodes = new ArrayList<>();
        for (Permission permission : permissions) {
            Integer id =permission.getId();
            String title = permission.getName();
            String checkArr = "0";
            Integer parentId = permission.getPid();
            Boolean spread = permission.getOpen()==SysConstast.STATUS_OPEN_TRUE?true:false;
            String iconClass = permission.getIcon();
            dtreeNodes.add(new DtreeNode(id,title,checkArr,parentId,spread,iconClass));
        }

        return new DtreeJson(SysConstast.SUCCESS_CODE,SysConstast.SUCCESS_MSG,dtreeNodes);
    }
}
