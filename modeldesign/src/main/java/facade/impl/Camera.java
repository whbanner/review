package facade.impl;

import facade.ICamera;

public class Camera implements ICamera {
    @Override
    public void takePicture() {
        System.out.println("拍照片");
    }
}
