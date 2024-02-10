package com.gfg.jbdlblrsession7;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jmx.export.annotation.ManagedNotification;
import org.springframework.stereotype.Component;

@Slf4j

public class Man {
    @Autowired
    Car car;

    String name;
    Man(Car car, String name){
         this.car = car;
         this.name = name;
    }

    Man(){

    }
    public Car getCar(){
        return this.car;
    }
    public void setCar(Car car){
       this.car =car;
    }
    public void drive(){
        car.start();
        car.drive();
    }


}
