package com.rbq.mybatisplus.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年05月14日 16:01
 * @Description  课程实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Course {
    private int courseId;
    private String courseName;
    //查询课程的时候 查询这个课程下的所有学生
    private List<Student> students;
}
