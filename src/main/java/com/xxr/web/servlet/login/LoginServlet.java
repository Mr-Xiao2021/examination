package com.xxr.web.servlet.login;

import com.alibaba.fastjson.JSON;
import com.xxr.pojo.Student;
import com.xxr.pojo.Teacher;
import com.xxr.service.TeacherService;
import com.xxr.service.impl.StudentServiceImpl;
import com.xxr.service.impl.TeacherServiceImpl;
import com.xxr.utils.StudentUtils;
import com.xxr.utils.TeacherUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LoginServlet", value = "/login/*")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        response.setContentType("text/json;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        String uri = request.getRequestURI();
        int index = uri.lastIndexOf('/');
        String methodName = uri.substring(index + 1);

        String responseStr;
        boolean isStu;

        if("user".equals(methodName)){
            isStu = true;
        }else if("admin".equals(methodName)){
            isStu = false;
        }else{
            responseStr = "用户路径错误~";
            Map<String, Object> map = new HashMap<>();
            map.put("errorInfo",responseStr);
            response.getWriter().write(JSON.toJSONString(map));
            return;
        }

        String errInfo;
        boolean isSuccess = false;

        String checkcode = request.getParameter("checkcode");
        String realCheckCode = (String) session.getAttribute("CHECKCODE_SERVER");
        //保持验证码一次性和用户、管理员登出
        session.removeAttribute("CHECKCODE_SERVER");
        session.removeAttribute("currentUserId");
        session.removeAttribute("currentAdminId");

        if(realCheckCode == null || !realCheckCode.equalsIgnoreCase(checkcode)){
            errInfo = "验证码错误！";
            Map<String, Object> map = new HashMap<>(2);
            map.put("errorInfo",errInfo);
            response.getWriter().write(JSON.toJSONString(map));
            return;
        }

//        String id = request.getParameter("id");
//        String password = request.getParameter("password");
//
//        System.out.println(isStu);
        Teacher loginTeacher;
        Student loginStudent;
        Map<String, Object> map = new HashMap<>(5);
        if(isStu){
            //是学生
            StudentServiceImpl ss = new StudentServiceImpl();
            Student student = StudentUtils.getRequestStudent(request);
            loginStudent = ss.login(student);
            if(loginStudent != null){
                isSuccess = true;
                session.setAttribute("currentUserId",student.getStudentId());
                map.put("currentUserId",student.getStudentId());
                System.out.println(session.getAttribute("currentUserId"));
            }
        }else{
            //是老师
            TeacherService ts = new TeacherServiceImpl();
            Teacher teacher = TeacherUtils.getRequestTeacher(request);
            loginTeacher = ts.login(teacher);
            if(loginTeacher != null){
                isSuccess = true;
                session.setAttribute("currentAdminId",teacher.getTeacherId());
                map.put("currentAdminId",teacher.getTeacherId());
                System.out.println(session.getAttribute("currentAdminId"));
            }
        }



        if(!isSuccess){

            errInfo = "用户名或密码错误!";
            map.put("errorInfo",errInfo);
        }
        map.put("isSuccess",isSuccess);

        response.getWriter().write(JSON.toJSONString(map));


    }
}
