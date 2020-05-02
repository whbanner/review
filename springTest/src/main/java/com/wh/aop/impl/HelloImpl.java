package com.wh.aop.impl;

import com.wh.aop.IHello;
import org.springframework.stereotype.Component;

@Component
public class HelloImpl implements IHello {
    @Override
    public String hello() {
        System.out.println("hello");
        return "123";
    }
}
