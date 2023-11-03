package com.example.mybatis.mybatisPractice.controller;

import com.example.mybatis.mybatisPractice.dto.UserDTO;
import com.example.mybatis.mybatisPractice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private AccountService accountService;
    @GetMapping("/")
    public String getMainPage(Model model) {
        return "main";
    }

    @PostMapping("/user")
    @ResponseBody
    public String signup(@RequestBody UserDTO userDTO) {
        System.out.println("ID" + userDTO.getId());
        System.out.println("userid" + userDTO.getUserid());
        System.out.println("password" + userDTO.getPassword());
        System.out.println("name" + userDTO.getName());

        accountService.addUser(userDTO);
        return "회원가입 성공";
    }

    @GetMapping("/users")
    @ResponseBody
    public List getUsers() {
        List userList = accountService.getUserList();
        if (userList == null) {
            return null;
        } else {
            return userList;
        }
    }

    @PostMapping("/login")
    @ResponseBody
    public UserDTO login(@RequestBody UserDTO userDTO) {
        System.out.println("ID" + userDTO.getId());
        System.out.println("userid" + userDTO.getUserid());
        System.out.println("password" + userDTO.getPassword());
        System.out.println("name" + userDTO.getName());

        UserDTO verifyResult = accountService.verifyUser(userDTO);
        return verifyResult;
    }

    @PutMapping("/user")
    @ResponseBody
    public boolean update(@RequestBody UserDTO userDTO) {
        return accountService.updateUser(userDTO);
    }

    @DeleteMapping("/user/{id}")
    @ResponseBody
    public boolean delete(@PathVariable int id) {
        return accountService.deleteUser(id);
    }
}
