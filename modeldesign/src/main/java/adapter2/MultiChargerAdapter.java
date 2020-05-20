package adapter2;

/**
 * 万能充，真正的适配器(对象适配器)
 * 传谁给谁充电
 */
public class MultiChargerAdapter implements IChargerAdapter{
    private ICharger charger;

    public MultiChargerAdapter(ICharger charger) {
        this.charger = charger;
    }

    @Override
    public void charge() {
        charger.charge();
    }
}
