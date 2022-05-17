package com.rbq.mybatisplus.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年05月14日 14:16
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String stuId;
    private String stuName;
    private int stuAge;
    //使用多对一的情况下 要在单个的情况下
    private Clazz clazz;
    ////关联课程 一个学生可以对应多个课程 学生选择的课程
    //private List<Course> courses;
}
