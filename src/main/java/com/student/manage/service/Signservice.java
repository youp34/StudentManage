package com.student.manage.service;

import com.student.manage.pojo.Sign_in;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Signservice {
    void preserveName(String name);
    List<Sign_in> queryAll();
    void finger_sign(String name,String sign_time,String sick,String absence,String attendance);
    void deleteByname(String name);
}
