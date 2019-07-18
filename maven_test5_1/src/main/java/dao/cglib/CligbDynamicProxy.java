package dao.cglib;

import aspect.MyAspect;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CligbDynamicProxy implements MethodInterceptor {
        public Object createProxy(Object target){
            Enhancer enhancer=new Enhancer();
            enhancer.setSuperclass(target.getClass());
            enhancer.setCallback(this);
            return enhancer.create();
        }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        MyAspect aspect=new MyAspect();
        aspect.check();
        aspect.except();
        Object obj=methodProxy.invokeSuper(o,objects);
        aspect.log();
        aspect.mointor();
            return obj;
    }
}
