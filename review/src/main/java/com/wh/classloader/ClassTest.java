package com.wh.classloader;

public class ClassTest {
    public static void main(String[] args) {

        //1.用子类调用父类的静态变量发现 父类初始化了
//        System.out.println(SubClass.superValue);
        //2.用子类调用父类的final修饰的静态变量 父类没有初始化
//        System.out.println(SubClass.superFvalue);
        //发现new数组的时候静块也没有触发，数组是又JVM创建的，并不是类加载器
//        SuperClass scc = new SuperClass();
        SuperClass[] sc = new SuperClass[10];
    }
}
