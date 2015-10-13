import junit.framework.Assert;
import org.testng.annotations.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by andreicontan on 12/10/15.
 */
public class ParrotTalkTest {

    @Test
    public void testParrot_at6hrsBoundary_isInTrouble(){
        ParrotTalk parrot = new ParrotTalk();
        boolean IS_TALKING = true;
        int DAY_HOUR = 6;

        boolean actual = parrot.parrotTrouble(IS_TALKING, DAY_HOUR);

        Assert.assertTrue("Parrot should be in Trouble", actual);

    }

    @Test
    public void testParrot_atNight_isNotInTrouble(){
        ParrotTalk parrotTalk = new ParrotTalk();
        boolean IS_TALKING = false;
        int DAY_HOUR = 22;

        boolean actual = parrotTalk.parrotTrouble(IS_TALKING, DAY_HOUR);

        Assert.assertFalse(actual);
    }

    @Test(expectedExceptions = NotImplementedException.class)
    public void testParrot_InvalidHour_ThrowsNotImplementedException(){
        ParrotTalk parrot = mock(ParrotTalk.class);
        when(parrot.parrotTrouble(true, 600)).thenThrow(NotImplementedException.class);

        parrot.parrotTrouble(true, 600);
    }
}
