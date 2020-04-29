package com.maureen.thread.exercise;

/**
 * 定义一个线程A，输出1~10之间的整数；定义一个线程B，逆序输出1~10之间的整数，要求线程A和线程B交替输出
 *
 * 分析：
 *      两个线程不能sleep相同的时间，因为如果时间相同，那么同时处于同一个状态，之后哪个线程先执行是不确定的。
 *      利用sleep的时间差，决定线程的先后顺序。
 */
public class ThreadTest1 implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "=====" + i);
            try {
                Thread.sleep(1001);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadTest1 t1 = new ThreadTest1();
        Thread thread = new Thread(t1);
        thread.start();

        for(int i = 10; i >0; i--) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
