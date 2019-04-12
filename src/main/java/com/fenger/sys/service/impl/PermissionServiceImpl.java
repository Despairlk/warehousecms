package com.fenger.sys.service.impl;

import com.fenger.sys.domain.Permission;
import com.fenger.sys.mapper.PermissionMapper;
import com.fenger.sys.service.PermissionService;
import com.fenger.sys.vo.PermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionMapper permissionMapper;
    @Override
    @Transactional(readOnly = true)
    public List<Permission> queryAllPermission(PermissionVo permissionVo) {
        return this.permissionMapper.queryAllPermission(permissionVo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Permission> queryPermissionByUserid(PermissionVo permissionVo, Integer userid) {

        return this.permissionMapper.queryAllPermission(permissionVo);
    }
}
