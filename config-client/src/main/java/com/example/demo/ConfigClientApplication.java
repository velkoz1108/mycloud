package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication

public class ConfigClientApplication {
    @Value("${foo}")
    String foo;
    @Value("${password}")
    String appenv;
    @Value("${spring}")
    String spring;

    @RequestMapping(value = "/hi2")
    public String hi2() {
        return foo;
    }

    @RequestMapping(value = "/hi")
    public String hi() {
        return appenv + "," + spring;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }
}
