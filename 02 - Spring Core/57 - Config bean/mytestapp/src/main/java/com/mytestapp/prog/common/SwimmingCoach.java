package com.mytestapp.prog.common;

public class SwimmingCoach implements Coach{

    public SwimmingCoach(){
        System.out.println("In Constructor : "+this.getClass().getSimpleName());
    }


    @Override
    public String getDailyWorkout() {

        return "Practice 100m of Free Style";
    }
}
