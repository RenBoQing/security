package com.rbq.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author RenBoQing
 * @date 2022年05月12日 15:18
 * @Description
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum SexEnum {
    MALE(1, "男"),
    FEMALE(2, "女");
    @EnumValue
    private Integer sex;
    private String sexName;
}
