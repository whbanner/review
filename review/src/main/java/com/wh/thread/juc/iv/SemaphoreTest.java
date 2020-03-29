package com.wh.thread.juc.iv;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 多个线程 使用时，允许一个或多个线程等待，直到其他线程完成操作并释放锁
 * 1.资源有限，且互斥。
 * 2.可限流
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i <6 ; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"拿到资源");
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName()+"释放资源");
                }
            }).start();
        }
    }
}
