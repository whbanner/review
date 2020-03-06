package com.wh.annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * 若一个类过时就加上@Deprecated，意思是该类是危险的，或者有更好的类代替了
 * 对方法，变量也可
 */
// 关闭整个类里的编译器警告
@SuppressWarnings("all")
public class DeprecatedTest {

    public static void main(String[] args) {
        //如果list没被使用 会出现警告 现在没有了
        List list = new ArrayList();


    }
}

@Deprecated
class Person1 {
    @Deprecated
    public void fun1() {

    }

    @Deprecated
    public int i;

}

