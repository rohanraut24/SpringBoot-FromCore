package myApp.package01.rest;

import myApp.package01.commonClassFile.LifeCoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import myApp.package01.commonClassFile.Coach;

@RestController
public class DemoController {
    private Coach myCoach;

    @Autowired
    //We can access this class method without using @Component for add in bean we are adding it manually
//    @Qualifier("swimCoach")
    @Qualifier("anything")
    public void setter(Coach theCoach){
        myCoach = theCoach;
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
