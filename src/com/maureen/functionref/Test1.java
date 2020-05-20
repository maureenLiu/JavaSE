package com.maureen.functionref;

import java.util.function.Consumer;
import java.util.function.Function;

public class Test1 {
    public static void main(String[] args) {
        Function<String, Integer> f1 = (str)->{return str.length();};
        System.out.println(f1.apply("abc"));

        Consumer<String> c1 = (str)-> System.out.println(str);
        c1.accept("str");

    }
}
