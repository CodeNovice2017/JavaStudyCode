package DynamicAgent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import DynamicAgent.SimpleDynamicAgent.UserDao;
import DynamicAgent.SimpleDynamicAgent.UserDaoImpl;
import DynamicAgent.SimpleDynamicAgent.UserHandler;

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
    public static void main(String[] args) {
        System.out.println("Hello World!");

        UserDao userDao = new UserDaoImpl();
        InvocationHandler userHandler = new UserHandler(userDao);
        ClassLoader classLoader = userDao.getClass().getClassLoader();
        Class<?>[] interfaces = userDao.getClass().getInterfaces();

        UserDao proxy = (UserDao)Proxy.newProxyInstance(classLoader, interfaces, userHandler);

        proxy.saveUser();
    }
}
