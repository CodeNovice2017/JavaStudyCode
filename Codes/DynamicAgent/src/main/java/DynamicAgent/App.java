package DynamicAgent;

import DynamicAgent.SimpleDynamicAgent.UserDao;
import DynamicAgent.SimpleDynamicAgent.UserDaoImpl;
import DynamicAgent.SimpleDynamicAgent.UserHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

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
    public static void main(String[] args) throws ClassNotFoundException{
        System.out.println("Hello World!");

        // 获取某个类的ClassLoader,这里获取的是String类的ClassLoader。由于java核心api是用引导类加载器加载的，所以输出为null。
        ClassLoader stringClassLoader = Class.forName("java.lang.String").getClassLoader();
        // 获取当前类的ClassLoader
        ClassLoader currentClassLoader = App.class.getClassLoader();
        // 获取当前线程的ClassLoader
        ClassLoader currentThreadClassLoader = Thread.currentThread().getContextClassLoader();
        // 获取系统的ClassLoader
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();

        System.out.println(stringClassLoader);
        System.out.println(currentClassLoader);
        System.out.println(currentThreadClassLoader);
        System.out.println(systemClassLoader);

        UserDao userDao = new UserDaoImpl();
        InvocationHandler userHandler = new UserHandler(userDao);
        ClassLoader classLoader = userDao.getClass().getClassLoader();
        Class<?>[] interfaces = userDao.getClass().getInterfaces();

        UserDao proxy = (UserDao)Proxy.newProxyInstance(classLoader, interfaces, userHandler);

        proxy.saveUser();
    }
}
