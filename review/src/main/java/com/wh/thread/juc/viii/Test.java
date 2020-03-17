package com.wh.thread.juc.viii;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
    }

    //时间:7243求和值:499999999500000000
    @org.junit.Test
    public void test1(){
        Long sum=0l;
        long start=System.currentTimeMillis();
        for (Long i = 0l; i <10_0000_0000l ; i++) {
            sum=sum+i;
        }

        long end=System.currentTimeMillis();
        System.out.println("时间:"+(end-start)+"求和值:"+sum);
    }

    public static void test2() throws ExecutionException, InterruptedException {
        Long sum=0l;
        long start=System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task =new ForkJoinTest(0L,10_0000_0000L);
        ForkJoinTask<Long> submit=forkJoinPool.submit(task);
         sum = submit.get();
        long end=System.currentTimeMillis();
        System.out.println("时间:"+(end-start)+"求和值:"+sum);
    }

    @org.junit.Test
    public void test3(){
        Long sum=0l;
        long start=System.currentTimeMillis();
        sum= LongStream.rangeClosed(0L,10_0000_0000L).parallel().reduce(0,Long::sum);

        long end=System.currentTimeMillis();
        System.out.println("时间:"+(end-start)+"求和值:"+sum);
    }
}
