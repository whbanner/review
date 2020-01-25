package com.wh.thread;

public class StartDead extends Thread{
    private int i;

    public StartDead() {
    }

    public void run() {
        while(this.i < 100) {
            System.out.println(this.getName() + " " + this.i);
            ++this.i;
        }

    }

    public static void main(String[] args) {
        StartDead sd = new StartDead();

        for(int i = 0; i < 300; ++i) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                sd.start();
                System.out.println(sd.isAlive());
            }

            if (i > 20 && !sd.isAlive()) {
                sd.start();
            }
        }

    }
}
