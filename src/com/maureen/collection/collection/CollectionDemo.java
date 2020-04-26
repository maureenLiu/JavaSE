package com.maureen.collection.collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo {
    public static void main(String[] args) {
        Collection collection = new ArrayList();
        //添加数据
        collection.add(1);  //自动装箱了: collection.add(new Integer(1));
        collection.add(true);
        collection.add(1.23);
        collection.add("abc");
        System.out.println(collection); //[1, true, 1.23, abc]
        //指定位置添加数据
        ((ArrayList)collection).add(0,"maureen"); //这个方法在ArrayList中
        System.out.println(collection); //[maureen, 1, true, 1.23, abc]
        //添加整个集合
        Collection collection1 = new ArrayList();
        collection1.add("hello");
        collection.addAll(collection1);
        System.out.println(collection); //[maureen, 1, true, 1.23, abc, hello]
        //是否包含指定元素
        System.out.println(collection.contains("a"));//false
        System.out.println(collection.contains("abc"));//true
        //是否包含另一个集合
        System.out.println(collection.containsAll(collection1)); //true
        //判断是否为空
        System.out.println(collection.isEmpty()); //false
        //清空集合中的数据
//        collection.clear();
//        System.out.println(collection); //[]
//        //判断是否为空
//        System.out.println(collection.isEmpty()); //true
        //删除集合中的指定元素
        collection.remove(1);
        System.out.println(collection);//[maureen, true, 1.23, abc, hello]
        //保留指定集合中的元素
        System.out.println(collection1.retainAll(collection)); //false
        System.out.println(collection1); //[hello]
//        System.out.println(collection.retainAll(collection1)); //true
//        System.out.println(collection); //[hello]
        //当前集合的长度
        System.out.println(collection.size()); //5
        //当前集合转成数组
        Object[] objects = collection.toArray();
    }
}
