package com.maureen.lambda.exercise;


import java.lang.String;

import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaTest {
    public static void main(String[] args) throws Exception{
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("running....");
            }
        };
        r1.run();

        Runnable r2 = ()-> {
            System.out.println("running2....");
        };
        r2.run();

        Runnable r3 = ()-> System.out.println("running3...");
        r3.run();

        Callable<String> c1 = new Callable() {
            @Override
            public String call() throws Exception {
                return "maureen";
            }
        };
        System.out.println(c1.call());

        Callable<String> c2 = ()->{return "maureen2";};
        System.out.println(c2.call());

        Callable<String> c3 = ()->"maureen3";
        System.out.println(c3.call());


        StudentDao sd1 = new StudentDao() {
            @Override
            public void insert(Student student) {
                System.out.println("插入学生1");
            }
        };

        StudentDao sd2 = (student) -> {
            System.out.println("student：" + student);
        };

        StudentDao sd3 = (Student student)-> System.out.println("student3:" + student);

        sd1.insert(new Student());
        sd2.insert(new Student());
        sd3.insert(new Student());


        TeacherDao td1 = new TeacherDao() {
            @Override
            public int get(Teacher teacher) {
                return 1;
            }
        };
        TeacherDao td2 = (teacher)-> {return 2;};
        TeacherDao td3 = (Teacher teacher)-> {return 3;};
        TeacherDao td4 = (teacher)->4;
        TeacherDao td5 = (Teacher teacher)->5;

        System.out.println(td1.get(new Teacher()));
        System.out.println(td2.get(new Teacher()));
        System.out.println(td3.get(new Teacher()));
        System.out.println(td4.get(new Teacher()));
        System.out.println(td5.get(new Teacher()));

        /**
         * 在Java中提供了一系列的函数式接口，用来接收后续传入的逻辑，但是对输入和输出有要求.
         * Supplier 代表一个输出
         * Consumer 代表一个输入
         * BiConsumer 代表两个输入
         * Function 代表一个输入，一个输出（一般输入和输出是不同类型的）
         * UnaryOperator 代表一个输入，一个输出（输入和输出是相同类型的）
         * BiFunction 代表两个输入，一个输出（一般输入和输出是不同类型的）
         * BinaryOperator 代表两个输入，一个输出（输入和输出是相同类型的）
         */
        Function<String, Integer> f1 = (str)->{return str.length();};
        System.out.println(f1.apply("abcdefg"));

        Supplier<String> s1 = ()->{return "maureen";};
        Supplier<String> s2 = ()->"maureen";
        System.out.println(s1.get());
        System.out.println(s2.get());

        Consumer<String> c11 = (str)-> System.out.println(str);
        c11.accept("beijing");

        BiFunction<String, String, Integer> bf = (a,b)->a.length() + b.length();
        System.out.println(bf.apply("maureen", "clever"));

        System.out.println("-------------------");
        //函数式接口中调用自定义方法
        Runnable runnable1 = ()->get();
        Runnable runnable2 = ()->exec();
        runnable1.run();

        //自定义函数式接口
        LambdaInterface li1 = ()->get(); //->后可以直接跟上返回值
        //LambdaInterface li2 = ()->find(); //不能这样用，因为LambdaInterface中的方法get返回值类型为int，find返回值类型为String，类型不匹配
        LambdaInterface li3 = ()->100;
        LambdaInterface li4 = ()->true? 1 : 0;
        System.out.println(li1.get());
    }

    static int get() {
        return 1;
    }

    static String find() {
        return "find";
    }

    static void exec() {
        find();
    }
}
