package com.wh.queue.mq;

public class ProduceClient {
    public static void main(String[] args) throws Exception {
        MqClient client = new MqClient();
        client.produce("SEND:Hello World");
    }
}

class ConsumeClient {
    public static void main(String[] args) throws Exception {
        MqClient client = new MqClient();
        String message = client.consume();
        System.out.println("获取的消息为：" + message);
    }
}
