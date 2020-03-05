package com.wh.thread.lock.iii;

public class VolatileTest {
    /**
     * t1，t2两个线程运行 t1一直while(！data){ }在死循环，如果t2改了值 data不是volatile 原则上，t1线程不可见
     * 但是如果while 里面不是空语句随便输出一句话，发现如t1，死循环解开
     * 发现println()方法 中有这段代码
     * synchronized (this) {
     *             print(x);
     *             newLine();
     *         }
     *         看到synchronized
     *         synchronized 依赖于mutex(互斥锁),在同一时刻只有一个线程进入
     *         synchronized 进入同步代码块之前 会将工作区所有的内容映射到主存中,然后将工作区清零，再从主寄存器中拿到最新的值
     *         而synchronize退出时，会将工作空间中的内容映射到主存中，工作空间值不清零
     *         这样就保持了工作空间和主存空间的一致性
     *         换句话说while里面的data知道了最新值改为了true
     */
    private  static boolean data=false;
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"开始运行");
                while(!data){
                    System.out.println("xxx");
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
