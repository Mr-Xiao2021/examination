package com.xxr.web.servlet.student;

import com.alibaba.fastjson.JSON;
import com.xxr.pojo.Student;
import com.xxr.service.StudentService;
import com.xxr.service.impl.StudentServiceImpl;
import com.xxr.utils.StuEcpUtils;
import com.xxr.utils.StudentUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr_X
 */
@WebServlet(name = "AddStuServlet", value = "/register")
public class AddStuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.removeAttribute("currentUserId");

        Student student = StudentUtils.getRequestStudent(request);

        response.setContentType("text/json;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        StudentService ss = new StudentServiceImpl();

        System.out.println(student);
        Map<String, Object> map = new HashMap<>();
        ss.addStudent(student);
        map.put("isSuccess",true);
        map.put("currentUserId",student.getStudentId());
        session.setAttribute("currentUserId",student.getStudentId());
        System.out.println("session--\t"+session.getAttribute("currentUserId"));
        String jsonString = JSON.toJSONString(map);


        response.getWriter().write(jsonString);

        //http://47.113.225.80:8080/examination/register?name=testHa&gender=%E7%94%B7&password=4321&email=123@123.com
    }
}
