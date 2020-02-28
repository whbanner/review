package com.wh.thread;



public class AccountingTest implements Runnable {
     static volatile int i = 0;

    public synchronized void increase() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            increase();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        AccountingTest test1 = new AccountingTest();
//        AccountingTest test2 = new AccountingTest();
        //synchronized原子性锁 是保证同一对象在不同线程中的原子性
        //synchronized保证同一对对象的这个方法不能被不同线程同时访问 但是最后被访问的次数是2000000次
        Thread t1 = new Thread(test1);
        Thread t2 = new Thread(test1);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(Thread.currentThread().getName() + i);
    }
}
