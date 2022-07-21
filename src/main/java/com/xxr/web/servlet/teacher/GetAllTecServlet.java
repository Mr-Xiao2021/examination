package com.xxr.web.servlet.teacher;

import com.alibaba.fastjson.JSON;
import com.xxr.service.TeacherService;
import com.xxr.service.impl.TeacherServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "GetAllTecServlet", value = "/getAllTecServlet")
public class GetAllTecServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeacherService ts = new TeacherServiceImpl();
        String jsonString = JSON.toJSONString(ts.selectAll());
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
}
