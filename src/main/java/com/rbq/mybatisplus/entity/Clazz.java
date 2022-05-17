package com.rbq.mybatisplus.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author RenBoQing
 * @date 2022年05月14日 14:14
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Clazz {
    private int classId;
    private String className;
    private String classDesc;
}
