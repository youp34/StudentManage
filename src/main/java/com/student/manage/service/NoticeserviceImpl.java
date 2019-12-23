package com.student.manage.service;

import com.student.manage.dao.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeserviceImpl implements Noticeservice{
    @Autowired
    NoticeMapper noticeMapper;
    @Override
    public void update_notice(String notice) {
        noticeMapper.update_notice(notice);
    }

    @Override
    public String find_notice() {
        return noticeMapper.find_notice();
    }
}
