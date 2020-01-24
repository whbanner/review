package com.wh.thread;

public class FirstThread extends Thread{
    private int i;

    public FirstThread(String name) {
        super(name);
    }

    public void run() {
        while(this.i < 2) {
            System.out.println(this.getName() + " " + this.i);
            ++this.i;
        }

    }

    public static void main(String[] args) {
        for(int i = 0; i < 2; ++i) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 1) {
                (new FirstThread("aaaaa")).start();
                (new FirstThread("bbbbb")).start();
            }
        }

    }
}
