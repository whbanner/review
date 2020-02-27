package com.wh.thread;
/**
 * Callable和Runnable
 * 区别
 * Runnable 的run方法没有返回值且不能抛出异常
 * Callable 的call方法有返回值 也可以向上抛出异常
 * 注：Callalbe接口支持返回执行结果，需要调用FutureTask.get()得到，此方法会阻塞主进程的继续往下执行，如果不调用不会阻塞。
 * @author hui wang
 * @since 2020.2.27
 */


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Thread3 implements Callable<Integer> {


    public static void main(String[] args) {
        Thread3 ct3= new Thread3();
        FutureTask<Integer> ft = new FutureTask<>(ct3);
        for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"===="+i);
            if (i==10){
                new Thread(ft,"有返回值的线程").start();
            }
        }

        try {
            System.out.println(ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }



    @Override
    public Integer call() throws Exception {
        int i;
        for(i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"===="+i);
        }
        return i;
    }
}
