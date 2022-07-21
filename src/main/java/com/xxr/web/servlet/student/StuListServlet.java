package com.xxr.web.servlet.student;

import com.alibaba.fastjson.JSON;
import com.xxr.pojo.Student;
import com.xxr.service.StudentService;
import com.xxr.service.impl.StudentServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * 响应获得所有学生信息的请求，返回students的json数据信息
 */
@WebServlet(name = "StuListServlet", value = "/stuListServlet")
public class StuListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentService ss = new StudentServiceImpl();
        List<Student> students = ss.selectAll();
        String jsonString = JSON.toJSONString(students);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
}
