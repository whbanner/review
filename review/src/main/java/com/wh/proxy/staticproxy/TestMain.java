package com.wh.proxy.staticproxy;



import com.wh.proxy.staticproxy.extendproxy.ProduceProxy;
import com.wh.proxy.staticproxy.extendproxy.TeaProduceProxy;
import com.wh.proxy.staticproxy.extendproxy.TeaProxy;
import com.wh.proxy.staticproxy.togetherproxy.ProduceProxy1;
import com.wh.proxy.staticproxy.togetherproxy.TeaProxy1;
import org.junit.Test;

public class TestMain {

    @Test
    public void test1(){
        ProduceProxy produceProxy = new ProduceProxy();
        TeaProxy teaProxy=new TeaProxy();
        produceProxy.sale();
        System.out.println("========");
        /**
         *  在介绍前喝茶 得重写一个代理类继承ProduceProxy ,在喝茶前介绍，顺序颠倒了也要重写写一个代理类。
         */

        TeaProduceProxy teaProduceProxy=new TeaProduceProxy();
        teaProduceProxy.sale();
        System.out.println("========");
        /**
         * 当多一个逻辑时,喝茶,介绍，详谈，只需要在写一个详谈就好了，顺序颠倒不用再重新写。
         * 聚合式更加灵活
         */
        ProduceProxy1 produceProxy1=new ProduceProxy1(new SaleMan());
        TeaProxy1 teaProxy1=new TeaProxy1(produceProxy1);
        teaProxy1.sale();
    }
}
