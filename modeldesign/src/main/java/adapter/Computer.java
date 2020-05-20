package adapter;
//客户端 想上网 不过插不了网线
public class Computer {
    //电脑连接上转接器才可以上网
    public void net(NetToUsb ad){
        //上网的具体实现找一个转接头
        ad.handlerRequest();
    }
}
