package com.wh;


import java.util.concurrent.atomic.AtomicReference;
/*
http://ifeve.com/java_lock_see1/
 */
public class SpinLock {
    private AtomicReference<Thread> sign =new AtomicReference<>();
    public void lock(){
        Thread current = Thread.currentThread();
        while(!sign .compareAndSet(null, current)){
        }

    }

    public void unlock (){

        Thread current = Thread.currentThread();

        sign .compareAndSet(current, null);

    }


}
