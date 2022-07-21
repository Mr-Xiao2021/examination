package com.xxr.web.servlet.question;

import com.alibaba.fastjson.JSON;
import com.xxr.pojo.Bank;
import com.xxr.pojo.PageBean;
import com.xxr.pojo.Question;
import com.xxr.service.QuestionService;
import com.xxr.service.impl.QuestionServiceImpl;
import com.xxr.utils.QuestionUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "QuestionServlet", value = "/question/*")
public class QuestionServlet extends HttpServlet {
    private final static String[] COMMANDS = new String[]{"list","add","delete","update"};
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionService qs = new QuestionServiceImpl();
        BufferedReader bf = request.getReader();
        String params = bf.readLine();

        response.setContentType("text/json;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        String uri = request.getRequestURI();
        int index = uri.lastIndexOf('/');
        String methodName = uri.substring(index + 1);

        Question question = new Question();

        if(!COMMANDS[0].equalsIgnoreCase(methodName)){
            question = QuestionUtils.getRequestStudent(request);
        }

        if(COMMANDS[0].equalsIgnoreCase(methodName)){
            //分页列举
            int pageSize = Integer.parseInt(request.getParameter("pageSize"));
            int currentPage = Integer.parseInt(request.getParameter("currentPage"));
            PageBean<Question> questionPageBean = qs.selectPaperByPage(currentPage, pageSize);
//            List<Question> allQuestion = qs.getAllQuestion();
            String js = JSON.toJSONString(questionPageBean);
            response.getWriter().write(js);
            return;
        }else if(COMMANDS[1].equalsIgnoreCase(methodName)){
            //增加
            qs.addQuestion(question);
        }else if(COMMANDS[2].equalsIgnoreCase(methodName)){
            //删除
            qs.deleteById(question);
        }else if(COMMANDS[3].equalsIgnoreCase(methodName)){
            //更新
            qs.updateQuestion(question);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("isSuccess",true);
        response.getWriter().write(JSON.toJSONString(map));
    }

}
