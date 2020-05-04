package com.example.streamdemo.controller;

import com.example.streamdemo.entity.Classes;
import com.example.streamdemo.entity.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @类描述: 高级集合Collection和收集器的研究
 * @author guohuixiang
 * @date 2019/8/2
 */
@RestController
public class StreamApiController {


    /**
     * @描述: 按照年龄倒叙排序
     * @exception
     * @return void
     * @date 2019/8/2
     */
    public void getSorted() {
        List<Student> students = new ArrayList<>(10);
        Student student1 = new Student("张三", 23, 1, true);
        Student student2 = new Student("李四", 26, 1, true);
        Student student3 = new Student("王五", 29, 2, false);
        Student student4 = new Student("赵六", 28, 2, false);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        List<Student> list = students.stream()
                .sorted(Comparator.comparing(Student::getAge).reversed())
                .collect(Collectors.toList());
        System.out.println("-----------倒叙排序--------------");
        System.out.println(list.toString());
    }

    /**
     * 改写嵌套for 循环
     */
    public void getStudent() {
        List<Student> students = new ArrayList<>(10);
        Student student1 = new Student("张三", 23, 1, true);
        Student student2 = new Student("李四", 26, 1, true);
        Student student3 = new Student("王五", 29, 2, false);
        Student student4 = new Student("赵六", 28, 2, false);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        Classes classes1 = new Classes(1, "一班", "一班", students);

        List<Student> students2 = new ArrayList<>(10);
        Student student11 = new Student("张三2", 23, 1, true);
        Student student22 = new Student("李四2", 26, 1, true);
        Student student33 = new Student("王五2", 29, 2, false);
        Student student44 = new Student("赵六2", 28, 2, false);
        students.add(student11);
        students.add(student22);
        students.add(student33);
        students.add(student44);
        Classes classes2 = new Classes(2, "二班", "二班", students2);
        List<Classes> list = new ArrayList<>();
        list.add(classes1);
        list.add(classes2);

        //获取所有学生年龄等于28的学生信息
        List<Student> studentList = list.stream()
                .flatMap(classes -> classes.getStudents().stream())
                .filter(student -> student.getAge() == 28)
                .collect(Collectors.toList());
        System.out.println("------------steam 改写双重for 循环 获取所有年龄等于28的学生---------------");
        System.out.println(studentList.toString());

    }


}
