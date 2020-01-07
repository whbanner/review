package com.wh;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        HelloService helloService = (HelloService)context.getBean("helloService"); // 获取远程服务代理
        String hello = helloService.sayHello("world"); // 执行远程方法
        System.out.println( hello ); // 显示调
    }
}
