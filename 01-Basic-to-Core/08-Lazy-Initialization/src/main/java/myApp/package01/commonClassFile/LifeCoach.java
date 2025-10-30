package myApp.package01.commonClassFile;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class LifeCoach implements Coach {
    public LifeCoach() {
        System.out.println("We are in " + getClass().getSimpleName());
    }

    public String getDailyWorkout() {
        return "Life is hard,there is SOMETHING that makes life EASY that thing is DISCIPLINE";
    }
}
