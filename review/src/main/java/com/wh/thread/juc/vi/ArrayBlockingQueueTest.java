package com.wh.thread.juc.vi;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueTest {
    public static void main(String[] args) {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(1);
        Data data = new Data();
        data.fun1(arrayBlockingQueue);
    }


}
class Data{
    /**
     * 用add 超出容量，       remove 为0时 会抛出异常        element() 查看队首 为0时，也会抛出异常 .
     * Queue full            NoSuchElementException       NoSuchElementException
     *
     */
    public void fun1(ArrayBlockingQueue ab){
        System.out.println(ab.add("a"));
        System.out.println(ab.add("b"));

//
//        System.out.println(ab.remove());
//        System.out.println(ab.remove());
//
        System.out.println(ab.element());

    }
}
