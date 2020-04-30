package com.maureen.thread.ticket;

/**
 * 使用接口的方式，每次只创建了一个共享对象，所有的线程能够实现资源共享
 * 存在的问题：
 *  1、数据不一致的问题
 *      解决方法：线程同步
 */
public class TicketRunnable2 implements Runnable {
    private int ticketCnt = 5;

    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            try {
                Thread.sleep(200);//多个子线程可以轮流得到执行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(this) {
                if (ticketCnt > 0) {
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + (ticketCnt--) + "张票");
                }
            }
        }
    }

    public static void main(String[] args) {
        TicketRunnable2 ticketRunnable = new TicketRunnable2();
        Thread t1 = new Thread(ticketRunnable);
        Thread t2 = new Thread(ticketRunnable);
        Thread t3 = new Thread(ticketRunnable);
        Thread t4 = new Thread(ticketRunnable);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
