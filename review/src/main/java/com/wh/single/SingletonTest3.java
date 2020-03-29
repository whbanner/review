package com.wh.single;

/**
 * 双重验证
 */
public class SingletonTest3 {

    private volatile static SingletonTest3 SingletonDemo3;

    private SingletonTest3() {
    }

    public static SingletonTest3 newInstance() {
        if (SingletonDemo3 == null) {
            //如果竞争激烈 有两个空对象在这等待
            synchronized (SingletonTest3.class) {
                if (SingletonDemo3 == null) { //第二个进入如果不验证就又new了一次
                    SingletonDemo3 = new SingletonTest3();
                }
            }
        }
        return SingletonDemo3;
    }
}
