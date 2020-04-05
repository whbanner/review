package com.wh.reflect.II;

public class KeyBoard implements IUSB {
    @Override
    public void connection() {
        System.out.println("KeyBoard 连接中");
    }

    @Override
    public void use() {
        System.out.println("KeyBoard 使用中");
    }
}
