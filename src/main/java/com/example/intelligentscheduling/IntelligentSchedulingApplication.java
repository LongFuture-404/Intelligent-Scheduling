package com.example.intelligentscheduling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class IntelligentSchedulingApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntelligentSchedulingApplication.class, args);
    }

}
