package com.wh.design;

import java.io.*;

/**
 * 序列化破坏单例
 * 测试类
 * @see SeriableSingletonTest1
 *
 * 原因:反序列化时, 对象会重新初始化
 */
public class SeriableSingletonTest  implements Serializable{
    private SeriableSingletonTest(){}
    private final static SeriableSingletonTest INSTANCE = new SeriableSingletonTest();
    public static SeriableSingletonTest getInstance(){
        return INSTANCE;
    }
    //加上此方法就为true  但是被实例化了两次  新创建的只是没有返回
    private Object readResolve(){
        return INSTANCE;
    }
}


