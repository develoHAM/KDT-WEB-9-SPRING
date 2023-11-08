package com.mybatis.kdt9.controller;

import com.mybatis.kdt9.domain.User;
import com.mybatis.kdt9.dto.UserDTO;
import com.mybatis.kdt9.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    // 1) domain
    // 2) dto
    // 3) mapper
    // 4) service
    // 5) controller

    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String getUser(Model model) {
        List<UserDTO> users = userService.getUserList();
        model.addAttribute("list", users);
        return "user";
    }

    // get 방식으로 /user?name=이름&nickname=닉네임
//    @GetMapping("/user")
//    @ResponseBody
//    public String insertUser(@RequestParam String name, @RequestParam String nickname) {
//        userService.insertUser(name, nickname);
//        return "user";
//    }

    @GetMapping("/search")
    @ResponseBody
    public String selectUser(@RequestParam String name) {
        return userService.searchUser(name);
    }

    @GetMapping("/searchid")
    @ResponseBody
    public String searchid(@RequestParam int id) {
        return userService.searchId(id);
    }

    @GetMapping("/insert")
    @ResponseBody
    public UserDTO insertUser(@RequestParam String name, @RequestParam String nickname) {
        return userService.insertUser(name, nickname);
    }

    @GetMapping("/searchname")
    @ResponseBody
    public List<UserDTO> searchname(@RequestParam String name) {
        return userService.searchName(name);
    }

    @GetMapping("/searchnameornickname")
    @ResponseBody
    public List<UserDTO> searchnameornickname(@RequestParam String searchParam) {
        return userService.searchNameOrNickname(searchParam);
    }

    @GetMapping("/checknameexists")
    @ResponseBody
    public boolean checknameexists(@RequestParam String name) {
        return userService.checkNameExists(name);
    }
}
