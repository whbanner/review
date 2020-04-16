package com.wh.socket.ii;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Scanner;

public class NioClientSocket {

    // 定义检测SocketChannel的Selector对象
    private Selector selector = null;
    // 客户端SocketChannel
    private SocketChannel sc = null;

    private final String HOSTNAME ="127.0.0.1";
    private final int PORT=10000;

    public void init() throws IOException {
        selector = Selector.open();
        InetSocketAddress isa = new InetSocketAddress(HOSTNAME,PORT);
        sc=SocketChannel.open(isa);
        sc.configureBlocking(false);
        int op = SelectionKey.OP_READ | SelectionKey.OP_WRITE;
        sc.register(selector,op);

        new ClientThread1().start();

        //起用键盘输入
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            //将键盘输入的内容 输入到socketchannel中
            sc.write(StandardCharsets.UTF_8.encode(line));
        }

    }

    private class ClientThread1 extends Thread{
        public void run() {

            try {
                    while (selector.select()>0){
                    //iterator 需要用集合.iterator
                    // selector.selectedKeys()返回一个集合
                    Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
                    while (iter.hasNext()){
                        SelectionKey sk=iter.next();
                        selector.selectedKeys().remove(sk);
                        //如果该sk对象的channel有数据可读
                        if (sk.isReadable()){
                            SocketChannel sc2 =(SocketChannel) sk.channel();
                            ByteBuffer buffer = ByteBuffer.allocate(1024);
                            String content = "";
                            while (sc2.read(buffer)>0){
                               sc2.read(buffer);
                                buffer.flip();
                                content+=StandardCharsets.UTF_8.decode(buffer);
                            }
                            System.out.println("聊天消息："+content);
                        }

                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new NioClientSocket().init();
    }
}
