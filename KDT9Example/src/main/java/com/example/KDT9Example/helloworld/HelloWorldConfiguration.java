package com.example.KDT9Example.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// record: getter, setter, 생성자 등을 자동으로 생성
record Person(String name, int age){}
record Address(String address, int postcode){}
record Information(String name, int age, Address address) {}
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
    @Primary
    public Address address() {
        return new Address("신림", 3023);
    }

    @Bean
    @Primary
    public Information info(String name, int age, Address myAddress) {
        return new Information(name, age, myAddress);
    }

    @Bean
    public Address address2() {
        return new Address("Seoul Yongsan", 4549);
    }

    @Bean
    @Qualifier("address3Qualifier")
    public Address address3() {
        return new Address("Seoul SeoDaeMun", 34343);
    }

    @Bean
    public Information info2(String name, int age,     @Qualifier("address3Qualifier")
    Address myAddress) {
        return new Information(name, age, myAddress);
    }
}
