package com.xxr.web.servlet.bank;

import com.alibaba.fastjson.JSON;
import com.xxr.pojo.Bank;
import com.xxr.service.BankService;
import com.xxr.service.impl.BankServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetAllBankNameServlet", value = "/getAllBankNameServlet")
public class GetAllBankNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        BankService bs = new BankServiceImpl();
        List<Bank> allName = bs.getAllName();
        String jsonString = JSON.toJSONString(allName);
        response.getWriter().write(jsonString);
    }
}
