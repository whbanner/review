package com.wh.thread;

import java.util.Random;

public class C extends Thread {
    public C(String name) {
        super(name);
    }

    public void run() {
        try {
            Thread.sleep((long)(new Random()).nextInt(1000));
            System.out.println(this.getName());
            Contral.cdl.countDown();
        } catch (InterruptedException var2) {
            var2.printStackTrace();
        }

    }
}
