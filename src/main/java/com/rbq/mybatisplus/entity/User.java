package com.rbq.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.rbq.mybatisplus.enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author RenBoQing&HuHanYue
 * @date 2022年05月10日 9:38
 * @Description 实体类
 */
@Data
@NoArgsConstructor
//无参数
@AllArgsConstructor
//全参数
@TableName("user")
//指定对应的表名  用于设置对应的表名称不一致的情况
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private Long uid;
    @TableField("name")
    private String name;
    private int age;
    private String email;
    //引用枚举
    private SexEnum sex;
    //实现逻辑删除使用的注解
    @TableLogic
    private Integer isDeleted;
}
