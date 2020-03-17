package com.wh.thread.juc.xi;

import lombok.Synchronized;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * 1.为什么不直接把synchronized加在方法上，不是更简单吗?
 * 如果加在同步方法上，每个线程都会抢锁在判断，因为只有一个new对象机会,其他进入也是白搭，会造成资源浪费
 * 而双重检测锁模式，先判断在去拿锁，避免不必要的抢锁，造成资源浪费
 *
 * 2.这里为什么用双重检测锁模式，判断两次
 * 若2线程判断lazyMan为nul,都会进入第一重if循环,此时线程1拿到锁进入并new了个对象在释放锁
 * 如果没有第二重if判断，线程2同样拿到锁 也会进入并又new了个对象
 */
public class LazyMan {
    //解决两次都用放射会的构造方法
    private boolean wh=false;

    //私有构造方法
    private LazyMan(){
        System.out.println(Thread.currentThread().getName());
        synchronized (LazyMan.class){
            if(wh=false){
                wh=true;
            }else {
                throw new RuntimeException("不要试图用反射破坏");
            }
//            if(lazyMan!=null){
//  throw new RuntimeException("不要试图用反射破坏");
//            }
        }

    }
    private volatile static  LazyMan lazyMan;
    //单线程下是安全的
    public static LazyMan getInstance(){
        //双重检测锁模式的单例 简称DCL懒汉式单例
        if (lazyMan==null){
            synchronized (LazyMan.class){
                if(lazyMan==null){
                    lazyMan=new LazyMan();
                    /**
                     * new lazyMan()不是原子操作
                     * 1.开辟一块空间
                     * 2.执行构造方法初始化这个对象
                     * 3,把这个对象指针指向这块空间
                     *
                     * 应为cpu指令重排 可能先1,3
                     * 而此时另一个线程进入 因为判断lazy！=null 直接执行return，此时是空间是空的，会出错
                     * 所有加上voliate禁止指令重排
                     */
                }
            }
        }

        return lazyMan;
    }

    public static void main(String[] args) throws Exception {
//        for (int i = 0; i <10 ; i++) {
//            new Thread(()->{
//                LazyMan.getInstance();
//            }).start();
//
//        }
//        LazyMan lm1=LazyMan.getInstance();
        //用反射获得该对象
        Constructor<LazyMan> constructor=LazyMan.class.getDeclaredConstructor();
        //设置权限，破坏私有构造方法
        constructor.setAccessible(true);
        LazyMan lm1=constructor.newInstance();

        Field wh = LazyMan.class.getDeclaredField("wh");
        wh.setAccessible(true);
        wh.set(lm1,false);

        LazyMan lm2=constructor.newInstance();
        System.out.println(lm1);
        System.out.println(lm2);


    }
}
