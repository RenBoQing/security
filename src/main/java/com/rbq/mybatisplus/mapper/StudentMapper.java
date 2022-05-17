package com.rbq.mybatisplus.mapper;

import com.rbq.mybatisplus.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年05月14日 14:44
 * @Description 学生实体类的集合
 */
@Mapper
@Repository
public interface StudentMapper {
    Student queryStudentById(String sid);

    //根据课程的id来查询学生
    List<Student> queryStudentByCourseId(int courseId);
}
