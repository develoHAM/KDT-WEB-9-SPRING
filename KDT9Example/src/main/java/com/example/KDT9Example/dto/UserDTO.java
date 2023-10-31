package com.example.KDT9Example.dto;

import lombok.Getter;
import lombok.Setter;

// @Getter
// @Setter
public class UserDTO {
    private String name;
    // getter와 setter을 만들거다. Generate > Getter and Setter
    // lombok ( 코드 다이어터 )
    public String getName() { return name;}
    public void setName(String name) { this.name = name; }


    private String age;
    public String getAge() { return age;}
    public void setAge(String age) { this.age = age; }
}
