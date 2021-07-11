package juc;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author codechase <codecx@163.com>
 * Created on 2021-07-10
 */
public class SpinLock {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void lock(){
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName() + "get lock");
        while(!atomicReference.compareAndSet(null,currentThread)){

        }
    }

    public void unLock(){
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName());
        atomicReference.compareAndSet(currentThread,null);
    }
}
