package JavaSE;

import JavaSE.EnumTest.CountryEnum;
import JavaSE.Regex.PatternMatcherStudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * class_name: App
 * package: JavaSE
 * creat_user: CodeChase
 * creat_date: 4/5/2022
 * creat_time: 11:04 PM
 **/
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) throws Exception {

        testRegex();

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

    static void testStringFunctionSplit(){
        String s1 = new String("abc.d.e");
        String s2 = new String("abc.d.e.");
        String s3 = new String("abc.d.e.");
        String s4 = new String(".abc.d.e");

        System.out.println(Arrays.toString(s1.split("\\.")));
        System.out.println(Arrays.toString(s1.split("\\.",1)));
        System.out.println(s1.split("\\.", 1).length);
        System.out.println(Arrays.toString(s2.split("\\.")));
        System.out.println(Arrays.toString(s3.split("\\.",-1)));
        System.out.println((s3.split("\\.",-1).length));
        System.out.println(Arrays.toString(s4.split("\\.")));
        System.out.println(Arrays.toString(s3.split("\\.")));
        System.out.println((s3.split("\\.").length));
    }

    static void testRegex(){
        PatternMatcherStudy.func();
    }
}
