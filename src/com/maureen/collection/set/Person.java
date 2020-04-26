package com.maureen.collection.set;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

//    /**
//     * 此比较器按照name的长度来比较，Person实现Comparable接口，重写compareTo方法
//     *
//     * @param o
//     * @return
//     */
//    @Override
//    public int compareTo(Object o) {
//        //System.out.println("compareTo");
//        Person p = (Person) o;
//        //System.out.println("p.name=" + p.name + ",this.name=" + this.name);
//        if (p.name.length() > this.name.length()) {
//            return 1;
//        } else if (p.name.length() < this.name.length()) {
//            return -1;
//        }
//        return 0;
//    }
}
