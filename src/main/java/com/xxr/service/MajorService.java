package com.xxr.service;

import com.xxr.pojo.Major;

import java.util.List;

/**
 * @Description TODO
 * @Author Mr_X
 * @Date 2022/6/28 16:48
 * @Version 1.0
 */
public interface MajorService {
    Major selectMajorById(int id);

    List<Major> selectAll();

    String getNameById(int id);
}
