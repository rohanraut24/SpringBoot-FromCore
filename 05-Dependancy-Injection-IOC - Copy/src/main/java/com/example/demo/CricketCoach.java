package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout(){
        return "You need work whole day and night";
    }
}
