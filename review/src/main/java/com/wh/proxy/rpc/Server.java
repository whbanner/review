package com.wh.proxy.rpc;

import java.io.IOException;

public class Server {

    public static void main(String[] args) throws IOException {
        HelloService service=new HelloServiceImpl();
        ProxyFramework.export(service,9999);
    }
}
