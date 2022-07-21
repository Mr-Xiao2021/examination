package com.xxr.pojo;

/**
 * @ClassName Teacher
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/6/28 16:38
 * @Version 1.0
 */
public class Teacher {
    private Integer teacherId;
    private String name;
    private String password;

    public Teacher() {
    }

    public Teacher(Integer teacherId, String name, String password) {
        this.teacherId = teacherId;
        this.name = name;
        this.password = password;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "teacherId=" + teacherId +
                ", name='" + name + '\'' +
                '}';
    }
}
