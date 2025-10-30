package myApp.package01.commonClassFile;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary
@Component
public class CricketCoach implements Coach{
    public String getDailyWorkout(){
        return "Practice spring-boot whole day ";
    }
}
