package com.maureen.threadpool.scheduledthreadpoolexecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SingleThreadScheduledExecutor {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " running");
                System.out.println("延迟1s执行");
            }
        }, 1, TimeUnit.SECONDS);
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " running");
                System.out.println("延迟1s执行");
            }
        }, 1, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
    }
}
