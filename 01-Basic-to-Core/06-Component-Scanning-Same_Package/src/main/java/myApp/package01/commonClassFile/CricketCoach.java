package myApp.package01.commonClassFile;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    public String getDailyWorkout(){
        return "Practice spring-boot whole day ";
    }
}
