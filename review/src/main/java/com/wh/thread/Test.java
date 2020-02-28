package com.wh.thread;

public class Test {
        static int j=0;
    public static class ThreadRun implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<100000;i++){
                synchronized (this){
                j++;
                System.out.println(Thread.currentThread().getName()+"======"+j);
                }
            }

        }
    }
    public static void main(String[] args) throws InterruptedException {
        ThreadRun tr = new ThreadRun();
       Thread t1=new Thread(tr);
       Thread t2=new Thread(tr);
        //和new 两个的区别:如果操作的是ThreadRun的成员变量时 不加Static 他们自己干自己的活
        //如果加了static没区别 没区别都是操作j
        //如果操作别的对象 一个两个操作没区别 ，不过不加锁两个都会有线程安全问题
       t1.start();
       t2.start();
       t1.join();
       t2.join();
//        System.out.println(j);
    }
}
