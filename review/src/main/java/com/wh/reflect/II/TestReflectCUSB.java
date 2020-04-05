package com.wh.reflect.II;

import com.wh.reflect.entity.MyComputer;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class TestReflectCUSB {
    @Test
    public void test() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyComputer mc = new MyComputer();

        File config = new File("/home/wh/worksapce/review1/review/src/main/java/com/wh/reflect/II/usb.properties");
        FileInputStream fis = new FileInputStream(config);
        Properties p = new Properties();
        p.load(fis);
        String className = p.getProperty("usb");
        Class<?> clasz = Class.forName(className);
        Object obj = clasz.newInstance();
        IUSB iusb = (IUSB) obj;
        mc.useUSB(iusb);
    }
}
