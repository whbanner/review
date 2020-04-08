

import java.util.concurrent.locks.ReentrantLock;

public class TestThis {
    /**
     * 如果只是一个对象，两个this.lock所用的锁是同一把锁;
     * 同一时间只能有一个线程 访问
     */
    ReentrantLock lock = new ReentrantLock();
    public void fun1(){
        ReentrantLock lock=this.lock;
        lock.lock();
        System.out.println(Thread.currentThread().getName()+"fun1");
    }

    public void fun2(){
        ReentrantLock lock=this.lock;
        lock.lock();
        System.out.println(Thread.currentThread().getName()+"fun2");
    }



    public static void main(String[] args) {
        TestThis testThis = new TestThis();
        new Thread(()->{
            testThis.fun1();
        }).start();
        new Thread(()->{
            testThis.fun2();
        }).start();
    }
}
