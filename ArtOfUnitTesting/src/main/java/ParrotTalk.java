import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by andreicontan on 12/10/15.
 */
public class ParrotTalk {

    public boolean parrotTrouble(boolean talking, int hour) {

          return (talking && (hour < 7 || hour > 20));

    }


}
