// File: DemoApplication.java

package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

    @Value("${country:France}")
    private String country;

    @Value("${city:Paris}")
    private String city;

    @Value("${city:Red}")
    private String color;
    
    @GetMapping("/")
    public String home(@RequestParam(value = "name", defaultValue = "Kubernetes") String name) {
        return String.format("Hello, %s!", name);
    }

    @GetMapping("/details")
    public String details() {
        return String.format("Country: %s \nCity: %s \Color: %s", country,city,color);
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
