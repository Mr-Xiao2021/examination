package com.xxr.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @ClassName Bank
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/7/12 23:25
 * @Version 1.0
 */
public class Bank {
    private int id;
    private String name;
    private String remark;
    @JSONField(format = "yyyy-MM-dd HH:mm")
    private Date createTime;

    public Bank() {
    }

    public Bank(int id, String name, String remark, Date createTime) {
        this.id = id;
        this.name = name;
        this.remark = remark;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
