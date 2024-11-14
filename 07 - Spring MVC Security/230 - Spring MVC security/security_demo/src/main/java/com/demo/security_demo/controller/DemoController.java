package com.demo.security_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//When server side rendering takes place @Controller annotation is used
//instead of @Restcontroller annotation

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome(){
        return "home";
    }
}
