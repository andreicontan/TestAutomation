/**
 * Created by andreicontan on 06/10/15.
 */
public class LogAnalyzer {

    //Step 2
    private boolean wasLastFileNameValid;

    public boolean isWasLastFileNameValid() {
        return wasLastFileNameValid;
    }

    public void setWasLastFileNameValid(boolean wasLastFileNameValid) {
        this.wasLastFileNameValid = wasLastFileNameValid;
    }


//end of step 2

    public boolean IsValidLogFileName(String fileName)
        {
            if(String.valueOf(fileName).isEmpty())
            {
                throw new IllegalArgumentException("No filename provided!");
            }
            if(!fileName.toLowerCase().endsWith(".txt"))
            {
                //step 2
                wasLastFileNameValid = false;
                return wasLastFileNameValid;
                        //end of step 2
             //   return false;
            }
            //step2
            wasLastFileNameValid = true;
            return wasLastFileNameValid;
            //end of step 2
            //return true;
        }
    }

