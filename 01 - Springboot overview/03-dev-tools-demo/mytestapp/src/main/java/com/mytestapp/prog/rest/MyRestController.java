package com.mytestapp.prog.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

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
 }
