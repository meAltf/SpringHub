package com.learn.restapi.SpringHub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@ComponentScan("com.learn.SpringHub.*")
//@ComponentScan({"com.learn.SpringHub.controller", "com.learn.SpringHub.service"})
@EnableScheduling
public class SpringHubApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringHubApplication.class, args);
    }

}
