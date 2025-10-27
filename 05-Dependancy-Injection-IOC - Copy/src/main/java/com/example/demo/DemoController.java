package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

//  There is Field Dependency injection also there
//  if we declare direction Autowire to object of Coach like below but ⚠️ It's just not recommended by best practices.
//  @Autowired
    private Coach myCoach;

//    #Using Setter method for Dependency In Injection
//    @Autowired
//    public void setter(Coach theCoach){
//        myCoach =theCoach;
//    }

//    #Using Constructor method for Dependency In Injection
    @Autowired
    public DemoController(Coach theCoach){
        myCoach =theCoach;
    }

    @GetMapping("/Workout")
    public String anyName(){
        return myCoach.getDailyWorkout();
    }
}
