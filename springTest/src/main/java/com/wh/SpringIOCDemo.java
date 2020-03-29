package com.wh;

import com.wh.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.DispatcherServlet;

@Component
public class SpringIOCDemo {
    public static void main(String[] args) {
        DispatcherServlet a = new DispatcherServlet();
        ApplicationContext ac = new ClassPathXmlApplicationContext();
//        ApplicationContext ac = new AnnotationConfigApplicationContext(Person.class);
        Person p= (Person) ac.getBean("person");
        p.setName("wh");
        p.setAge(22);
        p.speak();


    }

}


