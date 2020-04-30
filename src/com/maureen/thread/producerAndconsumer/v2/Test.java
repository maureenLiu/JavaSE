package com.maureen.thread.producerAndconsumer.v2;

/**
 * v0:
 * 多线程访问的时候出现了数据安全问题：
 *  1、生产者没有生产产品，消费者就可以获取
 *  2、商品的品牌和名称对应不上
 *
 *  v1：解决了商品的品牌和名称对应不上的问题
 *  v2：通过flag和wait()、notify()方法的使用解决了“生产者没有生产产品，消费者就可以获取”
 */
public class Test {
    public static void main(String[] args) {
        Goods goods = new Goods();

        Producer producer = new Producer(goods);
        Consumer consumer = new Consumer(goods);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        t1.start();
        t2.start();
    }
}
