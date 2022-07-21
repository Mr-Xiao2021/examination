package com.xxr.service;

import com.xxr.pojo.PageBean;
import com.xxr.pojo.Question;

import java.util.List;

/**
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/7/14 11:49
 * @Version 1.0
 */
public interface QuestionService {
    List<Question> getAllQuestion();
    void addQuestion(Question question);
    int getCurrentId();
    void deleteById(Question question);
    void updateQuestion(Question question);
    List<Question> getTargetAll(int type, int[] majors);
    Question getQuestionById(int questionId);
    List<Question> getQuestionsByIds(List<Integer> ids);


    List<Question> selectByPage(int begin, int size);

    PageBean<Question> selectPaperByPage(int currentPage, int pageSize);

    int selectTotalCount();

}
