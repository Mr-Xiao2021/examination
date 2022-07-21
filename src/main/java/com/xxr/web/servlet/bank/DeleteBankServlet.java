package com.xxr.web.servlet.bank;

import com.alibaba.fastjson.JSON;
import com.xxr.pojo.Bank;
import com.xxr.service.BankService;
import com.xxr.service.impl.BankServiceImpl;
import com.xxr.utils.BankUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "DeleteBankServlet", value = "/deleteBankServlet")
public class DeleteBankServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader bf = request.getReader();
        String params = bf.readLine();
        Bank bank = BankUtils.getRequestStudent(request);
        response.setContentType("text/json;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        BankService bs = new BankServiceImpl();
        bs.deleteByName(bank);
        Map<String, Object> map = new HashMap<>(10);
        map.put("isSuccess",true);
        response.getWriter().write(JSON.toJSONString(map));
    }
}
