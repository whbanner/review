package com.wh.thread;

public class Test {
    public static void main(String[] args) {
        Thread t1=new Thread1();
        Thread t2= new Thread1();
        t1.run();
        t2.run();
    }
}
