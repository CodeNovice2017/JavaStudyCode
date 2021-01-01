package DynamicAgent.SimpleDynamicAgent;

// 静态代理
// 新创建一个用户实现类 （UserDaoImpl），它不执行用户操作。
// 然后再创建一个用户代理（UserProxy），执行用户代理的用户保存（saveUser），其内部会调用用户实现类的保存用户（saveUser）方法，
// 因为我们 JVM 可以在编译期确定最终的执行方法，所以上面的这种代理模式又叫做静态代理。

public class UserProxy {
    
    private UserDao userDao;

    public UserProxy(UserDao userDao){
        this.userDao = userDao;
    }
    public void saveUser(){
        System.out.println(" ---- 代理开始 ---- ");
        userDao.saveUser();
        System.out.println(" ---- 代理结束 ----");
    }
}
