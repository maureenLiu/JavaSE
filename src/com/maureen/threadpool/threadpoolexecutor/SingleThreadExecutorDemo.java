package com.maureen.threadpool.threadpoolexecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorDemo {
    public static void main(String[] args) {
        //线程池中只有一个线程
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for(int i = 0; i < 20; i++) {
            executorService.execute(new Task());
        }
        executorService.shutdown();
    }
}
