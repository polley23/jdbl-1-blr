package com.ghf.orderjdbl1;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "product")
public interface RemoteCall {

    @GetMapping("/product")
    String getProduct() ;
}
