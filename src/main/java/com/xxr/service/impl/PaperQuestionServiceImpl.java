package com.xxr.service.impl;

import com.xxr.mapper.PaperQuestionMapper;
import com.xxr.pojo.PaperQuestion;
import com.xxr.service.PaperQuestionService;
import com.xxr.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @ClassName PaperQuestionServiceImpl
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/7/19 8:44
 * @Version 1.0
 */
public class PaperQuestionServiceImpl implements PaperQuestionService {
    private SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public void addPaperQuestion(PaperQuestion pq) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        PaperQuestionMapper paperQuestionMapper = sqlSession.getMapper(PaperQuestionMapper.class);
        paperQuestionMapper.addPaperQuestion(pq);
        sqlSession.close();
    }

    @Override
    public List<Integer> selectQuestionIdByPaperId(int paperId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PaperQuestionMapper paperQuestionMapper = sqlSession.getMapper(PaperQuestionMapper.class);
        List<Integer> questionIds = paperQuestionMapper.selectQuestionIdByPaperId(paperId);
        sqlSession.close();
        return questionIds;
    }

    @Override
    public void batchAddPaperQuestion(List<PaperQuestion> pqs) {
        for (PaperQuestion paperQuestion : pqs) {
            addPaperQuestion(paperQuestion);
        }
    }
}
