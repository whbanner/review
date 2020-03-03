package com.wh.thread.lock.i;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 乐观锁
 * 通过atomic类完成
 * 有cas(compare and swap) 会出现aba问题
 * CAS有3个缺点
 * 1.自旋操作 一直循环等V于A相等
 * 2.只能保证一个共享变量的原子操作
 * 3.会出现ABA问题  解决方法时间戳,或者本版号
 */
public class OptimsticLock {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(10);
        AtomicStampedReference atomicStampedReference = new AtomicStampedReference(10,0);

        new Thread(new Runnable() {
            @Override
            public void run() {
                atomicInteger.compareAndSet(10,12);
                atomicInteger.compareAndSet(12,10);

                System.out.println(Thread.currentThread().getName()+"10-12-10");
            }
        },"线程A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                atomicInteger.compareAndSet(10,12);

                System.out.println(Thread.currentThread().getName()+"10-12");
            }
        },"线程B").start();

/**
 * return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
 * return UNSAFE.compareAndSwapObject(this, pairOffset, cmp, val);
 * 比较发现下面的 就是对对这面的进行封装 多个版本号判断 之后执行的方法类似
 */
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i=atomicStampedReference.getStamp();
                Boolean a=atomicStampedReference.compareAndSet(10,12, i ,++i);
                System.out.println(atomicStampedReference.getReference()+"=="+atomicStampedReference.getStamp());
                Boolean b =atomicStampedReference.compareAndSet(12,14, i ,++i);
                System.out.println(atomicStampedReference.getReference()+"=="+atomicStampedReference.getStamp());
                if(a&b==true){
                    System.out.println(Thread.currentThread().getName()+"10-12-10");
                }

            }
        },"线程c" ).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int j=atomicStampedReference.getStamp();
                boolean a=atomicStampedReference.compareAndSet(10,12, j ,++j); //false 不执行
                System.out.println(atomicStampedReference.getReference()+"=="+atomicStampedReference.getStamp());
                if (a==true)
                System.out.println(Thread.currentThread().getName()+"10-12");
            }
        },"线程D" ).start();

    }



}
