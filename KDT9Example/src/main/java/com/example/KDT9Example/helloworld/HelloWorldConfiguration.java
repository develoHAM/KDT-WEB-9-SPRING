package com.example.KDT9Example.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Configuration: 빈(Bean) 정의를 포함하는 클래스
@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name() {
        return "KDT9";
    }

    @Bean
    public int age() {
        return 25;
    }
}
