package com.maureen.lambda;

/**
 * 有且仅有一个抽象方法（Object类中的方法除外）的接口是函数式接口
 * 下面的接口中包含两个接口，所以不是函数式接口
 */
@FunctionalInterface
public interface InterfaceTest {
    public void add();
    //public void sub();
}
