package com.wh.singleton;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class TestSingleton {
    @Test
    public void test1() throws InterruptedException {
        Set<SingletonTest1> set = new HashSet<SingletonTest1>();

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> set.add(SingletonTest1.getInstance())).start();
        }

        Thread.sleep(10000);

        for (SingletonTest1 singletonTest2s : set) {
            System.out.println(singletonTest2s);
        }
    }
}
