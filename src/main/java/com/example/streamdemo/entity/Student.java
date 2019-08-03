package com.example.streamdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @类描述: 学生类
 * @author guohuixiang
 * @date 2019/8/2
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    private String name;
    private Integer age;
    /**
     * 年级
     */
    private Integer grade;
    private Boolean Man;


}
