package spring.proxyfactorybean;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
       check();
       except();
       Object obj=methodInvocation.proceed();
       log();
       mointor();
        return obj;
    }
    public void check(){
        System.out.println("模拟权限控制");
    }
    public void except(){
        System.out.println("模拟异常处理");
    }
    public  void log(){
        System.out.println("模拟日志记录");
    }
    public void mointor(){
        System.out.println("性能监测");
    }
}
