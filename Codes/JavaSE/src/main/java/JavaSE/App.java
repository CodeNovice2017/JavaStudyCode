package JavaSE;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

import JavaSE.EnumTest.CountryEnum;

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
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");

        CountDownLatch countDownLatch = new CountDownLatch(2);

        for (int i = 1; i <= 2; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "国,被灭!");
                countDownLatch.countDown();
            },CountryEnum.countryEnum_forEach(i).getReturnMessage()).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "秦国统一成功!");

        CyclicBarrier cyclicBarrier = new CyclicBarrier(0);
    }
}
