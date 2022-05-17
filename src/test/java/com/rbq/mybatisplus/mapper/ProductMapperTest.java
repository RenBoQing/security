package com.rbq.mybatisplus.mapper;

import com.rbq.mybatisplus.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class ProductMapperTest {
    @Autowired
    private ProductMapper productMapper;

    /*
     *获取价格测试
     * @author RenBoQing
     * @date 2022/5/12 0012 14:36
     */
    @Test
    void BgTest() {
        // 小李获取商品的价格
        Product productLi = productMapper.selectById(1);
        System.out.println(productLi.getPrice());
        //    小王获取商品的价格
        Product productWang = productMapper.selectById(1);
        System.out.println(productWang.getPrice());
        //    小李将商品的价格+50
        productLi.setPrice(productLi.getPrice() + 50);
        productMapper.updateById(productLi);
        //    小王将商品价格-30
        productWang.setPrice(productWang.getPrice() - 30);
        productMapper.updateById(productWang);

        //    老板查询
        Product productLb = productMapper.selectById(1);
        System.out.println(productLb.getPrice());
    }

    /*
     *优化价格修改
     * @author RenBoQing
     * @date 2022/5/12 0012 15:07
     */
    @Test
    void LgTest() {
        // 小李获取商品的价格
        Product productLi = productMapper.selectById(1);
        System.out.println(productLi.getPrice());
        //    小王获取商品的价格
        Product productWang = productMapper.selectById(1);
        System.out.println(productWang.getPrice());
        //    小李将商品的价格+50
        productLi.setPrice(productLi.getPrice() + 50);
        productMapper.updateById(productLi);
        //    小王将商品价格-30
        productWang.setPrice(productWang.getPrice() - 30);
        int update = productMapper.updateById(productWang);
        if (update == 0) {
            //表示操作失败 进行重试
            //再次获取价格  进行修改
            Product productNew = productMapper.selectById(1);
            productNew.setPrice(productNew.getPrice() - 30);
            productMapper.updateById(productNew);
        }
        //    老板查询
        Product productLb = productMapper.selectById(1);
        System.out.println(productLb.getPrice());
    }


}