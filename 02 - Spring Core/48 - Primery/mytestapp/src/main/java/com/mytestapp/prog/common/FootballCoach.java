package com.mytestapp.prog.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary  //Makes this class as default choice for DI
public class FootballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "practice long kicks";
    }
}
