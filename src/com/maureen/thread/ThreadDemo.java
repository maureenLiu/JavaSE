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
 *
 * 线程的生命周期：
 *      1、新生状态：当创建好当前线程对象之后，没有启动之前(调用start()方法之前)
 *          ThreadDemo thread = new ThreadDemo();
 *          RunnableDemo run = new RunnableDemo();
 *      2、就绪状态：准备开始执行，并没有执行，表示调用start方法之后
 *          当对应的线程创建完成，且调用start方法之后，所有的线程会添加到一个就绪队列中，所有的线程同时去抢占CPU的资源
 *      3、运行状态：当前进程获取到CPU资源之后，就绪队列中的所有线程会去抢占CPU资源，谁先抢占到谁先执行，在执行的过程中就叫做运行状态
 *          抢占CPU资源，执行代码逻辑开始
 *      4、死亡状态：当运行中的线程正常执行完所有的代码逻辑或者因为异常情况导致程序结束叫做死亡状态
 *          进入的方式：
 *              1、正常运行完成且结束
 *              2、人为中断执行，比如使用stop方法
 *              3、程序抛出未捕获的异常
 *      5、阻塞状态：在程序运行过程中，发生某些异常情况，导致当前线程无法再顺利执行下去，此时会进入阻塞状态。进入阻塞状态的原因消除之后，
 *          所有的阻塞队列会再次进入到就绪状态中，随机抢占CPU的资源，等待执行。
 *        进入的方式：
 *              sleep方法
 *              等待io资源
 *              join方法(代码中执行的逻辑)
 *
 *      注意：
 *          在多线程的时候，可以实现唤醒和等待的过程，但是唤醒和等待操作的对应不是thread类，而是设置的共享对象或者共享变量
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
