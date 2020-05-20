package com.maureen.lambda.why4;

import com.maureen.lambda.why2.Student;
import com.maureen.lambda.why2.StudentFilter;

import java.util.ArrayList;

/**
 * 相比v3，不用使用匿名内部类，减少代码量
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(new Student("zhangsan",14,67));
        list.add(new Student("lisi",13,89));
        list.add(new Student("wangwu",15,97));
        list.add(new Student("maliu",12,63));
        list.add(new Student("zhaoqi",17,75));
        //查找年龄大于14的学生
        getByFilter(list, (e)-> e.getAge() > 14);
        System.out.println("-------------------------");
        //查找分数大于75的学生
        getByFilter(list, e->e.getScore()>75);
        System.out.println("-------------------------");
        getByFilter(list, (e)->e.getName().length() > 5);
    }

    public static void getByFilter(ArrayList<Student> students, StudentFilter filter) {
        ArrayList<Student> list = new ArrayList<>();
        for(Student student: students) {
            if(filter.compare(student)) {
                list.add(student);
            }
        }
        printStudent(list);
    }

    public static void printStudent(ArrayList<Student> students) {
        for(Student student: students) {
            System.out.println(student);
        }
    }
}
