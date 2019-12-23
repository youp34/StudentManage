package com.student.manage.service;

import com.student.manage.dao.LoginMapper;
import com.student.manage.pojo.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginserviceImpl implements Loginservice {
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public void deleteBystudent_id(String student_id) {
        loginMapper.deleteBystudent_id(student_id);
    }
    @Override
    public void changepassword(String newpassword,String student_id) {
        loginMapper.changepassword(newpassword,student_id);
    }

    @Override
    public Login findloginuser(String student_id) {              //登录验证
        return loginMapper.findloginuser(student_id);
    }

    @Override
    public void registered(String email, String password, String name,String finger_id) {      //注册
        loginMapper.registered(email,password,name,finger_id);
    }

    @Override
    public void setpermissionbyid(String permission, String student_id) {
        loginMapper.setpermissionbyid(permission,student_id);
    }
}
