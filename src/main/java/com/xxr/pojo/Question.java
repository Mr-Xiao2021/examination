package com.xxr.pojo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @ClassName Question
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/7/14 11:04
 * @Version 1.0
 */
public class Question {
    private static final String[] TYPE_NAMES = new String[]{"单选题","多选题","对错题","简答题"};
    private int id;
    private String content;
    private int type;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private int answerId;
    private int bankId;
    private int majorId;
    private String remark;
    private String majorName;
    private String bankName;
    private String typeName;


    public Question() {
    }

    public Question(int id, String content, int type, String optionA, String optionB, String optionC, String optionD, int answerId, int bankId, int majorId, String remark, String majorName, String bankName) {
        this.id = id;
        this.content = content;
        this.type = type;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.answerId = answerId;
        this.bankId = bankId;
        this.majorId = majorId;
        this.remark = remark;
        this.majorName = majorName;
        this.bankName = bankName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
        typeName = TYPE_NAMES[type];
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", type=" + type +
                ", optionA='" + optionA + '\'' +
                ", optionB='" + optionB + '\'' +
                ", optionC='" + optionC + '\'' +
                ", optionD='" + optionD + '\'' +
                ", answerId=" + answerId +
                ", bankId=" + bankId +
                ", majorId=" + majorId +
                ", remark='" + remark + '\'' +
                ", majorName='" + majorName + '\'' +
                ", bankName='" + bankName + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
