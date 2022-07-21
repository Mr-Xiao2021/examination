package com.xxr.service.impl;

import com.xxr.mapper.PaperMapper;
import com.xxr.pojo.PageBean;
import com.xxr.pojo.Paper;
import com.xxr.pojo.Question;
import com.xxr.service.PaperService;
import com.xxr.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Date;
import java.util.List;

/**
 * @ClassName PaperServiceImpl
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/7/18 17:47
 * @Version 1.0
 */
public class PaperServiceImpl implements PaperService {
    private SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public List<Paper> selectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PaperMapper pm = sqlSession.getMapper(PaperMapper.class);
        List<Paper> papers = pm.selectAll();
        sqlSession.close();
        return papers;
    }


    /**
     * @description: 根据用户id查询考试信息
     * @param: id
     * @return: java.util.List<com.xxr.pojo.Paper>
     * @author
     * @date: 23:24 2022/7/18
     */

    @Override
    public List<Paper> selectById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PaperMapper pm = sqlSession.getMapper(PaperMapper.class);
        List<Paper> papers = pm.selectByUser(id);
        sqlSession.close();
        return papers;
    }

    @Override
    public int getCurrentId() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PaperMapper pm = sqlSession.getMapper(PaperMapper.class);
        int currentId = pm.getCurrentId();
        sqlSession.close();
        return currentId;
    }

    @Override
    public int addPaper(Paper paper) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        PaperMapper pm = sqlSession.getMapper(PaperMapper.class);
        paper.setPaperId(getCurrentId()+1);
        paper.setCreateDate(new Date());
        pm.addPaper(paper);
        int currentId = pm.getCurrentId();
        sqlSession.close();

        return currentId;
    }

    /**
     * @description: 根据paper_id查询信息
     * @param: id
     * @return: com.xxr.pojo.Paper
     * @author
     * @date: 23:24 2022/7/18
     */


    @Override
    public Paper selectByPaperId(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PaperMapper pm = sqlSession.getMapper(PaperMapper.class);
        Paper paper = pm.selectById(id);
        sqlSession.close();
        return paper;
    }

    @Override
    public List<Paper> selectByPage(int begin, int size) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PaperMapper pm = sqlSession.getMapper(PaperMapper.class);
        List<Paper> papers = pm.selectByPage(begin, size);
        sqlSession.close();
        return papers;
    }

    @Override
    public int selectTotalCount() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PaperMapper pm = sqlSession.getMapper(PaperMapper.class);
        int count = pm.selectTotalCount();
        sqlSession.close();
        return count;
    }

    @Override
    public void deleteByPaperId(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        PaperMapper pm = sqlSession.getMapper(PaperMapper.class);
        pm.deleteByPaperId(id);
        sqlSession.close();
    }

    @Override
    public void updateGrade(int paperId, String newGrade) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        PaperMapper pm = sqlSession.getMapper(PaperMapper.class);
        pm.updateGrade(paperId,newGrade);
        sqlSession.close();
    }

    @Override
    public int selectUserTotalCount(int studentId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PaperMapper pm = sqlSession.getMapper(PaperMapper.class);
        int userTotalCount = pm.selectUserTotalCount(studentId);
        sqlSession.close();
        return userTotalCount;
    }

    @Override
    public List<Paper> selectByUserPage(int begin, int size, int studentId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PaperMapper pm = sqlSession.getMapper(PaperMapper.class);
        List<Paper> papers = pm.selectByUserPage(begin, size, studentId);
        sqlSession.close();
        return papers;
    }

    @Override
    public PageBean<Paper> selectUserPaperByPage(int currentPage, int pageSize, int studentId) {
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        return new PageBean<Paper>(selectUserTotalCount(studentId),selectByUserPage(begin,size,studentId));
    }


    @Override
    public PageBean<Paper> selectPaperByPage(int currentPage, int pageSize) {

        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        return new PageBean<Paper>(selectTotalCount(), selectByPage(begin, size));
    }



}
