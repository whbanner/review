package com.wh.consumeraction;


import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

@Component("consumerAction")
public class ConsumerAction {

    @Reference
    private Hello2Service hello2Service;

    public String doSayHello(String name) {
        return hello2Service.sayHello2(name);
    }
}
