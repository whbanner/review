package facade;

import org.junit.Test;

public class MainTest {

    @Test
    public void test1(){
        SuperPhone phone=new SuperPhone();
        phone.callPhone();
        phone.sendMessage();
        phone.takePicture();
    }
}
