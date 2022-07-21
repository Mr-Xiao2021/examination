package com.xxr.mapper;

import com.xxr.pojo.PaperQuestion;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/7/19 8:20
 * @Version 1.0
 */
public interface PaperQuestionMapper {

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
    @Select("select question_id from PaperQuestion where paper_id  =#{paperId};")
    List<Integer> selectQuestionIdByPaperId(int paperId);

}
