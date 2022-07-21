package com.xxr.utils;

import com.xxr.pojo.Question;
import jakarta.servlet.http.HttpServletRequest;

/**
 * @ClassName QuestionUtils
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/7/14 15:27
 * @Version 1.0
 */
public class QuestionUtils {
    public static Question getRequestStudent(HttpServletRequest request){
        Question question = new Question();

        String content = request.getParameter("content");
        String optionA = request.getParameter("optionA");
        String optionB = request.getParameter("optionB");
        String optionC = request.getParameter("optionC");
        String optionD = request.getParameter("optionD");

        String remark = request.getParameter("remark");

        String _id = request.getParameter("id");
        String _bankId = request.getParameter("bankId");
        String _answerId = request.getParameter("answerId");
        String _majorId = request.getParameter("majorId");
        String _type = request.getParameter("type");

        if(_id!=null&&_id.length()>0){

            question.setId(Integer.parseInt(_id));
        }
        if(_bankId!=null&&_bankId.length()>0){

            question.setBankId(Integer.parseInt(_bankId));
        }
        if(_answerId!=null&&_answerId.length()>0){

            question.setAnswerId(Integer.parseInt(_answerId));
        }
        if(_majorId!=null&&_majorId.length()>0){

            question.setMajorId(Integer.parseInt(_majorId));
        }
        if(_type!=null&&_type.length()>0){

            question.setType(Integer.parseInt(_type));
        }

        question.setContent(content);
        question.setOptionA(optionA);
        question.setOptionB(optionB);
        question.setOptionC(optionC);
        question.setOptionD(optionD);
        question.setRemark(remark);

        return question;

    }
}
