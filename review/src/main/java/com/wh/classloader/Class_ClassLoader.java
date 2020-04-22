package com.wh.classloader;

/**
 * 通过例子可以看出 .Class只有一个（称为模板） 只要是Car的实例hashcode都与Car.class一样
 * 而new出来的实例有多个 hashcode都不一样
 */
public class Class_ClassLoader {

    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car();
        System.out.println(car1.hashCode());  //951007336
        System.out.println(car2.hashCode());  //2001049719
        //后面3个都是1528902577
        System.out.println(car1.getClass().hashCode());
        System.out.println(car2.getClass().hashCode());
        System.out.println(Car.class.hashCode());
        //得到Car的classloader
        ClassLoader classLoader1 = car1.getClass().getClassLoader();
        System.out.println(classLoader1); //sun.misc.Launcher$AppClassLoader@18b4aac2
        //得到Car父类的classloader
        ClassLoader parent = classLoader1.getParent();
        System.out.println(parent); //sun.misc.Launcher$ExtClassLoader@72ea2f77
        //得到Car父类的父类的classloader
        System.out.println(parent.getParent()); //null java获得不到Bootstrap C写的

    }

}
class Car{
    int age;
}
