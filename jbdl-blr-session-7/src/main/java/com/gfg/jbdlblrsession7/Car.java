package com.gfg.jbdlblrsession7;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
public class Car {
    private String name;
    Car(){
    }
    public void start(){
        log.info("Car is started.");
    }
    public void drive(){
        log.info("Car is being driven.");
    }

}
