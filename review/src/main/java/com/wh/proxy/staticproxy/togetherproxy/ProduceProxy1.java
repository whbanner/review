package com.wh.proxy.staticproxy.togetherproxy;

import com.wh.proxy.staticproxy.ISale;
import com.wh.proxy.staticproxy.SaleMan;

public class ProduceProxy1 extends SaleMan {
    private ISale saleMan;

    public ProduceProxy1(ISale saleMan) {
        this.saleMan= saleMan;
    }

    @Override
    public void sale() {
       produce();
       saleMan.sale();
    }

    public void produce(){
        System.out.println("介绍");
    }
}
