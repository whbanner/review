package com.wh.thread.pool;

import org.junit.Test;

import java.util.concurrent.*;

public class ThreadPool {
    public static void main(String[] args) {
//        //创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
//        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
//        //创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
//        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
//        //创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
//        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
//        //创建一个定长线程池，支持定时及周期性任务执行。
//        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(5);
//        //自定义线程池
//        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(0, 0, 0,
//                TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
            new ThreadPool().fun3();
    }

    //线程池为无线大 执行第二个任务时,若第一个任务已经完成,则继续用之前的线程
    @Test
    public void fun1() {

        ExecutorService newcachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            newcachedThreadPool.execute(new Runnable() {

                @Override
                public void run() {
                    System.out.println(index + Thread.currentThread().getName() + "====" + Thread.currentThread().getId());
                }
            });
        }
        newcachedThreadPool.shutdown();
    }

    //定长，但可以定时执行任务，次例子是延迟3秒执行
    @Test
    public void fun2() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(new Runnable() {

            @Override
            public void run() {
                System.out.println("delay 3 seconds");
            }
        }, 3, TimeUnit.SECONDS); //单位不同 还有.MILLISECONDS DAYS HOURS,
        scheduledThreadPool.shutdown();
    }

    @Test
    public void fun22() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                System.out.println("delay 1 seconds, and excute every 3 seconds");
            }
        }, 1, 3, TimeUnit.SECONDS); //表示延迟1秒后每3秒执行一次。
        scheduledThreadPool.shutdown();
    }

    //定长，任务超出即等待
    @Test
    public void fun3() {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {

            final int index = i;

            newFixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index + Thread.currentThread().getName() + "====" + Thread.currentThread().getId());

                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        newFixedThreadPool.shutdown();
                    }
                }
            });
        }
        newFixedThreadPool.shutdown();
    }

    @Test
    public static void fun4() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            int index = i;

            newSingleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index + Thread.currentThread().getName() + "====" + Thread.currentThread().getId());

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        newSingleThreadExecutor.shutdown();
                    }
                }
            });
        }
    }

}
