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

@WebServlet(name = "ShowCurStuServlet", value = "/showCurStuServlet")
public class ShowCurStuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        HashMap<String, Object> map = new HashMap<>();

        StudentService ss = new StudentServiceImpl();
        HttpSession session = request.getSession();
        String studentIdStr = (String) session.getAttribute("studentId");
        String reg = "^[0-9]*[1-9][0-9]*$";
        int studentId;
        if(studentIdStr!=null&&studentIdStr.matches(reg)){
            studentId = Integer.parseInt(studentIdStr);
            Student student = ss.selectStuById(studentId);
            if(student!=null){
                map.put("isExist",true);
                map.put("student",student);
            }else{
                map.put("isExist",false);
            }
        }else{
            map.put("isExist",false);
        }

        String jsonString = JSON.toJSONString(map);
        response.getWriter().write(jsonString);

    }
}
