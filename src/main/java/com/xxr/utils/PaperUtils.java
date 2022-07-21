package com.xxr.utils;

import com.xxr.pojo.Bank;
import com.xxr.pojo.Paper;
import jakarta.servlet.http.HttpServletRequest;

/**
 * @ClassName PaperUtils
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/7/18 21:57
 * @Version 1.0
 */
public class PaperUtils {
    public static Paper getRequestPaper(HttpServletRequest request){

        Paper paper = new Paper();
        String _paperId = request.getParameter("paperId");
        if(_paperId!=null&&_paperId.length()>0){
            paper.setPaperId(Integer.parseInt(_paperId));
        }

        String _judgeNum = request.getParameter("judgeNum");
        if(_judgeNum!=null&&_judgeNum.length()>0){
            paper.setJudgeNum(Integer.parseInt(_judgeNum));
        }
        String _mulNum = request.getParameter("mulNum");
        if(_mulNum!=null&&_mulNum.length()>0){
            paper.setMulNum(Integer.parseInt(_mulNum));
        }
        String _singleNum = request.getParameter("singleNum");
        if(_singleNum!=null&&_singleNum.length()>0){
            paper.setSingleNum(Integer.parseInt(_singleNum));
        }
        String _userId = request.getParameter("userId");
        if(_userId!=null&&_userId.length()>0){
            paper.setUserId(Integer.parseInt(_userId));
        }

        String name = request.getParameter("name");
        paper.setName(name);
        System.out.println(paper);
        return paper;
    }
}
