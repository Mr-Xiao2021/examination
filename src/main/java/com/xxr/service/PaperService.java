package com.xxr.service;

import com.xxr.pojo.PageBean;
import com.xxr.pojo.Paper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/7/18 17:47
 * @Version 1.0
 */
public interface PaperService {
    List<Paper> selectAll();
    List<Paper> selectById(int id);
    int getCurrentId();

    int addPaper(Paper paper);

    Paper selectByPaperId(int id);

    List<Paper> selectByPage(int begin,int size);

    PageBean<Paper> selectPaperByPage(int currentPage, int pageSize);

    int selectTotalCount();

    void deleteByPaperId(int id);

    void updateGrade(int paperId, String newGrade);

    int selectUserTotalCount(int studentId);

    List<Paper> selectByUserPage(int begin, int size, int studentId);

    PageBean<Paper> selectUserPaperByPage(int currentPage, int pageSize,int studentId);

}
