package com.fenger.sys.service.impl;

import com.fenger.sys.contast.SysConstast;
import com.fenger.sys.domain.Dept;
import com.fenger.sys.mapper.DeptMapper;
import com.fenger.sys.service.DeptService;
import com.fenger.sys.utils.DataGirdView;
import com.fenger.sys.vo.DeptVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    DeptMapper deptMapper;
    @Override
    public List<Dept> queryAllDept(DeptVo deptVo) {
        return this.deptMapper.queryAllDept(deptVo);
    }
    @Override
    public DataGirdView queryAllDeptForPage(DeptVo deptVo) {
        Page<Object> page = PageHelper.startPage(deptVo.getPage(), deptVo.getLimit());
        List<Dept> depts = this.deptMapper.queryAllDept(deptVo);

        return new DataGirdView(SysConstast.SUCCESS_CODE,SysConstast.SUCCESS_MSG,page.getTotal(),depts) ;
    }
}
