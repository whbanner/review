package com.wh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component()
public class TestNoIOC2 {
    @Autowired
    Person p;

    public void fun1(){
        p.setAge(10);
        int age = p.getAge();
        System.out.println(age);
    }


}
