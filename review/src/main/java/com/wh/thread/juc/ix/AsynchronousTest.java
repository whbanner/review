package com.wh.thread.juc.ix;

import com.wh.pool.C;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 异步回调 类似ajax
 * completableFuture类               函数式接口为
 * runAsync() 不可以得到结果   1.get
 * supplyAsync() 可以得到结果   1.get    2.whenComplete...exceptionally
 */
public class AsynchronousTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //没有返回值
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("异步回调结束");

        });

        //有返回值的回调
        CompletableFuture completableFuture2 = CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
                int a =1/0;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("异步回调结束");

            return 200;
        });

        System.out.println(completableFuture2.whenComplete((t, u) -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t->" + t); //正常结果
            System.out.println("u->" + u); //错误时的异常
        }).exceptionally((e) -> {
            return 404;
        }).get());  //并得到错误结果
        //成功回调可以设置200，失败404
         System.out.println("main");
//        Thread.sleep(5000);
//        如果程序没有执行完，得到结果的过程中,调用线程会阻塞
        //而且get方法在异常时会报错
        System.out.println(completableFuture2.get());
        System.out.println("main2");

    }
}
