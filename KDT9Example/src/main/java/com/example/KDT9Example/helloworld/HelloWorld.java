package com.example.KDT9Example.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorld {
    public static void main(String[] args) {

        // 스프링 컨텍스트를 실행하는 단계
        var context = new AnnotationConfigApplicationContext( HelloWorldConfiguration.class );

        // 스프링 프레임워크가 관리하도록 설정
        // 스프링에서 관리하는것은 무엇이든 Bean이 될 수 있다
        System.out.println((context.getBean("name")));
        System.out.println((context.getBean("age")));
    }
}
