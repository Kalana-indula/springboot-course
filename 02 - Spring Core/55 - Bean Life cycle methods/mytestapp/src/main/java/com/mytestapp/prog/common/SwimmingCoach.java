package com.mytestapp.prog.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class SwimmingCoach implements Coach{

    public SwimmingCoach(){
        System.out.println("In Constructor : "+this.getClass().getSimpleName());
    }

    @PostConstruct
    public void doMyStartUpStuff(){
        System.out.println("doMyStartUpStuff : "+this.getClass().getSimpleName());
    }

    @PreDestroy
    public void doMyCleanUpStuff(){
        System.out.println("doMyCleanUpStuff : "+this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {

        return "Practice 100m of Free Style";
    }
}
