package com.wh;


import com.wh.config.ProviderConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Provider {

    public static void main(String[] args) throws IOException {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProviderConfig.class);
        context.start();
        System.in.read(); // 按任意键退出
    }
}
