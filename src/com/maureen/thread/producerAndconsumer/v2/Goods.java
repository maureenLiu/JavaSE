package com.maureen.thread.producerAndconsumer.v2;

public class Goods {
    private String brand;
    private String name;
    //默认是不存在商品的，如果值等于true，代表有商品;flag用来保证先有生产者生产，然后消费者才能消费
    private boolean flag = false;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //消费者获取商品
    public synchronized void get(){
        /**
         * 如果flag = false，意味着生产者还没有生产商品，此时消费者无法消费，需要让消费者线程进入到阻塞状态，等待生产者生产；
         * 当有商品之后，再开始消费
         */
        if(!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(200);//来完成线程之间的切换
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("消费者取走了"+this.getBrand() + "----" + this.getName());
        //商品取走后，将flag设置为false
        flag = false;
        //唤醒生产者去生产
        notify();
    }


    //生产者生产产品:解决了v0中brand和name不对应的问题(原子操作，品牌和名称同时设置)
    public synchronized void set(String brand, String name){
        /**
         * 当生产者抢占到CPU资源之后会判断当前对象是否有值:
         * 如果有的话，就意味着消费者还没有消费，需要提醒消费者消费，同时当前线程进入阻塞状态，等待消费者取走商品之后再次生产;
         * 如果没有的话，不需要等待，不需要进入阻塞状态，直接生产即可
         */
        if(flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.setBrand(brand);
        try {
            Thread.sleep(200);//模拟生产的时候需要的时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setName(name);
        System.out.println("生产者生产了"+this.getBrand() + "----" +this.getName());
        //如果代码执行到此处，意味着已经生产完成，需要将flag设置为true
        flag = true;
        //唤醒消费者去消费
        notify();
    }
}
