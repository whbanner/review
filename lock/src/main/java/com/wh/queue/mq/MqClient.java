package com.wh.queue.mq;

public class MqClient {

    public void produce(String str){
        System.out.println(str);
    }
    public String consume(){
        System.out.println("consume");
        return "consume";
    }
}
