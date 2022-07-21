package com.xxr.pojo;

/**
 * @ClassName Major
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/6/28 16:40
 * @Version 1.0
 */
public class Major {
    private Integer majorId;
    private String name;

    public Major() {
    }

    public Major(Integer majorId, String name) {
        this.majorId = majorId;
        this.name = name;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Major{" +
                "majorId=" + majorId +
                ", name='" + name + '\'' +
                '}';
    }
}
