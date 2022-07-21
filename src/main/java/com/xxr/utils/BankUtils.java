package com.xxr.utils;

import com.xxr.pojo.Bank;
import com.xxr.pojo.Student;
import jakarta.servlet.http.HttpServletRequest;

/**
 * @ClassName BankUtils
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/7/14 15:19
 * @Version 1.0
 */
public class BankUtils {
    public static Bank getRequestStudent(HttpServletRequest request){

        Bank bank = new Bank();
        String _bankId = request.getParameter("id");
        if(_bankId!=null&&_bankId.length()>0){
            bank.setId(Integer.parseInt(_bankId));
        }
        String name = request.getParameter("name");
        String remark = request.getParameter("remark");

        bank.setName(name);
        bank.setRemark(remark);
        return bank;

    }
}
