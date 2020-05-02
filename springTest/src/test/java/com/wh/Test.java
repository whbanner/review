package com.wh;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 可以发现第一种调用会空指针
 * 因为你没有给IOC分配内存(也就是没new)
 *
 * 而将person加上@Component
 * 在别的类中使用他 只要Person p 加上@Autowired 初始化交给了ioc容器
 * 我门就可以通过初始化ioc容器的方式 拿到一个对象 里面用到了person
 * person就不许要我们来new了
 * ioc容器帮我们来new
 */
public class Test {
    public static void main(String[] args) {
//        new TestNoIOC().fun1(); //   1
        AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfig.class);
        TestNoIOC2 tc2 = (TestNoIOC2) ac.getBean("testNoIOC2"); //如果@Component没取名 默认该类首字小写
        tc2.fun1();
    }

}
