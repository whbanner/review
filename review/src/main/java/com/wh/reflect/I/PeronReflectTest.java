package com.wh.reflect.I;

import com.wh.reflect.entity.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PeronReflectTest {


    @Test
    public void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String classname = "com.wh.reflect.entity.Person";
        Class clazz = Class.forName(classname);
        System.out.println(clazz);
        /**
         * 通过newinstance得到的方法 不能访问static 和private 方法
         */
        Person p = (Person) clazz.newInstance();


        //无参构造
        Constructor constructor = clazz.getConstructor();
        Object o = constructor.newInstance();
        Person pp= (Person) o;
        pp.fun1();

        //获取所有的公共方法，包括Static，和父类的,Object,和SuperPerson
        Method[] methods = clazz.getMethods();
//        for (Method m:methods) {
//            System.out.println(m);
//        }

        //获取所有私有方法 不包括其父类，因为私有方法无法继承
        Method[] methods1 = clazz.getDeclaredMethods();
//        for (Method m:methods1) {
//            System.out.println(m);
//        }

        //获取普通的无参方法
        Method m1 = clazz.getMethod("fun1", null);
        System.out.println(m1);
        //获取普通的有参方法
        Method m2 = clazz.getMethod("fun2", String.class);
        System.out.println(m2);
        //也可同样获得static方法
        Method m3 = clazz.getMethod("fun4", null);
        System.out.println(m3);
        //私有方法
        Method m4 = clazz.getDeclaredMethod("fun5", null);
        System.out.println(m4);
        //获取可变参方法
        Method m5 = clazz.getMethod("fun3", String[].class);
        System.out.println(m5);

        //私有构造方法要消除权限
        m4.setAccessible(true);
        m4.invoke(p, null);

        m2.invoke(p, "xx");
        //调用可变参方法 
        m5.invoke(p, new Object[]{new String[]{"xx", "x2"}});
    }

     //反射字段
    @Test
    public void test2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
           String classname = "com.wh.reflect.entity.Person";
           Class clazz = Class.forName(classname);
           Object obj = clazz.newInstance();

           //获取私有字段
            Field ageField =clazz.getDeclaredField("age");
           //暴力访问私有字段
            ageField.setAccessible(true);
            ageField.set(obj,11);

        System.out.println(ageField.get(obj));
        Person p= (Person)obj;
        System.out.println(p.getAge());
    }
}
