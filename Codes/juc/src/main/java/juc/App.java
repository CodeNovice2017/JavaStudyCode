package juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");

        // testSingletonDemo();

        for (int i = 0; i < 10; i++) {
            new Thread(()->SingletonDemo.getInstance(),String.valueOf(i)).start();
        }
    }

    // 单例模式测试
    static void testSingletonDemo(){
        // 这里的 == 是比较内存地址
        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
    }

    // 原子类AtomicInteger测试
    static void atomicIntegerTest(){
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.compareAndSet(5, 2020);
    }
}
