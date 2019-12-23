package com.student.manage.dao;

import com.student.manage.pojo.Information;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InformationMapper {
    //保存用户信息
    @Insert("insert into tb_information(name,student_id,classes,college,phonenumber,finger_id) values (#{name},#{student_id},#{classes},#{college},#{phonenumber},#{finger_id})")
    void preserve(@Param("name")String name,@Param("student_id")String student_id,@Param("classes")String classes,@Param("college")String college,@Param("phonenumber")String phonenumber,@Param("finger_id")String finger_id);
    //用作登录保存用户姓名
    @Insert("insert into tb_information(name,student_id) values (#{name},#{student_id})")
    void preserveName(@Param("name")String name,@Param("student_id")String student_id);
    //删除用户信息 通过姓名
    @Delete("delete from tb_information where name=#{name}")
    void deleteByName(@Param("name")String name);
    //修改用户信息 通过姓名
    @Update("update tb_information set classes=#{classes},student_id=#{student_id},phonenumber=#{phonenumber},college=#{college},finger_id=#{finger_id} where name=#{name}")
    void updateByName(@Param("name")String name,@Param("classes")String classes,@Param("student_id")String student_id,@Param("college")String college,@Param("phonenumber")String phonenumber,@Param("finger_id")String finger_id);
    @Update("update tb_information set classes=#{classes},student_id=#{student_id},phonenumber=#{phonenumber},college=#{college} where name=#{name}")
    void updatestudent(@Param("name")String name,@Param("classes")String classes,@Param("student_id")String student_id,@Param("college")String college,@Param("phonenumber")String phonenumber);
    //遍历
    @Select("select * from tb_information")
    List<Information> queryAll();
    @Select("select * from tb_information where student_id=#{student_id}")
    Information finger_exist(@Param("student_id")String student_id);
    @Update("update tb_information set finger_id=#{finger_id} where name=#{name}")
    void inputFinger_id(@Param("name")String name,@Param("finger_id")String finger_id);
    @Select("select * from tb_information where finger_id=#{finger_id}")
    Information findsign(@Param("finger_id")String finger_id);
    @Delete("delete from tb_information where student_id=#{student_id}")
    void deleteBystudent_id(@Param("student_id")String student_id);
}
