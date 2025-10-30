package myApp.package01.commonClassFile;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
    public String getDailyWorkout(){
        return "Practice throws with Baseball";
    }
    public BaseballCoach(){
        System.out.println("We are in : "+getClass().getSimpleName());
    }
}
