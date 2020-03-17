package com.wh.thread.juc.viii;

import java.util.concurrent.RecursiveTask;

public class ForkJoinTest extends RecursiveTask<Long> {
    private Long start;
    private Long end;

    //零界值
    private final Long TEMP=10000L;

    public ForkJoinTest(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        Long len=end-start;
        Long sum=0l;
        if (len<TEMP){
            for (int start = 0; start <end ; start++) {
            sum=sum+start;
            }
        }else {
            //forkjoin
            Long middle=len/2;
            //拆分成两个任务
            ForkJoinTest f1= new ForkJoinTest(start,middle);
            //将之压入线程队列
            f1.fork();
            ForkJoinTest f2= new ForkJoinTest(middle+1,end);
            f2.fork();
            sum= f1.join()+f2.join();

        }
        return sum;
    }
}
