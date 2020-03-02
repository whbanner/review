package com.wh.thread.lock;

public class BadLock implements Runnable{
    public static Integer i = 0;
    private static BadLock badLock = new BadLock();


    @Override
    public void run() {
        for(int j=0;j<10000;j++){
            synchronized (badLock){
                i++;
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(badLock);
        Thread t2 = new Thread(badLock);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);

    }
}
