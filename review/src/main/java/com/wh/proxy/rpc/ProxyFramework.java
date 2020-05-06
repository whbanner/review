package com.wh.proxy.rpc;

import com.wh.proxy.dynamicproxy.ProxyHandler;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;

public class ProxyFramework {
    //暴露服务 让客户端知道去哪个ip，端口下去请求 可得到想要的内容  4S点提车
    public static void export(final Object service,int port) throws IOException  {
        if(service==null){
            throw new IllegalArgumentException("no service");
        }
        if (port<0||port>65535){
            throw new IllegalArgumentException("Invalid port"+port);
        }

        System.out.println("service:"+service.getClass().getName()+"port:"+port);

        ServerSocket serverSocket = new ServerSocket(port);
        //不断去接受请求
        while (true){
            Socket accept = serverSocket.accept();
            //input接受请求
            InputStream inputStream = accept.getInputStream();
            //inputstream是二进制字节流，用Object包装一下
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            //通过ObjectInputStream方法 拿到方法名 读到的string就是传过来为string类型的方法名
            String methedName = objectInputStream.readUTF();

            //写回去
            OutputStream outputStream = accept.getOutputStream();
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);


            try{

                //参数类型
                Class<?>[] paramTypes = (Class<?>[])objectInputStream.readObject();
                //具体参数值
                Object[] args = (Object[]) objectInputStream.readObject();
                //找到service这个类，在找里面的方法（方法名+参数类型）
                Method method = service.getClass().getMethod(methedName, paramTypes);
                //调用这个方法
                Object invoke = method.invoke(service, args);

                //将invoke后的结果返回到客户端
                objectOutputStream.writeObject(invoke);
                //将写入Stream的消息flush到socket中，发送
                objectOutputStream.flush();

            }catch (Throwable throwable){
                throwable.printStackTrace();

            }finally {

                objectOutputStream.close();
                objectInputStream.close();

            }

        }
    }
    @SuppressWarnings("unchecked")
    //客户端真正调用的地方（拿到相应的实例对象 调用他具体的方法）   4s店给用户交车
    public static <T> T refer(final Class<T> interfaceClass,final String host,final int port){
        if(interfaceClass==null){
            throw new IllegalArgumentException("interface is null");
        }
        //JDK的动态代理必须是接口
        if (!interfaceClass.isInterface()){
            throw new IllegalArgumentException("The" + interfaceClass.getName() + "must be interface");
        }
        if (host==null||host.length()==0){
            throw new IllegalArgumentException("host is null");
        }
        if (port<0||port>65535){
            throw new IllegalArgumentException("Invalid port"+port);
        }
        System.out.println("Get Remote Service:"+interfaceClass.getName());
        //代理传过来的接口，再将方法名 参数类型，参数值，用socket发送给上面的export()方法
        return (T)Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket socket=new Socket(host, port);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeUTF(method.getName());
                objectOutputStream.writeObject(method.getParameterTypes());
                objectOutputStream.writeObject(args);
                objectOutputStream.flush();

                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                //对象上面方法的invoke调用结果 读取过来
                Object invoke = objectInputStream.readObject();

                return invoke;
            }
        });

    }
}
