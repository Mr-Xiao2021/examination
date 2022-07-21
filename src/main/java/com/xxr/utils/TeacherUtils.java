package com.xxr.utils;

import com.xxr.pojo.Student;
import com.xxr.pojo.Teacher;
import jakarta.servlet.http.HttpServletRequest;

/**
 * @ClassName TeacherUtils
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/7/18 17:10
 * @Version 1.0
 */
public class TeacherUtils {
    public static Teacher getRequestTeacher(HttpServletRequest request){
        Teacher teacher = new Teacher();
        String _teacherId = request.getParameter("teacherId");
        if(_teacherId!=null&&_teacherId.length()>0){
            teacher.setTeacherId(Integer.parseInt(_teacherId));
        }
        teacher.setName(request.getParameter("name"));
        teacher.setPassword(request.getParameter("password"));
        return teacher;
    }
}
