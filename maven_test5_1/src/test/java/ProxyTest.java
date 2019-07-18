import dao.jdk.TestDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProxyTest {
    public static void main(String[] args){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        TestDao testDao= (TestDao) applicationContext.getBean("testDaoProxy");
        testDao.save();
        System.out.println("=================");
        testDao.delete();
        System.out.println("=================");
        testDao.modify();
        System.out.println("=================");
    }
}
