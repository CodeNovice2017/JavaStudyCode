package heima;

import org.junit.jupiter.api.Test;

import heima.day12.MyFunctionalInterface;
import heima.day12.MyFunctionalInterfaceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {
        assertEquals(1, 1);
    }

    // MyFunctionalInterfaceTest
    public void show(MyFunctionalInterface myFunctionalInterface){
        myFunctionalInterface.method();
    }
    @Test
    void MyFunctionalInterfaceTest(){

        // 方法的参数是一个接口的实现类对象
        show(new MyFunctionalInterfaceImpl());

        // 使用匿名内部类重写接口中的抽象方法
        show(new MyFunctionalInterface(){
            @Override
            public void method(){
                System.out.println("使用匿名内部类重写接口中的抽象方法");
            }
        });

        // 使用Lambda表达式重写接口中的抽象方法
        show(()->{
            System.out.println("使用Lambda表达式重写接口中的抽象方法");
        });
    }
}
