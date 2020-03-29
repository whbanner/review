package com.wh.thread.juc.xi;



import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class Atomic {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.compareAndSet(1,2);
        atomicInteger.getAndIncrement();
        /**
         *   int var5;
         *         do {
         *             var5 = this.getIntVolatile(var1, var2);
         *         } while(!this.compareAndSwapInt(var1, var2, var5, var5 + var4));
         *
         *         return var5;
         *
         *
         *         底层就是自旋锁
         */
        atomicInteger.incrementAndGet();

    }
    //解决aba  初始值，初始时间戳

    @Test
    public static void abaTest(){
        AtomicStampedReference atomicStampedReference=new AtomicStampedReference<>(123,1);

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicStampedReference.compareAndSet(123, 124, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1));

            System.out.println(Thread.currentThread().getName()+"==="+atomicStampedReference.getStamp());

            System.out.println(atomicStampedReference.compareAndSet(124, 123, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1));

            System.out.println(Thread.currentThread().getName()+"==="+atomicStampedReference.getStamp());
        },"线程A").start();

        new Thread(()->{
            Integer samp=null;
            try {
                 samp = atomicStampedReference.getStamp();
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicStampedReference.compareAndSet(123, 125,
                    samp, atomicStampedReference.getStamp() + 1));

            System.out.println(Thread.currentThread().getName()+"==="+atomicStampedReference.getStamp());

        },"线程B").start();

    }
}
