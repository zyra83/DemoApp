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
  
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/hello/{name}")
    public String helloName(@PathVariable String name) {
        return String.format("Hello, %s!", name);
    }

    @PostMapping("/hello")
    public String helloPost(@RequestBody String name) {
        return String.format("Hello, %s!", name);
    }

    @GetMapping("/country")
    public String country() {
        return String.format("Country: %s", country);
    }

    @GetMapping("/city")
    public String city() {
        return String.format("City: %s", city);
    }

    @GetMapping("/color")
    public String color() {
        return String.format("Color: %s", color);
    }


    @GetMapping("/")
    public String home(@RequestParam(value = "name", defaultValue = "Kubernetes") String name) {
        return String.format("Hello, %s!", name);
    }

    @GetMapping("/details")
    public String details() {
        return String.format("Country: %s \nCity: %s \nColor: %s", country,city,color);
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
