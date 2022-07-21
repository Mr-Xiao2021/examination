package com.xxr.service.impl;

import com.xxr.mapper.TeachersMapper;
import com.xxr.pojo.Teacher;
import com.xxr.service.TeacherService;
import com.xxr.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @ClassName TeacherServiceImpl
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/6/28 16:48
 * @Version 1.0
 */
public class TeacherServiceImpl implements TeacherService {
    private SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public Teacher selectTeacherById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TeachersMapper teachersMapper = sqlSession.getMapper(TeachersMapper.class);
        Teacher teacher = teachersMapper.selectTeacherById(id);

        sqlSession.close();
        return teacher;
    }

    @Override
    public List<Teacher> selectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TeachersMapper teachersMapper = sqlSession.getMapper(TeachersMapper.class);
        List<Teacher> teachers = teachersMapper.selectAll();
        sqlSession.close();
        return teachers;
    }

    @Override
    public Teacher login(Teacher teacher) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TeachersMapper teachersMapper = sqlSession.getMapper(TeachersMapper.class);
        Teacher loginTeacher = teachersMapper.login(teacher);
        sqlSession.close();
        return loginTeacher;
    }

    @Override
    public void update(Teacher teacher) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        TeachersMapper teachersMapper = sqlSession.getMapper(TeachersMapper.class);
        teachersMapper.update(teacher);
        sqlSession.close();
    }
}
