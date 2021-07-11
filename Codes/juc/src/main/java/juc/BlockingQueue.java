package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author codechase <codecx@163.com>
 * Created on 2021-07-11
 */
public class BlockingQueue <E> {

    Object[] table;
    int size;
    int currentIndex;
    int headIndex;
    int currentSize;
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public BlockingQueue(int capacity){
        table = new Object[capacity];
        size = 0;
        currentIndex = 0;
        currentSize = 0;
        headIndex = 0;
    }

    public boolean offer(E element){
        try{
            lock.lock();
            if(currentSize == table.length){
                condition.await();
            }
            table[currentIndex++] = (Object) element;
            currentIndex %= table.length;
            currentSize++;
            condition.signalAll();
            return true;
        }catch (InterruptedException e){
            e.printStackTrace();
            return false;
        }finally {
            lock.unlock();
        }
    }

    public E poll(){
        try{
            lock.lock();
            if(currentSize == 0){
                condition.await();
            }
            Object result = table[headIndex++];
            headIndex %= table.length;
            currentSize--;
            condition.signalAll();
            return (E)result;
        }catch (InterruptedException e){
            e.printStackTrace();
            return null;
        }finally {
            lock.unlock();
        }
    }
}
