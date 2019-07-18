import dao.jdk.JDKDynamicProxy;
import dao.jdk.TestDao;
import dao.jdk.TestDaoImpl;

public class JDKTest {
    public static void main(String[] args){
        JDKDynamicProxy jdkDynamicProxy=new JDKDynamicProxy();
        TestDao testDao=new TestDaoImpl();
        TestDao testDao1= (TestDao) jdkDynamicProxy.createProxy(testDao);
        testDao1.save();
        System.out.println("===================");
        testDao1.modify();
        System.out.println("===================");
        testDao1.delete();
        System.out.println("===================");

    }
}
