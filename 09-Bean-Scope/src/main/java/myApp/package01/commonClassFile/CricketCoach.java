package myApp.package01.commonClassFile;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    public CricketCoach(){
        System.out.println("We are in "+getClass().getSimpleName());
    }
    public String getDailyWorkout(){
        return "Practice spring-boot whole day ";
    }
}
