package com.xxr.web.servlet.paper;

import com.alibaba.fastjson.JSON;
import com.xxr.pojo.PageBean;
import com.xxr.pojo.Paper;
import com.xxr.service.PaperService;
import com.xxr.service.impl.PaperServiceImpl;
import com.xxr.utils.PaperQuestionUtils;
import com.xxr.utils.PaperUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.*;

@WebServlet(name = "PaperServlet", value = "/paper/*")
public class PaperServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        String uri = request.getRequestURI();
        int index = uri.lastIndexOf('/');
        String methodName = uri.substring(index + 1);

        String responseJson;


        if("add".equalsIgnoreCase(methodName)){
            String _majorId = request.getParameter("majorId");
            //1,2,3
            List<Integer> majorIdList = new ArrayList<>();
            String[] split = _majorId.split(",");
            for (String s : split) {
                majorIdList.add(Integer.parseInt(s));
            }
            int[] majors = new int[majorIdList.size()];
            for (int i = 0; i < majorIdList.size(); i++) {
                majors[i] = majorIdList.get(i);
            }
            PaperService ps = new PaperServiceImpl();
            int brieflyNum = Integer.parseInt(request.getParameter("brieflyNum"));
            Paper paper = PaperUtils.getRequestPaper(request);
            paper.setBrieflyNum(brieflyNum);
            int currenId = ps.addPaper(paper);
            responseJson = PaperQuestionUtils.generatePaperQuestionsJSON(true,brieflyNum, paper, majors);
        }else if("search".equalsIgnoreCase(methodName)){
            responseJson = PaperQuestionUtils.getPaperJsonByPaperId(Integer.parseInt(request.getParameter("paperId")),false);
        }else if("curPagePaper".equalsIgnoreCase(methodName)){
            //当前页面的所有paper信息
            PaperService ps = new PaperServiceImpl();
            int pageSize = Integer.parseInt(request.getParameter("pageSize"));
            int currentPage = Integer.parseInt(request.getParameter("currentPage"));
            Object currentUserId = request.getSession().getAttribute("currentUserId");
            System.out.println(currentUserId);
            PageBean<Paper> paperPageBean;
            if(currentUserId!=null){
                //用户查看
                int userId = (int) currentUserId;
                paperPageBean = ps.selectUserPaperByPage(currentPage,pageSize,userId);
            }else{
                paperPageBean = ps.selectPaperByPage(currentPage, pageSize);
            }

            responseJson = JSON.toJSONString(paperPageBean);
        }else if("curUserPaper".equalsIgnoreCase(methodName)){
            //当前用户的所有paper信息
            PaperService ps = new PaperServiceImpl();
            int userId = Integer.parseInt(request.getParameter("userId"));
            List<Paper> papers = ps.selectById(userId);
            responseJson = JSON.toJSONString(papers);
        }else if("delete".equalsIgnoreCase(methodName)){
            PaperService ps = new PaperServiceImpl();
            int paperId = Integer.parseInt(request.getParameter("paperId"));
            ps.deleteByPaperId(paperId);
            responseJson = "delete successly !";
        }else if("assign".equalsIgnoreCase(methodName)){
            PaperService ps = new PaperServiceImpl();
            int paperId = Integer.parseInt(request.getParameter("paperId"));
            String grade = request.getParameter("score");
            ps.updateGrade(paperId,grade);
            responseJson = "assign grade successly !";
        }else{
            Map<String, Object> map = new HashMap<>(5);
            map.put("errorInfo","路径不正确~");
            responseJson = JSON.toJSONString(map);
        }
        response.getWriter().write(responseJson);
    }
}

//星际穿越
