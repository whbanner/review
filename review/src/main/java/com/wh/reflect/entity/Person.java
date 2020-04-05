package com.wh.reflect.entity;

import com.wh.reflect.I.SuperPerson;

public class Person extends SuperPerson {
    private String name;
    private int age;

    public Person() {
        System.out.println("无参构造");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void fun1(){
        System.out.println("普通方法");
    }
    public void fun2(String str){
        System.out.println("普通有参方法");
    }

    public void fun3(String ...str){
        System.out.println("普通可变参方法");
    }
    public static void fun4(){
        System.out.println("静态方法");
    }
    private void fun5(){
        System.out.println("普通私有方法");
    }



}
