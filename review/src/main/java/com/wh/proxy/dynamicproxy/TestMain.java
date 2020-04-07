package com.wh.proxy.dynamicproxy;

import org.junit.Test;

public class TestMain {

    @Test
    public void test1(){
        IHello hello = new HelloImpl();

        ProxyHandler proxyHandler = new ProxyHandler(hello);

        IHello proxy= (IHello) proxyHandler.getProxy();
        proxy.hello();
    }

    /**
     * continue的使用
     * 如果continue跳出 继续从头开始执行，continue下的不用执行了
     */
    @Test
    public void test2(){
        int i=0;
        while (i<5){
            i++;
            if (i==3){
                continue;
            }
            System.out.println(i);

        }
    }
}
