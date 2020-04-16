package com.wh.socket.ii;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;

/**
 * 对应reactor模型  事件
 * 先来个Selector是总管理员
 * 之后在来个ServerSocketChannel ssc
 * ssc可以调用.socket 拿到Serversocket实例,让ServerSocket 去监听 ip端口
 */
public class NioServerSocket {
    private final String HOSTNAME ="127.0.0.1";
    private final int PORT=10000;
    private Selector selector=null;
    public void init() throws IOException {
        //得到Selector实例
        selector = Selector.open();
        //得到ServerSocketChannel实例
        ServerSocketChannel server = ServerSocketChannel.open();
        //得到ip地址
        InetSocketAddress address = new InetSocketAddress(HOSTNAME,PORT);
        //SKCHANNEL.socket()得到Serversocket实例，让他去监听ip端口
        server.socket().bind(address);
        //设置非阻塞
        server.configureBlocking(false);
        //注册到Selector上
        server.register(selector, SelectionKey.OP_ACCEPT);
        while(selector.select()>0){
            //依次处理selector中每个selectionkey
            for (SelectionKey sk:selector.selectedKeys()) {
                //将拿到的selectionkey从set中除去
                selector.selectedKeys().remove(sk);

                if (sk.isAcceptable()){
                    //拿到socketchannel
                    SocketChannel sc = server.accept();
                    sc.configureBlocking(false);
                    sc.register(selector,SelectionKey.OP_READ);
                    //并将socketchannel也注册到selector
                }
                //如果sk对应的channel中有数据可读
                if (sk.isReadable()) {

                    SocketChannel sc=(SocketChannel)sk.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);

                    StringBuilder content= new StringBuilder();
                    try{
                        //开始读数据
                        while (sc.read(buffer)>0){
                            buffer.flip();
                            content.append(StandardCharsets.UTF_8.decode(buffer));
                        }
                        // 打印从该sk对应的Channel里读取到的数据
                        System.out.println("Server:" +content);
                        //该sk对应的channel如果出现异常
                    }catch (IOException ex){
                        //从Selector中删除，不然之后遍历到他还是会抛异常
                        sk.cancel();
                        if (sk.channel()!=null){
                            //sk出现了异常 sk对应的channel出现了异常
                            // 表明client也出现了异常
                            sk.channel().close();
                        }
                    }
                        //如果消息不为空，发送给所有的对应的所有socketchannel
                    if(content.length()>0){
                        for (SelectionKey sk2:selector.selectedKeys()) {
                            //获取sk2对象的channel
                           Channel targetChannel=sk2.channel();
                           //判断这些channel是不是sokcetchannel
                            // 如果是将数据写入
                            if (targetChannel instanceof SocketChannel){
                                SocketChannel dest = (SocketChannel) targetChannel;
                                //之前已经filp过
                                dest.write(StandardCharsets.UTF_8.encode(content.toString()));
                            }
                        }
                    }

                }



            }
        }

    }

    public static void main(String[] args) throws IOException {
            new NioServerSocket().init();
    }
}
