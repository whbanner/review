package com.wh.singleton;

public enum SingletonTest5 {
    //枚举元素本神就是单例
    INSTANCE;

    public SingletonTest5 getInstance(){
        return INSTANCE;
    }
}
