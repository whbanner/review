package com.wh.design;

import org.junit.Test;

/**
 * 简单工厂模式,
 * 将想创建的对象告诉工厂，由工厂创建
 * 适用于 工厂对象创建较少的情况，不需要关心怎么创对象
 * 不易扩展，功能比较杂接口中需要定义新的方法
 */
public class SimpleFactoryTest {
    public IPersonSpeak speak(String className){
        try {
            if(!(className==null||"".equals(className))){
                return (IPersonSpeak) Class.forName(className).newInstance();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
       return null;
    }
    @Test
    public void test(){
        SimpleFactoryTest simpleFactoryTest = new SimpleFactoryTest();
        IPersonSpeak student =simpleFactoryTest.speak("com.wh.design.Student");
        student.speak();
    }
}

interface IPersonSpeak{
    public void speak();
}

class Teacher implements IPersonSpeak{


    @Override
    public void speak() {
        System.out.println("i am teacher");
    }
}

class Student implements IPersonSpeak{

    @Override
    public void speak() {
        System.out.println("i am student");
    }
}