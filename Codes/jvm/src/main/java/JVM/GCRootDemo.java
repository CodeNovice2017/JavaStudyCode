package JVM;

import java.util.HashMap;

public class GCRootDemo {

    // 方法区中类的静态属性引用的对象
    // static静态是全部实例共用,会被加载进入方法区(jdk1.7用永久代实现,jdk1.8用元空间实现)
    // 这种也称为引用可达
    // private static GCRootDemo2 gcRootDemo2;

    // 方法区中常量引用的对象
    // private static GCRootDemo3 gcRootDemo3 = new GCRootDemo3(0);

    public static void m1(){
        GCRootDemo gcRootDemo = new GCRootDemo();

        int c = 0;
        c = Integer.MIN_VALUE + -1;
        System.out.println(c);

        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,null);

        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run(){
                System.out.println("哈哈");
            }
        });

        t1.start();
        t1.start();

        System.gc();
        System.out.println("第一次GC完成");
    }
    public static void main(String[] args){
        // 假如main方法要调用m1
        // 而m1方法中,gcRootDemo引用指向了一个GCRootDemo对象
        // 方法执行是在虚拟机栈中的
        // 在m1方法的作用域中有一个局部变量(本地变量)gcRootDemo引用对象
        // 且该gcRootDemo引用对象指向了一个GCRootDemo对象
        // 这个new GCRootDemo对象就叫对象可达
        m1();
    }
}
