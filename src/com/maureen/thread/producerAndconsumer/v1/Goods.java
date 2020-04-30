package com.maureen.thread.producerAndconsumer.v1;

public class Goods {
    private String brand;
    private String name;

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
        try {
            Thread.sleep(200);//来完成线程之间的切换
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("消费者取走了"+this.getBrand() + "----" + this.getName());
    }
    //生产者生产产品:解决了v0中brand和name不对应的问题
    public synchronized void set(String brand, String name){
        this.setBrand(brand);
        try {
            Thread.sleep(200);//模拟生产的时候需要的时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setName(name);
        System.out.println("生产者生产了"+this.getBrand() + "----" +this.getName());
    }
}
