package com.maureen.thread;

public class YieldTest {
    public static void main(String[] args) {
        MyRun run = new MyRun();
        Thread thread = new Thread(run);
        thread.start();

        for (int i = 0; i < 5; i++) {
            if(i == 2) {
                Thread.yield();
                //thread.stop();
                System.out.println(Thread.currentThread().getName() + "------" + i +" 礼让一次");
            } else {
                System.out.println(Thread.currentThread().getName() + "======" + i);
            }
        }
    }
}
