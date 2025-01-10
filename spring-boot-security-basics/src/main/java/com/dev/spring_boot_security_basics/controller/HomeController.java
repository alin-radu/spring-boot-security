package com.dev.spring_boot_security_basics.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Hello, to everybody.";
    }

    @GetMapping("/private")
    public String securePath() {
        return "Staff only.";
    }
}
