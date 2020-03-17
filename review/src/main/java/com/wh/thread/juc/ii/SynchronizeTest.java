package com.wh.thread.juc.ii;

import java.util.concurrent.TimeUnit;

/**
 * 思错 ，正常1线程sleep后 2线程不是应该可以拿到锁 进行2的操作吗
 * sleep 不同于wait  sleep睡眠是不扔锁，线程状态是Runnable
 */
public class SynchronizeTest {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(()->{
            phone.send();
        }).start();


        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone.phone();
        }).start();
    }


}

class Phone{

    public synchronized void send(){
        try {
            wait();
            System.out.println(Thread.currentThread().getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我在send");
    }
    public synchronized void phone(){
        System.out.println("phone");
    }
}
