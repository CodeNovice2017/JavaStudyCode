package DynamicAgent.SimpleDynamicAgent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserHandler implements InvocationHandler {

    private Object target;

    public UserHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        saveUserStart();
        Object obj = method.invoke(target, args);
        saveUserDone();
        return obj;
    }

    public void saveUserStart() {
        System.out.println("---- 开始插入 ----");
    }

    public void saveUserDone() {
        System.out.println("---- 插入完成 ----");
    }    
}
