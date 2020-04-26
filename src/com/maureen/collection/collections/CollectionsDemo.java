package com.maureen.collection.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("af");
        list.add("bg");
        list.add("cssf");
        list.add("dfsdfs");

        Collections.addAll(list, "efsdf", "f1","g32");
        System.out.println(list); //[af, bg, cssf, dfsdfs, efsdf, f1, g32]

        list.sort(new Comparator<String>() { //匿名内部类
            @Override
            public int compare(String o1, String o2) { //自定义的比较器，按照字符串长度排序
                if(o1.length() > o2.length())
                    return 1;
                else if(o1.length() < o2.length())
                    return -1;
                return 0;
            }
        });
        System.out.println(list);//[af, bg, f1, g32, cssf, efsdf, dfsdfs]

        Collections.sort(list); //按照字典序排序
        System.out.println(list); //[af, bg, cssf, dfsdfs, efsdf, f1, g32]

        Collections.sort(list,new Comparator<String>() { //匿名内部类
            @Override
            public int compare(String o1, String o2) { //自定义的比较器，按照字符串长度排序
                if(o1.length() > o2.length())
                    return 1;
                else if(o1.length() < o2.length())
                    return -1;
                return 0;
            }
        });
        System.out.println(list); //[af, bg, f1, g32, cssf, efsdf, dfsdfs]

        //二分查找的时候需要先进行排序操作，如果没有排序是找不到指定的元素的，所以必须先手动排序
        Collections.sort(list);
        System.out.println(Collections.binarySearch(list, "af"));//返回下标对应的位置0

        //将所有元素都替换为maureen
        Collections.fill(list, "maureen");
        System.out.println(list); //[maureen, maureen, maureen, maureen, maureen, maureen, maureen]
    }
}
