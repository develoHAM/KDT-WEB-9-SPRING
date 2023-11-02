package com.example.mybatis.mybatisPractice.mapper;

import com.example.mybatis.mybatisPractice.domain.Users;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Mapper
public interface AccountMapper {

    @Select("SELECT * FROM users")
    List<Users> findAll();

    @Insert("INSERT INTO users (userid, password, name) VALUES (#{userid}, #{password}, #{name})")
    void insertUser(Users user);

    @Select("SELECT * FROM users WHERE userid = #{userid} AND password = #{password}")
    Users findOne(Users user);

    @Update("UPDATE users SET userid = #{userid}, password = #{password}, name = #{name} WHERE id = #{id}")
    int updateUser(Users user);

    @Delete("DELETE FROM users WHERE id = #{id}")
    int deleteUser(int id);
}
