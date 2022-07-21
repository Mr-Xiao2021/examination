package com.xxr.mapper;

import com.xxr.pojo.Major;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/6/28 16:46
 * @Version 1.0
 */
public interface MajorMapper {
    @Select("select * from Examination.majors where major_id = #{id};")
    @ResultMap("majorResultMapper")
    Major selectMajorById(int id);

    @Select("select * from Examination.majors;")
    @ResultMap("majorResultMapper")
    List<Major> selectAll();


    String getNameById(int id);
}
