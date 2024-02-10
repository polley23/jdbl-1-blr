package com.example.rest;


import jdk.jfr.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class Api {
    @GetMapping("/test")
    ResponseEntity<String> test(){
        return ResponseEntity.ok("Hello World");
    }
    @PostMapping("/test/{param}")
    ResponseEntity<String> post(@PathVariable("param") String s,
    @RequestParam("query") String s1,
                                @RequestBody  Input input ){
        log.info("hello "+ s + " "+ s1 + " " + input.name);
        return null;
    }
}
