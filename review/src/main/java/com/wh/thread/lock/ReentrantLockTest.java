package com.wh.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest implements Runnable{
    public static ReentrantLock lock = new ReentrantLock();
    public static int i=0;

    @Override
    public void run() {
        for(int j=0;j<3;j++){
            lock.lock();
        }
        try {
            i++;
        }finally {
            for (int j=0;j<3;j++){  //加几次锁就要放几次锁
                lock.unlock();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest rt=new ReentrantLockTest();
        Thread t1 = new Thread(rt);
        Thread t2 = new Thread(rt);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
