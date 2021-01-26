package JavaSE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        // testEnumAndCountDownLatch();
        testArrayToCollection();
    }

    static void testEnumAndCountDownLatch(){
        CountDownLatch countDownLatch = new CountDownLatch(2);

        for (int i = 1; i <= 2; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "国,被灭!");
                countDownLatch.countDown();
            }, CountryEnum.countryEnum_forEach(i).getReturnMessage()).start();
        }
        try {
            countDownLatch.await();
        } catch (Exception e) {
            //TODO: handle exception
        }
        System.out.println(Thread.currentThread().getName() + "秦国统一成功!");

        CyclicBarrier cyclicBarrier = new CyclicBarrier(0);
    }

    static void testArrayToCollection(){
        List<Integer> integerList = Arrays.asList(1, 3, 2);
        // // 方法一，强制转换
        // Integer[] integerAry = (Integer[]) integerList.toArray();
        // 方法二，传入一个指定类型对象
        Integer[] integerAry2 = integerList.toArray(new Integer[0]);
        Arrays.stream(integerAry2).forEach(System.out::println);

        

        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        String[] a = new String[1];
        String[] aa = list.toArray(a);
        Arrays.stream(aa).forEach(System.out::println);
    }
}
