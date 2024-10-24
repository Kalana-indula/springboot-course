package com.mytestapp.prog.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    public TennisCoach(){
        System.out.println("In constructor : "+this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {

        return "Practice 10 dashes";
    }
}