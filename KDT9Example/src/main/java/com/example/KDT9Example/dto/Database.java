package com.example.KDT9Example.dto;

import lombok.Getter;

import java.util.ArrayList;
@Getter
public class Database {
    private static int count = 0;
    private static ArrayList<User> users = new ArrayList<>();

    public void addUser(User user) {
        count++;
        user.setDbid(count);
        users.add(user);
    }

    public void setUser(ArrayList users) {
        this.users = users;
    }

    public ArrayList<User> getUsers() {
        return this.users;
    }
}
