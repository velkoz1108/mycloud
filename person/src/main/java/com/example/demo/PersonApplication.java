package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class PersonApplication {
    @RequestMapping("/index")
    public String index() {
        return "in person idnex";
    }

    public static void main(String[] args) {
//        SpringApplication.run(PersonApplication.class, args);
        new SpringApplicationBuilder(PersonApplication.class).web(true).run(args);
    }
}
