package com.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigServerCamdenSr7Application {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerCamdenSr7Application.class, args);
    }
}
