package facade;

import facade.impl.Camera;
import facade.impl.Phone;

/**
 * 外观模式
 * 有多个子系统 有不同的子功能
 * 当需要多个子功能  需要new多个类
 *
 * 通过一个类集成这些子系统的功能，这样在用户看来只需要new一个类
 * 就可以调用多个子系统的功能
 * 在用户看来，所有功能都由 superPhone这个类实现的一样
 */
public class SuperPhone {
    private Camera camera=new Camera();
    private Phone phone = new Phone();

    public void takePicture(){
        camera.takePicture();
    }

    public void sendMessage(){
        phone.sendMessage();
    }
    public void callPhone(){
        phone.callPhone();
    }
}
