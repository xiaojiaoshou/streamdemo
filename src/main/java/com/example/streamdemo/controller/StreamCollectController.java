package com.example.streamdemo.controller;

import com.example.streamdemo.entity.Student;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.AssertTrue;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @类描述: 高级集合和收集器的研究
 * @author guohuixiang
 * @date 2019/8/2
 */
@RestController
public class StreamCollectController {
    private  static List<Student> students = new ArrayList<>(10);
    static {

        Student student1 = new Student("张三", 23, 1, true);
        Student student2 = new Student("李四", 25, 1, true);
        Student student3 = new Student("王五", 25, 2, false);
        Student student4 = new Student("赵六", 25, 2, false);
        student1.setName(null);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
    }

    @RequestMapping("/test")
    public void test() {

    }

    /**
     * @描述: collect 转换为集合 list
     * @exception
     * @return void
     * @date 2019/8/2
     */
    public void getCollectToList() {
        List<Student> list = Optional
                .ofNullable(students)
                .orElseGet(() -> Collections.emptyList())
                .stream()
                .filter(student -> student.getAge() > 24)
                .collect(Collectors.toList());
        System.out.println("---------获取集合list-------------");
        System.out.println(list.toString());
    }

    /**
     * @描述: collect 转换为集合set
     * @param students
     * @exception
     * @return void
     * @date 2019/8/2
     */
    public void getCollectToSet(List<Student> students) {
        Set<Student> set = Optional
                .ofNullable(students)
                .orElseGet(() -> Collections.emptyList())
                .stream()
                .filter(student -> student.getAge() > 24)
                .collect(Collectors.toSet());
        System.out.println("---------获取集合set-------------");
        System.out.println(set.toString());
    }


    /**
     * @描述: collect 转换为集合map  默认转换为hashmap
     * @exception
     * @return void
     * @date 2019/8/2
     */
    public void getCollectToMap() {
        HashMap<Integer, String> hashMap = Optional
                .ofNullable(students)
                .orElseGet(() -> Collections.emptyList())
                .stream()
                .collect(Collectors.toMap(Student::getAge, item -> item.getName(), (key1, key2) -> key1, HashMap::new));
        System.out.println("---------获取list转换为map-------------");
        System.out.println(hashMap.toString());
    }


    /**
     *  数据分块:  有这样一个收集器 partitioningBy，它接受一个流，并将其分成两部分,
     *  它使用 Predicate 对象判断一个元素应该属于哪个部分，并根据布尔值返回一 个 Map 到列表。
     *  因此，对于 true List 中的元素，Predicate 返回 true；对其他 List 中的 元素，
     *  Predicate 返回 false。
     */
    public void getPartitioningBy() {
        // 数据分块
        // 按男女进行分组
        Map<Boolean, List<Student>> collect5 = Optional
                .ofNullable(students)
                .orElse(Collections.<Student>emptyList())
                .stream()
                .collect(Collectors.partitioningBy(Student::getMan));
        System.out.println("--------按男女进行分组------------");
        System.out.println(collect5.toString());

    }

    /**
     *
     *   使用收集器
     * Collectors.groupingBy 用法  分组
     */
    public void getGroupByGrade() {
        //1.按照学生年级进行分组
        //避免空指针写法
        Map<Integer, List<Student>> collect1 = Optional
                .ofNullable(students)
                .orElse(Collections.<Student>emptyList())
                .stream()
                .collect(Collectors.groupingBy(Student::getGrade));
        System.out.println(collect1.toString());
    }
    /**
     * 使用收集器
     */
    public void getGroupMapping() {
        // 按照学生年级进行分组,并统计每个年级的学生姓名
        Map<Integer, List<String>> collect4 = Optional
                .ofNullable(students)
                .orElse(Collections.<Student>emptyList())
                .stream()
                .collect(Collectors.groupingBy(Student::getGrade,
                        Collectors.mapping(Student::getName, Collectors.toList())));
        System.out.println("--------每个年级的学生姓名------------");
        System.out.println(collect4.toString());
    }
    /**
     * 使用收集器
     */
    public void getGroupBykey() {
        // 按照学生年龄进行分组,并统计每个年级的学生人数
        Map<String, Long> collect3 = Optional
                .ofNullable(students)
                .orElse(Collections.<Student>emptyList())
                .stream()
                .collect(Collectors.groupingBy(student -> {
                    if (student.getGrade() == 1) {
                        return "一年级";
                    } else {
                        return "二年级";
                    }
                }, Collectors.counting()));
        System.out.println("----------自定义key----------");
        System.out.println(collect3.toString());
    }

    /**
     * 使用收集器: counting
     */
    public void getGroupCount() {
        // 按照学生年龄进行分组,并统计每个年级的学生人数
        Map<Integer, Long> collect2 = Optional
                .ofNullable(students)
                .orElse(Collections.<Student>emptyList())
                .stream()
                .collect(Collectors.groupingBy(Student::getGrade, Collectors.counting()));
        System.out.println("--------每个年级的学生人数------------");
        System.out.println(collect2.toString());

    }



}
