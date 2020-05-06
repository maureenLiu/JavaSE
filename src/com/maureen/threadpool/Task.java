package com.maureen.threadpool;

public class Task implements Runnable{
    @Override
    public void run() {
        //不加sleep的时候，CachedThreadPool会有线程复用的情况
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" running");
    }
}
