package com.example.playereval;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.example.playereval.entity")
@EnableJpaRepositories("com.example.playereval.repository")
public class PlayerEvalApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlayerEvalApplication.class, args);
        System.out.println("Player Evaluation System Started!");
        System.out.println("Access the application at: http://localhost:8080");
    }
}