package com.student.manage.service;

import com.student.manage.dao.SignMapper;
import com.student.manage.pojo.Sign_in;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignserviceImpl implements Signservice {
    @Autowired
    SignMapper signMapper;
    @Override
    public void preserveName(String name) {
        signMapper.preserveName(name);
    }

    @Override
    public List<Sign_in> queryAll() {
        return signMapper.queryAll();
    }

    @Override
    public void deleteByname(String name) {
        signMapper.deleteByname(name);
    }

    @Override
    public void finger_sign(String name, String sign_time, String sick, String absence, String attendance) {
        signMapper.finger_sign(name,sign_time,sick,absence,attendance);
    }
}
