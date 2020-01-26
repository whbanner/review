package com.wh.thread;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class Contral extends Thread {
    public static CountDownLatch cdl;
    private HashMap<String, Thread> hashMap;

    Contral() {
    }

    public HashMap getHashMap() {
        return this.hashMap;
    }

    public void setHashMap(HashMap hashMap) {
        this.hashMap = hashMap;
    }

    public void run() {
        Set<String> keys = this.hashMap.keySet();
        int i = keys.size();
        cdl = new CountDownLatch(i);
        Iterator var3 = keys.iterator();

        while(var3.hasNext()) {
            String key = (String)var3.next();
            Thread t = (Thread)this.hashMap.get(key);
            System.out.println("aaaaaaaaaa" + key);
            t.start();
        }

        try {
            cdl.await();
        } catch (InterruptedException var6) {
            var6.printStackTrace();
        }

    }
}
