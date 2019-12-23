package com.student.manage.service;


import com.student.manage.pojo.Login;
import org.springframework.stereotype.Service;

@Service
public interface Loginservice {
    Login findloginuser(String student_id);
    void changepassword(String newpassword,String student_id);
    void registered(String email,String password,String name,String finger_id);
    void setpermissionbyid(String permission,String student_id);
    void deleteBystudent_id(String student_id);
}
