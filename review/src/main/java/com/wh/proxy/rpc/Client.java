package com.wh.proxy.rpc;

public class Client {

    public static void main(String[] args) {
//        HelloService service=new HelloServiceImpl();
//        service.hello();


        HelloService service1= ProxyFramework.refer(HelloService.class,"127.0.0.1",9999);
//        for (int i = 0; i <10000 ; i++) {
            service1.hello("hello");
//        }

    }

}
