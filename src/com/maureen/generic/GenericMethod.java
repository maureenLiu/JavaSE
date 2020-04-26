package com.maureen.generic;

public class GenericMethod<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public <Q> void show(Q q) { //泛型方法
        System.out.println(q);
        System.out.println(t);
    }
}
