package com.xxr.web.update;

import com.alibaba.fastjson.JSON;
import com.xxr.pojo.Student;
import com.xxr.pojo.Teacher;
import com.xxr.service.StudentService;
import com.xxr.service.TeacherService;
import com.xxr.service.impl.StudentServiceImpl;
import com.xxr.service.impl.TeacherServiceImpl;
import com.xxr.utils.StudentUtils;
import com.xxr.utils.TeacherUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "UpdateServlet", value = "/update/*")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        String uri = request.getRequestURI();
        int index = uri.lastIndexOf('/');
        String methodName = uri.substring(index + 1);

        System.out.println(methodName);
        boolean isSuccess = true;
        if("user".equalsIgnoreCase(methodName)){
            //更新学生
            Student stu = StudentUtils.getRequestStudent(request);
            StudentService ss = new StudentServiceImpl();
            ss.updateStudent(stu);

        }else if("admin".equalsIgnoreCase(methodName)){
            //更新管理员
            Teacher teacher = TeacherUtils.getRequestTeacher(request);
            TeacherService ts = new TeacherServiceImpl();
            ts.update(teacher);
        }else{
            isSuccess = false;
        }

        Map<String, Object> map = new HashMap<>(10);
        map.put("isSuccess",isSuccess);
        response.getWriter().write(JSON.toJSONString(map));
    }
}
