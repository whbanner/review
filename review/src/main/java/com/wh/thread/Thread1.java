package com.wh.thread;

public class Thread1 extends Thread {
    @Override
    public void run() {
        String name =Thread.currentThread().getName();
        System.out.println("thread======"+name);

    }
}
