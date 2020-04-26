package com.maureen.generic;

public class GenericClass<T> {
    private int id;
    private T t;

    public void setId(int id) {
        this.id = id;
    }

    public void setT(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public void show() {
        System.out.println("id:" + id + ",t:" + t);
    }
}
