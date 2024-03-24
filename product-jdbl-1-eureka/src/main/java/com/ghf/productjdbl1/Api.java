package com.ghf.productjdbl1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Api {
    @GetMapping("/product")
    String product() {
        return "Laptop.";
    }
}