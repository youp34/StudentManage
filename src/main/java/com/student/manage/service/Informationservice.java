package com.student.manage.service;

import com.student.manage.pojo.Information;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Informationservice {
    void preserve(String name,String student_id,String classes,String college,String phonenumber,String finger_id);
    void deleteByName(String name);
    void updateByName(String classes,String student_id,String college,String phonenumber,String finger_id,String name);
    List<Information> queryAll();
    void preserveName(String name,String student_id);
    void inputFinger_id(String name,String finger_id);
    Information finger_exist(String student_id);
    Information findsign(String finger_id);
    void updatestudent(String name,String classes,String student_id,String college,String phonenumber);
    void deleteBystudent_id(String student_id);
}
