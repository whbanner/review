package com.wh.proxy.staticproxy.extendproxy;

public class TeaProduceProxy extends ProduceProxy {
    @Override
    public void sale() {
        tea();
        super.sale();
    }

    public void tea(){
        System.out.println("tea");
    }
}
