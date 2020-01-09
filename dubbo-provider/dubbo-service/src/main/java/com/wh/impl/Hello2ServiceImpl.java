package com.wh.impl;

import com.ease.archiecture.api.Hello2Service;
import org.apache.dubbo.config.annotation.Service;

@Service
public class Hello2ServiceImpl implements Hello2Service {
    @Override
    public String sayHello2(String anything) {
        return "hello2" + anything;
    }
}
