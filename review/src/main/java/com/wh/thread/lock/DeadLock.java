package com.wh.thread.lock;

public class DeadLock extends Thread{
    static Object obj1 = new Object();
    static Object obj2 = new Object();
    Object tool;

    public DeadLock(Object tool){
        this.tool=tool;
        if(tool==obj1){
            this.setName("lockA");
        }
        if(tool==obj2){
            this.setName("lockB");
        }
    }

    @Override
    public void run() {
        if(tool==obj1){
            synchronized (obj1){
                try {
                    System.out.println("线程:"+Thread.currentThread().getName()+"拿到loackA,需要lockB");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj2){
                    System.out.println("拿到lockB");
                }
            }
        }

        if(tool==obj2){
            synchronized (obj2){
                try {
                    System.out.println("线程:"+Thread.currentThread().getName()+"拿到loackB,需要lockA");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj1){
                    System.out.println("拿到lockA");
                }
            }
        }
    }

    public static void main(String[] args) {
        DeadLock t1 = new DeadLock(obj1);
        DeadLock t2 = new DeadLock(obj2);
        t1.start();
        t2.start();
    }

}
