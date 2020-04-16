package com.wh.socket.i;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.net.Socket;
import java.util.ArrayList;

public class SocketClientTest {

    public static void main(String[] args) throws IOException {
        //创一个socket 与localhost 9999进行连接
        Socket socket = new Socket("localhost",9999);
        //连接成功后发数据
        OutputStream outputStream = socket.getOutputStream();
        String message="hello";
        //发数据 规定为UTF8
        outputStream.write(message.getBytes("UTF-8"));
        //告诉Server端 已经发完了 此后只可以接受数据。
        socket.shutdownOutput();

        InputStream inputStream=socket.getInputStream();
        byte[] bytes = new byte[1024];

        StringBuilder sb = new StringBuilder();
        int len;
        //一次最多读1024个字节的数据，并放到到byte里
        while ((len=inputStream.read(bytes))!=-1){
            sb.append(new String(bytes,0,len,"UTF-8"));
        }
        System.out.println("client receive message:"+sb);

        outputStream.close();
        inputStream.close();
        socket.close();
    }

}
