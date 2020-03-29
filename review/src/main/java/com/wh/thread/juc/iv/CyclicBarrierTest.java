package com.wh.thread.juc.iv;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 每次执行 调用await 就会 进入等待，
 * 允许几个线程同时执行，等全部达到公平屏障，之后才可执行，构造方法中的Thread任务
 * 当有5个线程 都执行完了 ，再继续执行 所要执行的任务
 */
public class CyclicBarrierTest {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(6, new Thread(()->{ System.out.println("i am close the door"); }));
        for (int i = 0; i <6 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"===I am inner");
                try {
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }



    }
}
