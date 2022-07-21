package com.xxr.web.servlet.student;

import com.alibaba.fastjson.JSON;
import com.xxr.pojo.Student;
import com.xxr.service.StudentService;
import com.xxr.service.impl.StudentServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "FindStuByIdServlet", value = "/findStuByIdServlet")
public class FindStuByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HashMap<String, Object> map = new HashMap<>();

        String _studentId = request.getParameter("studentId");

        int studentId = Integer.parseInt(_studentId);
        //根据前端 注册 页面传来的用户号判断是否被占用，返回是否被占用的boolean值
        StudentService ss = new StudentServiceImpl();
        Student student = ss.selectStuById(studentId);

        boolean isExist = student != null;

        map.put("isExist",isExist);

        String toJSONString = JSON.toJSONString(map);
        //处理异步请求后的响应数据，返回exist的判断
        response.getWriter().write(toJSONString);

    }
}
