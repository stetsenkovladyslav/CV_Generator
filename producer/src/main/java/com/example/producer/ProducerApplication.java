package com.example.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("model")
@ComponentScan
        ({"aws",
        "com.example.producer.controller",
        "com.example.producer.configuration",
        "com.example.producer.service.person",
        "com.example.producer.mapper"
        })

public class ProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

}
