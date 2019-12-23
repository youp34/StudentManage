package com.student.manage.dao;

import com.student.manage.pojo.Sign_in;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SignMapper {
    //用作登录保存用户姓名
    @Insert("insert into tb_sign (name,sign_time,finger_id) values (#{name},NULL,NULL)")
    void preserveName(@Param("name")String name);
    @Select("select * from tb_sign")
    List<Sign_in> queryAll();
    @Delete("delete from tb_sign where sign_time=#{sign_time}")
    void delete_sign(@Param("sign_time")String sign_time);
    @Insert("insert into tb_sign (name,sign_time,sick,absence,attendance) values (#{name},#{sign_time},#{sick},#{absence},#{attendance})")
    void finger_sign(@Param("name")String name,@Param("sign_time")String sign_time,@Param("sick")String sick,@Param("absence")String absence,@Param("attendance")String attendance);
    @Delete("delete from tb_sign where name=#{name}")
    void deleteByname(@Param("name")String name);
}

