package heima;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import heima.day12.MyFunctionalInterface;
import heima.day12.MyFunctionalInterfaceImpl;

public class Day12FunctionalCoding {

    /**
     * MyFunctionalInterfaceTest
     */
    public void show(MyFunctionalInterface myFunctionalInterface) {
        myFunctionalInterface.method();
    }

    @Test
    void MyFunctionalInterfaceTest() {

        // 方法的参数是一个接口的实现类对象
        show(new MyFunctionalInterfaceImpl());

        // 使用匿名内部类重写接口中的抽象方法

        show(new MyFunctionalInterface() {
            @Override
            public void method() {
                System.out.println("使用匿名内部类重写接口中的抽象方法");
            }
        });

        // 使用Lambda表达式重写接口中的抽象方法
        show(() -> {
            System.out.println("使用Lambda表达式重写接口中的抽象方法");
        });

        // 进一步精简为
        show(() -> System.out.println("使用Lambda表达式精简重写接口中的抽象方法"));
    }

    /**
     * Lambda表达式作为参数
     */
    // Runable实际上就是一个函数式接口
    public static void startThread(Runnable task) {
        new Thread(task).start();
    }

    @Test
    void LambdaAsParam() {
        // 调用startThread方法,方法的参数是一个接口Runable,可以使用接口的匿名内部类
        startThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "线程启动");
            }
        });
        // 调用startThread方法,方法的参数就是一个函数式接口Runable,可以使用Lambda表达式
        startThread(() -> System.out.println(Thread.currentThread().getName() + "线程启动"));
    }

    /**
     * Lambda表达式作为返回值
     */
    public static Comparator<String> getComparatorByAnonymousInnerClass() {

        // 方法的返回值类型使用函数式接口Comparator
        return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 按照字符串长度降序排序
                return o2.length() - o1.length();
            }
        };
    }

    public static Comparator<String> getComparatorByLambda() {
        // 方法的返回值类型使用函数式接口Comparator

        // 未精简
        // return (String o1,String o2) -> {
        // return o2.length() - o1.length();
        // };
        // 精简
        // 1. 数据类型String可以省略
        // 2. 因为只有一行代码,所以{}可以省略
        // 3. 分号省略
        return (o1, o2) -> o2.length() - o1.length();
    }

    @Test
    void LambdaAsReturn() {

        String[] arr = { "aaa", "bbbb", "ccccc" };

        // Arrays.sort(arr, getComparatorByLambda());

        Arrays.sort(arr, (o1,o2) -> o1.length() - o2.length());

        System.out.println(Arrays.toString(arr));
    }

    @Test
    void basicTypeTurnToBoxedTypeTest(){
        
    }

}
