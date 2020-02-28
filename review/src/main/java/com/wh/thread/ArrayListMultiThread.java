package com.wh.thread;

import java.util.ArrayList;

public class ArrayListMultiThread {

    static volatile ArrayList<Integer> list=new ArrayList<>();

    public static class AddThread implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<10000000;i++){
                System.out.println(Thread.currentThread().getName());
                list.add(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        AddThread at= new AddThread();
        Thread t1=new Thread(new AddThread());
        Thread t2=new Thread(new AddThread());
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(list.size());
    }
}
