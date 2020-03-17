package com.wh.thread.juc.v;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * 读共享，写独占
 */
public class ReadWriteLockTest {
    public static void main(String[] args) {
        Mycache mycache = new Mycache();
        for (int i = 1; i <= 5; i++) {
            int temp = i;
            new Thread(() -> {
                mycache.put(temp + "", temp + "");
            }, String.valueOf(i)).start();
        }

        for (int i = 1; i <= 5; i++) {
            int temp = i;
            new Thread(() -> {
                mycache.get(temp + "");
            }, String.valueOf(i)).start();
        }
    }

}

class Mycache {
    Map map = new HashMap<String, String>();
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    //写入
    public void put(String key, String value) {
        readWriteLock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + "写入" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写入ok");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }


    //读取
    public void get(String key) {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "读出" + key);
            map.get(key);
            System.out.println(Thread.currentThread().getName() + "读出ok");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            readWriteLock.readLock().unlock();
        }

    }
}
