package com.wh.classloader;

public class SubClass extends SuperClass{
    static {
        System.out.println("subclass init");
    }
    public final static int subFvalue=1111;
    public static int subvalue=2222;

}
