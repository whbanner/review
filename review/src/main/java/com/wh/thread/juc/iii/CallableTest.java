package com.wh.thread.juc.iii;

import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 发现Callable 起了两个线程，只掉用了一次call方法
 * 结果有缓存
 *
 * 1,如果call是个耗时的过程，立马调用get会阻塞
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<>(myCallable);
        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();
        String str=futureTask.get();
        System.out.println(str);
//        CopyOnWriteArrayList s
    }
}
class MyCallable implements Callable<String>{
    @Override
    public String call() throws Exception {
        System.out.println("Callable 被调用");
        Thread.sleep(10000);
        return "ok";
    }
}
