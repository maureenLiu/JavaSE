package com.maureen.thread.producerAndconsumer.v3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 使用JUC中的BlockingQueue实现线程的同步，简单方便地解决了线程安全问题
 */
public class Test {
    public static void main(String[] args) {
        BlockingQueue<Goods> queue = new ArrayBlockingQueue<Goods>(5);//只要queue中的容量没满，就可以往里放
        ProducerQueue producerQueue = new ProducerQueue(queue);
        ConsumerQueue consumerQueue = new ConsumerQueue(queue);
        new Thread(producerQueue).start();
        new Thread(consumerQueue).start();
    }
}
