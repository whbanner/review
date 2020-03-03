package com.wh.thread.lock.ii;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock(重入锁)是独享锁的一种，一次只能被一个线程拿 可以拿多次，也必须释放多次，其他线程才可用
 */
public class ReentrantLockTest implements Runnable{
    final static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(new ReentrantLockTest());
        Thread t2 = new Thread(new ReentrantLockTest());
        t1.start();
        t2.start();

    }

    @Override
    public void run() {
        for (int i=0;i <3;i++){
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"我拿到锁"+i);
        }

        for (int j=0;j<3;j++){
            lock.unlock();
            System.out.println(Thread.currentThread().getName()+"我释放了锁");
        }

    }
}
