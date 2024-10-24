package com.mytestapp.prog.rest;

import com.mytestapp.prog.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;

    //When using 'Qualifier' , name should be in camelcase despite the class being Pascal case
//    @Autowired
//    public DemoController(@Qualifier("tennisCoach") Coach thCoach){
//        this.myCoach=thCoach;
//    }

    @Autowired
    public void setMyCoach(@Qualifier("tennisCoach") Coach theCoach){
        this.myCoach=theCoach;
        System.out.println("In Constructor : "+this.getClass().getSimpleName());
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
