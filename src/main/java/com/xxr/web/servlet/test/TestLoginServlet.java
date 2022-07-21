package com.xxr.web.servlet.test;

import com.alibaba.fastjson.JSON;
import com.xxr.pojo.Student;
import com.xxr.service.StudentService;
import com.xxr.service.impl.StudentServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "TestLoginServlet", value = "/testLoginServlet")
public class TestLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String s = reader.readLine();
        Student student = JSON.parseObject(s, Student.class);
        System.out.println(student);
        System.out.println(s);
//        System.out.println("一次检测~");
//        request.getParameterMap().forEach((k,v)-> System.out.println(k+"--->"+v[0]));
//        StudentService ss = new StudentServiceImpl();
//        HashMap<String, Object> map = new HashMap<>();
//        Student student = ss.selectStuById(1);
//        student.setName("肖先荣");
//        map.put("studentId",student.getStudentId());
//        map.put("name",student.getName());
//        map.put("password",student.getPassword());
//        map.put("email",student.getEmail());
//        map.put("teacherId",student.getTeacherId());
//        map.put("majorId",student.getMajorId());
//        String jsonString = JSON.toJSONString(map);
//        System.out.println(jsonString);
//        response.setContentType("text/json;charset=utf-8");
//        Cookie cookie = new Cookie("student", "hello");
//        response.addCookie(cookie);
//        response.getWriter().write(jsonString);
    }
}
