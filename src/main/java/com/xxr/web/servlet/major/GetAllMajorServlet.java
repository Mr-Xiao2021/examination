package com.xxr.web.servlet.major;

import com.alibaba.fastjson.JSON;
import com.xxr.pojo.Major;
import com.xxr.service.MajorService;
import com.xxr.service.impl.MajorServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetAllMajorServlet", value = "/getAllMajorServlet")
public class GetAllMajorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MajorService ms = new MajorServiceImpl();
        List<Major> majors = ms.selectAll();
        String jsonString = JSON.toJSONString(majors);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
}
