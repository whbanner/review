package com.wh.thread.juc.i;

public class ProduceC {
    public static void main(String[] args) {
        Data data =new Data();
        new Thread(()->{
            try {
                for (int i=0;i<10;i++){
                    data.incr();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"生产者1").start();

        new Thread(()->{
            try {
                for (int i=0;i<10;i++){
                    data.decr();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"消费者1").start();
        new Thread(()->{
            try {
                for (int i=0;i<10;i++){
                    data.incr();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"生产者2").start();

        new Thread(()->{
            try {
                for (int i=0;i<10;i++){
                    data.decr();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"消费者2").start();
    }
}

/**
 * 生产者，消费者模型
 * 总结
 * 判断等待，业务，唤醒
 */
class Data{
    private int number;

    public synchronized void incr() throws InterruptedException {
        while (number!=0){
            //等待
            wait();
        }

        number++;
        System.out.println(Thread.currentThread().getName()+"=>"+number);
        //唤醒
        notifyAll();
    }

    public synchronized  void decr() throws InterruptedException {
        while (number==0){
            //等待
            wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"=>"+number);
        //唤醒
        notifyAll();
    }
}