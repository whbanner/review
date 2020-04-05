package com.wh.reflect.II;

public class Mouse implements IUSB{
    @Override
    public void connection() {
        System.out.println("Mouse连接中");
    }

    @Override
    public void use() {
        System.out.println("Mouse使用中");
    }
}
