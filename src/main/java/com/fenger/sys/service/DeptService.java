package com.fenger.sys.service;

import com.fenger.sys.domain.Dept;
import com.fenger.sys.utils.DataGirdView;
import com.fenger.sys.vo.DeptVo;

import java.util.List;

public interface DeptService {

    /**
     * 查询所有部门
     */
    List<Dept> queryAllDept(DeptVo deptVo);

    /**
     * 查询所有部门 带分页
     * @param deptVo
     * @return
     */
    DataGirdView queryAllDeptForPage(DeptVo deptVo);
}
