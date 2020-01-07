package com.wh;


import com.wh.config.ConsumerConfig;
import com.wh.consumeraction.ConsumerAction;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Consumer2 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfig.class);
        context.start();
        ConsumerAction annotationAction = (ConsumerAction) context.getBean("consumerAction");
        System.out.println(annotationAction.doSayHello("jw"));
    }
}
