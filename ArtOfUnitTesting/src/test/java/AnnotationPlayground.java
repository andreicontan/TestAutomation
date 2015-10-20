
import org.testng.annotations.*;

/**
 * Created by andreicontan on 20/10/15.
 */
public class AnnotationPlayground {

    @BeforeClass
    public void setUp(){
        System.out.println("Before Class");
    }

    @BeforeMethod
    public void prepareTest(){
        System.out.println("Before Test");
    }
    @Test
    public void testMethod1(){
        System.out.println("Test 1");
    }

    @Test
    public void testMethod2(){
        System.out.println("Test 2");
    }



    @AfterMethod
    public void cleanUpTest(){
        System.out.println("After test");
    }

    @AfterClass
    public void cleanUp(){
        System.out.println("After Class");


    }
}
