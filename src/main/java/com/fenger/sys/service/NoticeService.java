package com.fenger.sys.service;


import com.fenger.sys.utils.DataGirdView;
import com.fenger.sys.vo.NoticeVo;


public interface NoticeService {

    DataGirdView queryAllNotice(NoticeVo noticeVo);

    void addNotice(NoticeVo noticeVo);
    void updateNotice(NoticeVo noticeVo);
    void deleteNotice(Integer id);

}
