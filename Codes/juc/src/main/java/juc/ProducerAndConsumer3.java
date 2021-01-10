package juc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerAndConsumer3 {
    
    private volatile boolean FLAG = true;
    private AtomicInteger atomicInteger = new AtomicInteger();
    private BlockingQueue<String> blockingQueue = null;

    public ProducerAndConsumer3(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    public void myProducerProcess(){
        String data = atomicInteger.incrementAndGet() + "";
        boolean returnCondition = false;
        while(FLAG){
            try {
                returnCondition = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
                if(returnCondition == false){
                    System.out.println(Thread.currentThread().getName() + "\t 生产者生产(插入阻塞队列):" + "失败");
                    System.out.println("");
                    System.out.println("");
                    TimeUnit.SECONDS.sleep(1);
                }else{
                    System.out.println(Thread.currentThread().getName() + "\t 生产者生产(插入阻塞队列):" + "成功");
                    System.out.println("");
                    System.out.println("");
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
        System.out.println(Thread.currentThread().getName() + "因为FLAG = false,整体生产消费结束");
    }

    public void myConsumerProcess(){
        while(FLAG){
            try {
                String data = blockingQueue.poll(2L, TimeUnit.SECONDS);
                if(data == null || data.equalsIgnoreCase("")){
                    FLAG = false;
                    System.out.println(Thread.currentThread().getName() + "超过两秒钟获取不到数据或者获取数据无效,消费者停止运行");
                    System.out.println("");
                    System.out.println("");
                    return;
                }
            } catch (Exception e) {
                //TODO: handle exception
            }
            System.out.println(Thread.currentThread().getName() + "\t 消费者消费(从阻塞队列取出):" + "成功");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
    }
    public void stop(){
        this.FLAG = false;
    }
}
