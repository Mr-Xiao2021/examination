package com.xxr.service.impl;

import com.xxr.mapper.StudentMapper;
import com.xxr.pojo.Student;
import com.xxr.service.StudentService;
import com.xxr.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;
import java.util.Map;

/**
 * @ClassName StudentServiceImpl
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/6/28 13:02
 * @Version 1.0
 */
public class StudentServiceImpl implements StudentService {
    private SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public List<Student> selectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = studentMapper.selectAll();
        sqlSession.close();
        return students;
    }

    @Override
    public Student selectStuById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = studentMapper.selectByStuId(id);
        sqlSession.close();
        return student;
    }

    @Override
    public void addStudent(Student student) {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        student.setStudentId(getCurrentId()+1);
        if(student.getPassword() == null || student.getPassword().length() == 0){
            student.setPassword("123456");
        }
        System.out.println(student);
        studentMapper.addStudent(student);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public Student login(Student student) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student loginStu = studentMapper.login(student);
        sqlSession.close();
        return loginStu;
    }

    @Override
    public List<Student> selectByCondition(Student student) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = studentMapper.selectByCondition(student);
        sqlSession.close();
        return students;
    }


    @Override
    public int selectStuCountByCondition(Student student) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        int stuCount = studentMapper.getStuCountByCondition(student);
        sqlSession.close();
        return stuCount;
    }

    @Override
    public Map<String, Object> getByStudentIdToMap(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Map<String, Object> map = studentMapper.getByStudentIdToMap(id);
        sqlSession.close();
        return map;
    }

    @Override
    public List<Map<String, Object>> getStuByCdtToList(Student student) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Map<String, Object>> mapList = studentMapper.getStuByCdtToList(student);
        sqlSession.close();
        return mapList;
    }

    @Override
    public boolean updateStudent(Student student) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
//        try {
//            studentMapper.updateStudent(student);
//        } catch (Exception e) {
//            return false;
//        }finally {
//            sqlSession.close();
//        }
        studentMapper.updateStudent(student);
        sqlSession.close();
        return true;
    }

    @Override
    public boolean deleteByStudentId(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        try {
            studentMapper.deleteByStudentId(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public int getCurrentId() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        int currentId = studentMapper.getCurrentId();
        sqlSession.close();
        return currentId;
    }


}
