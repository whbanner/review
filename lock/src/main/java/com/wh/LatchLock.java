package com.wh;

import java.util.concurrent.CountDownLatch;

/**
 * 闭锁
 */
public class LatchLock implements Runnable{
    private final CountDownLatch await;
    private final int num;
    public LatchLock(CountDownLatch await, int num) {
        this.await = await;
        this.num  =  num;
           }
           public void run() {
               System.out.println("线程"+num+"执行完毕。");
               await.countDown(); // 当前事件执行完毕，计数 -1
           }


    public static void main(String[] args) throws InterruptedException {
        // 申明，等待事件数量 5次
        CountDownLatch await = new CountDownLatch(5);
        // 依次创建并启动处于等待状态的5个MyRunnable线程
        for (int i = 1; i < 6; ++i) {
            new Thread(new LatchLock(await, i)).start();
        }
        System.out.println("等待线程开始工作......");
        await.await();
        System.out.println("结束!");
    }

}
