package com.maureen.callable;

import java.util.concurrent.Callable;

/**
 * Callable<T>，T表示call()方法的返回值类型
 */
public class Task implements Callable<String> {
    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName() + " is running!";
    }
}
