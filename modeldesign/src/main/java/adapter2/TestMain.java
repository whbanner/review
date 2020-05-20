package adapter2;

import org.junit.Test;

/**
 * 传谁给谁充电
 */
public class TestMain {

    @Test
    public void test1(){
        MultiChargerAdapter multiChargerAdapter = new MultiChargerAdapter(
                new AppleCharger());
        multiChargerAdapter.charge();

        MultiChargerAdapter multiChargerAdapter2 = new MultiChargerAdapter(
                new AndroidCharger());
        multiChargerAdapter2.charge();
    }
}
