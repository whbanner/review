package com.wh.thread.lock.ii;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWritLockDemo {
    public static void main(String[] args) {
        ReadWriteTest rl = new ReadWriteTest();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                rl.set(111);
            }
        },"write").start();
        //起100个读线程
        for (int i=0;i<100;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                 rl.get();

                }
            }).start();
        }


    }
}

class ReadWriteTest{
    //模拟资源
    private int number=10;
    static ReadWriteLock rwl = new ReentrantReadWriteLock();

    //写
    public void set(int number){
        rwl.writeLock().lock();
        this.number=number;
        System.out.println(Thread.currentThread().getName()+"==="+number);
        rwl.writeLock().unlock();

    }
    //读
    public void  get(){
        rwl.readLock().lock();
        System.out.println(Thread.currentThread().getName()+"==="+number);
        rwl.readLock().unlock();
    }

}
