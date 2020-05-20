package adapter;
//真正适配器 连接网线，连接usbAdapter
public class Adapter extends Adaptee implements NetToUsb {

    @Override
    public void handlerRequest() {
            super.request();
    }
}
