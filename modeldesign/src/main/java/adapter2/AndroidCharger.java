package adapter2;

/**
 * 安卓充电器
 */
public class AndroidCharger implements ICharger{
    @Override
    public void charge() {
        System.out.println("给安卓手机充电");
    }
}
