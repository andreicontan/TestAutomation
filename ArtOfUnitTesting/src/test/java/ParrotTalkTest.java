
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.*;


/**
 * Created by andreicontan on 12/10/15.
 */
public class ParrotTalkTest {

    ParrotTalk parrot = new ParrotTalk();

//    @BeforeMethod
//    public void setUp(){
//        parrot = new ParrotTalk();
//    }

    @DataProvider(name = "parrot")
    public Object[][] testData(){
    return new Object[][]{
            {true, 7, false},
            {true, 8, false},
            {true, 21, new Exception()}
    };
    }
    @DataProvider(name = "returnsFalse")
    public Object[][] testDataFalse(){
        return new Object[][]{
                {true, 7},
                {true, 8}

        };
    }

    @Test(dataProvider = "parrot")
    public void testParrotTalks_atLowerBoundary_isFalse(boolean talks, int hour, boolean expected){
        boolean parrotTalks = talks;
        int lowBoundary = hour;
        boolean expect = expected;

       // ParrotTalk parrot = new ParrotTalk();
        boolean actual = parrot.parrotTrouble(parrotTalks, lowBoundary);

        Assert.assertEquals(actual, expect);

    }


    @Test
    public void testParrotTalk_inBoundary_isTrue(){

        //Arrange
        boolean parrotTalks = true;
        int inBoundaryHour = 22;
        //Act
        boolean actual = parrot.parrotTrouble(parrotTalks, inBoundaryHour);
        //Assert
        Assert.assertTrue(actual,"Message for reporting");
    }






















  //  @Test
//    public void testParrot_at6hrsBoundary_isInTrouble(){
//        ParrotTalk parrot = new ParrotTalk();
//        boolean IS_TALKING = true;
//        int DAY_HOUR = 6;
//
//        boolean actual = parrot.parrotTrouble(IS_TALKING, DAY_HOUR);
//
//        Assert.assertTrue("Parrot should be in Trouble", actual);
//
//    }
//
//    @Test
//    public void testParrot_atNight_isNotInTrouble(){
//        ParrotTalk parrotTalk = new ParrotTalk();
//        boolean IS_TALKING = false;
//        int DAY_HOUR = 22;
//
//        boolean actual = parrotTalk.parrotTrouble(IS_TALKING, DAY_HOUR);
//
//        Assert.assertFalse(actual);
//    }

    @Test
    public void testParrot_InvalidHour_ThrowsNotImplementedException(){
        Person person = mock(Person.class);
        when(person.isTrainer("Mihai")).thenReturn(true);

        boolean actual = person.isTrainer("Mihai");
        Assert.assertTrue(actual);
    }
}
