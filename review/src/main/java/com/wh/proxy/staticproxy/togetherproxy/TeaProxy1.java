package com.wh.proxy.staticproxy.togetherproxy;

import com.wh.proxy.staticproxy.ISale;
import com.wh.proxy.staticproxy.SaleMan;

public class TeaProxy1 extends SaleMan {
    private ISale saleMan;

    public TeaProxy1(ISale saleMan) {
        this.saleMan= saleMan;
    }

    @Override
    public void sale() {
        tea();
       saleMan.sale();
    }

    public void tea(){
        System.out.println("喝茶");
    }
}
