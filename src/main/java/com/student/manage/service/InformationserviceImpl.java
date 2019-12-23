package com.student.manage.service;

import com.student.manage.dao.InformationMapper;
import com.student.manage.pojo.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationserviceImpl implements Informationservice{
    @Autowired
    InformationMapper informationMapper;
    @Override
    public void deleteByName(String name) {
        informationMapper.deleteByName(name);
    }

    @Override
    public void preserve(String name, String student_id, String classes, String college, String phonenumber, String finger_id) {
        informationMapper.preserve(name,student_id,classes,college,phonenumber,finger_id);
    }

    @Override
    public List<Information> queryAll() {
        return informationMapper.queryAll();
    }

    @Override
    public void updateByName(String classes, String student_id, String college, String phonenumber, String finger_id,String name) {
        informationMapper.updateByName(classes,student_id,college,phonenumber,finger_id,name);
    }

    @Override
    public void preserveName(String name,String student_id) {
        informationMapper.preserveName(name,student_id);
    }
    @Override
    public void inputFinger_id(String name,String finger_id) {
        informationMapper.inputFinger_id(name,finger_id);
    }

    @Override
    public Information finger_exist(String student_id) {
        return informationMapper.finger_exist(student_id);
    }

    @Override
    public void deleteBystudent_id(String student_id) {
        informationMapper.deleteBystudent_id(student_id);
    }

    @Override
    public Information findsign(String finger_id) {
        return informationMapper.findsign(finger_id);
    }

    @Override
    public void updatestudent(String name, String classes, String student_id, String college, String phonenumber) {
        informationMapper.updatestudent(name,classes,student_id,college,phonenumber);
    }
}
