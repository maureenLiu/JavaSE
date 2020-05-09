package com.maureen.threadpool.scheduledthreadpoolexecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolDemo2 {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        System.out.println(System.currentTimeMillis());
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" running");
                System.out.println("延迟1s执行,每3s执行一次");
                System.out.println(System.currentTimeMillis());
            }
        }, 1, 3, TimeUnit.SECONDS);
        //scheduledExecutorService.shutdown();
    }
}
