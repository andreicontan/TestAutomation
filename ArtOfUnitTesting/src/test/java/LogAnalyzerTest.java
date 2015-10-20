import org.testng.Assert;
import org.testng.annotations.Test;
import sun.rmi.runtime.Log;

/**
 * Created by andreicontan on 06/10/15.
 */
public class LogAnalyzerTest {


    @Test
    public void testNameFile(){
        LogAnalyzer log = new LogAnalyzer();
        boolean actual = log.IsValidLogFileName("FileName.SLF");

        Assert.assertTrue(actual);
    }


    @Test
    public void testProperties(){
        LogAnalyzer log = new LogAnalyzer();
        log.IsValidLogFileName("log.slf");
        Assert.assertTrue(log.isWasLastFileNameValid());
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testException(){
        LogAnalyzer log = new LogAnalyzer();
        log.IsValidLogFileName("");
    }

}
