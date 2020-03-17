package com.wh.thread.juc.ii;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用condition实现线程精确唤醒
 * A唤醒B B唤醒C C唤醒A
 */
public class ConditionTest {
    public static void main(String[] args) {

        Data3 data3 = new Data3();
        new Thread(()->{
            for (int i=0;i<10;i++){
                data3.printA();
            }

        },"A线程").start();
        new Thread(()->{
            for (int i=0;i<10;i++) {
                data3.printB();
            }
        },"B线程").start();
        new Thread(()->{
            for (int i=0;i<10;i++) {
                data3.printC();
            }
        },"C线程").start();
    }
}

class Data3 {
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    private volatile int number = 1;

    public void printA() {
        lock.lock();
        try {
            while (number != 1) {

                condition1.await();
            }
            System.out.println("AAAAAAAA");
            number = 2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

            lock.unlock();

        }
    }

    public void printB() {
        lock.lock();


        try {
            while (number != 2) {
                condition2.await();
            }
            System.out.println("bbbbbbb");
            number = 3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

            lock.unlock();
        }

    }

    public void printC() {
        lock.lock();
        try {
            while (number != 3) {
                condition1.await();
            }
            System.out.println("ccccccc");
            number = 1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

            lock.unlock();
        }

    }
}
