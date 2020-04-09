package com.wh.proxy.dynamicproxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 为什么要有cglib
 * JDK动态动态代理，虽然简单，不过只可对接口进行代理
 */
public class CglibTest {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Hello.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("Before____hello");
                Object result = methodProxy.invokeSuper(o, objects);
                System.out.println("after____hello");

                return result;
            }
        });
        Hello h= (Hello) enhancer.create();
        h.sayHello();

    }
}
