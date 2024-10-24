package com.mytestapp.prog.config;

import com.mytestapp.prog.common.Coach;
import com.mytestapp.prog.common.SwimmingCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportsConfig {

    @Bean("aquatic")
    public Coach swimmingCoach(){ //method name should be equal to the class name being injected
        return new SwimmingCoach();
    }
}
