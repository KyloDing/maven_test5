import dao.cglib.CligbDynamicProxy;
import dao.cglib.TestCglibDao;
import dao.jdk.TestDao;

public class CligbTest {
    public static  void main(String[] args){
        CligbDynamicProxy cdp=new CligbDynamicProxy();
        TestCglibDao testDao=new TestCglibDao();
        TestCglibDao testCglibDao= (TestCglibDao) cdp.createProxy(testDao);
        testCglibDao.save();
        System.out.println("_______________________");
        testCglibDao.delete();
        System.out.println("_______________________");
        testCglibDao.modify();
    }
}
