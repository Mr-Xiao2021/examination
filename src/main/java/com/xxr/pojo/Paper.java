package com.xxr.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.xxr.service.StudentService;
import com.xxr.service.impl.StudentServiceImpl;

import java.util.Date;

/**
 * @ClassName Paper
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/7/18 17:28
 * @Version 1.0
 */
public class Paper {
    private Integer paperId;
    private String name;
    private Integer singleNum;
    private Integer mulNum;
    private Integer judgeNum;
    private Integer brieflyNum;
    private Integer userId;
    @JSONField(format = "yyyy-MM-dd HH:mm")
    private Date createDate;
    private String userName;
    private String score;

    public Paper() {
    }

    public Paper(Integer paperId, String name, Integer singleNum, Integer mulNum, Integer judgeNum, Integer brieflyNum, Integer userId, Date createDate,String score) {
        this.paperId = paperId;
        this.name = name;
        this.singleNum = singleNum;
        this.mulNum = mulNum;
        this.judgeNum = judgeNum;
        this.brieflyNum = brieflyNum;
        this.userId = userId;
        this.createDate = createDate;
        this.score = score;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSingleNum() {
        return singleNum;
    }

    public void setSingleNum(Integer singleNum) {
        this.singleNum = singleNum;
    }

    public Integer getMulNum() {
        return mulNum;
    }

    public void setMulNum(Integer mulNum) {
        this.mulNum = mulNum;
    }

    public Integer getJudgeNum() {
        return judgeNum;
    }

    public void setJudgeNum(Integer judgeNum) {
        this.judgeNum = judgeNum;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
        //从数据库中取出userName
        StudentService ss = new StudentServiceImpl();
        this.userName = ss.selectStuById(userId).getName();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getBrieflyNum() {
        return brieflyNum;
    }

    public void setBrieflyNum(Integer brieflyNum) {
        this.brieflyNum = brieflyNum;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "paperId=" + paperId +
                ", name='" + name + '\'' +
                ", singleNum=" + singleNum +
                ", mulNum=" + mulNum +
                ", judgeNum=" + judgeNum +
                ", brieflyNum=" + brieflyNum +
                ", userId=" + userId +
                ", createDate=" + createDate +
                ", userName='" + userName + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
