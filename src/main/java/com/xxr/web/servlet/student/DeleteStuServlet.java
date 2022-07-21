package com.xxr.web.servlet.student;

import com.alibaba.fastjson.JSON;
import com.xxr.pojo.Student;
import com.xxr.service.StudentService;
import com.xxr.service.impl.StudentServiceImpl;
import com.xxr.utils.StudentUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "DeleteStuServlet", value = "/deleteStuServlet")
public class DeleteStuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        boolean isSuccess;
//        BufferedReader bf = request.getReader();
//        String params = bf.readLine();
//        Student student = JSON.parseObject(params, Student.class);
        Student student = StudentUtils.getRequestStudent(request);
        if(student==null){
            isSuccess = false;
        }else{
            StudentService ss = new StudentServiceImpl();
            System.out.println(student);
            isSuccess = ss.deleteByStudentId(student.getStudentId());
        }
        Map<String, Object> map = new HashMap<>();
        map.put("isSuccess",isSuccess);
        response.getWriter().write(JSON.toJSONString(map));
    }
}
