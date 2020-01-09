package com.wh.impl;


import com.wh.api.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String something) {
        System.out.println(something + ".................");
        return something + "abc";

    }
}
