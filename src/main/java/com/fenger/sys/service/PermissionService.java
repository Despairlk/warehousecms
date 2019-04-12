package com.fenger.sys.service;

import com.fenger.sys.domain.Permission;
import com.fenger.sys.vo.PermissionVo;

import java.util.List;

public interface PermissionService {

    /**
     * 查询所有可用的菜单或权限
     */
    List<Permission> queryAllPermission(PermissionVo permissionVo);
    /**
     * 根据用户菜单查询权限或菜单
     */
    List<Permission> queryPermissionByUserid(PermissionVo permissionVo,Integer userid);
}
