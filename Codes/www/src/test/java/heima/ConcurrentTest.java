package heima;

import org.junit.jupiter.api.Test;

public class ConcurrentTest {

    /**
     * 多线程面试题目笔记理解示例测试
     */
    @Test
    void test1(){
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
    class MyThread2 implements Runnable{
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
    void test2() throws InterruptedException{
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run(){
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
}
