package com.mytestapp.prog.rest;

import com.mytestapp.prog.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;

//    @Autowired
//    public DemoController(Coach thCoach){
//        this.myCoach=thCoach;
//    }

    @Autowired
    public void setMyCoach(Coach theCoach){
        this.myCoach=theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
