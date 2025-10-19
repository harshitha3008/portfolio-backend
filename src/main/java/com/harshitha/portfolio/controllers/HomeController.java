package com.harshitha.portfolio.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // Marks this class as a controller that returns data
public class HomeController {

    @GetMapping("/")  // Maps HTTP GET requests to "/"
    public String home() {
        return "Portfolio backend is running! 🚀";
    }

    @GetMapping("/hello") // Another endpoint example
    public String hello() {
        return "Hello from your Portfolio API!";
    }
}
