package com.xxr.web.servlet.test;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//@WebServlet(name = "BaseServlet", value = "/baseServlet")
public class BaseServlet extends HttpServlet {
    //根据请求的最后一段路径来进行方法分发
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //1. 获取请求路径
//        String uri = req.getRequestURI(); // /brand-case/brand/selectAll
////        System.out.println(uri);
//        //2. 获取最后一段路径，方法名
//        int index = uri.lastIndexOf('/');
//
//        String methodName = uri.substring(index + 1); //  /selectAll? selectAll?
//
////        System.out.println(methodName);
//
//        //2. 执行方法
//        //2.1 获取BrandServlet /UserServlet 字节码对象 Class
//        //System.out.println(this);
//
//        Class<? extends BaseServlet> cls = this.getClass();
//        //2.2 获取方法 Method对象
//        try {
//            Method method = cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
//            //2.3 执行方法
//            method.invoke(this,req,resp);
//        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
//            e.printStackTrace();
//        }
//
//
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取请求路径
        String uri = req.getRequestURI(); // /brand-case/brand/selectAll
//        System.out.println(uri);
        //2. 获取最后一段路径，方法名
        int index = uri.lastIndexOf('/');

        String methodName = uri.substring(index + 1); //  /selectAll? selectAll?

//        System.out.println(methodName);

        //2. 执行方法
        //2.1 获取BrandServlet /UserServlet 字节码对象 Class
        //System.out.println(this);

        Class<? extends BaseServlet> cls = this.getClass();
        //2.2 获取方法 Method对象
        try {
            Method method = cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //2.3 执行方法
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
