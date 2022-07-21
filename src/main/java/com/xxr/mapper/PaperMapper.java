package com.xxr.mapper;

import com.xxr.pojo.Paper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/7/18 17:44
 * @Version 1.0
 */
public interface PaperMapper {
    @Select("select * from papers;")
    @ResultMap("paperResultMapper")
    List<Paper> selectAll();

    @Select("select * from papers where user_id = #{id};")
    @ResultMap("paperResultMapper")
    List<Paper> selectByUser(int id);

    int getCurrentId();

    void addPaper(Paper paper);

    @Select("select * from papers where paper_id = #{id};")
    @ResultMap("paperResultMapper")
    Paper selectById(int id);

    @Select("select * from papers limit #{begin}, #{size};")
    @ResultMap("paperResultMapper")
    List<Paper> selectByPage(@Param("begin")int begin,@Param("size")int size);

    @Select("select count(*) from papers;")
    int selectTotalCount();


    @Delete("delete from papers where paper_id = #{id};")
    void deleteByPaperId(int id);

    @Update("update papers set score = #{newGrade} where paper_id = #{paperId};")
    void updateGrade(@Param("paperId") int paperId,@Param("newGrade") String newGrade);

    @Select("select * from papers where user_id = #{userId} limit #{begin}, #{size};")
    @ResultMap("paperResultMapper")
    List<Paper> selectByUserPage(@Param("begin")int begin,@Param("size")int size,@Param("userId")int studentId);

    @Select("select count(*) from papers where user_id = #{userId};")
    int selectUserTotalCount(int userId);


}
