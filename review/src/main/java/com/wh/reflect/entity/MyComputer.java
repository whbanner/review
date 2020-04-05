package com.wh.reflect.entity;

import com.wh.reflect.II.IUSB;

public class MyComputer {

    public void useUSB(IUSB usb){
        if(usb!=null){
            usb.connection();
            usb.use();
        }
    }
}
