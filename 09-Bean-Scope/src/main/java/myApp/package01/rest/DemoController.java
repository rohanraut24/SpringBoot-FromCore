package myApp.package01.rest;

import myApp.package01.commonClassFile.LifeCoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import myApp.package01.commonClassFile.Coach;

//Bean scope
//Singleton (It is default scope of Bean i.e. Every instance pointing to same bean address)
//Prototype (this scope we need to give manually. Each instance has separate location in bean )

@RestController
public class DemoController {
    //Create 2 instance
    private Coach myCoach;
    private Coach theCoach;

//    Way 1
//    @Autowired
//        [if you used same qualifier
//        then it is pointing to same bean]
//    public void setter(@Qualifier("lifeCoach") Coach myCoach, @Qualifier("lifeCoach")Coach theCoach){
//        this.myCoach =myCoach;
//        this.theCoach =theCoach;
//    }

//    Way 2
    @Autowired
//        [if you used same qualifier
//        then it is pointing to same bean]
//    BUT
//    We configure the scope in lifeCoach class to 'PROTOTYPE '
//    Then it will create the different bean for each instance for same class
    public void setter(@Qualifier("lifeCoach") Coach myCoach, @Qualifier("lifeCoach")Coach theCoach){
        this.myCoach =myCoach;
        this.theCoach =theCoach;
    }


//    # Way 3
//    @Autowired
//        [if you used diff qualifier for lifeCoach and footballCoach
//        then it create two different bean and pointing to different location
//    public void setter(@Qualifier("lifeCoach") Coach myCoach, @Qualifier("footballCoach")Coach theCoach){
//        this.myCoach =myCoach;
//        this.theCoach =theCoach;
//    }

    @GetMapping("/checkScope")
    public String checkScope(){
//      (myCoach==theCoach);  => true for Way 1
//      (myCoach==theCoach);  => false for Way 3
        return "Is myCoach and the Coach pointing to same location :"+(myCoach==theCoach);//false for Way 2
    }
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
