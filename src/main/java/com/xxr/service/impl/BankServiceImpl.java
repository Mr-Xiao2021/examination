package com.xxr.service.impl;

import com.xxr.mapper.BankMapper;
import com.xxr.pojo.Bank;
import com.xxr.service.BankService;
import com.xxr.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @ClassName BankServiceImpl
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/7/13 10:29
 * @Version 1.0
 */
public class BankServiceImpl implements BankService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public void updateBank(Bank bank) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BankMapper bankMapper = sqlSession.getMapper(BankMapper.class);
        bankMapper.updateBank(bank);
        sqlSession.close();
    }

    @Override
    public void insert(Bank bank) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BankMapper bankMapper = sqlSession.getMapper(BankMapper.class);
        //确保无论如何都可以使得插入成功
        bank.setId(getCurrentId()+1);
        bankMapper.insert(bank);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public List<Bank> getAllName() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BankMapper bankMapper = sqlSession.getMapper(BankMapper.class);
        List<Bank> allInfo = bankMapper.getAllInfo();
        sqlSession.close();
        return allInfo;
    }

    @Override
    public int getCurrentId() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BankMapper bankMapper = sqlSession.getMapper(BankMapper.class);
        int currentId = bankMapper.getCurrentId();
        sqlSession.close();
        return currentId;
    }

    @Override
    public void deleteByName(Bank bank) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BankMapper bankMapper = sqlSession.getMapper(BankMapper.class);
        bankMapper.deleteByName(bank);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public String getNameById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BankMapper bankMapper = sqlSession.getMapper(BankMapper.class);
        String name = bankMapper.getNameById(id);
        sqlSession.close();
        return name;
    }
}
