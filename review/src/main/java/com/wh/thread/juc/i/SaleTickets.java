package com.wh.thread.juc.i;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTickets {

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        Condition condition= lock.newCondition();
//        lock.lock();
//        lock.tryLock()
        Tickets tickets= new Tickets();
        //lambda
        new Thread(()->{
            for (int i=0;i<50;i++){
                tickets.sale();
            }

        },"售票员1").start();

        new Thread(()->{
            for (int i=0;i<50;i++){
                tickets.sale();
            }
        },"售票员2").start();

        new Thread(()->{
            for (int i=0;i<50;i++){
                tickets.sale();
            }
        },"售票员3").start();
    }
}

class Tickets{
    int tickets=50;
    public synchronized void  sale(){
            if (tickets>0){
                System.out.println(Thread.currentThread().getName()+"卖出了"+(tickets--)+"票"+"当前还剩"+tickets);

            }
    }
}
