package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ShareData {
    // 作为要交替生产 消费变量 比如number就表示要生产消费的东西,最开始还没生产是0,当为0的时候,生产者生产,当为1的时候,消费者消费
    private int number = 0; 
    // 因为这个资源类本身应该和调用它的线程之间解耦,所以操作资源类加1和减1的方法应该在资源类本身提供
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();


    // 使用ReentrantLock实现多线程按顺序执行
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    // 生产
    public void increment(){
        lock.lock();
        try {
            while (number != 0) {
                condition.await();
            }
            // 干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t " + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            lock.unlock();
        }
    }
    // 消费
    public void decrement(){
        lock.lock();
        try {
            while(number == 2){
                condition.await();
            }
            // 干活
            number--;
            System.out.println(Thread.currentThread().getName() + "\t " + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    // 三个线程按顺序执行打印 number=0 就是A线程执行 1就是B线程执行 2就是C线程执行
    // 最开始要么保证三个线程都获取过锁阻塞了,然后通过第四个线程去唤醒其中A线程,但是这样和题目要求用三个线程就不符合了,而且可能也无法完成循环十次,因为这种方式依然只能保证第一次ABC三个线程的执行顺序
    // 要么就是无论ABC三个打印线程谁先获得锁,只有A可以最先运行,同时无论此时B,C是否获得过锁而进入阻塞,都要求A释放锁之后,B线程可以运行起来
    // 方法就是让printB本身无论是否获取过锁阻塞,如果获取过锁阻塞了,此时因为A最先执行,并且调用了condition1.signal();会唤醒B执行,
    // 而如果本身B线程没有获得过锁进入阻塞,A因为修改了number的值为1,即使此时C又先于B获取了锁,C本身也要被阻塞,如果B先获得了锁,B开始运行,此时因为number=1,B不会进入while阻塞,直接开始运行,所以无论如何程序都能按照顺序执行
    public void printA(){
        lock.lock();
        try {
            while(number != 0){
                condition3.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.print("A");                
            }
            number = 1;
            condition1.signal();
        } catch (Exception e) {
            //TODO: handle exception
        } finally {
            lock.unlock();
        }
    }
    
    public void printB() {
        lock.lock();
        try {
            while(number != 1){
                condition1.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.print("B");
            }
            number = 2;
            condition2.signal();
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lock.unlock();
        }
    }
    public void printC() {
        lock.lock();
        try {
            while(number != 2){
                condition2.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.print("C");
            }
            System.out.println();
            number = 0;
            condition3.signal();
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lock.unlock();
        }
    }
}

