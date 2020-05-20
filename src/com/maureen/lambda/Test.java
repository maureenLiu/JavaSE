package com.maureen.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("java", "python", "scala","javascript");
        //普通匿名内部类方式
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        //lambda表达式
        Collections.sort(list, (a,b)->a.length()-b.length());
        list.forEach(System.out::println);
    }
}
