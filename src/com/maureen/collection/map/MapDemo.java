package com.maureen.collection.map;

import java.util.*;

/**
 * map存储的是k-v键值对映射的数据
 *  实现子类：
 *      HashMap：数组+链表(JDK1.7); 数组+链表+红黑树(jdk1.8及之后)
 *      LinkedHashMap：链表
 *      TreeMap：红黑树
 *
 *   基本API：
 *      增加：
 *          put(k,v) 添加元素
 *      查找：
 *          isEmpty() 判断是否为空
 *          size()   返回map的大小
 *          containsKey
 *          containsValue
 *          get
 *       删除：
 *          clear() 清除map的数据
 *          remove 删除指定元素
 *
 *  Map.Entry: 表示的是K-V组合的一组映射关系，key和value成组出现
 *
 * HashMap和Hashtable的区别：
 *      1、HashMap线程不安全，效率比较高；Hashtable线程安全(方法中有synchronized关键字)，效率比较低
 *      2、HashMap中key和value都可以为空;Hashtable不允许为空
 *
 */

public class MapDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        //添加数据
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        map.put(null, null);
        System.out.println(map);
        System.out.println(map.isEmpty());
        System.out.println(map.size());
        //清除数据
        // map.clear();

        //判断是否包含数据
        System.out.println(map.containsKey("a"));
        System.out.println(map.containsValue(2));

        //获取指定key对应的value
        System.out.println(map.get("a"));

        //删除指定key对应的value，即删除指定的键值对
        map.remove("a");
        System.out.println(map);

        //遍历操作
        //遍历方法1：
        Set<String> keys = map.keySet();
        for(String key: keys) {
            System.out.println(key + "=" + map.get(key));
        }
        //遍历方法2：只能获取对应的value值，不能根据value来获取key
        Collection<Integer> values = map.values();
        for (Integer i: values) {
            System.out.println(i);
        }
        //遍历方法3：迭代器
        Set<String> keys2 = map.keySet();
        Iterator<String> iterator = keys2.iterator();
        while(iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key + "=" + map.get(key));
        }
        //遍历方法3：Map.Entry
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator1 = entries.iterator();
        while(iterator1.hasNext()) {
            Map.Entry<String, Integer> next = iterator1.next();
            System.out.println(next.getKey() + "---" + next.getValue());
        }
    }
}
