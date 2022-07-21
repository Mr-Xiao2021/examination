package com.xxr.mapper;

import com.xxr.pojo.Teacher;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/6/28 16:43
 * @Version 1.0
 */
public interface TeachersMapper {
    @Select("select * from Examination.admins where id = #{id};")
    @ResultMap("teachersResultMapper")
    Teacher selectTeacherById(int id);


    @Select("select * from Examination.admins;")
    @ResultMap("teachersResultMapper")
    List<Teacher> selectAll();

    @Select("select * from Examination.admins where id = #{teacherId} and password = #{password};")
    @ResultMap("teachersResultMapper")
    Teacher login(Teacher teacher);

    void update(Teacher teacher);

}
