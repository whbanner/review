package com.wh.thread.lock;

import java.util.concurrent.TimeUnit;

public class Test implements Runnable {
    static final Test t = new Test();
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(5);
            System.out.println(Thread.currentThread().getName()+"结束"+Thread.currentThread().getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(t,"线程A").start();

        System.out.println(Thread.currentThread().getName()+"结束"+Thread.currentThread().getState());
    }
}
