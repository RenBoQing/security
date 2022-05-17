package com.rbq.mybatisplus.mapper;

import com.rbq.mybatisplus.entity.Clazz;
import com.rbq.mybatisplus.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author RenBoQing
 * @date 2022年05月14日 14:43
 * @Description 班级的Mapper接口
 */
@Mapper
@Repository
public interface ClazzMapper {
   Clazz  queryClazzById(Integer classId);
}
