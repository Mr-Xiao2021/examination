package com.xxr.service;

import com.xxr.pojo.Bank;

import java.util.List;

/**
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/7/13 10:28
 * @Version 1.0
 */
public interface BankService {
    void updateBank(Bank bank);
    void insert(Bank bank);
    List<Bank> getAllName();
    int getCurrentId();
    void deleteByName(Bank bank);
    String getNameById(int id);
}
