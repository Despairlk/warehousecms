package com.fenger.sys.service.impl;

import com.fenger.sys.contast.SysConstast;
import com.fenger.sys.domain.Notice;
import com.fenger.sys.mapper.NoticeMapper;
import com.fenger.sys.service.NoticeService;
import com.fenger.sys.utils.DataGirdView;
import com.fenger.sys.vo.NoticeVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    NoticeMapper noticeMapper;
    @Override
    public DataGirdView queryAllNotice(NoticeVo noticeVo) {
        Page<Object> page = PageHelper.startPage(noticeVo.getPage(), noticeVo.getLimit());
        List<Notice> notices = this.noticeMapper.queryAllNotice(noticeVo);

        return new DataGirdView(SysConstast.SUCCESS_CODE,SysConstast.SUCCESS_MSG,page.getTotal(),notices);
    }

    @Override
    public void addNotice(NoticeVo noticeVo) {
        this.noticeMapper.insertSelective(noticeVo);
    }

    @Override
    public void updateNotice(NoticeVo noticeVo) {
        this.noticeMapper.updateByPrimaryKeySelective(noticeVo);
    }

    @Override
    public void deleteNotice(Integer id) {
        this.noticeMapper.deleteByPrimaryKey(id);
    }
}
