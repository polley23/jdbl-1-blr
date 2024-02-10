package com.gfg.jbdlblrsession6;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class Api {

    @PostMapping("/v1/api/movie")
    ResponseEntity<String> createMovie(){
        log.debug(" Movie is created.");
        return ResponseEntity.ok("Movie is created");
    }

    @GetMapping("/v1/api/movie")
    ResponseEntity<MovieRequest> getMovie(@RequestParam("movieName") String name){
        return ResponseEntity.ok(MovieRequest.builder().name(name).build());
    }

    @PutMapping("/v1/api/movie/")
    ResponseEntity<String> updateMovie(@RequestBody MovieRequest movieRequest){
        log.info(movieRequest.getName() +" got updated");
        return ResponseEntity.ok(movieRequest.getName());
    }

    @DeleteMapping("/v1/api/movie/{movieName}")
    ResponseEntity<String> deleteMovie(@PathVariable("movieName") String name){
        return ResponseEntity.ok(name);
    }
}
