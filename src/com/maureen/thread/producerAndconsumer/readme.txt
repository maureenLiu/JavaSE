版本说明：
    v0：
       多线程访问的时候出现了数据安全问题：
            1、生产者没有生产产品，消费者就可以获取
            2、商品的品牌和名称对应不上(品牌和名称的设置不是原子操作，并不是一定同时被设置)
    v1：
        在Goods中添加同步的get和set方法，set方法解决了“商品的品牌和名称对应不上”的问题
    v2：
        针对问题“生产者没有生产产品，消费者就可以获取”,因为生产者和消费者线程是公平地去竞争资源的，所以是无法判断哪个线程先执行的。
        为此，在该版本中添加了flag标志，调用了wait和notify方法以保证生产者先生产，然后消费者消费
    v3：
        JUC(Java.util.concurrent)中BlockingQueue的使用,使得不再需要等待和唤醒操作，而可以解决线程安全问题
            BlockingQueue中常用的API:
            放数据：put(E e);
            取数据：take()


