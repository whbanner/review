package com.wh.proxy.dynamicproxy;

import org.junit.Test;

/**
 * 静态代理 需要new具体的代理类，然后用代理类去调用
 * 而动态代理 你只要传入你需要被代理的类，之后proxyhandler 来具体实现来决定。
 * 隐藏了代理类的细节，不知道具体的代理类
 */
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
