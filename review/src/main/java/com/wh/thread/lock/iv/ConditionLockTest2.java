package com.wh.thread.lock.iv;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionLockTest2 {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition putlock=lock.newCondition();
    private static Condition takelock=lock.newCondition();
    private static String[] items = new String[10];
    private static int putptr,takeptr,count=0;

    public static void put(String x) throws InterruptedException {
        lock.lock();
        //当数组已满，等待非满条件
        while (count==items.length){
            System.out.println("putTask添加到阻塞队列中");
            putlock.await();
            System.out.println("putTask被唤醒，继续添加元素");
        }
        items[putptr]=x;
        if (++putptr==items.length)
            putptr=0;
        count++;
        //添加元素，发送可get信号
        takelock.signal();

        lock.unlock();
    }

    public static String take() throws InterruptedException {
        lock.lock();
        while (count==0){
            System.out.println("没数据了，takeTask在阻塞中");
            takelock.await();
            System.out.println("有数据了，继续take");
        }
        String x=items[takeptr];
        if (++takeptr==items.length)
            takeptr=0;
        count--;
        //添加元素，就发一个可put信号
        putlock.signal();
        Thread.sleep(100);
        lock.unlock();
        return x;

    }

    public static void main(String[] args) {
        new Thread("线程A"){
            @Override
            public void run() {
                for(int i=0;i<13;i++){
                    try {
                        put("abc");
                        System.out.println(Thread.currentThread().getName()+"put==="+count+"个元素");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread("线程B"){
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i=0;i<2;i++){
                    System.out.println(Thread.currentThread().getName()+"get==="+count+"个元素");
                }

            }
        }.start();
    }


}
