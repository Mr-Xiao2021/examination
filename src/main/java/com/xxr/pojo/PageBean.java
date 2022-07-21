package com.xxr.pojo;

import java.util.List;

/**封装总记录数和对应的题目若干行
 * @ClassName PageBean
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/7/19 16:16
 * @Version 1.0
 */
public class PageBean<T> {
    private int totalCount;
    private List<T> rows;

    public PageBean() {
    }

    public PageBean(int totalCount, List<T> rows) {
        this.totalCount = totalCount;
        this.rows = rows;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", rows=" + rows +
                '}';
    }
}
