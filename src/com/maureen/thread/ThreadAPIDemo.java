package com.maureen.thread;

/**
 * 介绍线程类的API方法
 */
public class ThreadAPIDemo implements Runnable{
    public static void main(String[] args) {
        //获取当前线程对象
        Thread thread = Thread.currentThread();
        //获取当前线程的名称
        System.out.println(thread.getName()); //main
        //获取线程的id
        System.out.println(thread.getId()); //1
        //获取线程的优先级，在一般系统中范围是0~10的值，如果没有经过设置的话，就是默认值5；有些系统是0~100
        System.out.println(thread.getPriority()); //5
        //设置线程的优先级
        /**
         * 优先级越高就一定越先执行吗？
         *      不一定，只是优先执行的概率比较大而已
         */
        thread.setPriority(10);
        System.out.println(thread.getPriority()); //10

        ThreadAPIDemo threadAPIDemo = new ThreadAPIDemo();
        Thread t1 = new Thread(threadAPIDemo);
        //判断线程是否存活
        System.out.println(t1.isAlive());//false
        t1.start();
        System.out.println(t1.getPriority());
        for(int i =0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+"----" + i);
        }
        System.out.println(t1.isAlive());//true
    }

    @Override
    public void run() {
        for(int i =0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+"----" + i);
        }
    }
}
