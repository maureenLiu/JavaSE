package com.maureen.thread;

/**
 * 实现多线程：
 * 第一种实现方式：
 *      1、继承Thread类
 *      2、重写run方法，指的是核心执行的逻辑
 *      3、线程在启动的时候不要直接调用run方法，而是要通过start方法来进行调用
 *      4、每次运行相同的代码，出来的结果可能不一样，原因在于多线程谁先抢占资源无法进行人为控制
 *
 * 第二种实现方式：使用了代理设计模式
 *      1、实现Runnable接口
 *      2、重写run方法
 *      3、创建Thread对象，将创建好的Runnable的子类实现作为Thread的构造参数
 *      4、通过Thread.start()进行启动
 *
 * 推荐使用第二种方式：
 *      1、java是单继承，将继承关系留给最需要的类
 *      2、不需要给共享变量添加static关键字，每次创建一个对象作为共享对象
 */

public class RunnableDemo implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+"----:"+i);
        }
    }

    public static void main(String[] args) {
        RunnableDemo runnableDemo = new RunnableDemo();
        Thread t = new Thread(runnableDemo);
        t.start();
        for(int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "====:" + i);
        }
    }
}
