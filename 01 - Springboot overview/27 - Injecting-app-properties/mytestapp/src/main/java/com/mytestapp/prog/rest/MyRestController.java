package com.mytestapp.prog.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
    //Fields
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/")
    public String greet(){
        return "Hello";
    }

    @GetMapping("/workout")
    public String workout(){
        return "Dev tools added";
    }

    @GetMapping("/edits")
    public String getEdits(){
        return "App is on edit";
    }

    @GetMapping("/coach-name")
    public String getCoachName(){
        return this.coachName;
    }

    @GetMapping("/team-name")
    public String getTeamName(){
        return this.teamName;
    }
 }
