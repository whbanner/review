package com.wh.aop;

import com.wh.aop.conifg.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        IHello helloImpl = (IHello) ac.getBean("helloImpl");
        helloImpl.hello();
    }
    }
    
