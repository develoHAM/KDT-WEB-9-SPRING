package com.example.mybatis.mybatisPractice.service;

import com.example.mybatis.mybatisPractice.domain.Users;
import com.example.mybatis.mybatisPractice.dto.UserDTO;
import com.example.mybatis.mybatisPractice.mapper.AccountMapper;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;

    public List getUserList() {
        List dbUsers = accountMapper.findAll();
        return dbUsers;
    }

    public void addUser(UserDTO user) {
        Users userDomain = new Users();

        userDomain.setUserid(user.getUserid());
        userDomain.setPassword(user.getPassword());
        userDomain.setName(user.getName());

        accountMapper.insertUser(userDomain);
    }

    public UserDTO verifyUser(UserDTO loginInfo) {
        Users userDomain = new Users();
        userDomain.setUserid(loginInfo.getUserid());
        userDomain.setPassword(loginInfo.getPassword());

        Users result = accountMapper.findOne(userDomain);

        if(Objects.isNull(result)) {
            return null;
        } else {
            System.out.println("result" + result.getId());
            System.out.println("result" + result.getUserid());
            System.out.println("result" + result.getPassword());
            System.out.println("result" + result.getName());
            UserDTO resultDTO = new UserDTO();
            resultDTO.setId(result.getId());
            resultDTO.setUserid(result.getUserid());
            resultDTO.setPassword(result.getPassword());
            resultDTO.setName(result.getName());
            return resultDTO;
        }
    }

    public boolean updateUser(UserDTO userInfo) {
        Users userDomain = new Users();
        userDomain.setId(userInfo.getId());
        userDomain.setUserid(userInfo.getUserid());
        userDomain.setPassword(userInfo.getPassword());
        userDomain.setName(userInfo.getName());

        int result = accountMapper.updateUser(userDomain);
        System.out.println("result" + result);

        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteUser(int id) {
        int result = accountMapper.deleteUser(id);

        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }
}
