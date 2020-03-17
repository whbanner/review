package com.wh.thread.juc.viii;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * 函数型接口 工具类
 * 只要是函数式 都可以用lambda表达式
 */
public class FunctionInterfaceTest {
    public static void main(String[] args) {
        FunctionInterfaceTest functionInterfaceTest = new FunctionInterfaceTest();
        System.out.println(functionInterfaceTest.fun4());


    }

    /**
     * 1.函数接口  Function接口
     * 有一个输入参数和一个返回值
     */
    public void fun1() {

        Function f = new Function<String, String>() {
            @Override
            public String apply(String o) {
                String str = o + "123";
                return str;
            }
        };
        System.out.println(f.apply("abc"));

        Function<Integer, String> f1 = (str) -> {
            String str1 = str + "123";
            return str1;
        };
        System.out.println(f1.apply(123));
    }

    /**
     * 2.断定式接口(也是函数式接口) Predicate
     * 有一个输入参数，返回值是boolean类型
     * eg.判断字符串 是否为空
     */
    public void fun2() {
        Predicate<String> p = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                Boolean f = false;
                if (s == null) {
                    f = true;
                }
                return f;
            }
        };
        Predicate<String> p1 = (str1) -> {

            return str1.isEmpty();
        };
        String ss = "";
        System.out.println(p1.test(ss));

    }

    /**
     *Consumer 消费型接口
     * 只有输入参数 没有返回值
     */
    public void fun3(){
        Consumer<String> consumer=new Consumer<String>(){

            @Override
            public void accept(String s) {
                System.out.println("我消费了"+s);
            }
        };

        consumer.accept("abc");

        Consumer<String> consumer1=(str)->{
            System.out.println("我也消费了"+str);
        };
        consumer1.accept("efg");
    }

    /**
     * 供给型接口Supplier
     *没有入参，只有返回值
     */
    public String fun4(){
        Supplier<String>  supplier=()->{
            String str = "abc";
            System.out.println("我造了一个===="+str);
            return str;
        };

        String s=supplier.get();
        return s;
    }
}
