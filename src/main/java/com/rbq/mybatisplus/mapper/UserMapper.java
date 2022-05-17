package com.rbq.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rbq.mybatisplus.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author RenBoQing&HuHanYue
 * @date 2022年05月10日 9:49
 * @Description mybatis-plus的baseMapper
 */
@Repository
//将当前类或接口转为持久层
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /*
     *根据id查询
     * @author RenBoQing
     * @date 2022/5/12 0012 13:37
     * @param id
     * @return java.util.List<com.rbq.mybatisplus.entity.User>
     */
    List<User> queryUserByPage(Long id);
    /*
     *根据年龄查询用用户
     * @author RenBoQing
     * @date 2022/5/12 0012 13:40
     * @param page
     * @param age
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.rbq.mybatisplus.entity.User>
     */
    Page<User> selectPageVo(Page<User> page, Integer age);
}
