package com.xxr.mapper;

import com.xxr.pojo.Bank;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/7/12 23:27
 * @Version 1.0
 */
public interface BankMapper {
    void updateBank(Bank bank);

    @Insert("insert into banks (bank_id, name, remark, createtime) values (#{id},#{name},#{remark},#{createTime});")
    @ResultMap("bankResultMap")
    void insert(Bank bank);

    @Select("select * from banks;")
    @ResultMap("bankResultMap")
    List<Bank> getAllInfo();


    int getCurrentId();


    void deleteByName(Bank bank);


    String getNameById(int id);
}
