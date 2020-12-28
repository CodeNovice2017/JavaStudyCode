package juc;

public class SingletonDemo {
    // 最经典的单例模式
    // private static SingletonDemo instance = null;
    // private SingletonDemo(){
    //     System.out.println(Thread.currentThread().getName() + "\t 我是构造方法SingletonDemo");
    // }
    // public static SingletonDemo getInstance(){
    //     if(instance == null){
    //         instance = new SingletonDemo();
    //     }
    //     return instance;
    // }

    // 多线程环境下线程安全的单例模式
    private static volatile SingletonDemo instance = null;
    private SingletonDemo(){
        System.out.println(Thread.currentThread().getName() + "\t 我是构造方法SingletonDemo");
    }
    public static SingletonDemo getInstance(){
        if(instance == null){
            synchronized(SingletonDemo.class){
                if(instance == null){
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }
}
