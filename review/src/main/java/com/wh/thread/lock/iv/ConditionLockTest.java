package com.wh.thread.lock.iv;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * condition 条件锁 获取方式 reentrantlock.newCondition
 * 在lock，unlock 方法直接调用await(),此时T1线程释放锁，处于等待，
 * 等另一个线程调用signal()方法 t1线程竞争到锁之后继续执行。
 */
public class ConditionLockTest {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        //获取condition锁
        Condition condition =lock.newCondition();

        Thread t1=new Thread("线程A"){
            @Override
            public void run() {
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"拿到锁");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }

            }
        };
        t1.start();
        new Thread("线程B"){
            @Override
            public void run() {
                System.out.println("线程B");
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"拿到锁");
                System.out.println(t1.getState()+"=======1");
                condition.signal();
                lock.unlock();
                try {
                    sleep(1000);
                    System.out.println(t1.getState()+"=======2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
