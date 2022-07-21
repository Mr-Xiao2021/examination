package com.xxr.web.servlet.assets;

import com.alibaba.fastjson.JSON;
import com.xxr.pojo.Student;
import com.xxr.pojo.Teacher;
import com.xxr.service.StudentService;
import com.xxr.service.TeacherService;
import com.xxr.service.impl.StudentServiceImpl;
import com.xxr.service.impl.TeacherServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "InfoServlet", value = "/info/*")
public class InfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();

        String uri = request.getRequestURI();
        int index = uri.lastIndexOf('/');
        String methodName = uri.substring(index + 1);

        Map<String, Object> map = new HashMap<>(10);
        if("user".equalsIgnoreCase(methodName)){
            int userId = (int) session.getAttribute("currentUserId");
            StudentService ss = new StudentServiceImpl();
            Student student = ss.selectStuById(userId);

            map.put("name",student.getName());
            map.put("gender",student.getGender());
            map.put("email",student.getEmail());

        }else if("admin".equalsIgnoreCase(methodName)){
            int currentAdminId = (int) session.getAttribute("currentAdminId");
            TeacherService ts = new TeacherServiceImpl();
            Teacher teacher = ts.selectTeacherById(currentAdminId);

            map.put("name",teacher.getName());

        }else{
            map.put("errorInfo","路径出错啦！");
        }

        response.getWriter().write(JSON.toJSONString(map));
    }
}
