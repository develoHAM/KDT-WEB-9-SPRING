package com.example.mybatis.mybatisExample.service;

import com.example.mybatis.mybatisExample.domain.Users;
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

        //실제 데이터베이스에서 가져오는 Users배열
        List<Users> result = mainMapper.findAll();
        //위에서 맏은 Users배열을 UsersDTO배열로 반환하기
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

    public void addUser(Users user) {
        mainMapper.insertUser(user);
    }

}
