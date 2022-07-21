package com.xxr.pojo;

/**
 * @ClassName Student
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/6/27 21:54
 * @Version 1.0
 */
public class Student {
    private Integer studentId;
    private String name;
    private String password;
    private String email;
    private Integer teacherId;
    private Integer majorId;
    private String gender;

    public Student() {
    }


    public Student(Integer studentId, String name, String password, String email, Integer teacherId, Integer majorId, String gender) {
        this.studentId = studentId;
        this.name = name;
        this.password = password;
        this.email = email;
        this.teacherId = teacherId;
        this.majorId = majorId;
        this.gender = gender;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", teacherId=" + teacherId +
                ", majorId=" + majorId +
                '}';
    }

}
