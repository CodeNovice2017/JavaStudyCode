package heima;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

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
    
    public static void main(String[] args){

        Object concurrentObject = new Object();
        // 对多线程wait()的理解
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run(){
                synchronized(concurrentObject){
                    try {
                        concurrentObject.wait(); 
                        // concurrentObject.notify();
                        System.out.println("t1获得了同步对象的锁");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (concurrentObject) {
                    try {
                        concurrentObject.wait();
                        System.out.println("t2获得了同步对象的锁");
                        concurrentObject.notify();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (concurrentObject) {
                    try {
                        System.out.println("t3获得了同步对象的锁");
                        concurrentObject.notify();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t2.start();
        t1.start();
        t3.start();

        FutureTask<Integer> ft = new FutureTask<>(new Callable<Integer>(){
            @Override
            public Integer call(){
                System.out.println("使用Callable接口!");
                return 123;
            }
        });
        Thread thread = new Thread(ft);
        thread.start();


    }
    class Thread1 extends Thread{
        @Override
        public void run(){

            try {
                Thread.sleep(100);                
                System.out.println("t1开始运行");
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }
        }
    }

    class Thread2 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(100);
                System.out.println("t2开始运行");
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            new Thread1().start();
        }
    }

    class Thread3 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(100);
                System.out.println("t3开始运行");
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            new Thread2().start();
        }
    }
}
