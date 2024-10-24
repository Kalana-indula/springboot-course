package com.mytestapp.prog.common;

import org.springframework.stereotype.Component;

@Component
public class SwimmingCoach implements Coach{

    public SwimmingCoach(){
        System.out.println("In Constructor : "+this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {

        return "Practice 100m of Free Style";
    }
}
