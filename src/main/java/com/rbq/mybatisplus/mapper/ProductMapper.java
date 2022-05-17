package com.rbq.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rbq.mybatisplus.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
/**
 * @author RenBoQing
 * @date 2022年05月12日 14:32
 * @Description
 */
@Mapper
@Repository
public interface ProductMapper extends BaseMapper<Product> {

}
