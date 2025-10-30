package myApp.package01.commonClassFile;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach{
    public FootballCoach(){
        System.out.println("We are in "+getClass().getSimpleName());
    }
    public String getDailyWorkout(){
        return "Practice long shoot goals for 10 hrs";
    }
}
