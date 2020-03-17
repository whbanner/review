package com.wh.thread.juc.vi;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueTest {
    public static void main(String[] args) {
        SynchronousQueue sq = new SynchronousQueue<String>();
        new Thread(() -> {
            try {

                System.out.println(Thread.currentThread().getName() + "put  a");
                sq.put("a");
                System.out.println(Thread.currentThread().getName() + "put  b");
                sq.put("b");
                System.out.println(Thread.currentThread().getName() + "put  c");
                sq.put("c");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程1").start();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "take" + "====" + sq.take());
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "take" + "====" + sq.take());
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "take" + "====" + sq.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程1").start();
    }
}
