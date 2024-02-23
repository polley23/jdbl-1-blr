package com.gfg.jbdl1session8;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
public class Car {
    Car(){

    }
    @Deprecated
    public void start(){
      log.info(" Car is getting started");
    }

    @CustomLog
    public void run(){
        log.info(" Car is running");
    }
}
