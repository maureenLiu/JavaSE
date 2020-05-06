package com.maureen.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolDemo {
    public static void main(String[] args) {
        //自定义线程池中线程的个数
        ExecutorService executorService = Executors.newFixedThreadPool(5);//5表示最多可以容纳的线程数
        for(int i = 0; i < 20; i++) {
            executorService.execute(new Task());
        }
        executorService.shutdown();
    }
}
