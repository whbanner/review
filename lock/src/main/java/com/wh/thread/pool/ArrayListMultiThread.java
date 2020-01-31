package com.wh.thread.pool;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMultiThread {

    static List<Integer> list = new ArrayList<>();

    public static class AddThread implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10000000; i++) {
                list.add(i);
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new AddThread());
        Thread t2 = new Thread(new AddThread());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(list.size());
    }
}
