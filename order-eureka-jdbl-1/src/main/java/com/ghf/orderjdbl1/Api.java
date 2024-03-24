package com.ghf.orderjdbl1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Api {
//    @Autowired
//    RestTemplate restTemplate;
    @Autowired
    RemoteCall remoteCall;
    @GetMapping("/order")
    String order(){
//        ResponseEntity<String> response
//                = restTemplate.getForEntity("http://product/product", String.class);
//        return "The order is placed for "+ response.getBody();
        String product = remoteCall.getProduct();
        return "The order is placed for "+ product;
    }
}
