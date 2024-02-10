package com.gfg.jbdlblrsession7;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
   @Bean
    Car car(){
        return new Car();
    }
    //Constructor based dependency injection
    @Bean("b1")
    Man man(Car car){
       return new Man(car,"GFG");
    }

    // Setter based dependency injection
    @Bean("b2")
    Man manWithSetter(Car car){
        Man man =  new Man();
        man.setCar(car);
        return man;
    }
}
