package com.example.calculadora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.calculadora.model")
public class CalculadoraApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalculadoraApplication.class, args);
    }
}
