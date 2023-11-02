package com.example.mybatis.mybatisExample.controller;

import com.example.mybatis.mybatisExample.domain.Users;
import com.example.mybatis.mybatisExample.dto.UserDTO;
import com.example.mybatis.mybatisExample.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private MainService mainService;

    @GetMapping("/users")
    public String getUsers(Model model) {
        List<UserDTO> userList = mainService.getUserList();
        model.addAttribute("list", userList);
        return "user";
    }

    @GetMapping("/insert")
    public String getInsertUser(@RequestParam String name, @RequestParam String address, Model model) {

        Users user = new Users();
        user.setName(name);
        user.setAddress(address);

        mainService.addUser(user);

        model.addAttribute("list", null);
        return "user";
    }
}
