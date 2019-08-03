package com.example.streamdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.AssertTrue;
import java.util.List;

/**
 * @类描述: 班级
 * @author guohuixiang
 * @date 2019/8/2
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Classes {
    /**
     * 班级编号
     */
    private int classNum;
    /**
     * 班级编号
     */
    private String name;
    /**
     * 班级描述
     */
    private String desc;
    /**
     * 学生
     */
    private List<Student> students;
}
