package com.wh.thread.lock.v;

import java.util.concurrent.locks.ReentrantLock;

public class NoFairLockTest {

    /**
     * ReentrantLock默认非公平锁
     * Thread-0获取锁
     * Thread-0获取锁
     * Thread-1获取锁 一个线程获取锁两次，随机的
     * Thread-1获取锁
     * Thread-3获取锁
     * Thread-3获取锁
     * Thread-2获取锁
     * Thread-2获取锁
     * Thread-4获取锁
     * Thread-4获取锁
     */

    static ReentrantLock lock1 = new ReentrantLock();
//    private static ReentrantLock lock1 = new ReentrantLock(true);

    public static void main(String[] args) {
        Runnable  runnable=()-> {
                for (int j = 0; j < 2; j++) {
                    lock1.lock();
                    System.out.println(Thread.currentThread().getName() + "获取锁");
                    lock1.unlock();
//                    System.out.println(Thread.currentThread().getName() + "释放锁");
                }
        };
        //创建5个线程
        for (int i = 0; i < 5; i++) {
            new Thread(runnable,"线程"+i).start();
        }
    }
}
