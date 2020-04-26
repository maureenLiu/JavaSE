package com.maureen.collection.set;

import java.util.Comparator;
import java.util.TreeSet;

public class SetDemo implements Comparator<Person> {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet(new SetDemo());

        treeSet.add(new Person("lisi", 15));
        treeSet.add(new Person("wangwu", 13));
        treeSet.add(new Person("maliu", 17));
        treeSet.add(new Person("zhangsan", 12));
        treeSet.add(new Person("zhangsan", 12));
        System.out.println(treeSet);
    }

    @Override
    public int compare(Person o1, Person o2) {
        if(o1.getAge() > o2.getAge()) {
            return -1;
        } else if(o1.getAge() < o2.getAge()) {
            return 1;
        }
        return 0;
    }
}
