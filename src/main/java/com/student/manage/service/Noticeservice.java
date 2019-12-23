package com.student.manage.service;

import org.springframework.stereotype.Service;

@Service
public interface Noticeservice {
    void update_notice(String notice);
    String find_notice();
}
