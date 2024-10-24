package com.mytestapp.prog.common;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach{

    public FootballCoach(){
        System.out.println("In constructor :"+this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {

        return "practice long kicks";
    }
}
