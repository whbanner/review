package com.wh.thread.juc.vii;

import org.omg.SendingContext.RunTime;

import java.util.concurrent.*;

/**
 * 4大拒绝策略
 * .AbortPolicy() 同时最多执行 5+BQ.MAX =8 最多执行8个，不然抛出异常
 * CallerRunsPolicy() 哪来的去哪里 发现main线程执行的(因为从main线程来的)
 * DiscardPolicy() 队列满了不会抛出异常
 * DiscardOldestPolicy() 队列满了,会和最早的线程竞争，把那线pop掉，让该线程来代替
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
            //得到cpu是几核
//        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());


        try {
            for (int i = 0; i < 30; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }


}
