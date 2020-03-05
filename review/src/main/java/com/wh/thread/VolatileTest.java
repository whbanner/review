package com.wh.thread;

public class VolatileTest {
    static boolean b;
    //如果不加volatile就会死循环 因为后个线程虽然改变了b的值 但是他们都在改的是自己工作内存了 不是主内空间

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
