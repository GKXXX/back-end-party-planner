package com.example.party_planner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableCaching
@CrossOrigin(origins = "http://localhost:5173")
public class PartyPlannerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PartyPlannerApplication.class, args);
    }

}
