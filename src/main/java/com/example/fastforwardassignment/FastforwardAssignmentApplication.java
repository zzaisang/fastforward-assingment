package com.example.fastforwardassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class FastforwardAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastforwardAssignmentApplication.class, args);
    }

}
