package com.maureen.thread;

/**
 * 实现多线程：
 *      1、继承Thread类
 *      2、重写run方法，指的是核心执行的逻辑
 *      3、线程在启动的时候不要直接调用run方法，而是要通过start方法来进行调用
 *      4、每次运行相同的代码，出来的结果可能不一样，原因在于多线程谁先抢占资源无法进行人为控制
 */
public class ThreadDemo extends Thread{
    @Override
    public void run() {
        for(int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+"----:"+i);
        }
    }

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        //threadDemo.run();仅仅是对象调方法，创建了线程但并没有运行
        threadDemo.start(); //开启线程并执行该线程的run方法
        for(int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "====:" + i);
        }
    }
}
