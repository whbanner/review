package com.wh;

import com.wh.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SpringIOCDemo {
    public static void main(String[] args) {

        ApplicationContext ac = new AnnotationConfigApplicationContext(Person.class);
        Person p= (Person) ac.getBean("person");
        p.setName("wh");
        p.setAge(22);
        p.speak();
    }
}
