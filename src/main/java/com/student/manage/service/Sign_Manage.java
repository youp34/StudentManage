package com.student.manage.service;

import com.student.manage.tool.time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//数据库管理
public class Sign_Manage {
    @Autowired
    InformationserviceImpl informationservice;
    @Autowired
    SignserviceImpl signservice;
    time time = new time();
    public void updata_Sign(){
        //数据库签到信息只保存近五周
        //删除数据库过期信息
    }
}
