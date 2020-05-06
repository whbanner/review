package com.wh.proxy.rpc;

public class HelloServiceImpl implements HelloService {
    @Override
    public void hello(String str) {
        System.out.println("hello"+str);
    }
}
