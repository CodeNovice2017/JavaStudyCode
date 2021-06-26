package juc;

import java.util.concurrent.*;
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

        // reentrantLockTest();

        // shareDataTest();

        // shareDataTest2();

        // ProducerAndConsumer3Test();

        // threadPoolTest();

        PrintOddAndEvenNumbersInOrder printOddAndEvenNumbersInOrder = new PrintOddAndEvenNumbersInOrder();
        new Thread(printOddAndEvenNumbersInOrder::printNumbers).start();
        new Thread(printOddAndEvenNumbersInOrder::printNumbers).start();

//        while(Thread.activeCount() > 2){
//            Thread.yield();
//        }

        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            for(int i = 0;i < 50;i++){
                System.out.println(i);
            }
            return 50;
        });
        new Thread(futureTask).start();
        try{
            System.out.println(futureTask.get());
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
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

    // 生产者 消费者模式2.0测试
    static void shareDataTest(){
        ShareData shareData = new ShareData();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                shareData.increment();
            },"生产者" + i).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                shareData.decrement();
            }, "消费者" + i).start();
        }
    }

    // 多线程按顺序执行
    static void shareDataTest2(){
        ShareData shareData = new ShareData();

        // 三个线程
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareData.printA();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareData.printB();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareData.printC();
            }
        }).start();
    }

    static void ProducerAndConsumer3Test(){
        ProducerAndConsumer3 producerAndConsumer3 = new ProducerAndConsumer3(new ArrayBlockingQueue<String>(10));
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 生产线程启动");
            System.out.println("");
            System.out.println("");
            try {
                producerAndConsumer3.myProducerProcess();
                System.out.println("");
                System.out.println("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "prod").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 消费线程启动");

            try {
                producerAndConsumer3.myConsumerProcess();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "consumer").start();

        // 让主线程睡眠,这样才能够在控制台看到输出
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("");
        System.out.println("");
        System.out.println("5秒中后，生产和消费线程停止，线程结束");
        producerAndConsumer3.stop();
    }

    static void threadPoolTest(){
        System.out.println(Runtime.getRuntime().availableProcessors());

        ExecutorService executorService = Executors.newCachedThreadPool();

        try {
            for (int i = 0; i < 10; i++) {
                executorService.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "开始执行任务");
                });
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        } catch (Exception e) {
            //TODO: handle exception
        } finally{
            executorService.shutdown();
        }

        ExecutorService executorService2 = new ThreadPoolExecutor(
            2,
            5,
            1L,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(3),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy()
        );
    }
}
