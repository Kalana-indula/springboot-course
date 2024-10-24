package com.mytestapp.prog.rest;

import com.mytestapp.prog.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    public DemoController(
            @Qualifier("swimmingCoach")Coach myCoach,
            @Qualifier("swimmingCoach")Coach anotherCoach){

        this.myCoach=myCoach;
        this.anotherCoach=anotherCoach;
    }

    @GetMapping("/check")
    public String check(){
        return "Comparing beans : myCoach == anotherCoach  "+(myCoach==anotherCoach);
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
