package com.example.mybatis.mybatisExample.service;

import com.example.mybatis.mybatisExample.domain.User;
import com.example.mybatis.mybatisExample.dto.UserDTO;
import com.example.mybatis.mybatisExample.mapper.MainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainService {
    //XML 주입 - SQL쿼리와 Java객체간의 매핑 정의
    @Autowired
    private MainMapper mainMapper;

    public List<UserDTO> getUserList() {

        List<User> result = mainMapper.retrieveAll();
        List<UserDTO> users = new ArrayList<>();

        for (int i = 0; i < result.size(); i++) {
            UserDTO user = new UserDTO();
            user.setId(result.get(i).getId());
            user.setName(result.get(i).getName());
            user.setAddress(result.get(i).getAddress());
            users.add(user);
        }
        return users;
    }

    public void addUser(User user) {
        mainMapper.insertUser(user);
    }

}
