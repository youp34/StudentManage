package com.student.manage.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface NoticeMapper {
    @Update("update tb_notice set notice=#{notice}")
    void update_notice(@Param("notice")String notice);
    @Select("select * from tb_notice")
    String find_notice();
}

