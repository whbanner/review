package com.wh.proxy.staticproxy.extendproxy;

import com.wh.proxy.staticproxy.SaleMan;

public class TeaProxy extends SaleMan {
    @Override
    public void sale() {
        tea();
        super.sale();
    }

    public void tea(){
        System.out.println("喝茶");
    }
}
