package com.wh.thread.juc.iv;

import java.util.concurrent.CountDownLatch;

/**
 * 并发下的一个减法计数器
 * 开始设定一个int 值
 * 每调用一个.countDown()   -1
 * 当 为0时,. .awit就可以运行了
 *
 * eg 一个房间5个人 ，等5个都出去才关门
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        for (int i = 0; i <5 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"===== i am outing");
                countDownLatch.countDown();
            },""+i+"").start();
        }
            countDownLatch.await();

        System.out.println("i am close gate");
    }
}
