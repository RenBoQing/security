package com.rbq.mybatisplus.mapper;

import com.rbq.mybatisplus.entity.Course;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class CourseMapperTest {
    @Autowired
    private CourseMapper courseMapper;
    /*
     *当前课程有哪些学生选
     * @author RenBoQing
     * @date 2022/5/14 0014 16:46
     */
    @Test
    void queryCousrseById() {
        Course course = courseMapper.queryCousrseById(1);
        System.out.println(course);
    }
}