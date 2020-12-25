package heima;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.Test;

public class ConcurrentTest {

    /**
     * 多线程面试题目笔记理解示例测试
     */
    @Test
    void test1() {
        // 这种就是完全错误的方式,因为这是创建了两个线程对象,自然而然的各自都有一个ticket
        // new MyThread().start();
        // new MyThread().start();

        MyThread myThread1 = new MyThread();
        MyThread2 myThread2 = new MyThread2();

        new Thread(myThread1).start();
        new Thread(myThread1).start();

        new Thread(myThread2).start();
        new Thread(myThread2).start();

    }

    class MyThread extends Thread {
        private int ticket = 5;

        public void run() {
            while (true) {
                System.out.println("Thread ticket = " + ticket--);
                if (ticket < 0) {
                    break;
                }
            }
        }
    }

    class MyThread2 implements Runnable {
        private int ticket = 5;

        public void run() {
            while (true) {
                System.out.println("Runnable ticket = " + ticket--);
                if (ticket < 0) {
                    break;
                }
            }
        }
    }

    /**
     * 一道经典的面试题是让线程T1，T2，T3按顺序执行
     */
    @Test
    void test2() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1线程开始执行");
            }
        });
        t1.start();
        t1.join();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t2线程开始执行");
            }
        });
        t2.start();
        t2.join();
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t3线程开始执行");
            }
        });
        t3.start();
        t3.join();
    }

    /**
     * 基础线程机制 Executor
     */
    public class SynchronizedExample {
        public void func1() {
            synchronized (this) {
                for (int i = 0; i < 10; i++) {
                    System.out.print(i + " ");
                }
            }
        }

        public synchronized void func2(){
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        }
    }

    

    @Test
    void testExecutor() {

        /**
         * 同步一个代码块 
         * 它只作用于同一个对象，如果调用两个对象上的同步代码块，就不会进行同步。
         */
        // SynchronizedExample e1 = new SynchronizedExample();
        // ExecutorService executorService1 = Executors.newCachedThreadPool();
        // executorService1.execute(() -> e1.func1());
        // executorService1.execute(() -> e1.func1());
        // 两个线程进行同步

        /**
        * 同步一个方法
        */
        // SynchronizedExample e2 = new SynchronizedExample();
        // SynchronizedExample e3 = new SynchronizedExample();
        // ExecutorService executorService2= Executors.newCachedThreadPool();
        // executorService2.execute(() -> e2.func2());
        // executorService2.execute(() -> e3.func2());
        // 无需同步 交叉运行
        // 0 1 2 3 4 0 1 2 3 4 5 6 7 8 9 5 6 7 8 9

        

        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
