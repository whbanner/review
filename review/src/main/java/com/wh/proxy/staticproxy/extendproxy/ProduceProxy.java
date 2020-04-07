package com.wh.proxy.staticproxy.extendproxy;

import com.wh.proxy.staticproxy.SaleMan;

public class ProduceProxy extends SaleMan {
    @Override
    public void sale() {
        produce();
        super.sale();
    }
    public void produce(){
        System.out.println("介绍");
    }
}
