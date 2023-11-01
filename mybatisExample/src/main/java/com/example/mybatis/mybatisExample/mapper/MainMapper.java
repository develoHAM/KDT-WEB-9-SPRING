package com.example.mybatis.mybatisExample.mapper;

import com.example.mybatis.mybatisExample.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MainMapper {
    //MainMapper.xml 참조하기
    List<User> retrieveAll();

    //MainMapper.xml 참조 안하기
    @Insert("INSERT INTO user (name, address) VALUES (#{name}, #{address})")
    void insertUser(User user);
}
