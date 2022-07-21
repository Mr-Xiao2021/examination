package com.xxr.service.impl;

import com.xxr.mapper.QuestionMapper;
import com.xxr.pojo.PageBean;
import com.xxr.pojo.Paper;
import com.xxr.pojo.Question;
import com.xxr.service.BankService;
import com.xxr.service.MajorService;
import com.xxr.service.QuestionService;
import com.xxr.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName QuestionServiceImpl
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/7/14 11:50
 * @Version 1.0
 */
public class QuestionServiceImpl implements QuestionService {
    private SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public List<Question> getAllQuestion() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        QuestionMapper questionMapper = sqlSession.getMapper(QuestionMapper.class);
        List<Question> allQuestion = questionMapper.getAllQuestion();
        MajorService ms = new MajorServiceImpl();
        BankService bs = new BankServiceImpl();
        for (Question question : allQuestion) {
            question.setBankName(bs.getNameById(question.getBankId()));
            question.setMajorName(ms.getNameById(question.getMajorId()));
        }
        sqlSession.close();
        return allQuestion;
    }

    @Override
    public void addQuestion(Question question) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        QuestionMapper questionMapper = sqlSession.getMapper(QuestionMapper.class);
        question.setId(getCurrentId()+1);
        questionMapper.addQuestion(question);
        sqlSession.close();
    }

    @Override
    public int getCurrentId() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        QuestionMapper questionMapper = sqlSession.getMapper(QuestionMapper.class);
        int currentId = questionMapper.getCurrentId();
        sqlSession.close();
        return currentId;
    }

    @Override
    public void deleteById(Question question) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        QuestionMapper questionMapper = sqlSession.getMapper(QuestionMapper.class);
        questionMapper.deleteById(question);
        sqlSession.close();
    }

    @Override
    public void updateQuestion(Question question) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        QuestionMapper questionMapper = sqlSession.getMapper(QuestionMapper.class);
        questionMapper.updateQuestion(question);
        sqlSession.close();
    }

    /** 据指定类型和指定数量随机抽取题库中的题目
     * @description:
     * @param: type nums
     * @return: java.util.List<com.xxr.pojo.Question>
     * @author
     * @date: 22:40 2022/7/18
     */
    @Override
    public List<Question> getTargetAll(int type, int[] majors) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        QuestionMapper questionMapper = sqlSession.getMapper(QuestionMapper.class);
        List<Question> targetAll = questionMapper.getTargetAll(type, majors);
        sqlSession.close();
        return targetAll;
    }

    @Override
    public Question getQuestionById(int questionId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        QuestionMapper questionMapper = sqlSession.getMapper(QuestionMapper.class);
        Question question = questionMapper.getQuestionById(questionId);
        sqlSession.close();
        return question;
    }

    @Override
    public List<Question> getQuestionsByIds(List<Integer> ids) {
        List<Question> questions = new ArrayList<>();
        for (Integer id : ids) {
            questions.add(getQuestionById(id));
        }
        return questions;
    }

    @Override
    public List<Question> selectByPage(int begin, int size) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        QuestionMapper questionMapper = sqlSession.getMapper(QuestionMapper.class);
        List<Question> questions = questionMapper.selectByPage(begin, size);
        sqlSession.close();
        return questions;
    }

    @Override
    public PageBean<Question> selectPaperByPage(int currentPage, int pageSize) {
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        List<Question> questions = selectByPage(begin, size);
        MajorService ms = new MajorServiceImpl();
        BankService bs = new BankServiceImpl();
        for (Question question : questions) {
            question.setBankName(bs.getNameById(question.getBankId()));
            question.setMajorName(ms.getNameById(question.getMajorId()));
        }
        return new PageBean<Question>(selectTotalCount(),questions);
    }

    @Override
    public int selectTotalCount() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        QuestionMapper questionMapper = sqlSession.getMapper(QuestionMapper.class);
        int count = questionMapper.selectTotalCount();
        sqlSession.close();
        return count;
    }


}
