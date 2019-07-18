package dao.jdk;



import aspect.MyAspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKDynamicProxy implements InvocationHandler {
    private TestDao testDao;
    public Object createProxy(TestDao testDao){
        this.testDao=testDao;
        ClassLoader cld=JDKDynamicProxy.class.getClassLoader();
        Class[] clazz=testDao.getClass().getInterfaces();
        return Proxy.newProxyInstance(cld,clazz,this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MyAspect myAspect=new MyAspect();
        myAspect.check();
        myAspect.except();
        Object obj=method.invoke(testDao,args);
        myAspect.log();
        myAspect.mointor();
        return obj;
    }
}
