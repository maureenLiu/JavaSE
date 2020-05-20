package com.maureen.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaDemo {
    public static void main(String[] args) {
        //example1：
        //普通写法
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running...");
            }
        });
        thread.start();
        //lambda表达式的写法
        new Thread(()->{
            System.out.println("running2.....");
        }).start();

        //example2：
        List<String> list = Arrays.asList("java", "javascript", "scala", "python");
        //普通写法
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        for(String str: list) {
            System.out.println(str);
        }
        //lambda表达式的写法
        Collections.sort(list, (a,b)->a.length() - b.length());
        list.forEach(System.out::println);
    }
}
