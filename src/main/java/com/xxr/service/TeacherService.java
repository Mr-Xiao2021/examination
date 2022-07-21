package com.xxr.service;

import com.xxr.pojo.Teacher;

import java.util.List;

/**
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/6/28 16:48
 * @Version 1.0
 */
public interface TeacherService {
    Teacher selectTeacherById(int id);

    List<Teacher> selectAll();

    Teacher login(Teacher teacher);

    void update(Teacher teacher);
}
