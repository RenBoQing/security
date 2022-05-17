package com.rbq.mybatisplus.mapper;

import com.rbq.mybatisplus.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class StudentMapperTest {
    @Autowired
    private StudentMapper studentMapper;
    /*
     *根据学生的id查询学生的信息
     * @author RenBoQing
     * @date  14:58
     */
    @Test
    void queryStudentById() {
        Student student = studentMapper.queryStudentById("1001");
        System.out.println(student);
    }
}