package com.maureen.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolDemo {
    public static void main(String[] args) {
        //创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //提交任务
        for(int i = 0; i < 20; i++) {
            executorService.execute(new Task());
        }
        //关闭线程池
        executorService.shutdown();
    }
}
