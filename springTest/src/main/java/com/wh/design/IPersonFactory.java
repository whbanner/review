package com.wh.design;

/**
 * 让类实例化推迟到子类
 * 符合开闭原则，可以直接添加别的工厂
 *
 * 缺点：类个个数太多，复杂
 * 关系多，不易理解
 */
interface Icourse{
    void say();
}

class JavaCourse implements Icourse{


    @Override
    public void say() {
        System.out.println("java");
    }
}

class GoCourse implements Icourse{


    @Override
    public void say() {
        System.out.println("GO");
    }
}

interface ICourseFactory{
    Icourse create();
}

class JavaCourseFactory implements ICourseFactory{

    @Override
    public Icourse create() {
        return new JavaCourse();
    }
}
class GoCourseFactory implements ICourseFactory{

    @Override
    public Icourse create() {
        return new GoCourse();
    }
}

class Test1{
    public static void main(String[] args) {

        ICourseFactory javaCourseFactory = new JavaCourseFactory();
        Icourse javaCourse = javaCourseFactory.create();
        javaCourse.say();
    }
}
