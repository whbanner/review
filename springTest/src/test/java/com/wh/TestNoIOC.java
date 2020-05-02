package com.wh;


public class TestNoIOC {
    Person p;

    public void fun1(){
        p.setAge(10);
        int age = p.getAge();
        System.out.println(age);
    }


}
