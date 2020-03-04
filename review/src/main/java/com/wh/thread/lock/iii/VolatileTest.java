package com.wh.thread.lock.iii;

public class VolatileTest {
    private volatile static boolean data=false;
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"开始运行");
                while(!data){
//                    System.out.println("xxxx");
// 发现如果while循环里不为空，data更改后的值就发现，愿意while底层有volatile
                }
                System.out.println(Thread.currentThread().getName()+"运行成功");
            }
        },"A线程").start();

        Thread.sleep(1000);


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"开始救A");
                data=true;
            }
        },"B线程").start();

//        while(true); //试试是否要等线程B结束 才会将值给主存， 发现只要数据改了，就会被主存得知。
    }
}
