package facade.impl;

import facade.IPhone;

public class Phone implements IPhone {
    @Override
    public void sendMessage() {
        System.out.println("发短信");
    }

    @Override
    public void callPhone() {
        System.out.println("打电话");
    }
}
