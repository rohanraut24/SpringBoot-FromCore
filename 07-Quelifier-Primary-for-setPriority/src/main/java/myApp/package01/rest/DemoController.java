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
//   This Qualifier doesn't work on Constructor ,so I made setter function
//    If you used @Primary somewhere then Qualifier has greater Scope ,so class declare inside @Quelifier will show as output
//    @Qualifier("footballCoach")
    public void setter(Coach theCoach){
        myCoach = theCoach;
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
