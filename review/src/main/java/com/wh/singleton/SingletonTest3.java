package com.wh.singleton;


import java.util.RandomAccess;

/**
 * 双重验证，加锁 volatile
 */
public class SingletonTest3 {
    private volatile static SingletonTest3 singletonTest3;
    private SingletonTest3(){}

    public static SingletonTest3 getInstance(){
        if (singletonTest3==null){
            synchronized (SingletonTest3.class) {
                if (singletonTest3==null){
                    singletonTest3=new SingletonTest3();
                }
            }
        }
        return singletonTest3;
    }
}
