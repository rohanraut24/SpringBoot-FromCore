package myApp.package01.commonClassFile;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//If you think this is unnecessary initialization then ,you can make it Lazy ,
// so it will not be Initialize unless you called it.
@Lazy
//also you can set all beam Lazy in Application Properties by
// spring.main.lazy-initialization=true;
@Component
public class CricketCoach implements Coach{
    public CricketCoach(){
        System.out.println("We are in "+getClass().getSimpleName());
    }
    public String getDailyWorkout(){
        return "Practice spring-boot whole day ";
    }
}
