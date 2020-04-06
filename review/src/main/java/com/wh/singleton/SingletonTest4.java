package com.wh.singleton;

/**
 * 静态内部类
 * 初始化一个类时会先调用<clinit>()类构造器
 * 虚拟机在多个线程对同个未初始化的类访问时，
 * 保证只有一个类去调用此构造器去初始化，其他线程处于阻塞状态，
 * 最终结果 其他线程在访问此内部类是发现他已经初始化，所以可以直接拿到这个实例。不用重新初始化
 */
public class SingletonTest4 {

    private static class innerClass{
        private static final SingletonTest4  singletonTest4=new SingletonTest4();
    }

    private static SingletonTest4 getInstance(){
        return innerClass.singletonTest4;
    }
    //序列化时会破坏单例，这个意思就是把序列化的对象丢弃，拿到我们指定的对象。
    public Object readResolve() {
        return innerClass.singletonTest4;
    }

}
