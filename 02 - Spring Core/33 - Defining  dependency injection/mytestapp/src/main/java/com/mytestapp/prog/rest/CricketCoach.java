package com.mytestapp.prog.rest;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice faset bawoling for 15 minutes.";
    }
}
