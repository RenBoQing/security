package com.rbq.mybatisplus.mapper;

import com.rbq.mybatisplus.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author RenBoQing
 * @date 2022年05月14日 16:23
 * @Description
 */
@Mapper
@Repository
public interface CourseMapper {
    Course queryCousrseById(int courseId);
}
