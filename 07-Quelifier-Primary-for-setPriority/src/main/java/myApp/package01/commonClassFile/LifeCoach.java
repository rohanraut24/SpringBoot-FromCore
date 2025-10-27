package myApp.package01.commonClassFile;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
// If there is NO @Quelifier used at Controller then default class will be LifeCoach
// @Primary work fine with constructor at controller NOT like @Quelifier(don't work with constructor)
@Primary
public class LifeCoach implements Coach{
    public String getDailyWorkout(){
        return "Life is hard,there is SOMETHING that makes life EASY that thing is DISCIPLINE";
    }
}
