package com.wh.thread.lock.iii;

public class Test {
    int i=0;
    public static void main(String[] args) {
       new Test().fun1();
    }

    /**
     * javap -c 通过jvm指令码 看一下i=i+1经过几步原子操作
     */
    public void fun1(){
        i=i+1;
    }
}
