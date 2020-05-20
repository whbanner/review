package adapter;

public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer();//电脑
        Adaptee adaptee=new Adaptee();//网线
//        Adapter adapter= new Adapter();//转接器
        Adapter2 adapter2 = new Adapter2(adaptee);
        //电脑上网需要一个转接器
        computer.net(adapter2);


    }
}
