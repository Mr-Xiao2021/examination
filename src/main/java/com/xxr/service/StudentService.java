package com.xxr.service;

import com.xxr.pojo.Student;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/6/27 21:58
 * @Version 1.0
 */
public interface StudentService {
    List<Student> selectAll();

    Student selectStuById(int id);

    void addStudent(Student student);

    Student login(Student student);

    List<Student> selectByCondition(Student student);


    int selectStuCountByCondition(Student student);

    Map<String, Object> getByStudentIdToMap(int id);

    List<Map<String, Object>> getStuByCdtToList(Student student);

    boolean updateStudent(Student student);

    boolean deleteByStudentId(int id);

    int getCurrentId();
}
