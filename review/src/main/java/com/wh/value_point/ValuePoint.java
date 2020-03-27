package com.wh.value_point;

/**
 * 值传递   基本类型 传值过去，对这个值操作不影响之前结果  包含string
 * 引用传递  非基本类型  传一个copy的指针，指针指向该对象内存地址，对这个 对象的操作，就是实际操作
 *
 *
 * String
 * 就算new一个String 传过去对他进行操作，还是只对值操作
 * Integer 也同样
 *
 */
public class ValuePoint {

    public void test1(int value,String a){

        value=20;
        a="b";
        System.out.println("test1:"+value+"==="+a);
    }

    public void test2(Data data,String str){

        data.value=200;
        str="b";
        System.out.println("test2:"+data.value+"==="+str);
    }

    public void test3(Data data){
        //指向另一块内存，对该内存操作，不是对传入的data进行操作
        data = new Data();
        data.value=200;
        System.out.println("test2:"+data.value);
    }

    public static void main(String[] args) {

        //基本数据类型
        int value=10;
        String a="a";
        ValuePoint vp = new ValuePoint();
        vp.test1(value,a);
        System.out.println("mian:"+value+"==="+a);

//        非基本数据类型
//        ValuePoint vp = new ValuePoint();
//        Data data = new Data();
        String str=new String("a");
//        System.out.println(str=="a");
//        data.value=10;
//        vp.test2(data,str);
//        System.out.println("mian:"+data.value+"==="+str);

//        ValuePoint vp = new ValuePoint();
//        Data data = new Data();
//        data.value=10;
//        vp.test3(data);
//        System.out.println("mian:"+data.value);
    }

}


class Data{
    int value=0;
    String str=null;
}