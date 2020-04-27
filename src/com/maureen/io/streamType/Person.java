package com.maureen.io.streamType;

import java.io.Serializable;

public class Person implements Serializable {
    private int id;
    private String name;
    private String pwd;

    public Person() {

    }

    public Person(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }
}
