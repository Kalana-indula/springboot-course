package com.mytestapp.prog.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SwimmingCoach implements Coach{

    public SwimmingCoach(){
        System.out.println("In Constructor : "+this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {

        return "Practice 100m of Free Style";
    }
}
