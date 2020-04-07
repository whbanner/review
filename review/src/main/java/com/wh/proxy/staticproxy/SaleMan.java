package com.wh.proxy.staticproxy;

/**
 * 被代理对象
 */
public class SaleMan implements ISale{
    @Override
    public void sale() {
        System.out.println("卖房");
    }
}
