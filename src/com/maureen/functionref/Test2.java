package com.maureen.functionref;

import java.util.function.*;

/**
 * 静态方法引用
 */

public class Test2 {
    static String put() {
        System.out.println("put...");
        return "put";
    }

    static void getSize(int size) {
        System.out.println(size);
    }

    static String toUpperCase(String str) {
        return str.toUpperCase();
    }

    static Integer getLength(String str, String str2) {
        return str.length() + str2.length();
    }

    public static void main(String[] args) {
        //调用put方法的方式
        //方式1：
        System.out.println(put());
        //方式2：
        Supplier<String> s1 = ()->Test2.put();
        System.out.println(s1.get());
        //方式3：静态方法的引用
        Supplier<String> s2 = Test2::put;
        System.out.println(s2.get());

        Supplier<String> s3 = Fun::hehe;
        System.out.println(s3.get());

        Consumer<Integer> c = (size)->Test2.getSize(size);
        Consumer<Integer> c1 = Test2::getSize;
        c1.accept(123);

        Function<String, String> f1 = (str)->str.toUpperCase();
        Function<String, String> f2 = (str)-> Test2.toUpperCase(str);
        Function<String, String> f3 = Test2::toUpperCase;
        Function<String, String> f4 = Fun::toUpperCase;
        System.out.println(f1.apply("abc"));
        System.out.println(f2.apply("abc"));
        System.out.println(f3.apply("abc"));
        System.out.println(f4.apply("abc"));

        BiFunction<String, String, Integer> bf = (a,b)->a.length() + b.length();
        BiFunction<String, String, Integer> bf2 = Test2::getLength;
        System.out.println(bf.apply("abc","def"));
        System.out.println(bf2.apply("abc", "def"));
    }
}

class Fun {
    static String hehe() {
        return "hehe";
    }

    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }
}
