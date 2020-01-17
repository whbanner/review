package com.wh;

public class SynchronizedLock implements Runnable {
    public synchronized void get() {
               System.out.println("2 enter thread name-->" + Thread.currentThread().getName());
              //reentrantLock.lock();
               System.out.println("3 get thread name-->" + Thread.currentThread().getName());
                 set();
                 //reentrantLock.unlock();
                 System.out.println("5 leave run thread name-->" + Thread.currentThread().getName());
             }

             public synchronized void set() {
                //reentrantLock.lock();
                 System.out.println("4 set thread name-->" + Thread.currentThread().getName());
                 //reentrantLock.unlock();
             }

             @Override
     public void run() {
                 System.out.println("1 run thread name-->" + Thread.currentThread().getName());
                get();
            }

            public static void main(String[] args) {
                SynchronizedLock test = new SynchronizedLock();
                 for (int i = 0; i < 10; i++) {
                         new Thread(test, "thread-" + i).start();
                     }
            }

}
