package com.student.manage.dao;

import com.student.manage.pojo.Login;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LoginMapper {
    @Select("select * from tb_login where student_id=#{student_id}")    //用作登录
    Login findloginuser(@Param("student_id")String student_id);
    @Update("update tb_login set password=#{newpassword} where student_id=#{student_id}")    //更改密码
    void changepassword(@Param("newpassword")String newpassword,@Param("student_id")String student_id);
    @Insert("insert into tb_login(student_id,password,name,permission) values (#{student_id},#{password},#{name},#{finger_id})")   //注册账号
    void registered(@Param("student_id")String student_id, @Param("password")String password,@Param("name")String name,@Param("finger_id")String finger_id);
    @Update("update tb_login set permission=#{permission} where student_id=#{student_id}")    //更改密码
    void setpermissionbyid(@Param("permission")String permission,@Param("student_id")String student_id);
    @Delete("delete from tb_login where student_id=#{student_id}")
    void deleteBystudent_id(@Param("student_id")String student_id);
}
