package juc;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");

        // testSingletonDemo();

        // 单例模式测试
        // for (int i = 0; i < 10; i++) {
        //     new Thread(() -> SingletonDemo.getInstance(), String.valueOf(i)).start();
        // }

        reentrantLockTest();
    }

    // 单例模式测试
    static void testSingletonDemo() {
        // 这里的 == 是比较内存地址
        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
    }

    // 原子类AtomicInteger测试
    static void atomicIntegerTest() {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.compareAndSet(5, 2020);
    }

    // ReentrantLock可重入测试
    static void reentrantLockTest() {
        Phone phone = new Phone();
        new Thread(()->{
            phone.get();
        }, "t1").start();
        new Thread(() -> {
            phone.get();
        }, "t2").start();
        new Thread(() -> {
            phone.get();
        }, "t3").start();
    }
    // ReentrantLock可重入测试所需
    public static class Phone implements Runnable {

        private Lock lock = new ReentrantLock(false);

        public void get(){
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t get Lock");
                set();
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        }

        public void set() {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t set Lock");
            } finally {
                lock.unlock();
            }
        }

        @Override
        public void run() {
            get();
        }
    }

    // while循环 + compareAndSet实现自旋锁
    static void whileAndCASImplementsLock(){
        AtomicReference<Thread> atomicReference = new AtomicReference<>();
    }
}
