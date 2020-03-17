package com.wh.thread.juc.unsafe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListTest {
    public static void main(String[] args) {
//        List<String> list= Arrays.asList("1","2","3");
//        list.forEach(System.out::println);

        List<String> list= new ArrayList<>();
//        List<String> list=new CopyOnWriteArrayList<>();
        for (int i=0;i<30;i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString());

        for (String x:list
             ) {
            System.out.println(x);
        }
            },String.valueOf(i)).start();

        }

        //1.8语法
//        list.forEach(System.out::println);


    }
}
