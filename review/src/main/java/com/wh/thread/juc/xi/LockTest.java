package com.wh.thread.juc.xi;

import com.wh.thread.lock.ReentrantLockTest;

import java.sql.SQLOutput;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 自旋锁
 */
public class LockTest {
    AtomicReference<Thread> atomicReference= new AtomicReference<>();
    //加锁
    public void myLock(){
        Thread thread=Thread.currentThread();
        System.out.println(thread.getName()+" lock");
        //如果当前线程不为空就一直循环
        while (!atomicReference.compareAndSet(null,thread)){

        }
    }
    //解锁
    public void myUnLock(){
        Thread thread=Thread.currentThread();
        System.out.println(thread.getName()+"unlock");
        atomicReference.compareAndSet(thread,null);
  
    }
}
