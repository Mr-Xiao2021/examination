package com.xxr.web.servlet.test;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/test/*")
public class ObjectServlet extends HttpServlet {
    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("deleteByIds();");
    }
    public void hello(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("hello();");
    }
    public void niHao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("niHao();");
    }
}
