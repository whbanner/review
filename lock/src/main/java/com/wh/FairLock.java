package com.wh;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁
 */
public class FairLock {

    private ReentrantLock lock;
    public FairLock(boolean isFair) {
        super();
        lock = new ReentrantLock(isFair);
    }
    public void serviceMethod() {
        try {
            lock.lock();
            System.out.println("ThreadName=" + Thread.currentThread().getName()
                    + "获取锁定");
        } finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        final FairLock service= new FairLock(true);
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                System.out.println("★线程" + Thread.currentThread().getName()
                        + "运行了");
                service.serviceMethod();
            }
        };
        Thread[] threadArray = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threadArray[i] = new Thread(runnable);
        }
        for (int i = 0; i < 10; i++) {
            threadArray[i].start();
        }
    }
}
