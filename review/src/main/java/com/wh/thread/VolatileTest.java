package com.wh.thread;

public class VolatileTest {
    static volatile boolean b;
    //如果不加volatile就会死循环 因为后个线程虽然改变了b的值 但是他们都在改的是自己本地内存了 不是堆中内存

    public static void main(String[] args) throws InterruptedException {
        new Thread(){
            @Override
            public void run() {
                while (true){
                    if(b==!b){
                        System.exit(0);
                }

                }
            }
        }.start();

        Thread.sleep(1000);

        new Thread(){
            @Override
            public void run() {
                while (true){

                    b=!b;
                }

            }
        }.start();
    }
}
