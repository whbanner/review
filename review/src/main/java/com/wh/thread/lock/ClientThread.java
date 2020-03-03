package com.wh.thread.lock;

public class ClientThread implements Runnable {
     int tickets = 100;
    final static Object obj = new Object();

    @Override
    public void run() {

        while (tickets!=0){
            bugTickets();

        }


    }

    public String bugTickets() {
        if (tickets == 0) {
            return "没票了";
        }

        synchronized (obj) {
            if (tickets != 0) {
                tickets--;
                System.out.println(Thread.currentThread().getName() + "====还剩:" + tickets);
            } else return "购买失败";

        }

        return "购买成功";
    }

    public static void main(String[] args) {
        ClientThread ct = new ClientThread();
        Thread t1 = new Thread(ct, "售票员1");
        Thread t2 = new Thread(ct, "售票员2");
        t1.start();
        t2.start();
    }
}
