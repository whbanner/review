package com.wh.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class JVMSupportThreadPool {

    public static void main(String[] args) {

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(5);

        TestPoolRunnable testPoolRunnable = new TestPoolRunnable();
//        for (int i = 0; i < 10; i++) {
//            singleThreadExecutor.submit(testPoolRunnable);
//        }


//        for (int i = 0; i < 10; i++) {
//            newCachedThreadPool.submit(testPoolRunnable);
//        }
//
//        for (int i = 0; i < 10; i++) {
//            newFixedThreadPool.submit(testPoolRunnable);
//        }
//
        for (int i = 0; i < 10; i++) {
//            newScheduledThreadPool.scheduleWithFixedDelay(testPoolRunnable, 0, 2, TimeUnit.SECONDS);
//            newScheduledThreadPool.scheduleAtFixedRate(testPoolRunnable, 0, 2, TimeUnit.SECONDS);
            newScheduledThreadPool.submit(testPoolRunnable);
        }


        try {
            newScheduledThreadPool.shutdown();
            if (newScheduledThreadPool.awaitTermination(1, TimeUnit.SECONDS)) {
                newScheduledThreadPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("awaitTermination interrupted: " + e);
            newScheduledThreadPool.shutdownNow();
        }
    }


}
