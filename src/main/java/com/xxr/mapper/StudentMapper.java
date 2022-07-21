package com.xxr.mapper;

import com.xxr.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/6/27 21:56
 * @Version 1.0
 */
public interface StudentMapper {

    /**
     * @description: 查询所有学生信息
     * @param:
     * @return: java.util.List<com.xxr.pojo.Student>
     * @author
     * @date: 13:24 2022/6/28
     */

    @Select("select * from Examination.users")
    @ResultMap("studentResultMapper")
    List<Student> selectAll();
    /**
     * @description: 根据条件查询学生列表信息
     * @param: student
     * @return: java.util.List<com.xxr.pojo.Student>
     * @author
     * @date: 17:25 2022/6/29
     */
    List<Student> selectByCondition(Student student);



    /**
     * @description: 根据学号查找学生
     * @param: id
     * @return: com.xxr.pojo.Student
     * @author
     * @date: 13:39 2022/6/28
     */

    @Select("select * from Examination.users where id = #{id}")
    @ResultMap("studentResultMapper")
    Student selectByStuId(int id);

    /**根据传入的map添加学生数据
     * @description:
     * @param: map
     * @return: void
     * @author
     * @date: 13:46 2022/6/28
     */
    void addStudent(Student student);


    /** 根据传入的用户名和密码进行用户登录，若错误则返回空对象
     * @description:
     * @param: student
     * @return: com.xxr.pojo.Student
     * @author
     * @date: 15:12 2022/6/28
     */

    @Select("select * from Examination.users where id = #{studentId} and password = #{password};")
    @ResultMap("studentResultMapper")
    Student login(Student student);

    /**
     * @description: 条件查询对应学生的数量
     * @param: student
     * @return: int
     * @author
     * @date: 20:50 2022/7/1
     */

    int getStuCountByCondition(Student student);


    void updateStudent(Student student);

    @Delete("delete from users where id = #{id};")
    @ResultMap("studentResultMapper")
    void deleteByStudentId(int id);
    /**
     * @description: 根据主键查询学生并返回封装好的map对象
     * @param: id
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @author
     * @date: 21:06 2022/7/1
     */

    Map<String,Object> getByStudentIdToMap(int id);

    int getCurrentId();

    List<Map<String,Object>> getStuByCdtToList(Student student);
}
