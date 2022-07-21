package com.xxr.service.impl;

import com.xxr.mapper.MajorMapper;
import com.xxr.pojo.Major;
import com.xxr.service.MajorService;
import com.xxr.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @ClassName MajorServiceImpl
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/6/28 16:49
 * @Version 1.0
 */
public class MajorServiceImpl implements MajorService {
    private SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public Major selectMajorById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        MajorMapper majorMapper = sqlSession.getMapper(MajorMapper.class);
        Major major = majorMapper.selectMajorById(id);
        sqlSession.close();
        return major;
    }

    @Override
    public List<Major> selectAll() {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        MajorMapper majorMapper = sqlSession.getMapper(MajorMapper.class);
        List<Major> majors = majorMapper.selectAll();
        sqlSession.close();
        return majors;
    }

    @Override
    public String getNameById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        MajorMapper majorMapper = sqlSession.getMapper(MajorMapper.class);
        String name = majorMapper.getNameById(id);
        sqlSession.close();
        return name;
    }
}
