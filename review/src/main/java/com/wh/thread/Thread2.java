package com.wh.thread;



public class Thread2 implements Runnable {
    @Override
    public void run() {
        String name=Thread.currentThread().getName();
        System.out.println("Runable:"+name);

    }


}
