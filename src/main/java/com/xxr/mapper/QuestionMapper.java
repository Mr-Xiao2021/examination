package com.xxr.mapper;

import com.xxr.pojo.Paper;
import com.xxr.pojo.Question;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/7/14 11:08
 * @Version 1.0
 */
public interface QuestionMapper {
    @Select("select * from questions;")
    @ResultMap("questionResultMapper")
    List<Question> getAllQuestion();

    @Insert("insert into questions (question_id, content, type, optionA, optionB, optionC, optionD, answer_id, bank_id, major_id, remark) " +
            "values (#{id},#{content},#{type},#{optionA},#{optionB},#{optionC},#{optionD},#{answerId},#{bankId},#{majorId},#{remark});")
    @ResultMap("questionResultMapper")
    void addQuestion(Question question);

    int getCurrentId();

    @Delete("delete from questions where question_id = #{id};")
    void deleteById(Question question);

    void updateQuestion(Question question);

    @Select("SELECT * FROM `questions`\n" +
            "WHERE question_id >= (SELECT floor( RAND() * ((SELECT MAX(question_id) FROM `questions`)-(SELECT MIN(question_id) FROM `questions`)) + (SELECT MIN(question_id) FROM `questions`)))\n" +
            "AND type = #{type}\n" +
            "ORDER BY question_id LIMIT #{nums};")
    @ResultMap("questionResultMapper")
    List<Question> selectTargetQuestion(@Param("type")int type,@Param("nums")int nums);

    List<Question> getTargetAll(@Param("type")int type,@Param("majors")int[] majors);

    /** 
     * @description: 根据question_id查找指定题目
     * @param: paperId
     * @return: com.xxr.pojo.Question
     * @author
     * @date: 8:28 2022/7/19
     */
    @Select("select * from questions where question_id = #{questionId};")
    @ResultMap("questionResultMapper")
    Question getQuestionById(int questionId);


    @Select("select * from questions limit #{begin}, #{size};")
    @ResultMap("questionResultMapper")
    List<Question> selectByPage(@Param("begin")int begin, @Param("size")int size);

    @Select("select count(*) from questions;")
    int selectTotalCount();
}
