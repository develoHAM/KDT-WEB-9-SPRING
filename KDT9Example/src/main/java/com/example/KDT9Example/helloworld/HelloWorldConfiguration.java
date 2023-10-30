package com.example.KDT9Example.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// record: getter, setter, 생성자 등을 자동으로 생성
record Person(String name, int age){}
record Address(String address, int postcode){}
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

    @Bean
    public Person person() {
        return new Person("김대원", 29);
    }

    @Bean
    public Person person2() {
        return new Person( name(), age());
    }

    @Bean(name="myAddress")
    public Address address() {
        return new Address("신림", 3023);
    }


}
