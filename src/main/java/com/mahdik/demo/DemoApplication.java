// File: DemoApplication.java

package com.mahdik.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

    @Value("${country:France}")
    private String country;

    @Value("${city:Paris}")
    private String city;

    @Value("${city:Blue}")
    private String color;
  
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/hello/{name}")
    public String helloName(@PathVariable String name) {
        return String.format("Hello, %s!", name);
    }

    @PostMapping("/Color")
    public String updateColor(@RequestBody String color) {
        return String.format("Color updated to  %s!", color);
    }

    @PostMapping("/City")
    public String updateCity(@RequestBody String city) {
        return String.format("City updated to  %s!", city);
    }
    
    @DeleteMapping("/Country")
    public String deleteCountry(@RequestBody String country) {
        return "Country deleted";
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
    public String home(@RequestParam(value = "name", defaultValue = "DEMO") String name) {
        return String.format("Welcome to your java Spring boot App , this is deployed on kubernetes! \n application name  %s", name);
    }

    @GetMapping("/details")
    public String details() {
        return String.format("Country: %s \nCity: %s \nColor: %s", country,city,color);
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
