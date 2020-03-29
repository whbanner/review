package com.wh.classloader;

public class SuperClass {
    static {
        System.out.println("父类superclass init");
    }
    public static int superValue=1;
    public final static int superFvalue=2;
}

