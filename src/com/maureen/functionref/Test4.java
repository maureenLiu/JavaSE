package com.maureen.functionref;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * 对象方法引用
 */
public class Test4 {
    public static void main(String[] args) {
        //参数too必须是要调用的实例方法的类型,泛型和第一个参数的类型必须一致
        Consumer<Too> c1 = (Too too)->new Too().foo();
        //参数必须和泛型的类型一样
        c1.accept(new Too());
        Consumer<Too> c2 = (Too too)->new Too2().foo();
        c2.accept(new Too());
        Consumer<Too> c3 = Too::foo;
        c3.accept(new Too());

        BiConsumer<Too2, String> bc = (too2, str)->new Too2().show(str);
        BiConsumer<Too2, String> bc2 = Too2::show;
        bc.accept(new Too2(),"abc");
        bc2.accept(new Too2(),"def");

        BiFunction<Exec,String, Integer> bf1 = (e,s)-> new Exec().test(s);
        bf1.apply(new Exec(), "abc");
        BiFunction<Exec,String, Integer> bf2 = Exec::test;
        bf2.apply(new Exec(), "def");
    }
}

class Exec {
    public int test(String name) {
        return 1;
    }
}

class Too {
    public Integer fun(String s) {
        return 1;
    }

    public void foo() {
        System.out.println("foo");
    }
}

class Too2 {
    public Integer fun(String s) {
        return 1;
    }

    public void foo() {
        System.out.println("foo---too2");
    }

    public void show(String str) {
        System.out.println("show---" + str);
    }
}