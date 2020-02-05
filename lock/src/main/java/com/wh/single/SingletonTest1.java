package com.wh.single;

public class SingletonTest1 {
    private static final SingletonTest1 instance = new SingletonTest1();
  //有final 类加载时 就new了个对象 在static之前
    //而灭有final  在Static的时候在new对象 在类加载的时候是 ingletonTest1 instance=null;
    private SingletonTest1() {
    }

    public static SingletonTest1 getInstance() {
        return instance;
    }
}
