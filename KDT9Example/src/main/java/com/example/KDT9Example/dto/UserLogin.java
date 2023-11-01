package com.example.KDT9Example.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLogin {
    private String userid;
    private String password;
    private String name;
    private int dbid;
}
