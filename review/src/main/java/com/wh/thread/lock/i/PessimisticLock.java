package com.wh.thread.lock.i;


public class  PessimisticLock implements Runnable {
    static int i = 0;
    static Object objLock = new Object();


    public  void add() {
        synchronized (objLock){
            i++;
        }

    }

    @Override
    public  void run() {
        for (int j = 0; j < 1000000; j++) {
            add();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        /**
         * 1.//如果是普通方法上加synchronized ，实例对象锁，必须是一个对象，
         * 如果是两个对象，他们各自拿各自的锁，所以结果不对
         *
         * 2.如果是static方法 加上synchronized 锁的为类对象，不管几个对象都可
         *
         * 3.指定加锁对象，进入代码块之前 要获得指定对象锁
         * 如果 对象为static 那就所有对象公用一个锁，
         * 如果 对象为实例对象 那就每个对象都有一把锁 this相当于实例对象
         */
        PessimisticLock p = new PessimisticLock();
        Thread t1 = new Thread(new PessimisticLock());
        Thread t2 = new Thread(new PessimisticLock());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);

    }
}
