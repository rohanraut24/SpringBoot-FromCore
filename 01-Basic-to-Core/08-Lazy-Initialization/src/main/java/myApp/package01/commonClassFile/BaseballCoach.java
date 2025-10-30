package myApp.package01.commonClassFile;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

//If you think this is unnecessary initialization then ,you can make it Lazy ,
// so it will not be Initialize unless you called it.
@Lazy
@Component
public class BaseballCoach implements Coach{
    public String getDailyWorkout(){
        return "Practice throws with Baseball";
    }
    public BaseballCoach(){
        System.out.println("We are in : "+getClass().getSimpleName());
    }
}
