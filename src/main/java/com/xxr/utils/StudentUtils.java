package com.xxr.utils;

import com.xxr.pojo.Student;
import jakarta.servlet.http.HttpServletRequest;

/**
 * @ClassName StudentUtils
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/7/14 15:02
 * @Version 1.0
 */
public class StudentUtils {
    public static Student getRequestStudent(HttpServletRequest request){
        Student student = new Student();

        String _studentId = request.getParameter("studentId");
        if(_studentId!=null&&_studentId.length()>0){
            student.setStudentId(Integer.parseInt(_studentId));
        }
        student.setName(request.getParameter("name"));
        student.setEmail(request.getParameter("email"));
        student.setGender(request.getParameter("gender"));
        student.setPassword(request.getParameter("password"));
        return student;
    }
}
