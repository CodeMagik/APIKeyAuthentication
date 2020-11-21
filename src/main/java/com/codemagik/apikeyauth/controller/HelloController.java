package com.codemagik.apikeyauth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/isAlive")
    public String isAlive() {
        return "I am alive, you dont need authentication to check whether I am alive";
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.status(HttpStatus.OK).body("hello");
    }
}
