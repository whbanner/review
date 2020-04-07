package com.wh.proxy.dynamicproxy;

public class HelloImpl implements IHello {
    @Override
    public void hello() {
        System.out.println("hello");
    }
}
