package com.wh.singleton;

/**
 * 懒汉模式
 * 延迟加载 用的时候再new
 * 加synchronize可以防止多线程同时getInstance;
 */
public class SingletonTest2 {
    private static SingletonTest2 instance = null;
    private SingletonTest2(){}
    public static synchronized SingletonTest2 getInstance(){
        if (instance==null){
            instance =new SingletonTest2();
        }
        return instance;
    }
}
