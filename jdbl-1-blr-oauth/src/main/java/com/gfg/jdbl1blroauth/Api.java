package com.gfg.jdbl1blroauth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Api {
    @GetMapping("/")
    String home(){
        return "Welcome to oauth tutorial";
    }
}
