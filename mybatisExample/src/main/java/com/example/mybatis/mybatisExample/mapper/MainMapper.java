package com.example.mybatis.mybatisExample.mapper;

import com.example.mybatis.mybatisExample.domain.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MainMapper {
    //MainMapper.xml 참조하기
    List<Users> findAll();

    //MainMapper.xml 참조 안하기
    @Insert("INSERT INTO users (name, address) VALUES (#{name}, #{address})")
    void insertUser(Users user);
}
