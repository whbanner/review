package com.wh.thread.lock;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test implements Runnable {
    static final Test t = new Test();

    @Override
    /**
     * .getState()看一下线程状态
     */
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(5);
            System.out.println(Thread.currentThread().getName() + "结束" + Thread.currentThread().getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void fun2() {
        /**
         * 试一下interupt
         *
         */

        Thread t1 = new Thread(new Runnable() {
            int num = 0;

            @Override
            public void run() {
                while (true) {
                    num++;
                    //如果线程中断，跳出此程序
                    if (Thread.currentThread().isInterrupted()) {
                        break;
                    }

                }
                System.out.println(num);
            }
        });
        t1.start();
        try {
            t1.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //线程中断  此时run方法中的判断结果变true break出循环
        t1.interrupt();
    }

    /**
     * 继interrupt
     * 1.如果某线程调用了sleep()在wait状态 该线程调用了interrupt（）会抛出中断异常
     */
    public static void fun3() {
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + "我马上sleep");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t2.start();
        //等待t2，sleep
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("在被interrupt之前:" + t2.getState());
        t2.interrupt();
    }

    /**
     * trylock的使用
     * 解决死锁 在多少时间内继续获得锁 超过时间就不要
     */
    public static void fun4() {
        Lock lockA = new ReentrantLock();
        Lock lockB = new ReentrantLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (lockA.tryLock(1, TimeUnit.SECONDS))
                        System.out.println(Thread.currentThread().getName() + "进入1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    if (lockB.tryLock(1, TimeUnit.SECONDS)) {
                        System.out.println(Thread.currentThread().getName() + "进入2");
                        lockB.unlock();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lockA.unlock();

                }
            }
        }, "线程A");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (lockB.tryLock(1, TimeUnit.SECONDS)) {
                        System.out.println(Thread.currentThread().getName() + "进入11");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                {

                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    if (lockA.tryLock(1, TimeUnit.SECONDS)) {
                        System.out.println(Thread.currentThread().getName() + "进入22");
                        lockA.unlock();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lockB.unlock();

                }
            }
        }, "线程B");

        t1.start();
        t2.start();
    }

    /**
     * lockInterruptibly();
     * 如果用了此方法 t2,在获取不到该锁时，如果有其他线程调用t2.interrupt()会中断
     */
    public static void fun5(){
        Lock lockA = new ReentrantLock();
        Lock lockB = new ReentrantLock();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                try {
                    lockA.lockInterruptibly();
                    System.out.println("lockA");
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    lockB.lockInterruptibly();
                    System.out.println("lockB");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lockA.unlock();
                    lockB.unlock();
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                try {
                    lockB.lockInterruptibly();
                    System.out.println("lockBB");
                    sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    lockA.lockInterruptibly();
                    System.out.println("lockAA");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lockB.unlock();

                }
            }
        };

        t1.start();
        t2.start();
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                t1.interrupt();
                t2.interrupt();
            }
        }.start();

    }

    public static void main(String[] args) {
//        new Thread(t,"线程A").start();
//
//        System.out.println(Thread.currentThread().getName()+"结束"+Thread.currentThread().getState());
        fun5();

    }
}
