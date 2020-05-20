package adapter2;

/**
 * 苹果充电器
 */
public class AppleCharger implements ICharger{
    @Override
    public void charge() {
        System.out.println("给苹果手机充电");
    }
}
