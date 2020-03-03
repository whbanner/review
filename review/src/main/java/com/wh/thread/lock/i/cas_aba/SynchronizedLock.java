package com.wh.thread.lock.i.cas_aba;

/**
 * javac  xxx.java  编译
 * javap -v xxx.class 反编译
 *
 * synchronized 是同过 monitor 监视器锁 实现, 而监视器锁本质依赖底层操作系统的mutex lock（互斥所） 实现，
 * 需要用户态到内核太切换 成本高
 */
public class SynchronizedLock {

    public synchronized void fun1(){
        System.out.println("hello world");
    }
    public void fun2(){
        synchronized (this){
            System.out.println("hello   ");
        }
    }

    public static void main(String[] args) {

    }
}
