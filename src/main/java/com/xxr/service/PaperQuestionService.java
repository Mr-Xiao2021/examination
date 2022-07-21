package com.xxr.service;

import com.xxr.pojo.PaperQuestion;

import java.util.List;

/**
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/7/19 8:43
 * @Version 1.0
 */
public interface PaperQuestionService {
    /**
     * @description: 添加考试信息及对应的具体题目编号
     * @param: pq
     * @return: void
     * @author
     * @date: 8:26 2022/7/19
     */
    void addPaperQuestion(PaperQuestion pq);


    /**
     * 根据PaperId来获得QuestionId的集合，再据此去QuestionService查出单个题目组成的集合
     * @param paperId
     * @return
     */
    List<Integer> selectQuestionIdByPaperId(int paperId);


    /**
     * @description: 批量插入考试信息及对应的具体题目编号
     * @param: pqs
     * @return: void
     * @author
     * @date: 8:49 2022/7/19
     */
    void batchAddPaperQuestion(List<PaperQuestion> pqs);
}
