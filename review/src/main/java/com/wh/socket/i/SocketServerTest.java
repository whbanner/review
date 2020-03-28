package com.wh.socket.i;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerTest {
    public static void main(String[] args) throws IOException {
        //创一个ServerSocket 去监听9999端口
        int port=9999;
        ServerSocket server = new ServerSocket(port);
        //等待连接到来，并创一个sokcet实例并与client通讯
        Socket socket =server.accept();
        //取到Client端数据
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        //一次读1024字节数据
        while ((len=inputStream.read(bytes))!=-1){
            sb.append(new String(bytes,0,len,"UTF-8"));
        }


        System.out.println("Server receive message:"+sb);

        OutputStream outputStream = socket.getOutputStream();
        sb.append("===you message");
        //发数据 规定为UTF8
        outputStream.write(sb.toString().getBytes("UTF-8"));
        //告诉Client端 已经发完了 此后只可以接受数据。
        socket.shutdownOutput();

        outputStream.close();
        inputStream.close();
        socket.close();
        server.close();

    }
}
